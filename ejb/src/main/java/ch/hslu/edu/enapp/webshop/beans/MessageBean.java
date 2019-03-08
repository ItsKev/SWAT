package ch.hslu.edu.enapp.webshop.beans;

import ch.hslu.edu.enapp.webshop.dto.BasketProduct;
import ch.hslu.edu.enapp.webshop.dto.Customer;
import ch.hslu.edu.enapp.webshop.jms.ObjectFactory;
import ch.hslu.edu.enapp.webshop.jms.PurchaseMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Stateless
public class MessageBean {

    private static final Logger LOGGER = LogManager.getLogger(MessageBean.class);

    @Resource(name = "jms/enappQueueAMQ")
    private Queue messageRemoteQueue;
    @Resource(name = "MyRemoteJmsQueueConnectionFactory")
    private ConnectionFactory messageRemoteFactory;


    public String sendMessage(Customer customer, String payId, String purchaseId, String totalPrice, List<BasketProduct> basketProducts) {
        LOGGER.info("SendMessage");
        final StringWriter writer;
        try {
            final JAXBContext jaxbContext = JAXBContext.newInstance(PurchaseMessage.class);
            writer = new StringWriter();
            final Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            PurchaseMessage purchaseMessage = createPurchaseMessage(payId, customer, purchaseId, totalPrice, basketProducts);
            marshaller.marshal(purchaseMessage, writer);
        } catch (Exception e) {
            LOGGER.error("Failed at marshal: " + e.getMessage());
            return "";
        }
        final String purchaseMessageText = writer.toString();
        LOGGER.info(purchaseMessageText);
        String correlationId = UUID.randomUUID().toString();
        if (sendMessage(purchaseMessageText, correlationId)) {
            return "";
        }
        return correlationId;
    }

    private boolean sendMessage(String purchaseMessageText, String correlationId) {
        Connection connection = null;
        Session session = null;
        try {
            connection = messageRemoteFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            final MessageProducer messageProducer = session.createProducer(messageRemoteQueue);
            final TextMessage textMessage = session.createTextMessage(purchaseMessageText);
            textMessage.setStringProperty("MessageFormat", "Version 1.5");
            textMessage.setJMSCorrelationID(correlationId);
            messageProducer.send(textMessage);
        } catch (final Exception e) {
            LOGGER.error("Failed at sending: " + e.getMessage());
            return true;
        } finally {
            if (null != session) {
                try {
                    session.close();
                } catch (final JMSException e) {
                    LOGGER.error(e.getMessage());
                }
            }
            if (null != connection) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    LOGGER.error(e.getMessage());
                }
            }
        }
        return false;
    }

    private PurchaseMessage createPurchaseMessage(String payId, Customer customer, String purchaseId, String totalPrice, List<BasketProduct> basketProducts) {
        PurchaseMessage purchaseMessage = new ObjectFactory().createPurchaseMessage();
        PurchaseMessage.Customer purchaseMessageCustomer = new ObjectFactory().createPurchaseMessageCustomer();
        purchaseMessageCustomer.setName(customer.getFirstname() + " " + customer.getLastname());
        purchaseMessageCustomer.setAddress(customer.getAddress());
        purchaseMessageCustomer.setShopLoginname(customer.getName());
        purchaseMessageCustomer.setCity("");
        purchaseMessageCustomer.setPostCode("");
        if (customer.getDynnavcustno() != null && !customer.getDynnavcustno().equals("")) {
            purchaseMessageCustomer.setDynNavCustNo(customer.getDynnavcustno());
        }
        purchaseMessage.setCustomer(purchaseMessageCustomer);

        List<PurchaseMessage.Lines.Line> purchaseLines = getPurchaseItems(basketProducts);

        PurchaseMessage.Lines purchaseMessageLines = new ObjectFactory().createPurchaseMessageLines();
        purchaseMessageLines.setLine(purchaseLines);
        purchaseMessage.setLines(purchaseMessageLines);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        purchaseMessage.setDate(dateFormat.format(date));
        purchaseMessage.setStudent("iahuber");
        purchaseMessage.setPayId(payId);
        purchaseMessage.setPurchaseId(purchaseId);
        purchaseMessage.setTotalPrice(totalPrice);
        return purchaseMessage;
    }

    private List<PurchaseMessage.Lines.Line> getPurchaseItems(List<BasketProduct> basketProducts) {
        List<PurchaseMessage.Lines.Line> purchaseLines = new ArrayList<>();
        for (BasketProduct basketProduct : basketProducts) {
            PurchaseMessage.Lines.Line purchaseMessageLinesLine = new ObjectFactory().createPurchaseMessageLinesLine();
            purchaseMessageLinesLine.setMsDynNAVItemNo(basketProduct.getProduct().getArticleNumber());
            purchaseMessageLinesLine.setDescription(basketProduct.getProduct().getDescription());
            purchaseMessageLinesLine.setQuantity(Integer.toString(basketProduct.getQuantity()));
            purchaseMessageLinesLine.setTotalLinePrice(basketProduct.getTotalPrice().toString());
            purchaseLines.add(purchaseMessageLinesLine);
        }
        return purchaseLines;
    }
}

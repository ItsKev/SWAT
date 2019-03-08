package ch.hslu.edu.enapp.webshop.beans;

import ch.hslu.edu.enapp.webshop.dto.BasketProduct;
import ch.hslu.edu.enapp.webshop.postfinance.Ncresponse;
import ch.hslu.edu.enapp.webshop.postfinance.ObjectFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Stateless;
import javax.ws.rs.client.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

@Stateless
public class PaymentBean {

    private static final Logger LOGGER = LogManager.getLogger(PaymentBean.class);

    public Ncresponse makePurchase(List<BasketProduct> basketProducts) {
        TreeMap<String, String> formData = new TreeMap<>();
        formData.put("PSPID", "HSLUiCompany");
        formData.put("ORDERID", UUID.randomUUID().toString());
        formData.put("USERID", "enappstudents");
        formData.put("PSWD", "ds2H9ZV.p!8r");
        formData.put("AMOUNT", Integer.toString(getTotalCost(basketProducts)));
        formData.put("CURRENCY", "CHF");
        formData.put("CARDNO", "5399999999999999");
        formData.put("ED", "1220");
        formData.put("CVC", "111");
        formData.put("OPERATION", "RES");

        StringBuilder stringToHash = new StringBuilder();
        for (Map.Entry<String, String> entry : formData.entrySet()) {
            stringToHash.append(entry.getKey());
            stringToHash.append("=");
            stringToHash.append(entry.getValue());
            stringToHash.append("hslu!comp@ny.websh0p");
        }

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.reset();
            digest.update(stringToHash.toString().getBytes(StandardCharsets.UTF_8));
            String sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
            formData.put("SHASIGN", sha1);
        } catch (NoSuchAlgorithmException e) {
            LOGGER.error("NoSuchAlgorithmFound SHA-1");
        }

        final Client client = ClientBuilder.newClient();
        final WebTarget target = client.target("https://e-payment.postfinance.ch/ncol/test/orderdirect.asp");
        final Invocation.Builder builder = target.request();
        final Response result = builder.header(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded").post(Entity.form(new MultivaluedHashMap<>(formData)));
        final String xmlResponse = result.readEntity(String.class);
        try {
            return unmarshalXml(xmlResponse);
        } catch (Exception e) {
            return new ObjectFactory().createNcresponse();
        }
    }

    private int getTotalCost(List<BasketProduct> basketProducts) {
        BigDecimal cost = new BigDecimal(0);
        for (BasketProduct basketProduct : basketProducts) {
            cost = cost.add(basketProduct.getTotalPrice());
        }
        return cost.multiply(new BigDecimal(100)).intValue();
    }

    /* Code fragment from Markus Kaufmann */
    private Ncresponse unmarshalXml(final String xml) throws Exception {
        try (final Reader reader = new StringReader(xml)) {
            final JAXBContext jaxbContext = JAXBContext.newInstance(Ncresponse.class);
            final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (Ncresponse) unmarshaller.unmarshal(reader);
        } catch (Exception e) {
            LOGGER.error("Error while unmarshaling the xml");
            LOGGER.error(e.getMessage());
            throw new Exception(e);
        }
    }
}

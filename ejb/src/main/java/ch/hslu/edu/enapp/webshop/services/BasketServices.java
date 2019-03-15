package ch.hslu.edu.enapp.webshop.services;

import ch.hslu.edu.enapp.webshop.beans.AccountBean;
import ch.hslu.edu.enapp.webshop.beans.MessageBean;
import ch.hslu.edu.enapp.webshop.beans.PaymentBean;
import ch.hslu.edu.enapp.webshop.beans.ScheduledTask;
import ch.hslu.edu.enapp.webshop.dto.BasketProduct;
import ch.hslu.edu.enapp.webshop.dto.Customer;
import ch.hslu.edu.enapp.webshop.dto.Product;
import ch.hslu.edu.enapp.webshop.entity.PurchaseEntity;
import ch.hslu.edu.enapp.webshop.entity.PurchaseitemEntity;
import ch.hslu.edu.enapp.webshop.postfinance.Ncresponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Stateful
public class BasketServices implements BasketServicesLocal {

    private static final Logger LOGGER = LogManager.getLogger(BasketServices.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private AccountBean accountBean;

    @Inject
    private PaymentBean paymentBean;

    @Inject
    private MessageBean messageBean;

    @Inject
    private ScheduledTask scheduledTask;

    private List<BasketProduct> basket;

    public BasketServices() {
        basket = new ArrayList<>();
    }

    @Override
    public void addToBasket(final Product product) {
        boolean contains = false;
        for (BasketProduct basketProduct : basket) {
            if (basketProduct.getProduct().equals(product)) {
                basketProduct.setQuantity(basketProduct.getQuantity() + 1);
                contains = true;
            }
        }
        if (!contains) {
            BasketProduct basketProduct = new BasketProduct();
            basketProduct.setProduct(product);
            basketProduct.setQuantity(1);
            basket.add(basketProduct);
        }
    }

    @Override
    public List<BasketProduct> getBasket() {
        return basket;
    }


    @Override
    public BigDecimal getTotalCost() {
        BigDecimal cost = new BigDecimal(0);
        for (BasketProduct basketProduct : basket) {
            cost = cost.add(basketProduct.getTotalPrice());
        }
        return cost;
    }

    @Override
    public void purchaseBasket(String customername) {
        Ncresponse ncresponse = paymentBean.makePurchase(basket);
        LOGGER.info("PayID: " + ncresponse.getPAYID());
        LOGGER.info("NcStatus: " + ncresponse.getNCSTATUS());
        LOGGER.info("NcError: " + ncresponse.getNCERROR());
        LOGGER.info("Status: " + ncresponse.getSTATUS());
        final PurchaseEntity purchaseEntity = persistPurchase(customername);
        Optional<Customer> customer = accountBean.getCustomer(customername);
        if(customer.isPresent()) {
            String correlationId = messageBean.sendMessage(customer.get(), ncresponse.getPAYID(),
                    Integer.toString(purchaseEntity.getId()), getTotalCost().toString(), basket);
            purchaseEntity.setCorrelationid(correlationId);
            entityManager.persist(purchaseEntity);

            scheduledTask.addCorrelationId(correlationId, customer.get());
            basket.clear();
        }
    }

    private PurchaseEntity persistPurchase(String customer) {
        final PurchaseEntity purchaseEntity = new PurchaseEntity();
        purchaseEntity.setCustomer(customer);
        purchaseEntity.setDatetime(new Timestamp(System.currentTimeMillis()));
        purchaseEntity.setState("");
        entityManager.persist(purchaseEntity);
        entityManager.flush();
        for (BasketProduct basketProduct : basket) {
            final PurchaseitemEntity purchaseitemEntity = new PurchaseitemEntity();
            purchaseitemEntity.setArticleNumber(basketProduct.getProduct().getArticleNumber());
            purchaseitemEntity.setQuantity(basketProduct.getQuantity());
            purchaseitemEntity.setPurchase(purchaseEntity.getId());
            entityManager.persist(purchaseitemEntity);
        }
        return purchaseEntity;
    }

}

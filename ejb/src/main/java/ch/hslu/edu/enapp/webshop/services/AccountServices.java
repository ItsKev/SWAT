package ch.hslu.edu.enapp.webshop.services;

import ch.hslu.edu.enapp.webshop.beans.AccountBean;
import ch.hslu.edu.enapp.webshop.dto.Customer;
import ch.hslu.edu.enapp.webshop.dto.Purchase;
import ch.hslu.edu.enapp.webshop.entity.CustomertoroleEntity;
import ch.hslu.edu.enapp.webshop.entity.PurchaseEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class AccountServices implements AccountServicesLocal {

    private static final Logger LOGGER = LogManager.getLogger(AccountServices.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private AccountBean accountBean;

    @Override
    public Customer getCustomer(String name) {
        return accountBean.getCustomer(name);
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> allCustomers = accountBean.getAllCustomers();
        LOGGER.info("Customer size: " + allCustomers.size());
        return allCustomers;
    }

    @Override
    public void changeAccountInformation(Customer customer) {
        accountBean.changeAccountInformation(customer);
    }

    @Override
    public List<Purchase> getOrders(String customerName) {
        TypedQuery<PurchaseEntity> getPurchaseByCustomerName = entityManager.createNamedQuery("getPurchaseByCustomerName", PurchaseEntity.class);
        getPurchaseByCustomerName.setParameter("customerName", customerName);
        List<PurchaseEntity> resultList = getPurchaseByCustomerName.getResultList();
        List<Purchase> purchases = new ArrayList<>();
        for (PurchaseEntity purchaseEntity : resultList) {
            Purchase purchase = new Purchase();
            purchase.setCustomer(purchaseEntity.getCustomer());
            purchase.setDatetime(purchaseEntity.getDatetime());
            purchase.setState(purchaseEntity.getState());
            purchase.setCorrelationid(purchaseEntity.getCorrelationid());
            purchases.add(purchase);
        }
        return purchases;
    }

    @Override
    public boolean isAdmin(String customerName) {
        TypedQuery<CustomertoroleEntity> getCustomerRoleByName = entityManager.createNamedQuery("getCustomerRoleByName", CustomertoroleEntity.class);
        getCustomerRoleByName.setParameter("name", customerName);
        CustomertoroleEntity customertoroleEntity = getCustomerRoleByName.getResultList().get(0);
        return customertoroleEntity.getRole().equals("admin-webshop");
    }
}

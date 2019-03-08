package ch.hslu.edu.enapp.webshop.beans;

import ch.hslu.edu.enapp.webshop.dto.Customer;
import ch.hslu.edu.enapp.webshop.entity.CustomerEntity;
import ch.hslu.edu.enapp.webshop.entity.PurchaseEntity;
import ch.hslu.edu.enapp.webshop.sales.Salesorder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Startup
@Singleton
public class ScheduledTask {

    private static final Logger LOGGER = LogManager.getLogger(ScheduledTask.class);


    @PersistenceContext
    private EntityManager entityManager;

    private Map<String, Customer> correlationsIds = new HashMap<>();
    private List<String> idsToRemove = new ArrayList<>();

    public void addCorrelationId(String correlationId, Customer customer) {
        this.correlationsIds.put(correlationId, customer);
    }

    @Schedule(second = "*/10", minute = "*", hour = "*")
    private void scheduleTask() {
        for (Map.Entry<String, Customer> entry : correlationsIds.entrySet()) {
            final String baseURI = "http://enapp-daemons.el.eee.intern:9080/EnappDaemonWeb/rest/salesorder/corr/"
                    + entry.getKey();
            final Client client = ClientBuilder.newClient();
            final WebTarget target = client.target(baseURI);
            Invocation.Builder builder = target.request();
            Salesorder salesorder = builder.get(Salesorder.class);
            Customer customer = entry.getValue();
            if (customer.getDynnavcustno() == null || customer.getDynnavcustno().equals("")) {
                LOGGER.info("DynNavNo: " + salesorder.getDynNAVCustomerNo());
                persistDynNavNo(salesorder.getDynNAVCustomerNo(), customer);
                customer.setDynnavcustno(salesorder.getDynNAVCustomerNo());
            }
            addStateToOrder(entry, salesorder.getStatus());
        }
        for (String id : idsToRemove) {
            correlationsIds.remove(id);
        }
        idsToRemove.clear();
    }

    private void persistDynNavNo(String dynNavNo, Customer customer) {
        TypedQuery<CustomerEntity> getCustomerByName = entityManager.createNamedQuery("getCustomerByName", CustomerEntity.class);
        getCustomerByName.setParameter("name", customer.getName());
        List<CustomerEntity> resultList = getCustomerByName.getResultList();
        CustomerEntity result = resultList.get(0);
        result.setDynnavcustno(dynNavNo);
        entityManager.persist(result);
        entityManager.flush();
    }

    private void addStateToOrder(Map.Entry<String, Customer> entry, String status) {
        LOGGER.info(entry.getKey() + ": " + status);
        TypedQuery<PurchaseEntity> getCustomerByName = entityManager.createNamedQuery("getPurchaseByCorrelationId", PurchaseEntity.class);
        getCustomerByName.setParameter("correlationid", entry.getKey());
        List<PurchaseEntity> resultList = getCustomerByName.getResultList();
        PurchaseEntity result = resultList.get(0);
        if (result.getState().equals("") || !result.getState().equals(status)) {
            result.setState(status);
            entityManager.persist(result);
            entityManager.flush();
            if (status.equals("010") || status.equals("000")) {
                idsToRemove.add(entry.getKey());
            }
        }
    }
}

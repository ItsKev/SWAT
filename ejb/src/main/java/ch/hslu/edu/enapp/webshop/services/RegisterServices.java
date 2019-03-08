package ch.hslu.edu.enapp.webshop.services;

import ch.hslu.edu.enapp.webshop.dto.Customer;
import ch.hslu.edu.enapp.webshop.entity.CustomerEntity;
import ch.hslu.edu.enapp.webshop.entity.CustomertoroleEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class RegisterServices implements RegisterServicesLocal {

    private static final Logger LOGGER = LogManager.getLogger(RegisterServices.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean register(Customer customer) {
        TypedQuery<CustomerEntity> getCustomerByName = entityManager.createNamedQuery("getCustomerByName", CustomerEntity.class);
        getCustomerByName.setParameter("name", customer.getName());
        List<CustomerEntity> resultList = getCustomerByName.getResultList();
        if (resultList.size() == 0) {
            CustomerEntity customerEntity = new CustomerEntity();
            customerEntity.setName(customer.getName());
            customerEntity.setFirstname(customer.getFirstname());
            customerEntity.setLastname(customer.getLastname());
            customerEntity.setPassword(customer.getPassword());
            customerEntity.setAddress(customer.getAddress());
            customerEntity.setEmail(customer.getEmail());
            try {
                entityManager.persist(customerEntity);
            } catch (Exception e) {
                return false;
            }

            CustomertoroleEntity customertoroleEntity = new CustomertoroleEntity();
            customertoroleEntity.setName(customer.getName());
            customertoroleEntity.setRole("customer-webshop");
            try {
                entityManager.persist(customertoroleEntity);
                entityManager.flush();
            } catch (Exception e) {
                return false;
            }
            return true;
        }
        return false;
    }
}

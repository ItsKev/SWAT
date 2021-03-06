package ch.hslu.edu.enapp.webshop.beans;

import ch.hslu.edu.enapp.webshop.dto.Customer;
import ch.hslu.edu.enapp.webshop.entity.CustomerEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Stateless
public class AccountBean {

    @PersistenceContext
    private EntityManager entityManager;

    public Optional<Customer> getCustomer(String name) {
        List<CustomerEntity> resultList = getCustomerEntitiesByName(name);
        if (!resultList.isEmpty()) {
            CustomerEntity result = resultList.get(0);
            Customer customer = getCustomer(result);
            customer.setPassword("");
            customer.setDynnavcustno(result.getDynnavcustno());
            return Optional.of(customer);
        }
        return Optional.empty();
    }

    public List<Customer> getAllCustomers() {
        TypedQuery<CustomerEntity> customersQuery =
                entityManager.createNamedQuery("getCustomers", CustomerEntity.class);
        List<CustomerEntity> resultList = customersQuery.getResultList();
        List<Customer> customers = new ArrayList<>();
        for (CustomerEntity customerEntity : resultList) {
            Customer customer = getCustomer(customerEntity);
            customer.setDynnavcustno(customerEntity.getDynnavcustno());
            customers.add(customer);
        }
        return customers;
    }

    public void changeAccountInformation(Customer customer) {
        List<CustomerEntity> resultList = getCustomerEntitiesByName(customer.getName());
        if (!resultList.isEmpty()) {
            CustomerEntity result = resultList.get(0);
            result.setFirstname(customer.getFirstname());
            result.setLastname(customer.getLastname());
            result.setAddress(customer.getAddress());
            result.setEmail(customer.getEmail());
            result.setDynnavcustno(customer.getDynnavcustno());
            if (!customer.getPassword().equals("")) {
                result.setPassword(customer.getPassword());
            }
            entityManager.persist(result);
            entityManager.flush();
        }
    }

    private Customer getCustomer(CustomerEntity result) {
        Customer customer = new Customer();
        customer.setName(result.getName());
        customer.setFirstname(result.getFirstname());
        customer.setLastname(result.getLastname());
        customer.setAddress(result.getAddress());
        customer.setEmail(result.getEmail());
        return customer;
    }

    private List<CustomerEntity> getCustomerEntitiesByName(String name) {
        TypedQuery<CustomerEntity> getCustomerByName =
                entityManager.createNamedQuery("getCustomerByName", CustomerEntity.class);
        getCustomerByName.setParameter("name", name);
        return getCustomerByName.getResultList();
    }

}

package ch.hslu.edu.enapp.webshop.beans;

import ch.hslu.edu.enapp.webshop.dto.Customer;
import ch.hslu.edu.enapp.webshop.entity.CustomerEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class AccountBean {

    @PersistenceContext
    private EntityManager entityManager;

    public Customer getCustomer(String name) {
        TypedQuery<CustomerEntity> getCustomerByName = entityManager.createNamedQuery("getCustomerByName", CustomerEntity.class);
        getCustomerByName.setParameter("name", name);
        List<CustomerEntity> resultList = getCustomerByName.getResultList();
        CustomerEntity result = resultList.get(0);
        Customer customer = new Customer();
        customer.setName(result.getName());
        customer.setFirstname(result.getFirstname());
        customer.setLastname(result.getLastname());
        customer.setAddress(result.getAddress());
        customer.setEmail(result.getEmail());
        customer.setPassword("");
        customer.setDynnavcustno(result.getDynnavcustno());
        return customer;
    }

    public List<Customer> getAllCustomers() {
        TypedQuery<CustomerEntity> customersQuery = entityManager.createNamedQuery("getCustomers", CustomerEntity.class);
        List<CustomerEntity> resultList = customersQuery.getResultList();
        List<Customer> customers = new ArrayList<>();
        for (CustomerEntity customerEntity : resultList) {
            Customer customer = new Customer();
            customer.setName(customerEntity.getName());
            customer.setFirstname(customerEntity.getFirstname());
            customer.setLastname(customerEntity.getLastname());
            customer.setAddress(customerEntity.getAddress());
            customer.setEmail(customerEntity.getEmail());
            customer.setDynnavcustno(customerEntity.getDynnavcustno());
            customers.add(customer);
        }
        return customers;
    }

    public void changeAccountInformation(Customer customer) {
        TypedQuery<CustomerEntity> getCustomerByName = entityManager.createNamedQuery("getCustomerByName", CustomerEntity.class);
        getCustomerByName.setParameter("name", customer.getName());
        List<CustomerEntity> resultList = getCustomerByName.getResultList();
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

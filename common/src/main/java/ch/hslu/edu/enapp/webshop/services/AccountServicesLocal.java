package ch.hslu.edu.enapp.webshop.services;

import ch.hslu.edu.enapp.webshop.dto.Customer;
import ch.hslu.edu.enapp.webshop.dto.Purchase;

import java.util.List;

public interface AccountServicesLocal {
    Customer getCustomer(String name);

    List<Customer> getAllCustomers();

    void changeAccountInformation(Customer customer);

    List<Purchase> getOrders(String customerName);

    boolean isAdmin(String customerName);
}

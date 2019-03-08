package ch.hslu.edu.enapp.webshop.jsf;

import ch.hslu.edu.enapp.webshop.dto.Customer;
import ch.hslu.edu.enapp.webshop.services.AccountServicesLocal;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class AdminJSF {

    private boolean accountInformationChanged = false;

    private List<Customer> customers = new ArrayList<>();

    @Inject
    private AccountServicesLocal accountServices;

    public List<Customer> getAllCustomers() {
        if (customers.isEmpty()) {
            customers = accountServices.getAllCustomers();
        }
        return customers;
    }

    public boolean isAccountInformationChanged() {
        return accountInformationChanged;
    }

    public void changeAccountInformation(Customer customer) {
        accountServices.changeAccountInformation(customer);
        accountInformationChanged = true;
    }
}

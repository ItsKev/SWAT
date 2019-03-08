package ch.hslu.edu.enapp.webshop.jsf;

import ch.hslu.edu.enapp.webshop.dto.Customer;
import ch.hslu.edu.enapp.webshop.dto.Purchase;
import ch.hslu.edu.enapp.webshop.services.AccountServicesLocal;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class AccountJSF {

    private Customer customer;
    private boolean accountInformationChanged = false;

    @Inject
    private AccountServicesLocal accountServices;

    @Inject
    private CustomerSessionJSF customerSession;

    @PostConstruct
    private void init() {
        customer = accountServices.getCustomer(customerSession.getUsername());
    }

    public Customer getCustomer() {
        return customer;
    }

    public boolean isAccountInformationChanged() {
        return accountInformationChanged;
    }

    public void changeAccountInformation() {
        accountServices.changeAccountInformation(customer);
        accountInformationChanged = true;
    }

    public List<Purchase> getOrders() {
        return accountServices.getOrders(customer.getName());
    }

}

package ch.hslu.edu.enapp.webshop.jsf;

import ch.hslu.edu.enapp.webshop.dto.Customer;
import ch.hslu.edu.enapp.webshop.services.RegisterServicesLocal;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class RegisterJSF {

    private Customer customer;
    private boolean usernameAlreadyTaken = false;
    @Inject
    private RegisterServicesLocal registerServices;

    public RegisterJSF() {
        customer = new Customer();
    }

    public Customer getCustomer() {
        return customer;
    }

    public boolean isUsernameAlreadyTaken() {
        return usernameAlreadyTaken;
    }

    public String register() {
        boolean registerResult = registerServices.register(customer);
        if (registerResult) {
            return "/secure/secured_index?faces-redirect=true";
        } else {
            usernameAlreadyTaken = true;
            return null;
        }
    }

}

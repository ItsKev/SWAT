package ch.hslu.edu.enapp.webshop.jsf;

import ch.hslu.edu.enapp.webshop.services.AccountServicesLocal;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;

@Named
@SessionScoped
public class CustomerSessionJSF implements Serializable {

    private static final long serialVersionUID = -6979664879145550177L;

    @Inject
    private AccountServicesLocal accountServices;

    private String username;

    public String getUsername() {
        if (null == username) {
            try {
                final FacesContext facesContext = FacesContext.getCurrentInstance();
                username = facesContext.getExternalContext().getUserPrincipal().getName();
            } catch (NullPointerException ex) {
                username = null;
            }
        }

        return username;
    }

    public boolean isAdmin() {
        return accountServices.isAdmin(getUsername());
    }

    public String logout() throws IOException {
        final FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getExternalContext().invalidateSession();

        return "/index?faces-redirect=true";
    }
}

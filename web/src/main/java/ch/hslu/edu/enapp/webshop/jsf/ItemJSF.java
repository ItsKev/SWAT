package ch.hslu.edu.enapp.webshop.jsf;

import ch.hslu.edu.enapp.webshop.dto.Product;
import ch.hslu.edu.enapp.webshop.services.ItemServicesLocal;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class ItemJSF {

    @Inject
    private ItemServicesLocal itemServices;

    public List<Product> getProducts() {
        return itemServices.getProducts();
    }
}

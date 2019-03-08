package ch.hslu.edu.enapp.webshop.jsf;

import ch.hslu.edu.enapp.webshop.dto.BasketProduct;
import ch.hslu.edu.enapp.webshop.dto.Product;
import ch.hslu.edu.enapp.webshop.services.BasketServicesLocal;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Named
@SessionScoped
public class BasketJSF implements Serializable {

    private static final long serialVersionUID = -2476326471122639243L;

    @Inject
    private BasketServicesLocal basketServices;

    public void addToBasket(Product product) {
        basketServices.addToBasket(product);
    }

    public List<BasketProduct> getBasket() {
        return basketServices.getBasket();
    }

    public BigDecimal getTotalCost() {
        return basketServices.getTotalCost();
    }

    public String purchaseBasket(String customername) {
        basketServices.purchaseBasket(customername);
        return "/secure/secured_purchased?faces-redirect=true";
    }

    public int getBasketSize() {
        return basketServices.getBasket().size();
    }
}

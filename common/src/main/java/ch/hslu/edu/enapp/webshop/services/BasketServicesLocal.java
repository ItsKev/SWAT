package ch.hslu.edu.enapp.webshop.services;

import ch.hslu.edu.enapp.webshop.dto.BasketProduct;
import ch.hslu.edu.enapp.webshop.dto.Product;

import javax.ejb.Local;
import java.math.BigDecimal;
import java.util.List;

@Local
public interface BasketServicesLocal {
    void addToBasket(Product product);

    List<BasketProduct> getBasket();

    BigDecimal getTotalCost();

    void purchaseBasket(String customername);
}

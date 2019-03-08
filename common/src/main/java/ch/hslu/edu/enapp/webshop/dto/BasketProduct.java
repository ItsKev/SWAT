package ch.hslu.edu.enapp.webshop.dto;

import java.math.BigDecimal;

public class BasketProduct {

    private Product product;
    private int quantity;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return product.getUnitprice().multiply(new BigDecimal(quantity));
    }
}

package ch.hslu.edu.enapp.webshop.dto;

import java.util.Objects;

public class Purchaseitem {
    private int id;
    private int purchase;
    private int product;
    private int quantity;
    private Purchase purchaseByPurchase;
    private Product productByProduct;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPurchase() {
        return purchase;
    }

    public void setPurchase(int purchase) {
        this.purchase = purchase;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchaseitem that = (Purchaseitem) o;
        return id == that.id &&
                purchase == that.purchase &&
                product == that.product &&
                quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, purchase, product, quantity);
    }

    public Purchase getPurchaseByPurchase() {
        return purchaseByPurchase;
    }

    public void setPurchaseByPurchase(Purchase purchaseByPurchase) {
        this.purchaseByPurchase = purchaseByPurchase;
    }

    public Product getProductByProduct() {
        return productByProduct;
    }

    public void setProductByProduct(Product productByProduct) {
        this.productByProduct = productByProduct;
    }
}

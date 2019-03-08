package ch.hslu.edu.enapp.webshop.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "purchaseitem", schema = "webshop", catalog = "")
public class PurchaseitemEntity {
    private int id;
    private int purchase;
    private String articleNumber;
    private int quantity;
    private PurchaseEntity purchaseByPurchase;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "purchase", nullable = false)
    public int getPurchase() {
        return purchase;
    }

    public void setPurchase(int purchase) {
        this.purchase = purchase;
    }

    @Basic
    @Column(name = "articleNumber", nullable = false, length = 255)
    public String getArticleNumber() {
        return articleNumber;
    }

    public void setArticleNumber(String articleNumber) {
        this.articleNumber = articleNumber;
    }

    @Basic
    @Column(name = "quantity", nullable = false)
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
        PurchaseitemEntity that = (PurchaseitemEntity) o;
        return id == that.id &&
                purchase == that.purchase &&
                quantity == that.quantity &&
                Objects.equals(articleNumber, that.articleNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, purchase, articleNumber, quantity);
    }

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "purchase", referencedColumnName = "id")
    public PurchaseEntity getPurchaseByPurchase() {
        return purchaseByPurchase;
    }

    public void setPurchaseByPurchase(PurchaseEntity purchaseByPurchase) {
        this.purchaseByPurchase = purchaseByPurchase;
    }
}

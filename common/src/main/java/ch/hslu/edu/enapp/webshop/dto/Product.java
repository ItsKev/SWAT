package ch.hslu.edu.enapp.webshop.dto;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

public class Product {
    private String articleNumber;
    private String name;
    private String description;
    private String mediapath;
    private BigDecimal unitprice;
    private Collection<Purchaseitem> purchaseitemsById;

    public String getArticleNumber() {
        return articleNumber;
    }

    public void setArticleNumber(String articleNumber) {
        this.articleNumber = articleNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMediapath() {
        return mediapath;
    }

    public void setMediapath(String mediapath) {
        this.mediapath = mediapath;
    }

    public BigDecimal getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(BigDecimal unitprice) {
        this.unitprice = unitprice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product that = (Product) o;
        return Objects.equals(articleNumber, that.articleNumber) &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(mediapath, that.mediapath) &&
                Objects.equals(unitprice, that.unitprice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleNumber, name, description, mediapath, unitprice);
    }
}

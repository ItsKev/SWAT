package ch.hslu.edu.enapp.webshop.dto;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

public class Purchase {
    private int id;
    private String customer;
    private Timestamp datetime;
    private String state;
    private String correlationid;
    private Customer customerByCustomer;
    private Collection<Purchaseitem> purchaseitemsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCorrelationid() {
        return correlationid;
    }

    public void setCorrelationid(String correlationid) {
        this.correlationid = correlationid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase that = (Purchase) o;
        return id == that.id &&
                Objects.equals(customer, that.customer) &&
                Objects.equals(datetime, that.datetime) &&
                Objects.equals(state, that.state) &&
                Objects.equals(correlationid, that.correlationid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, datetime, state, correlationid);
    }

    public Customer getCustomerByCustomer() {
        return customerByCustomer;
    }

    public void setCustomerByCustomer(Customer customerByCustomer) {
        this.customerByCustomer = customerByCustomer;
    }

    public Collection<Purchaseitem> getPurchaseitemsById() {
        return purchaseitemsById;
    }

    public void setPurchaseitemsById(Collection<Purchaseitem> purchaseitemsById) {
        this.purchaseitemsById = purchaseitemsById;
    }
}

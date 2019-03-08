package ch.hslu.edu.enapp.webshop.entity;

import ch.hslu.edu.enapp.webshop.converter.PasswordConverter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "getCustomerByName", query = "SELECT c FROM CustomerEntity c WHERE c.name = :name"),
        @NamedQuery(name = "getCustomers", query = "SELECT c FROM CustomerEntity c")
})
@Table(name = "customer", schema = "webshop", catalog = "")
public class CustomerEntity {
    private String name;
    private String password;
    private String firstname;
    private String lastname;
    private String address;
    private String email;
    private String dynnavcustno;
    private Collection<CustomertoroleEntity> customertorolesByName;
    private Collection<PurchaseEntity> purchasesByName;

    @Id
    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 255)
    @Convert(converter = PasswordConverter.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "firstname", nullable = false, length = 255)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "lastname", nullable = false, length = 255)
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "address", nullable = false, length = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "dynnavcustno", nullable = true, length = 255)
    public String getDynnavcustno() {
        return dynnavcustno;
    }

    public void setDynnavcustno(String dynnavcustno) {
        this.dynnavcustno = dynnavcustno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerEntity that = (CustomerEntity) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(password, that.password) &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(lastname, that.lastname) &&
                Objects.equals(address, that.address) &&
                Objects.equals(email, that.email) &&
                Objects.equals(dynnavcustno, that.dynnavcustno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password, firstname, lastname, address, email, dynnavcustno);
    }

    @OneToMany(mappedBy = "customerByName")
    public Collection<CustomertoroleEntity> getCustomertorolesByName() {
        return customertorolesByName;
    }

    public void setCustomertorolesByName(Collection<CustomertoroleEntity> customertorolesByName) {
        this.customertorolesByName = customertorolesByName;
    }

    @OneToMany(mappedBy = "customerByCustomer")
    public Collection<PurchaseEntity> getPurchasesByName() {
        return purchasesByName;
    }

    public void setPurchasesByName(Collection<PurchaseEntity> purchasesByName) {
        this.purchasesByName = purchasesByName;
    }
}

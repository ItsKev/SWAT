package ch.hslu.edu.enapp.webshop;

import ch.hslu.edu.enapp.webshop.beans.AccountBean;
import ch.hslu.edu.enapp.webshop.dto.Customer;
import ch.hslu.edu.enapp.webshop.entity.CustomerEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.validation.constraints.AssertFalse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountBeanTest {
    @Mock
    private EntityManager entityManagerMock;
    @Mock
    private TypedQuery<CustomerEntity> queryMock;

    @InjectMocks
    private AccountBean accountBean;

    @Before
    public void setUp() {
        accountBean = new AccountBean();
        MockitoAnnotations.initMocks(this);
        final List<CustomerEntity> customerEntities = getCustomerEntities();

        when(queryMock.getResultList()).thenReturn(customerEntities);
        when(entityManagerMock.createNamedQuery("getCustomerByName", CustomerEntity.class))
                .thenReturn(queryMock);
        when(entityManagerMock.createNamedQuery("getCustomers", CustomerEntity.class))
                .thenReturn(queryMock);
    }

    @Test
    public void getCustomer() {
        Optional<Customer> customer = accountBean.getCustomer("Test");
        if (customer.isPresent()) {
            Assert.assertEquals("Test", customer.get().getName());
        } else {
            Assert.fail();
        }
    }

    @Test
    public void getCustomer_NotAvailableCustomer() {
        when(queryMock.getResultList()).thenReturn(Collections.emptyList());
        Optional<Customer> customer = accountBean.getCustomer("Jon");
        customer.ifPresent(c -> Assert.fail());
    }

    @Test
    public void getAllCustomers() {
        List<Customer> customers = accountBean.getAllCustomers();
        Assert.assertEquals("Test", customers.get(0).getName());
        Assert.assertEquals("Admin", customers.get(1).getName());
    }

    @Test
    public void getAllCustomers_NoCustomersAvailable() {
        when(queryMock.getResultList()).thenReturn(Collections.emptyList());
        Assert.assertEquals(Collections.emptyList(), accountBean.getAllCustomers());
    }

    private List<CustomerEntity> getCustomerEntities() {
        final List<CustomerEntity> customerEntities = new ArrayList<>();
        final CustomerEntity customer = new CustomerEntity();
        customer.setName("Test");
        customer.setFirstname("Hans");
        customer.setLastname("Meier");
        customerEntities.add(customer);

        final CustomerEntity customer2 = new CustomerEntity();
        customer2.setName("Admin");
        customer2.setFirstname("root");
        customer2.setLastname("toor");
        customerEntities.add(customer2);
        return customerEntities;
    }
}

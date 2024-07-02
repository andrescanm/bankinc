package com.app.bankinc.controller;

import com.app.bankinc.model.Customer;
import com.app.bankinc.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
public class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllCustomers() {
        List<Customer> customerList = List.of(new Customer());
        when(customerService.getAllCustomers()).thenReturn(customerList);

        List<Customer> result = customerController.getAllCustomers();
        assertEquals(customerList, result);
    }

    @Test
    public void testGetCustomerById() {
        Customer customer = new Customer();
        when(customerService.getCustomerById(anyLong())).thenReturn(Optional.of(customer));

        ResponseEntity<Customer> result = customerController.getCustomerById(1L);
        assertEquals(ResponseEntity.ok(customer), result);
    }

    @Test
    public void testCreateCustomer() {
        Customer customer = new Customer();
        when(customerService.createCustomer(any(Customer.class))).thenReturn(customer);

        Customer result = customerController.createCustomer(customer);
        assertEquals(customer, result);
    }

    @Test
    public void testDeleteCustomer() {
        ResponseEntity<Void> result = customerController.deleteCustomer(1L);
        assertEquals(ResponseEntity.noContent().build(), result);
    }
}

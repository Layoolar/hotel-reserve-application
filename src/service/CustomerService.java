package service;

import model.customer.Customer;

import java.util.*;

public class CustomerService {
    private static final CustomerService INSTANCE = new CustomerService();
    private Map<String, Customer> customers = new HashMap<>();

    private CustomerService() { }

    public static CustomerService getInstance() {
        return INSTANCE;
    }

    public void addCustomer(String firstName, String lastName, String email) {
        customers.put(email, new Customer(firstName, lastName, email));
    }

    public Customer getCustomer(String customerEmail) {
        return customers.get(customerEmail);
    }

    public Collection<Customer> getAllCustomers() {
        return customers.values();
    }
}

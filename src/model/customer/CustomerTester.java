package model.customer;

public class CustomerTester {
    public static void main(String[] args) {
        // create a new customer
        Customer customer = new Customer("John", "Doe", "john.doe@example.com");

        // print the customer details
        System.out.println(customer);

        // test the email validation
        try {
            Customer invalidCustomer = new Customer("Jane", "Smith", "invalid.email");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid email: " + e.getMessage());
        }
    }
}

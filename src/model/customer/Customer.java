package model.customer;

public class Customer {
    private String firstName;
    private String lastName;
    private String email;

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println(email);
//        if (email == "") { throw new IllegalArgumentException("null"); }
        if (!email.matches("^(.+)@(.+).(.+)$")) {
            throw new IllegalArgumentException("Invalid email address format. The email should be in format 'name@domain.com'");
        }
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName + ", Email: " + email;
    }
}


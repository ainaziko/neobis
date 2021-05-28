package Part2;

import java.util.Objects;

public class Customer {
    private Long id;
    private String firstname;
    private String lastName;
    private String email;
    private String city;
    private Order order;

    public Customer() {
    }

    public Customer(String firstname, String lastName, String email, String city) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.email = email;
        this.city = city;
    }
    public Customer(String firstname, String lastName, String email, String city, Order order) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.email = email;
        this.city = city;
        this.order = order;
    }

    public Customer(Long id, String firstname, String lastName, String email, String city) {
        this.id = id;
        this.firstname = firstname;
        this.lastName = lastName;
        this.email = email;
        this.city = city;
    }

    public Customer(Long id, String firstname, String lastName, String email, String city, Order order) {
        this.id = id;
        this.firstname = firstname;
        this.lastName = lastName;
        this.email = email;
        this.city = city;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", order=" + order +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(firstname, customer.firstname) && Objects.equals(lastName, customer.lastName) && Objects.equals(email, customer.email) && Objects.equals(city, customer.city) && Objects.equals(order, customer.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastName, email, city, order);
    }
}

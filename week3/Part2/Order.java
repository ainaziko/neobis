package Part2;

import java.util.Objects;

public class Order {
    private int orderId;
    private Customer customer;
    private Cake cake;
    private SoftDrinks softDrinks;

    public Order() {}

    public Order(Customer customer, Cake cake) {
        this.customer = customer;
        this.cake = cake;
    }

    public Order(Customer customer, SoftDrinks softDrinks) {
        this.customer = customer;
        this.softDrinks = softDrinks;
    }

    public Order(Customer customer, Cake cake, SoftDrinks softDrinks) {
        this.customer = customer;
        this.cake = cake;
        this.softDrinks = softDrinks;
    }

    public Order(int orderId, Customer customer, Cake cake, SoftDrinks softDrinks) {
        this.orderId = orderId;
        this.customer = customer;
        this.cake = cake;
        this.softDrinks = softDrinks;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Cake getCake() {
        return cake;
    }

    public void setCake(Cake cake) {
        this.cake = cake;
    }

    public SoftDrinks getSoftDrinks() {
        return softDrinks;
    }

    public void setSoftDrinks(SoftDrinks softDrinks) {
        this.softDrinks = softDrinks;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customer=" + customer +
                ", cake=" + cake +
                ", softDrinks=" + softDrinks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId && Objects.equals(customer, order.customer) && Objects.equals(cake, order.cake) && Objects.equals(softDrinks, order.softDrinks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, customer, cake, softDrinks);
    }
}

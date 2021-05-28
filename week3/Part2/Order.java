package Part2;

import java.util.Objects;

public class Order {
    private int orderId;
    private Customer customer;
    private Dessert dessert;
    private int dessertDuplicates;
    private SoftDrink softDrink;
    private int softDrinkDuplicates;
    private String date;


    public Order() {}

    public Order(Dessert dessert, int dessertDuplicates, String date) {
        this.dessert = dessert;
        this.dessertDuplicates = dessertDuplicates;
        this.date = date;
    }
    public Order(SoftDrink softDrink, int softDrinkDuplicates, String date) {
        this.softDrink = softDrink;
        this.softDrinkDuplicates = softDrinkDuplicates;
        this.date = date;
    }

    public Order(Dessert dessert,int dessertDuplicates, SoftDrink softDrink, int softDrinkDuplicates, String date) {
        this.dessert = dessert;
        this.dessertDuplicates = dessertDuplicates;
        this.softDrink = softDrink;
        this.softDrinkDuplicates = softDrinkDuplicates;
        this.date = date;
    }


    public Order(int orderId, Dessert dessert, int dessertDuplicates, String date) {
        this.orderId = orderId;
        this.dessert = dessert;
        this.dessertDuplicates = dessertDuplicates;
        this.date = date;
    }

    public Order(int orderId, SoftDrink softDrink, int softDrinkDuplicates, String date) {
        this.orderId = orderId;
        this.softDrink = softDrink;
        this.softDrinkDuplicates = softDrinkDuplicates;
        this.date = date;
    }

    public Order(int orderId, Dessert dessert, int dessertDuplicates, SoftDrink softDrink, int softDrinkDuplicates, String date) {
        this.orderId = orderId;
        this.dessert = dessert;
        this.dessertDuplicates = dessertDuplicates;
        this.softDrink = softDrink;
        this.softDrinkDuplicates = softDrinkDuplicates;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", dessert=" + dessert +
                ", dessertDuplicates=" + dessertDuplicates +
                ", softDrink=" + softDrink +
                ", softDrinkDuplicates=" + softDrinkDuplicates +
                ", date='" + date + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId && dessertDuplicates == order.dessertDuplicates && softDrinkDuplicates == order.softDrinkDuplicates && customer.equals(order.customer) && dessert.equals(order.dessert) && softDrink.equals(order.softDrink) && date.equals(order.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, customer, dessert, dessertDuplicates, softDrink, softDrinkDuplicates, date);
    }
}

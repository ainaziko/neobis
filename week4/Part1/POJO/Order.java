package POJO;

import java.util.Objects;

public class Order {
    private int orderId;
    private int customerId;
    private Dessert dessert;
    private int dessertDuplicates;
    private SoftDrink softDrink;
    private int softDrinkDuplicates;
    private String date;


    public Order() {}

    public Order(int orderId, int customerId, Dessert dessert, int dessertDuplicates, SoftDrink softDrink, int softDrinkDuplicates, String date) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.dessert = dessert;
        this.dessertDuplicates = dessertDuplicates;
        this.softDrink = softDrink;
        this.softDrinkDuplicates = softDrinkDuplicates;
        this.date = date;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Dessert getDessert() {
        return dessert;
    }

    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }

    public int getDessertDuplicates() {
        return dessertDuplicates;
    }

    public void setDessertDuplicates(int dessertDuplicates) {
        this.dessertDuplicates = dessertDuplicates;
    }

    public SoftDrink getSoftDrink() {
        return softDrink;
    }

    public void setSoftDrink(SoftDrink softDrink) {
        this.softDrink = softDrink;
    }

    public int getSoftDrinkDuplicates() {
        return softDrinkDuplicates;
    }

    public void setSoftDrinkDuplicates(int softDrinkDuplicates) {
        this.softDrinkDuplicates = softDrinkDuplicates;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
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
        return orderId == order.orderId && customerId == order.customerId && dessertDuplicates == order.dessertDuplicates && softDrinkDuplicates == order.softDrinkDuplicates && Objects.equals(dessert, order.dessert) && Objects.equals(softDrink, order.softDrink) && Objects.equals(date, order.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, customerId, dessert, dessertDuplicates, softDrink, softDrinkDuplicates, date);
    }
}

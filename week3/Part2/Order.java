package Part2;

public class Order {
    private int orderId;
    private Customer customer;
    private Cake cake;
    private SoftDrinks softDrinks;
    private double check;

    public Order(Customer customer, Cake cake, SoftDrinks softDrinks, double check) {
        this.customer = customer;
        this.cake = cake;
        this.softDrinks = softDrinks;
        this.check = check;
    }

    public Order(Customer customer, Cake cake, SoftDrinks softDrinks) {
        this.orderId = orderId;
        this.customer = customer;
        this.cake = cake;
        this.softDrinks = softDrinks;
        this.check = check;
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

    public double getCheck() {
        check = cake.calcPrice() + softDrinks.calcPrice();
        return check;
    }

}

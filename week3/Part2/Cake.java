package Part2;

import java.util.Objects;

public class Cake {
    private int id;
    private String name;
    private int diameter;
    private double price;


    public Cake() { }

    public Cake(String name, int diameter, double price) {
        this.name = name;
        this.diameter = diameter;
        this.price = price;
    }

    public Cake(int id, String name, int diameter, double price) {
        this.id = id;
        this.name = name;
        this.diameter = diameter;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Cake{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", diameter=" + diameter +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cake cake = (Cake) o;
        return id == cake.id && diameter == cake.diameter && Double.compare(cake.price, price) == 0 && Objects.equals(name, cake.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, diameter, price);
    }
}

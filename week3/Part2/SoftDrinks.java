package Part2;

import java.util.Objects;

public class SoftDrinks{
    private int id;
    private String name;
    private boolean natual;
    private boolean carbonated;
    private int weight;
    private double price;
    private int duplicates;

    public SoftDrinks() {}

    public SoftDrinks(String name, boolean natual, boolean carbonated, int weight, double price, int duplicates) {
        this.name = name;
        this.natual = natual;
        this.carbonated = carbonated;
        this.weight = weight;
        this.price = price;
        this.duplicates = duplicates;
    }

    public SoftDrinks(int id, String name, boolean natual, boolean carbonated, int weight, double price, int duplicates) {
        this.id = id;
        this.name = name;
        this.natual = natual;
        this.carbonated = carbonated;
        this.weight = weight;
        this.price = price;
        this.duplicates = duplicates;
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

    public boolean isNatual() {
        return natual;
    }

    public void setNatual(boolean natual) {
        this.natual = natual;
    }

    public boolean isCarbonated() {
        return carbonated;
    }

    public void setCarbonated(boolean carbonated) {
        this.carbonated = carbonated;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDuplicates() {
        return duplicates;
    }

    public void setDuplicates(int duplicates) {
        this.duplicates = duplicates;
    }

    @Override
    public String toString() {
        return "SoftDrinks{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", natual=" + natual +
                ", carbonated=" + carbonated +
                ", weight=" + weight +
                ", price=" + price +
                ", duplicates=" + duplicates +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SoftDrinks that = (SoftDrinks) o;
        return id == that.id && natual == that.natual && carbonated == that.carbonated && weight == that.weight && Double.compare(that.price, price) == 0 && duplicates == that.duplicates && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, natual, carbonated, weight, price, duplicates);
    }
}

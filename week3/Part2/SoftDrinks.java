package Part2;

public class SoftDrinks extends Product {
    private int id;
    private String name;
    private boolean natual;
    private boolean carbonated;
    private int weight;
    private double price;
    private int duplicates;

    public SoftDrinks() {
    }

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
    public double calcPrice() {
        return price * duplicates;
    }
}

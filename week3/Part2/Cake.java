package Part2;

public class Cake extends Product {
    private int id;
    private String name;
    private int diameter;
    private double price;
    private int duplicates;

    public Cake() {
    }

    public Cake(String name, int diameter, double price, int duplicates) {
        this.name = name;
        this.diameter = diameter;
        this.price = price;
        this.duplicates = duplicates;
    }


    public Cake(int id, String name, int diameter, double price, int duplicates) {
        this.id = id;
        this.name = name;
        this.diameter = diameter;
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

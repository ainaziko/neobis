package com.production.stock.entity;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dessert")
public class Dessert {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "dessertId")
    private Long id;
    @Column(name = "dessertName")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "imgPath")
    private String imgPath;
    @Column(name = "price")
    private double price;

    public Dessert() {}

    public Dessert(String name, String description, String imgPath, double price) {
        this.name = name;
        this.description = description;
        this.imgPath = imgPath;
        this.price = price;
    }

    public Dessert(Long id, String name, String description, String imgPath, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imgPath = imgPath;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Dessert{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dessert dessert = (Dessert) o;
        return id == dessert.id && Double.compare(dessert.price, price) == 0 && Objects.equals(name, dessert.name) && Objects.equals(description, dessert.description) && Objects.equals(imgPath, dessert.imgPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, imgPath, price);
    }
}

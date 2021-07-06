package com.production.stock.entity;


import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "dessert")
public class Dessert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Dessert(String name, String description, String imgPath, double price) {
        this.name = name;
        this.description = description;
        this.imgPath = imgPath;
        this.price = price;
    }
}

package com.production.stock.entity;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "city")
    private String city;

    public Customer(String firstname, String lastName, String email, String city) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.email = email;
        this.city = city;
    }
}

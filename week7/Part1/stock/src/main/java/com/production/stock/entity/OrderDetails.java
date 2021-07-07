package com.production.stock.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "orderdetails")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderDetailId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order_id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dessert_id", nullable = false)
    private Dessert dessert_id;

    private int dessertQuantity;

    private double dessertsPrice;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "drink_id", nullable = false)
    private SoftDrink drink_id;

    private int drinkQuantity;

    private double drinksPrice;

    private double total;

    public OrderDetails(Order order_id, Dessert dessert_id, int dessertQuantity, double dessertsPrice, SoftDrink drink_id, int drinkQuantity, double drinksPrice, double total) {
        this.order_id = order_id;
        this.dessert_id = dessert_id;
        this.dessertQuantity = dessertQuantity;
        this.dessertsPrice = dessertsPrice;
        this.drink_id = drink_id;
        this.drinkQuantity = drinkQuantity;
        this.drinksPrice = drinksPrice;
        this.total = total;
    }


}

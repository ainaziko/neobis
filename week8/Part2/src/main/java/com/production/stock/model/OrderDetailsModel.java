package com.production.stock.model;

import com.production.stock.entity.Dessert;
import com.production.stock.entity.Order;
import com.production.stock.entity.SoftDrink;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsModel {

    private Long orderDetailId;
    private Order orderId;
    private Dessert dessertId;
    private int dessertQuantity;
    private double dessertPrice;
    private SoftDrink drinkId;
    private int drinkQuantity;
    private double drinkPrice;
    private double total;
}

package com.production.stock.model;

import com.production.stock.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderModel {

    private Long id;
    private Customer customerId;
    private LocalDateTime date;
    private int payed;
}

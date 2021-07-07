package com.production.stock.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customerId;

    private LocalDateTime date;

    private int payed;

    public Order(Customer customerId, LocalDateTime date, int payed) {
        this.customerId = customerId;
        this.date = date;
        this.payed = payed;
    }
}

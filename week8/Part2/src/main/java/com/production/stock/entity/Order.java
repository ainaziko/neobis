package com.production.stock.entity;

import com.production.stock.appuser.AppUser;
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
    private AppUser appUserId;

    private LocalDateTime date;

    private int payed;

    public Order(AppUser appUserId, LocalDateTime date, int payed) {
        this.appUserId = appUserId;
        this.date = date;
        this.payed = payed;
    }
}

package com.production.stock.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DessertModel {
    private Long id;
    private String name;
    private String description;
    private String imgPath;
    private double price;
}

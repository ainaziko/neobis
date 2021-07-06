package com.production.stock.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerModel {
    private Long id;
    private String firstname;
    private String lastName;
    private String email;
    private String city;
}

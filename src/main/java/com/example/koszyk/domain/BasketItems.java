package com.example.koszyk.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BASKET_ITEMS")
@Getter
@Setter
public class BasketItems {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "BASKET_ID")
    private long idBasket;

    @Column(name = "NAME")
    private String name;

    @Column(name = "QUANT")
    private int quantity;

    @Column(name = "PRICE")
    private double price;

    @Column(name = "SUMA")
    private double sumPrice;

    public BasketItems(String name, long idBasket, int quantity) {
        this.name = name;
        this.idBasket = idBasket;
        this.quantity = quantity;
    }

}

package com.example.koszyk.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "BASKET_ITEMS")
@Getter
@Setter
public class BasketItems {

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
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

    public BasketItems(long idBasket, String name, int quantity) {
        this.idBasket = idBasket;
        this.name = name;
        this.quantity = quantity;
        this.sumPrice = quantity * price;
    }

}

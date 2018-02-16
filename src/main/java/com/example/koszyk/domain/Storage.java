package com.example.koszyk.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "STORAGE")
@Getter
public class Storage {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "ITEM")
    private String name;

    @Column(name = "PRICE")
    private double price;

    @Column(name = "UNIT")
    private int unit;

    @Column(name = "SPECIAL_PRICE")
    private double specialPrice;
}

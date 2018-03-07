package com.example.koszyk.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@AllArgsConstructor
@Entity
@Table(name = "BASKETS")
@Getter
@Setter
public class Basket {

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @NotNull
    @Column(name = "CREATED")
    private Date created;

    @Column(name = "CLOSED")
    private Date close;

    @Column(name = "SUMA")
    private double sum;

    public Basket() {
        this.created = new Date();
    }
}

package com.example.koszyk.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "BASKETS")
@Getter
@AllArgsConstructor
public class Baskets {

    @NotNull
    @Id
    @GeneratedValue
    private long id;
    @NotNull
    @Column (name = "CREATE")
    private Date create;
    @Column (name = "ITEMS")
    private List<Item> items = new ArrayList<>();
    @Column (name = "CLOSE")
    private Date close;
    @Column (name = "SUM")
    private double sum;

}

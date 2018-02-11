package com.example.koszyk.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NamedNativeQueries( {

        @NamedNativeQuery(
                name = "Baskets.closeBaskets",
                query = "UPDATE BASKETS SET CLOSED = :NOWA,SUMA = 100 WHERE ID = :ID",
                resultClass = Baskets.class
        ),
        @NamedNativeQuery(
                name = "Baskets.getSum",
                query = "SELECT SUMA FROM BASKETS WHERE ID = :ID",
                resultClass = Baskets.class
        )
})

@Entity
@Table(name = "BASKETS")
@Getter
@Setter
public class Baskets {

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ID")
    private long id;

    @NotNull
    @Column(name = "CREATED")
    private Date created;

    @Column(name = "CLOSED")
    private Date close;

    @Column(name = "SUMA")
    private double sum;

    public Baskets() {
        this.created = new Date();
    }
}

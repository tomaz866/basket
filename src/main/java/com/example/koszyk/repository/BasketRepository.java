package com.example.koszyk.repository;

import com.example.koszyk.domain.Baskets;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface BasketRepository extends CrudRepository<Baskets,Long> {

    @Override
    Baskets save(Baskets basket);

    @Query(nativeQuery = true)
    Baskets closeBaskets(@Param("NOWA") Date date, @Param("ID") long id);

    @Query(nativeQuery = true)
    Baskets getSum(@Param("ID") long id);

}

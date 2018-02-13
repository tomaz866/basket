package com.example.koszyk.repository;

import com.example.koszyk.domain.Baskets;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends CrudRepository<Baskets,Long> {

    @Override
    Baskets save(Baskets basket);

    Baskets getById(Long id);



}

package com.example.koszyk.repository;

import com.example.koszyk.domain.Basket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends CrudRepository<Basket,Long> {

    @Override
    Basket save(Basket basket);

    Basket getById(Long id);



}

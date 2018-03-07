package com.example.koszyk.repository;

import com.example.koszyk.domain.BasketItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<BasketItem,Long> {

    @Override
    BasketItem save(BasketItem items);

    @Override
    void deleteById(Long id);

    List<BasketItem> getAllByIdBasket(Long idBasket);

    BasketItem getById(Long id);






}

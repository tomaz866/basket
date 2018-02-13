package com.example.koszyk.repository;

import com.example.koszyk.domain.BasketItems;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<BasketItems,Long> {

    @Override
    BasketItems save(BasketItems items);

    @Override
    void deleteById(Long id);

    List<BasketItems> getAllByIdBasket(Long idBasket);

    BasketItems getById(Long id);

    @Query(nativeQuery = true)
    double counts(@Param("ID") Long id);



}

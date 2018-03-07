package com.example.koszyk.service;

import com.example.koszyk.component.SumAllItems;
import com.example.koszyk.domain.Basket;
import com.example.koszyk.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BasketService {

    @Autowired
    BasketRepository basketRepository;

    @Autowired
    SumAllItems sumAllItems;

    public long open() {
        Basket basket = new Basket();
        basketRepository.save(basket);
        return basket.getId();
    }

    public double close(long id) {
        Basket basket = basketRepository.getById(id);
        basket.setClose(new Date());
        basket.setSum(sumAllItems.sum(id));
        basketRepository.save(basket);
        return basket.getSum();
    }


}

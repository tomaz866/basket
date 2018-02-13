package com.example.koszyk.service;

import com.example.koszyk.domain.Baskets;
import com.example.koszyk.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BasketService {

    @Autowired
    BasketRepository basketRepository;

    public long open() {
        Baskets baskets = new Baskets();
        basketRepository.save(baskets);
        return baskets.getId();
    }

    public double close(long id) {
        Baskets baskets = basketRepository.getById(id);
        baskets.setClose(new Date());
        baskets.setSum(300);
        basketRepository.save(baskets);
        return baskets.getSum();
    }


}

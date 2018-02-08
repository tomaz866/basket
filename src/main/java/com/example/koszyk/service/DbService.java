package com.example.koszyk.service;

import com.example.koszyk.domain.Baskets;
import com.example.koszyk.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbService {

    @Autowired
    private BasketRepository basketRepository;

    public Baskets open(Baskets baskets) {
        return basketRepository.save(baskets);
    }
}

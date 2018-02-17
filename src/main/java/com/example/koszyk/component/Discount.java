package com.example.koszyk.component;

import com.example.koszyk.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Discount {

    @Autowired
    StorageRepository storageRepository;

    public double sprice (String name, int q) {
        int quant = storageRepository.getByName(name).getUnit();
        double prices = 0;
        if(quant<=q) {
            prices = storageRepository.getByName(name).getSpecialPrice();
        } if (quant>q) {
            prices = storageRepository.getByName(name).getPrice();
        }
        return prices;
    }
}

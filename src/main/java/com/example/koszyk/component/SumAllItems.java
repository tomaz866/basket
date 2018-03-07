package com.example.koszyk.component;

import com.example.koszyk.domain.BasketItem;
import com.example.koszyk.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SumAllItems {

    @Autowired
    ItemRepository itemRepository;

    public double sum(long id) {
        List<BasketItem> list = itemRepository.getAllByIdBasket(id);
        double suma = 0;
        for(int n=0; n < list.size(); n++) {
            suma +=list.get(n).getSumPrice();
        }
        return suma;
    }
}

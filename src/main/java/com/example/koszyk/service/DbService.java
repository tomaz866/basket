package com.example.koszyk.service;

import com.example.koszyk.domain.BasketItems;
import com.example.koszyk.domain.Baskets;
import com.example.koszyk.repository.BasketRepository;
import com.example.koszyk.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbService {

    @Autowired
    private BasketRepository basketRepository;

    @Autowired
    private ItemRepository itemRepository;

    public long open() {
        Baskets baskets = new Baskets();
        basketRepository.save(baskets);
        return baskets.getId();
    }

    public long addItem(String name, int quant, long basketId) {
        BasketItems item = new BasketItems(basketId, name, quant);
        itemRepository.save(item);
        return item.getId();
    }

    public void deleteItem(long id) {
        itemRepository.deleteById(id);
    }

    public List<BasketItems> showItems(long idBasket) {
        return itemRepository.getAllByIdBasket(idBasket);
    }

}

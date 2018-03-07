package com.example.koszyk.service;

import com.example.koszyk.component.Discount;
import com.example.koszyk.domain.BasketItem;
import com.example.koszyk.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketItemsService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    Discount discount;

    public long addItem(String name, long bId, int quant) {
        BasketItem item = new BasketItem(name, bId, quant);
        item.setPrice(discount.sprice(name, quant));
        item.setSumPrice(item.getPrice()* quant);
        itemRepository.save(item);
        return item.getId();
    }

    public void updateItem(long id, int quant) {
        BasketItem item = itemRepository.getById(id);
        item.setQuantity(quant);
        itemRepository.save(item);
    }

    public void deleteItem(long id) {
        itemRepository.deleteById(id);
    }

    public List<BasketItem> showItems(long idBasket) {
        return itemRepository.getAllByIdBasket(idBasket);
    }

}

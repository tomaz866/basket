package com.example.koszyk.controller;

import com.example.koszyk.domain.BasketItem;
import com.example.koszyk.service.BasketItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/items")
public class ItemController {

    @Autowired
    private BasketItemsService service;

    @RequestMapping(method = RequestMethod.POST, value = "add")
    public long add(@RequestParam String name, @RequestParam long bId, @RequestParam int q) {
        return service.addItem(name, bId, q);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "delete")
    public void delete(@RequestParam Long itemId) {
        service.deleteItem(itemId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "showBasket")
    public List<BasketItem> showBasket(@RequestParam Long bId) {
        return service.showItems(bId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "update")
    public void update(@RequestParam Long itemId, @RequestParam int q) {
        service.updateItem(itemId, q);
    }
}







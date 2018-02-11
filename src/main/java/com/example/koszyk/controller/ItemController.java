package com.example.koszyk.controller;

import com.example.koszyk.domain.BasketItems;
import com.example.koszyk.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/items")
public class ItemController {

    @Autowired
    private DbService service;

    @RequestMapping(method = RequestMethod.GET, value = "add")
    public long add(@RequestParam String name, @RequestParam Long basketId, @RequestParam int q) {
        return service.addItem(name, q, basketId);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "delete")
    public void delete(@RequestParam Long itemId) {
        service.deleteItem(itemId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "showBasket")
    public List<BasketItems> showBasket(@RequestParam Long basketId) {
        return service.showItems(basketId);
    }
}







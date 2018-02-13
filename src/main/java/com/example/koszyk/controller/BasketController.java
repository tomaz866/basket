package com.example.koszyk.controller;

import com.example.koszyk.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/basket")
public class BasketController {

    @Autowired
    private BasketService service;

    @RequestMapping(method = RequestMethod.POST, value = "open")
    public long openBasket() {
        return service.open();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "close")
    public double closeBasket(@RequestParam long id) {
        return service.close(id);
    }
}

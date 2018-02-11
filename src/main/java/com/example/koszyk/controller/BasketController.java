package com.example.koszyk.controller;

import com.example.koszyk.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/basket")
public class BasketController {

    @Autowired
    private DbService service;

    @RequestMapping(method = RequestMethod.GET, value = "open")
    @ResponseBody
    public long openBasket() {
        return service.open();
    }

    @RequestMapping(method = RequestMethod.GET, value = "close")
    @ResponseBody
    public double closeBasket() {
        return 100;
    }
}

package com.example.koszyk.controller;

import com.example.koszyk.domain.Item;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/basket")
public class BasketController {

    @RequestMapping(method = RequestMethod.POST, value = "open")
    public void openBasket() {

    }

    @RequestMapping(method = RequestMethod.GET, value = "close")
    public double closeBasket() {
        return 10;
    }
}

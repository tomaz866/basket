package com.example.koszyk.controller;

import com.example.koszyk.domain.BasketItems;
import com.example.koszyk.service.BasketItemsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BasketItemsService service;

    @Test
    public void shouldShowBasket() throws Exception {
        //Given
        BasketItems item1 = new BasketItems("A",1L,3);
        BasketItems item2 = new BasketItems("B",1L,4);
        BasketItems item3 = new BasketItems("C",1L,7);

        List<BasketItems> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);

        when(service.showItems(1L)).thenReturn(items);

        // When & Then
        mockMvc.perform(get("/v1/items/showBasket?bId=1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].name", is("A")))
                .andExpect(jsonPath("$[0].idBasket", is(1)))
                .andExpect(jsonPath("$[0].quantity", is(3)))
                .andExpect(jsonPath("$[1].name", is("B")))
                .andExpect(jsonPath("$[1].idBasket", is(1)))
                .andExpect(jsonPath("$[1].quantity", is(4)))
                .andExpect(jsonPath("$[2].name", is("C")))
                .andExpect(jsonPath("$[2].idBasket", is(1)))
                .andExpect(jsonPath("$[2].quantity", is(7)));
    }

    @Test
    public void shouldDeleteItem() throws Exception {
        // Given

        // When & Then
        mockMvc.perform(delete("/v1/items/delete?itemId=1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldAddItem() throws Exception {
        //Given

        when(service.addItem("A", 1, 3)).thenReturn(1L);

        // When & Then
        mockMvc.perform(post("/v1/items/add?name=A&bId=1&q=3")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldUpdateItem() throws Exception {
        // Given

        // When & Then
        mockMvc.perform(put("/v1/items/update?itemId=1&q=3")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}

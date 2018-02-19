package com.example.koszyk.controller;

import com.example.koszyk.service.BasketService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BasketController.class)
public class BasketControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BasketService service;

    @Test
    public void shouldOpenBasket() throws Exception {
        //Given

        when(service.open()).thenReturn(1L);

        // When & Then
        mockMvc.perform(post("/v1/basket/open")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}

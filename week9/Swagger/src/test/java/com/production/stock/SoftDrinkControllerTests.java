package com.production.stock;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.production.stock.model.SoftDrinkModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SoftDrinkControllerTests {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper;

    public SoftDrinkControllerTests(){
        mapper = new ObjectMapper();
    }

    @Test
    public void add() throws Exception{
        SoftDrinkModel softDrinkModel = new SoftDrinkModel("Fresh Mix", "Mixed fruits drink", "path/mix", 100);

        String jsonRequest = mapper.writeValueAsString(softDrinkModel);

        mockMvc.perform( post("http://localhost:8085/dessert/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getAll() throws Exception{
        mockMvc.perform( get("http://localhost:8085/drink/all"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getById() throws Exception{
        mockMvc.perform(get("http://localhost:8085/drink/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void update() throws Exception{
        SoftDrinkModel softDrinkModel = new SoftDrinkModel("Fresh Mix", "Mixed fruits drink", "path/mix", 120);
        String jsonRequest = mapper.writeValueAsString((softDrinkModel));

        mockMvc.perform(put("http://localhost:8085/drink/edit/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andDo(print())
                .andExpect(status().isOk());
    }
}

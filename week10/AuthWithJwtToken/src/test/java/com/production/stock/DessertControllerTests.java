package com.production.stock;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.production.stock.model.DessertModel;
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
public class DessertControllerTests {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper;

    public DessertControllerTests(){
        mapper = new ObjectMapper();
    }

    @Test
    public void add() throws Exception{
        DessertModel dessertModel = new DessertModel("Mochi", "Japanese dessert", "path/mochi", 100);

        String jsonRequest = mapper.writeValueAsString(dessertModel);

        mockMvc.perform( post("http://localhost:8085/dessert/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getAll() throws Exception{
        mockMvc.perform( get("http://localhost:8085/dessert/all"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getById() throws Exception{
        mockMvc.perform(get("http://localhost:8085/dessert/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void update() throws Exception{
        DessertModel dessertModel = new DessertModel("Mochi", "Japanese dessert", "path/mochi", 100);
        String jsonRequest = mapper.writeValueAsString((dessertModel));

        mockMvc.perform(put("http://localhost:8085/dessert/edit/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andDo(print())
                .andExpect(status().isOk());
    }
}

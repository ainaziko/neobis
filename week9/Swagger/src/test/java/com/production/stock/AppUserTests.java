package com.production.stock;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.production.stock.appuser.AppUserRole;
import com.production.stock.model.AppUserModel;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AppUserTests {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper;

    public AppUserTests(){
        mapper = new ObjectMapper();
    }
    @Test
    public void add() throws Exception{
        AppUserModel peopleModel = new AppUserModel("Selena", "Mia", "mise@gmail.com", "password", AppUserRole.USER);

        String jsonRequest = mapper.writeValueAsString(peopleModel);

        mockMvc.perform( post("http://localhost:8085/customer/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getAll() throws Exception{
        mockMvc.perform( get("http://localhost:8085/customer/all"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getById() throws Exception{
        mockMvc.perform(get("http://localhost:8085/customer/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void update() throws Exception{
        AppUserModel peopleModel = new AppUserModel("Selena", "Mia", "mise@gmail.com", "password", AppUserRole.USER);
        String jsonRequest = mapper.writeValueAsString((peopleModel));

        mockMvc.perform(put("http://localhost:8085/customer/edit/{id}", 2)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andDo(print())
                .andExpect(status().isOk());
    }
}

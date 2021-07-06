package com.production.stock.controllers;

import com.production.stock.entity.Customer;
import com.production.stock.model.CustomerModel;
import com.production.stock.servise.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("all")
    public List<Customer> getAll(){
        return customerService.findAll();
    }

    @GetMapping("{id}")
    public Optional<Customer> getById(@PathVariable(name = "id") Long id){
        return customerService.findById(id);
    }

    @PostMapping("/add")
    public CustomerModel add(@RequestBody CustomerModel model){
        customerService.add(model);
        return model;
    }

    @PutMapping("edit/{id}")
    public Customer edit(@PathVariable(name = "id") Long id, @RequestBody CustomerModel model) throws Exception {
        return customerService.edit(id, model);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id){
        customerService.delete(id);
        return "Deleted";
    }
}

package com.production.stock.servise;

import com.production.stock.entity.Customer;
import com.production.stock.model.CustomerModel;
import com.production.stock.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAll(){
        return (List<Customer>) customerRepository.findAll();
    }

    public Optional<Customer> findById(Long id){
        return customerRepository.findById(id);
    }

    public Customer add(CustomerModel model){
        Customer customer = new Customer(model.getFirstname(), model.getLastName(), model.getEmail(), model.getCity());
        customerRepository.save(customer);
        return customer;
    }

    public Customer edit(Long id, CustomerModel model) throws Exception {
        return customerRepository.findById(id)
                .map(edit -> {
                    edit.setFirstname(model.getFirstname());
                    edit.setLastName(model.getLastName());
                    edit.setEmail(model.getEmail());
                    edit.setCity(model.getCity());
                    return customerRepository.save(edit);
                }).orElseThrow(Exception::new);
    }

    public String delete(Long id){
        customerRepository.deleteById(id);
        return "Deleted";
    }

}

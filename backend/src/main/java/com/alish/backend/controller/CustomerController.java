package com.alish.backend.controller;

import com.alish.backend.dto.CustomerDTO;
import com.alish.backend.model.Customer;
import com.alish.backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerDTO customerDTO) {
        Customer createdCustomer = customerService.createCustomer(Customer.builder()
                .name(customerDTO.getName())
                .password(customerDTO.getPassword())
                .username(customerDTO.getUsername())
                .voen(customerDTO.getVoen())
                .build());
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerId(@PathVariable long id){
        Customer customer = customerService.getCustomerById(id);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer CustomerDetails) {
        Customer updatedCustomer = customerService.updateCustomer(id, CustomerDetails);
        if (updatedCustomer != null) {
            return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

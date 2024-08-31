package com.alish.backend.service;

import com.alish.backend.model.Customer;
import com.alish.backend.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    public List<Customer> getAllCustomers() {
        log.info("printing all customers");
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        log.info("retrieving a customer by id:" + id);
        return customerRepository.findById(id).orElse(null);
    }

    public Customer createCustomer(Customer user) {
        log.info("Creating new customer:" + user.getName());
        return customerRepository.save(user);
    }
    public Customer createDefaultCustomer(){
        log.info("creating a default customer");
        return customerRepository.save(Customer.defaultCustomer());
    }
    public Customer updateCustomer(Long id, Customer userDetails) {
        log.info("updating a customer"+id);
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer != null) {
            customer.setName(userDetails.getName());
            customer.setHistory(userDetails.getHistory());
            customer.setPassword(userDetails.getPassword());
            customer.setVoen(userDetails.getVoen());
            log.info(id+"customer successfully updated");
            return customerRepository.save(customer);
        }
        log.error(id+":customer not found");
        return null;
    }

    public void deleteCustomer(Long id) {
        log.info("deleting customer by id:"+id);
        customerRepository.deleteById(id);
    }
}

package com.brand13.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.brand13.customer.controller.dto.CustomerSaveRequestDto;
import com.brand13.customer.controller.dto.CustomerUpdateRequestDto;
import com.brand13.customer.domain.Customer;
import com.brand13.customer.service.CustomerService;

@RequestMapping("/api/customers")
@RestController
public class CustomerContoller {
    
    @Autowired
    CustomerService customerService;

    @GetMapping
    // List<Customer> getCustomers(){
    //     List<Customer> customers = customerService.findAll();
    //     return customers;
    // }
    Page<Customer> getCustomers(@PageableDefault Pageable pageable){
        Page<Customer> customers = customerService.findAll(pageable);
        return customers;
    }

    @GetMapping("/{id}")
    Customer getCustomer(@PathVariable Long id){
        Customer customer = customerService.findOne(id);
        return customer;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Customer postCustomer(@RequestBody CustomerSaveRequestDto requestDto){
        Customer customer = customerService.create(requestDto);
        return customer;
    }

    @PutMapping("/{id}")
    Customer putCustomer(@PathVariable Long id, @RequestBody CustomerUpdateRequestDto requestDto){
        return customerService.update(id, requestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCustomer(@PathVariable Long id){
        customerService.delete(id);
    }
}

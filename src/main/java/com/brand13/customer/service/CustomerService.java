package com.brand13.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brand13.customer.controller.dto.CustomerSaveRequestDto;
import com.brand13.customer.controller.dto.CustomerUpdateRequestDto;
import com.brand13.customer.domain.Customer;
import com.brand13.customer.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {
    
    @Autowired
    CustomerRepository customerRepository;

    public Customer create(CustomerSaveRequestDto requestDto){
        return customerRepository.save(requestDto.toEntiry());
    }
    
    public Page<Customer> findAll(Pageable pageable){
        return customerRepository.findAllOrderByName(pageable);
    }

    public Customer findOne(Long id){
        return customerRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
    }

    public void delete(Long id){
        customerRepository.deleteById(id);
    }

    public Customer update(Long id, CustomerUpdateRequestDto customerUpdateRequestDto){
        Customer customer = customerRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        customer.update(customerUpdateRequestDto.getFirstname(), customerUpdateRequestDto.getLastname());

        return customer;
    }
}

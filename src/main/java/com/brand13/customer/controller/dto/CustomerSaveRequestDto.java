package com.brand13.customer.controller.dto;

import com.brand13.customer.domain.Customer;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CustomerSaveRequestDto {
    private String firstname;
    private String lastname;

    public Customer toEntiry(){
        return new Customer(firstname, lastname);
    }
}

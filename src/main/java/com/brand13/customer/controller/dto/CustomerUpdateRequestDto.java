package com.brand13.customer.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CustomerUpdateRequestDto {
    private String firstname;
    private String lastname;
    
    @Builder
    public CustomerUpdateRequestDto(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
    
}

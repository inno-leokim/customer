package com.brand13.customer.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
@Entity
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = true, name = "username")
    private User user;

    @Builder
    public Customer(String firstname, String lastname){
        this.firstname = firstname;
        this.lastname  = lastname; 
    }

    public void update(String firstname, String lastname){
        this.firstname = firstname;
        this.lastname = lastname;
    }
}

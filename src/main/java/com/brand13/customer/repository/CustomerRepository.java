package com.brand13.customer.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.brand13.customer.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // @Query(value = "SELECT * FROM customers ORDER BY first_name, last_name", nativeQuery=true) // nativeQuery를 통해 실제 쿼리를 쓸 수 있지만 이렇게 되면 jpa의 장점을 활용할 수 없다.
    @Query("SELECT x FROM Customer x ORDER BY x.firstname, x.lastname") //쿼리문 안에 Customer는 도메인 객체(Eintity) 명과 일치시킨다. 테이블명이 아니다.
    // List<Customer> findAllOrderByName();
    Page<Customer> findAllOrderByName(Pageable pageable);
}

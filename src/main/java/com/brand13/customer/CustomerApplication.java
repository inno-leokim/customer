package com.brand13.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.brand13.customer.domain.Customer;
import com.brand13.customer.repository.CustomerRepository;

@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class CustomerApplication implements CommandLineRunner{

	@Autowired
	CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Customer created = customerRepository.save(new Customer("Hidetoshi", "Dekisugi"));
		System.out.println(created + " is created");

		Pageable pageable = PageRequest.of(0, 3);

		Page<Customer> page = customerRepository.findAll(pageable);

		System.out.println("한 페이지당 데이터수=" + page.getSize());
		System.out.println("현재 페이지=" + page.getNumber());
		System.out.println("전체 페이지 수=" + page.getTotalPages());
		System.out.println("전체 데이터 수=" + page.getTotalElements());

		page.getContent().forEach((x) -> System.out.println("result = " + x.getFirstname() + " : " + x.getLastname() + " : " + x.getId()));
	}

}

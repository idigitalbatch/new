package com.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;



import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



import com.example.repository.BookingRepository;
import com.example.repository.CustomerRepository;
import com.example.model.Booking;
import com.example.model.Customer;




@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerTest {
@Autowired
private  CustomerRepository br;




	@Test
	@Order(1)
	public void testCreate() {
		Customer customer=new Customer();
		customer.setId(1);
		customer.setFirstName("Sandhiya");
		customer.setLastName("Ramya");
		customer.setPassword("Sandhiya@123");
		customer.setEmailId("Sandhiya123@gmail.com");
		customer.setPhoneNo(987645309);

		br.save(customer);
		assertNotNull(br.findById((long) 1).get());
		//assertNotNull(br.findById(12));
	}
	@Test
	@Order(2)
	public void testReadAll() {    
		List<Customer> list=br.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	@Test
	@Order(3)
	public void getSinglecustomer() {
		Customer customer=br.findById((long) 1).get();
		assertEquals(987645309,customer.getPhoneNo());
	}
	@Test
	@Order(4)
	public void testUpdate() {
		Customer customer=br.findById((long) 1).get();
		customer.setEmailId("Ramya123@gmail.com");
		br.save(customer);
		assertNotEquals("Sandhiya123@gmail.com", br.findById((long) 1).get().getEmailId());
	}
	@Test
	@Order(5)
	public void testDelete() {
		br.deleteById((long) 1);
		assertThat(br.existsById((long) 1)).isFalse();
	}

}

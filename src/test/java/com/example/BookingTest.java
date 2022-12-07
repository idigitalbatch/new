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
import com.example.model.Booking;



@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookingTest {
	
	
	
	@Autowired
	private  BookingRepository br;




		@Test
		@Order(1)
		public void testCreate() {
			Booking book=new Booking();
			book.setId(1);
			book.setCakeType("black forest");
			book.setCakeKg("1kg");
			book.setOccassions("birthday");
			

			br.save(book);
			assertNotNull(br.findById((long) 1).get());
			//assertNotNull(br.findById(12));
		}
		@Test
		@Order(2)
		public void testReadAll() {    
			List<Booking> list=br.findAll();
			assertThat(list).size().isGreaterThan(0);
		}
		@Test
		@Order(3)
		public void getSinglebooking() {
			Booking book=br.findById((long) 1).get();
			assertEquals("1kg",book.getCakeKg());
		}
		@Test
		@Order(4)
		public void testUpdate() {
			Booking book=br.findById((long) 1).get();
			book.setCakeType("venilla");
			br.save(book);
			assertNotEquals("black forest", br.findById((long) 1).get().getCakeType());
		}
		@Test
		@Order(5)
		public void testDelete() {
			br.deleteById((long) 1);
			assertThat(br.existsById((long) 1)).isFalse();
		}

	}

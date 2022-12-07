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
import com.example.repository.PaymentRepository;
import com.example.model.Booking;
import com.example.model.Payment;




@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PaymentTest {

	@Autowired
	PaymentRepository br;



	@Test
	@Order(1)
	public void testCreate() {
		Payment payment=new Payment();
		payment.setId(1);
		payment.setName("Sandhiya");
		payment.setBankName("IcIc");
		payment.setAccNo("345623789573");
		payment.setIfscCode("icic0005432");
		payment.setAmount("200");

		br.save(payment);
		assertNotNull(br.findById((long) 1).get());
	}
	@Test
	@Order(2)
	public void testReadAll() {    
		List<Payment> list=br.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	@Test
	@Order(3)
	public void getSinglepayment() {
		Payment Payment=br.findById((long) 1).get();
		assertEquals("200", Payment.getAmount());
	}
	@Test
	@Order(4)
	public void testUpdate() {
		Payment payment=br.findById((long)1).get();
		payment.setAmount("400");
		br.save(payment);
		assertNotEquals("200", br.findById((long) 1).get().getAmount());
	}
	@Test
	@Order(5)
	public void testDelete() {
		br.deleteById((long) 1);
		assertThat(br.existsById((long) 1)).isFalse();
	}

}
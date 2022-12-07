package com.example.servises;

import java.util.List;

import com.example.model.Payment;

public interface PaymentService {

	Payment savePayment(Payment payment);
	List<Payment> getAllPayments();
	Payment getPaymentById(long id);
	Payment updatePayment(Payment payment, long id);
	void deletePayment(long id);

}

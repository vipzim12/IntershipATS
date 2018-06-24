package com.tma.ats.api.myexample2;

import java.util.List;

public interface ICustomerService {
	List<Customer> getAllCustomer();

	Customer getCustomerById(int customerId);

	boolean addCustomer(Customer customer);

	void update(Customer customer);

	void delete(int customerId);
}

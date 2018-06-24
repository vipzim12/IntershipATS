package com.tma.ats.api.myexample2;

import java.util.List;

public interface ICustomerDAO {
	List<Customer> getAllCustomer();

	Customer getCustomerById(int customerId);

	void addCustomer(Customer customer);

	void updateCustomer(Customer customer);

	void deleteCustomer(int customerId);

	boolean customerExists(String customer, String item);

}

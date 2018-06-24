package com.tma.ats.api.myexample2;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class CustomerDAO implements ICustomerDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Customer> getAllCustomer() {
		String str = "FROM customer as cos ORDER BY cos.customerId";
		return entityManager.createQuery(str).getResultList();
	}

	@Override
	public Customer getCustomerById(int customerId) {

		return entityManager.find(Customer.class, customerId);
	}

	@Override
	public void addCustomer(Customer customer) {
		entityManager.persist(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		Customer cus = getCustomerById(customer.getCustomerId());
		cus.setCustomer(customer.getCustomer());
		cus.setItems(customer.getItems());
		entityManager.flush();
	}

	@Override
	public void deleteCustomer(int customerId) {
		entityManager.remove(getCustomerById(customerId));

	}

	@Override
	public boolean customerExists(String customer, String item) {
		String hml = "FROM customer as cus WHERE cus.customer=? and cus.item=?";
		int cont = entityManager.createQuery(hml).setParameter(1, customer).setParameter(2, customer).getResultList()
				.size();
		return cont > 0 ? true : false;
	}

}

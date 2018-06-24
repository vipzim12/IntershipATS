package com.tma.ats.api.myexample2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tma.ats.api.dto.FleetObject;
import com.tma.ats.api.service.FleetService;

@Service
public class CustomerService implements ICustomerService {
	@Autowired
	private ICustomerDAO iCustomerDAO;
	@Autowired
	private FleetService fleetService;

	@Override
	public List<Customer> getAllCustomer() {
		List<FleetObject> fleets = fleetService.getAllFleets();
		if (fleets != null) {
			for (FleetObject fleet : fleets) {
				System.out.println(fleet.getName());
			}
		}
		return iCustomerDAO.getAllCustomer();
	}

	@Override
	public Customer getCustomerById(int customerId) {

		return iCustomerDAO.getCustomerById(customerId);
	}

	@Override
	public boolean addCustomer(Customer customer) {
		if (iCustomerDAO.customerExists(customer.getCustomer(), customer.getItems())) {
			return false;
		} else {
			iCustomerDAO.addCustomer(customer);
			return true;
		}
	}

	@Override
	public void update(Customer customer) {
		iCustomerDAO.updateCustomer(customer);
	}

	@Override
	public void delete(int customerId) {
		iCustomerDAO.deleteCustomer(customerId);
	}

}

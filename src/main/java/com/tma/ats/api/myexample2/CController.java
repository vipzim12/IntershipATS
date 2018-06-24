package com.tma.ats.api.myexample2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class CController {
	@Autowired
	private ICustomerService customerService;

	@GetMapping("customer/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Integer id) {
		Customer customer = customerService.getCustomerById(id);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);

	}

}

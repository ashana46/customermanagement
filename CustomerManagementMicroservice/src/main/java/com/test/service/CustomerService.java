package com.test.service;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.CustomerDAOImpl;
import com.test.model.Customer;

//Service class for Customer management service 
@Service
@Transactional
public class CustomerService implements CustomerInterface {

	private static Logger logger = Logger.getLogger(CustomerService.class);
	@Autowired
	CustomerDAOImpl customer_database;
	
	List<Customer> customer_information;

	@Override
	public void createCustomer(Customer c) {
		try {
			customer_database.createCustomerDAO(c);
		} catch (ClassNotFoundException e) {
			logger.error(e.getMessage());
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}		
	}

	@Override
	public List<Customer> listCustomer(){
		try {
			customer_information=new ArrayList<Customer>();
			customer_information=customer_database.listCustomerDAO();
		} catch (ClassNotFoundException e) {
			logger.error(e.getMessage());
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return customer_information;
	}


	@Override
	public void deleteCustomer(int customer_id)  {

		try {
			 customer_database.deleteCustomerDAO(customer_id);
		} catch (ClassNotFoundException e) {
			logger.error(e.getMessage());
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public void updateCustomer(Customer customer) {

		try {
			 customer_database.updateCustomerDAO(customer);
		} catch (ClassNotFoundException e) {
			logger.error(e.getMessage());
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}

	}

	@Override
	public Customer searchFor(int customer_id){
		try {
			customer_information=customer_database.listCustomerDAO().stream()
					.filter(x-> customer_id==x.getId())
					.collect(Collectors.toList());

		}catch (SQLException e) {
			logger.error(e.getMessage());
		} catch (ClassNotFoundException e) {
			logger.error(e.getMessage());
		}
		return customer_information.get(0);

	}
}

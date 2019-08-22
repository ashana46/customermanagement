package com.test.dao;

import java.sql.SQLException;
import java.util.List;

import com.test.model.Customer;
//DAO interface for Customer Management System
public interface CustomerDAO {

	public void createCustomerDAO(Customer customer) throws SQLException, ClassNotFoundException;//Creates a new record in customer table
	public void deleteCustomerDAO(int customer_id) throws ClassNotFoundException, SQLException;//deletes a record in customer table
	public void updateCustomerDAO(Customer customer) throws ClassNotFoundException, SQLException;//Updates an existing record in customer table
	public List<Customer> listCustomerDAO() throws ClassNotFoundException, SQLException;//Displays the list of records in customer table
	
}

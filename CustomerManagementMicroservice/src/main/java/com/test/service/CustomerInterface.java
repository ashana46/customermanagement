/**
 * 
 */
package com.test.service;

import java.sql.SQLException;
import java.util.List;

import com.test.model.Customer;

/**
 * @author ashshett
 *
 */
//interface for Customer management service 
public interface CustomerInterface {

	public void createCustomer(Customer customer) ;
	public List<Customer> listCustomer();
	public void deleteCustomer(int customer_id);
	public void updateCustomer(Customer customer);
	public Customer searchFor(int customer_id);
	
}

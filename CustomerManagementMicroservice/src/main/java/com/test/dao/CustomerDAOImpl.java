package com.test.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.test.model.Customer;

//DAO interface for Customer Management System
@Repository
public class CustomerDAOImpl implements CustomerDAO{
	
	List<Customer> customer_information;
	
	 @Autowired
	    private SessionFactory sessionFactory;

	public Customer findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer=(Customer) session.get(Customer.class,id);
        return customer;
    }
	//Creates a new record in customer table
	public void createCustomerDAO(Customer customer) throws SQLException, ClassNotFoundException {


		Session session = sessionFactory.getCurrentSession();
        session.save(customer);

	}

	//deletes a record in customer table
	public void deleteCustomerDAO(int customer_id) throws ClassNotFoundException, SQLException {
		Session session = sessionFactory.getCurrentSession();
        session.delete(findById(customer_id));
	
		
	}

	//Updates an existing record in customer table
	public void updateCustomerDAO(Customer customer) throws ClassNotFoundException, SQLException {
		
		Session session = sessionFactory.getCurrentSession();
        session.update(customer);


	}

	//Displays the list of records in customer table
	public List<Customer> listCustomerDAO() throws ClassNotFoundException, SQLException {
		
		Session session = sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
        List<Customer> list= session.createCriteria(Customer.class).list();
        return list;
		

	}
	
}

package com.test.model;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Setter;

//customer table attributes
@Entity
@Table(name="customer")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter @Setter
public class Customer {
	
	@Id
	private int id;
	
	@Column(name="name")
	private String customer_name;
	 
	@Column(name="address")
	private String customer_address;
	
	
	
}

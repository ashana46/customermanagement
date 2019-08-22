package com.test.restcontroller;

import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;
import com.test.model.Customer;
import com.test.service.CustomerInterface;

@RestController
@Path("/customercontroller")
public class CustController {
	

	@Autowired
	public CustomerInterface service;
	

	
	@RequestMapping(produces=MediaType.APPLICATION_JSON,method =RequestMethod.GET,value="/listcustomer")
	@ResponseBody
	public ResponseEntity<List<Customer>> listCustomer() {
		//return service.listCustomer();
		HttpHeaders headers = new HttpHeaders();
	       headers.add("Access-Control-Allow-Origin", "*");
	       List<Customer> customers = service.listCustomer();
	       if (customers == null) {
	           return new ResponseEntity<List<Customer>>(HttpStatus.NOT_FOUND);
	       }
	       return new ResponseEntity<List<Customer>>(customers, headers, HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(produces=MediaType.APPLICATION_JSON,method =RequestMethod.POST,value="/createcustomer")
	@ResponseStatus(code = HttpStatus.OK)
	public void createCustomers(@RequestBody Customer customer) {
		service.createCustomer(customer);
	
	}
	
	@CrossOrigin
	@RequestMapping(produces=MediaType.APPLICATION_JSON,method =RequestMethod.PUT,value="/updatecustomer")
	@ResponseStatus(code = HttpStatus.OK)
	public void updateCustomers(@RequestBody Customer customer) {
		service.updateCustomer(customer);
	}
	
	@CrossOrigin
	@RequestMapping(produces=MediaType.APPLICATION_JSON,method =RequestMethod.DELETE,value="/deletecustomer/{customerId}")
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteCustomers(@PathVariable("customerId") int customerId) {
			service.deleteCustomer(customerId);
	}


	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value = "/hello/{name}")
  public String getHelloWorldObject(@PathVariable String name) {
		
      return "hello "+name;
  }
}

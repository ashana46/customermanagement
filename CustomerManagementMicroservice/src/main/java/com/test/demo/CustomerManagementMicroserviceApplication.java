package com.test.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

import com.test.config.CustomerConfig;





@SpringBootApplication(exclude=HibernateJpaAutoConfiguration.class)
@EnableDiscoveryClient
@ComponentScan({"com.test.*"})
public class CustomerManagementMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerManagementMicroserviceApplication.class, args);
	}

}

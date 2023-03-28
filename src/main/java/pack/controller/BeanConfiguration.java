package pack.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pack.beans.Car;

/**
 * @author andrewmccoy - agmccoy
 * CIS175 - Fall 2021
 * Mar 26, 2023
 */
@Configuration
public class BeanConfiguration {
	
	@Bean
	Car car() {
		Car bean = new Car();
		
		return bean;
	}
}

package pack.beans;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author andrewmccoy - agmccoy
 * CIS175 - Fall 2023
 * Mar 26, 2023
 */
@Entity
@Data
@NoArgsConstructor
@Table(name="cars")
public class Car {
	
	@Id
	@GeneratedValue
	private long id;
	private String make;
	private String model;
	private int year;
	private int numberOfCylinders;
		
}

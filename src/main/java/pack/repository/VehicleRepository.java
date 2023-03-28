package pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pack.beans.Car;

/**
 * @author andrewmccoy - agmccoy
 * CIS175 - Fall 2021
 * Mar 27, 2023
 */
public interface VehicleRepository extends JpaRepository<Car, Long> {

}

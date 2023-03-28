package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pack.beans.Car;
import pack.repository.VehicleRepository;

/**
 * @author andrewmccoy - agmccoy
 * CIS175 - Fall 2021
 * Mar 27, 2023
 */
@Controller
public class WebController {
	@Autowired
	VehicleRepository repo; 
	
	@GetMapping({"/", "viewAll"})
	public String viewAllVehicles(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewVehicle(model);
		}
		model.addAttribute("vehicle", repo.findAll());
		return "results";
	}
	
	@GetMapping("/inputVehicle")
	public String addNewVehicle(Model model) {
		Car c = new Car();
		model.addAttribute("newVehicle", c );
		return "input";
	}
	
	@PostMapping("/inputVehicle")	
	public String addNewVehicle(@ModelAttribute Car c, Model model) {
		repo.save(c);
		return viewAllVehicles(model);
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateVehicle(@PathVariable("id") long id, Model model) {
		Car c = repo.findById(id).orElse(null);
		model.addAttribute("newVehicle", c);
		return "input";
	}
	
	@PostMapping("/update/{id}")
	public String reviseVehicle(Car c, Model model) {
		repo.save(c);
		return viewAllVehicles(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteVehicle(@PathVariable("id") long id, Model model) {
		Car c = repo.findById(id).orElse(null);
		repo.delete(c);
		return viewAllVehicles(model);
	}
	
	
}

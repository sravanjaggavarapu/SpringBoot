package com.pack.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HospitalController {
	@Autowired
	HospitalService hospitalService;

	@GetMapping("/hospitals")
	public List<Hospital> getHospitals() {
		return hospitalService.getAllHospitals();
	}

	@PostMapping("/savehospital")
	public Hospital saveHospital(@RequestBody Hospital hospital) {
		return hospitalService.saveData(hospital);
	}

	@GetMapping("/hospital/{id}")
	public Hospital getHospital(@PathVariable int id) {
		return hospitalService.getHospital(id);
	}

	@GetMapping("/hospital/{rating}")
	public List<Hospital> getHospitalsByRating(@PathVariable double rating) {
		return hospitalService.getAllHospitalsByRating(rating);
	}

	@GetMapping("/hospital/{location}/{rating}")
	public List<Hospital> getHospitalsByLocationAndRating(@PathVariable String location, @PathVariable double rating) {
		return hospitalService.getAllHospitalsByLocationAndRating(location, rating);
	}
}

package com.pack.springboot;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class HospitalService {

	List<Hospital> hospitals = new ArrayList<Hospital>(Arrays.asList(
			new Hospital(100l, "apollo hospital", "chennai", 3.9), new Hospital(101l, "Kims hospital", "Mumbai", 4.6),
			new Hospital(102l, "Rainbow hospital", "vijayawada", 4.9),
			new Hospital(103l, "Vcare hospital", "hyderabad", 3.7)));

	public Hospital saveData(Hospital hospital) {
		return hospitals.add(hospital) ? hospital : null;
	}

	public List<Hospital> getAllHospitals() {
		return hospitals;
	}

	public Hospital getHospital(int id) {
		return hospitals.stream().filter(hospital -> hospital.getId() == id).findAny().get();
	}

	public List<Hospital> getAllHospitalsByRating(double rating) {
		return hospitals.stream().filter(hospital -> hospital.getRating() > rating).collect(Collectors.toList());
	}

	public List<Hospital> getAllHospitalsByLocationAndRating(String location, double rating) {
		return hospitals.stream()
				.filter(hospital -> hospital.getLocation().equals(location) && hospital.getRating() > rating)
				.collect(Collectors.toList());
	}

}

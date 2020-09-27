package com.example.restservice;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
public class CitiesController {

	@Autowired
	private CitiesService service;

	@GetMapping("/citiesList")
	public ResponseEntity getCitiesList() {
		return ResponseEntity.ok(service.getCitiesList());
	}

	@GetMapping("/weatherByCity")
	public ResponseEntity getWeatherByCity(@RequestParam(value = "name", defaultValue = "Москва") String name) {
		Cities city = service.getWeatherByCity(name);
		if (city != null) {
			return ResponseEntity.ok(city);
		} else {
			return ResponseEntity.ok("Нет такого города в списке!");
		}
	}

	@GetMapping("/citiesByIDs")
	public ResponseEntity getCitiesByID(@RequestParam(value = "id", defaultValue = "1") List<String> IDs) {
		List<String> citiesList = service.getCitiesByID(IDs);
		if (citiesList == null) {
			return ResponseEntity.ok("Нет такого города в списке!");
		} else {
			return ResponseEntity.ok(citiesList);
		}
	}
}

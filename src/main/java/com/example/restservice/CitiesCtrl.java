package com.example.restservice;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cities")
public class CitiesCtrl {

    @GetMapping("/citiesList")
    public ResponseEntity getCitiesList() {
        JSONObject json = new JSONObject();
        for (Cities model : Cities.getCityAndWeather()) {
            json.append("cityName", model.getCityName());
        }
        return ResponseEntity.ok(json.toString());
    }

    @GetMapping("/weatherByCity")
    public ResponseEntity getWeatherByCity(@RequestParam(value = "name", defaultValue = "Москва") String name) {
        Cities city = Cities.getCityAndWeather().stream().filter(model -> model.getCityName().toLowerCase().contains(name.toLowerCase())).findFirst().orElse(null);
        if (city != null) {
            return ResponseEntity.ok(city);
        } else {
            return ResponseEntity.ok("Нет такого города в списке!");
        }
    }

    @GetMapping("/citiesByIDs")
    public ResponseEntity getCitiesByID(@RequestParam(value = "id", defaultValue = "1") List<String> IDs) {
        JSONObject jsonCity = new JSONObject();
        List<Cities> cities = Cities.getCityAndWeather().stream().filter(model -> IDs.contains(model.getIdCity().toString())).collect(Collectors.toList());

        if (cities.isEmpty()) {
            jsonCity.append("error", "Нет такого города в списке!");
        } else {
            for (Cities city : cities) {
                jsonCity.append("cityName", city.getCityName());
            }
        }

        return ResponseEntity.ok(jsonCity.toString());
    }
}

package com.example.restservice;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CitiesService {

    public List<String> getCitiesList() {
        List<String> citiesList = new ArrayList<>();
        for (Cities model : Cities.getCityAndWeather()) {
            citiesList.add( model.getCityName());
        }
        return citiesList;
    }

    public Cities getWeatherByCity (String cityName) {
        return Cities.getCityAndWeather().stream().filter(model ->
                model.getCityName().toLowerCase().contains(cityName.toLowerCase())).findFirst().orElse(null);
    }

    public List<String> getCitiesByID(List<String> IDs) {
        List<Cities> cities = Cities.getCityAndWeather().stream().filter(model -> IDs.contains(model.getIdCity().toString())).collect(Collectors.toList());

        if (cities.isEmpty()) {
            return  null;
        } else {
            List<String> citiesList = new ArrayList<>();
            for (Cities city : cities) {
                citiesList.add(city.getCityName());
            }
            return citiesList;
        }
    }
}


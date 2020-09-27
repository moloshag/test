package com.example.restservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class Cities {
    private Long idCity;
    private String cityName;
    private List<Weather> weather;

    public static List<Cities> getCityAndWeather() {
        List<Cities> listCityAndWeather = new ArrayList<>();
        listCityAndWeather.add(new Cities(1L, "Москва", Arrays.asList(new Weather("Облачно", 18, 2, 30, new Date()))));
        listCityAndWeather.add(new Cities(2L, "Красноярск", Arrays.asList(new Weather("Осадки в виде дождя", 16, 3, 63, new Date()))));
        listCityAndWeather.add(new Cities(3L, "Иркутск", Arrays.asList(new Weather("Ясно", 21, 1, 19, new Date()))));
        listCityAndWeather.add(new Cities(4L, "Чита", Arrays.asList(new Weather("Осадки в виде дождя", 17, 4, 69, new Date()))));
        listCityAndWeather.add(new Cities(5L, "Владивосток", Arrays.asList(new Weather("Облачно", 15, 5, 49, new Date()))));
        listCityAndWeather.add(new Cities(6L, "Омск", Arrays.asList(new Weather("Ясно", 20, 0, 21, new Date()))));
        listCityAndWeather.add(new Cities(7L, "Ярославль", Arrays.asList(new Weather("Осадки в виде дождя", 14, 4, 60, new Date()))));
        listCityAndWeather.add(new Cities(8L, "Сочи", Arrays.asList(new Weather("Ясно", 25, 2, 39, new Date()))));
        listCityAndWeather.add(new Cities(9L, "Томск", Arrays.asList(new Weather("Облачно", 18, 2, 61, new Date()))));
        listCityAndWeather.add(new Cities(10L, "Якутск", Arrays.asList(new Weather("Осадки в виде снега", 6, 6, 57, new Date()))));
        return listCityAndWeather;
    }
}

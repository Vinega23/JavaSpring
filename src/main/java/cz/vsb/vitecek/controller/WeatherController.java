package cz.vsb.vitecek.controller;

import com.example.vitecek.City;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import cz.vsb.vitecek.connector.WeatherstackConnector;
import cz.vsb.vitecek.dto.WeatherDto;

@RestController
public class WeatherController {
    @RequestMapping("/weather")
    public String getWeather() {
        return "Pocasi pro vsechna mesta";
    }
    @RequestMapping("/weather/{city}")

    public WeatherDto getWeatherForCity(@PathVariable String city){
        WeatherstackConnector connector = new WeatherstackConnector();
        City cityEnum = City.valueOf(city.toUpperCase());
        WeatherDto wdto = new WeatherDto();
        String country = connector.getWeatherForCity(cityEnum);
        wdto.setLocation(country);
        return wdto;
    }

}

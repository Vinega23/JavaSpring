package cz.vsb.vitecek.connector;

import java.net.URI;
import java.net.URISyntaxException;

import com.example.vitecek.City;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


import cz.vsb.vitecek.dto.WeatherstackDto;

public class WeatherstackConnector {
    //http://api.weatherstack.com/current?access_key=d950942148c108ed9d6896648f374c88&query=New%20York
    private static String baseURL="http://api.weatherstack.com/";
    private static String urlParams="current?access_key=";
    private static String APIkey = "d950942148c108ed9d6896648f374c88";
    private static String url=baseURL+urlParams+APIkey+"&query=";
    public String getWeatherForCity(City city)
    {
        RestTemplate template = new RestTemplate();
        URI uri = null;
        try {
            uri = new URI(url + city.toString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        ResponseEntity<WeatherstackDto> response = template.getForEntity(uri, WeatherstackDto.class);
        return response.getBody().getLocation().getCountry();	}
}


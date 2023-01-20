package lt.ornetas.world.controller;


import lt.ornetas.world.repository.model.City;
import lt.ornetas.world.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/citymapping") //localhost:8080/citymapping

public class CityController {

    @Autowired
    private CityService cityService;

    // http://localhost:8080/citymapping/test
    @GetMapping(path = "/test")
    public @ResponseBody String getTestPage() {
        return "This is some test from SPRING!";
    }

    // http://localhost:8080/citymapping/city/all
    @GetMapping(path = "/city/all")
    public @ResponseBody List<City> getAllCities() {
        return cityService.getAllCities();
    }

    // http://localhost:8080/citymapping/city/1000
    @GetMapping(path = "/city/{id}")
    public @ResponseBody City getCityById(@PathVariable int id){
        return cityService.getCityById(id);
    }

    // http://localhost:8080/citymapping/city/name/Newport
    @GetMapping (path = "/city/name/{name}")
    public @ResponseBody City getCityByName(@PathVariable String name){
        return cityService.getCityByName(name);
    }

    // http://localhost:8080/citymapping/city/like/new
    @GetMapping (path = "/city/like/{name}")
    public @ResponseBody List<City> getCityByNameLike(@PathVariable String name){
        return cityService.getCityByNameLike("%" + name + "%");
    }

    // http://localhost:8080/citymapping/city/querylike/dam
    @GetMapping (path = "/city/querylike/{name}")
    public @ResponseBody List <City> getQueryCityByNameLike(@PathVariable String name){
        return cityService.getCityQueryByNameLike(name + "%");
    }
}

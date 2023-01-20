package lt.ornetas.world.controller;

import lt.ornetas.world.repository.model.City;
import lt.ornetas.world.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping ( path = "/citytemplate")
public class CityTemplateController {
    @Autowired
    private CityService cityService;

    // http://localhost:8080/citytemplate/firstpage/city/1000
    @GetMapping(path = "/firstpage/city/{id}")
    public String getCityWithFirstPage(Model model, @PathVariable int id) {

        City city = cityService.getCityById(id);
        model.addAttribute("city_name", city.getName());
        model.addAttribute("country_code", city.getCountryCode());
        model.addAttribute("district", city.getDistrict());
        model.addAttribute("population", city.getPopulation());

        return "/test/firstpage";
    }

    // http://localhost:8080/citytemplate/firstpage/city/all
    @GetMapping(path = "/firstpage/city/all")
    public String getAllCities(Model model){
        List<City> cityList = cityService.getAllCities();
        model.addAttribute("key_cities_list", cityList);
        return "test/firstpage_city_list";
    }

    // http://localhost:8080/citytemplate/firstpage/citylike/dam
    @GetMapping(path = "/firstpage/citylike/{name}")
    public String getAllCitiesLike(Model model, @PathVariable String name){
        List<City> cityList = cityService.getCityByNameLike("%" + name + "%");
        model.addAttribute("key_cities_list", cityList);
        return "test/firstpage_city_list";
    }



}

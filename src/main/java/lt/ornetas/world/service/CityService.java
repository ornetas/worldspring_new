package lt.ornetas.world.service;

import lt.ornetas.world.repository.CityRepository;
import lt.ornetas.world.repository.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<City> getAllCities(){
        return (List<City>) cityRepository.findAll();
    }

    public City getCityById(Integer cityId){
        return cityRepository.findById(cityId).get();

    }
    public City getCityByName(String cityName){
        return cityRepository.findByName(cityName).get();
    }
    public List<City> getCityByNameLike(String cityName){
        return (List<City>) cityRepository.findByNameLike(cityName);
    }
    public List<City> getCityQueryByNameLike(String cityName){
        return (List<City>) cityRepository.findByNameLike(cityName);
    }


}

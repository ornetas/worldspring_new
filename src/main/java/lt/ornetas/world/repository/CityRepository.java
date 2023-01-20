package lt.ornetas.world.repository;


import lt.ornetas.world.repository.model.City;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CityRepository extends CrudRepository<City, Integer> {


    Optional<City> findByName(String name);

    Iterable<City> findByNameLike(String name);

    @Query(value = "SELECT * FROM city WHERE Name LIKE :name", nativeQuery = true)
    List<City> getNameLike (@Param("name") String name);



}

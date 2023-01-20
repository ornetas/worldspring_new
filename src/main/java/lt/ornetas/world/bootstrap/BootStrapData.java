package lt.ornetas.world.bootstrap;

import lt.ornetas.world.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public void run(String... args) throws Exception {

        cityRepository.findAll().forEach(System.out::println);
        System.out.println("\n===============================\n");
        System.out.println(cityRepository.findById(2));

        System.out.println("\n===============================\n");
        System.out.println(cityRepository.findByName("Hebron"));

        System.out.println("\n===============================\n");
        cityRepository.findByNameLike("%new%").forEach(System.out::println);

        System.out.println("\n===============================\n");
        cityRepository.getNameLike("%new%").forEach(System.out::println);


    }

}

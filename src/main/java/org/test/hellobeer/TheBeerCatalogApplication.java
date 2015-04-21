package org.test.hellobeer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.test.hellobeer.model.Beer;
import org.test.hellobeer.model.Brewery;
import org.test.hellobeer.repository.BeerRepository;
import org.test.hellobeer.repository.BreweryRepository;

@SpringBootApplication
public class TheBeerCatalogApplication implements CommandLineRunner {

    @Autowired
    BreweryRepository breweryRepo;

    @Autowired
    BeerRepository beerRepo;

    public static void main(String[] args) {
        SpringApplication.run(TheBeerCatalogApplication.class, args);
    }

    @Override
    public void run(String... strings) {

        // save some breweries
        breweryRepo.save(new Brewery("Cervezas Lest", "Madrid", "España",
                "2010"));
        breweryRepo.save(new Brewery("Cibeles", "Madrid", "España", "1997"));

        Brewery breweryMahou = new Brewery("Mahou", "Madrid", "España", "1890");
        breweryRepo.save(breweryMahou);

        beerRepo.save(new Beer("Mahou 5 estrellas", breweryMahou, "Lager",
                (float) 5.4));
    }
}

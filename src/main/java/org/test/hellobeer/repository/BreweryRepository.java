package org.test.hellobeer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.test.hellobeer.model.Brewery;

public interface BreweryRepository extends CrudRepository<Brewery, Long> {

    List<Brewery> findByName(String name);

    Brewery findById(long id);
}

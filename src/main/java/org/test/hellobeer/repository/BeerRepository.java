package org.test.hellobeer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.test.hellobeer.model.Beer;

public interface BeerRepository extends CrudRepository<Beer, Long> {

    List<Beer> findByName(String name);

    Beer findById(long id);
}

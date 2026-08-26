package com.example.warehouse.inventory;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Long> {
    Location findById(long id);

    List<Location> findByLocationName(String locationName);

}

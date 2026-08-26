package com.example.warehouse.inventory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
    @Autowired
    LocationRepository locationRepository;

    public String CreateLocation(Location location) {
        locationRepository.save(location);

        return "Location " + location.getLocationName() + " added.";
    }

    public List<Location> GetLocations() {
        List<Location> locations = new ArrayList<>();
        locationRepository.findAll().forEach(locations::add);

        return locations;
    }
}

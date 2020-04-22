package com.libraryportal.portal.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraryportal.portal.models.Location;
import com.libraryportal.portal.exception.RecordNotFoundException;
import com.libraryportal.portal.repositories.LocationRepository;
 
@Service
public class LocationService {
     
    @Autowired
    LocationRepository locationRepository;
     
    public List<Location> getLocations()
    {
        List<Location> location = locationRepository.findAll();
         
        if(location.size() > 0) {
            return location;
        } else {
            return new ArrayList<Location>();
        }
    }
     
    public Location getLocationById(Long id) throws RecordNotFoundException 
    {
        Optional<Location> location = locationRepository.findById(id);
         
        if(location.isPresent()) {
            return location.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
     
    public Location createOrUpdateEmployee(Location location) throws RecordNotFoundException 
    {
        Optional<Location> employee = locationRepository.findById(location.getLocid());
         
        if(employee.isPresent()) 
        {
            Location newEntity = employee.get();
            newEntity.setShelfnum(location.getShelfnum());
            newEntity.setRownum(location.getRownum());
            newEntity.setColnum(location.getColnum());
 
            newEntity = locationRepository.save(newEntity);
             
            return newEntity;
        } else {
            location = locationRepository.save(location);
             
            return location;
        }
    } 
     
}
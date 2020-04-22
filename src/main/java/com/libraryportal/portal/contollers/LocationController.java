package com.libraryportal.portal.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.libraryportal.portal.exception.RecordNotFoundException;
import com.libraryportal.portal.models.Location;
import com.libraryportal.portal.repositories.LocationRepository;
import com.libraryportal.portal.service.LocationService;

@RestController
@RequestMapping("api/v1/books")
public class LocationController {
	
	@Autowired
    LocationService service;
	
	@Autowired
	private LocationRepository locationRepository;
	
	@PutMapping("/{id}/location")
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody Location location){
		
		locationRepository.save(location);
	}
	
	@GetMapping("/{id}/location")
    public ResponseEntity<Location> getEmployeeById(@PathVariable("id") Long id) 
                                                    throws RecordNotFoundException {
        Location location = service.getLocationById(id);
 
        return new ResponseEntity<Location>(location, new HttpHeaders(), HttpStatus.OK);
    }

}

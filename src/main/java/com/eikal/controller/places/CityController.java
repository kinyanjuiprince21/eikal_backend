package com.eikal.controller.places;

import com.eikal.models.places.City;
import com.eikal.service.places.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("city")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("save")
    public ResponseEntity<?> saveCity(@RequestBody City city) {
        city = cityService.save(city);
        if(city != null) {
            return ResponseEntity.status(201).body(city);
        } else {
            return ResponseEntity.status(415).build();
        }
    }


}

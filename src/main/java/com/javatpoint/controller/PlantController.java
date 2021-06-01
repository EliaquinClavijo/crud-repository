package com.javatpoint.controller;

import com.javatpoint.model.company.ResponseStatus;
import com.javatpoint.model.plant.Plant;
import com.javatpoint.model.plant.ResponsePlant;
import com.javatpoint.model.plant.ResponsePlantList;
import com.javatpoint.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlantController {

    @Autowired
    PlantService plantService;

    @CrossOrigin
    @GetMapping("/plants")
    private ResponsePlantList getAllPlants() {
        return plantService.getAllPlants();
    }

    @CrossOrigin
    @GetMapping("/plant")
    private ResponsePlant getPlant(@RequestParam("id") String plantId) {
        return plantService.getPlantById(plantId);
    }

    @CrossOrigin
    @GetMapping("/delete-plant")
    private ResponseStatus deleteCompany(@RequestParam("id") String plantId) {
        return plantService.delete(plantId);
    }

    @CrossOrigin
    @PostMapping("/plant")
    private ResponseStatus saveCompany(@RequestBody Plant plant) {
        return plantService.saveOrUpdate(plant);
    }

    @CrossOrigin
    @PostMapping("/plant-update")
    private ResponseStatus update(@RequestBody Plant plant) {
        return plantService.saveOrUpdate(plant);
    }
}

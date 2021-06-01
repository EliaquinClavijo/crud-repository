package com.javatpoint.service;

import com.javatpoint.model.company.ResponseStatus;
import com.javatpoint.model.plant.Plant;
import com.javatpoint.model.plant.ResponsePlant;
import com.javatpoint.model.plant.ResponsePlantList;
import com.javatpoint.repository.PlantRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//defining the business logic
@Service
public class PlantService {

    @Autowired
    PlantRepository plantRepository;

    public ResponsePlantList getAllPlants() {
        List<Plant> plants = new ArrayList<Plant>();
        plantRepository.findAll().forEach(plant -> plants.add(plant));
        ResponsePlantList response = new ResponsePlantList(true, plants, plants.size(), 1, 5);
        return response;
    }

    //getting a specific record by using the method findById() of CrudRepository
    public ResponsePlant getPlantById(String id) {
        return new ResponsePlant(true, plantRepository.findByUId(id));
    }

    //saving a specific record by using the method save() of CrudRepository
    public ResponseStatus saveOrUpdate(Plant plant) {
        if (plant.get_id() == null) {
            String sha256hex = DigestUtils.sha256Hex(LocalDate.now().toString() + plant);
            plant.set_id(sha256hex.substring(0, 24));
            plant.setStatus(true);
        }
        plant.setCreated_at(Instant.now().toEpochMilli());
        plantRepository.save(plant);
        return new ResponseStatus(true);
    }

    //deleting a specific record by using the method deleteById() of CrudRepository
    public ResponseStatus delete(String id) {
        plantRepository.deleteByUId(id);
        return new ResponseStatus(true);
    }
}

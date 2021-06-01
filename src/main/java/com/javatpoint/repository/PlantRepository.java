package com.javatpoint.repository;

import com.javatpoint.model.plant.Plant;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PlantRepository extends CrudRepository<Plant, Integer> {

    @Query(value = "SELECT plant from Plant plant where plant._id = :uID")
    Plant findByUId(@Param("uID") String uID);

    @Transactional
    @Modifying
    @Query(value = "DELETE  from Plant plant where plant._id = :uID")
    void deleteByUId(@Param("uID") String uID);
}

package com.parqueadero.parqueaderoback.repositories;

import com.parqueadero.parqueaderoback.models.ParqueaderoModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParqueaderoRepository extends MongoRepository<ParqueaderoModel,String> {
    
}

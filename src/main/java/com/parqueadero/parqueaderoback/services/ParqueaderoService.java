package com.parqueadero.parqueaderoback.services;

import java.util.List;


import com.parqueadero.parqueaderoback.models.ParqueaderoModel;
import com.parqueadero.parqueaderoback.repositories.ParqueaderoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParqueaderoService {
    

    //Crear la instancia del ParqueaderoRepository
    @Autowired
    ParqueaderoRepository ParqueaderoRepository;// contiene los métodos crud


    //Método para guaradar un Parqueadero
    public void guardarParqueadero(ParqueaderoModel Parqueadero){
       this.ParqueaderoRepository.save(Parqueadero);
    }


    //Método para listar los Parqueaderos
    public List<ParqueaderoModel> traerParqueaderos(){
        return this.ParqueaderoRepository.findAll();
    }

    public ParqueaderoModel getParqueadero(String id){
      return  this.ParqueaderoRepository.findById(id).orElse(new ParqueaderoModel());
    }




}

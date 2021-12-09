package com.parqueadero.parqueaderoback.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.parqueadero.parqueaderoback.models.ParqueaderoModel;
import com.parqueadero.parqueaderoback.services.ParqueaderoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

//Definimos el tipo de controlador 
@RestController
@RequestMapping("/api") //definimos la ruta
public class ParqueaderoController {
    
    //Instanciar el servicio de los Parqueaderos
    @Autowired
    ParqueaderoService ParqueaderoService;

    //Método para guardar un Parqueadero
    @PostMapping("/Parqueaderos")
    public ResponseEntity<Map<String, String>> guardar(@RequestBody ParqueaderoModel Parqueadero){
        this.ParqueaderoService.guardarParqueadero(Parqueadero);

        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje","Se agregó correctamente");

        return ResponseEntity.ok(respuesta);

    }

    //Método para obtener los datos de los Parqueaderos
    @GetMapping("/Parqueaderos")
    public List<ParqueaderoModel> mostrar(){
        return this.ParqueaderoService.traerParqueaderos();
    }

    //Método para actualizar un Parqueadero
    @PutMapping("/Parqueaderos")
    public ResponseEntity<Map<String, String>> actualizar(@RequestBody ParqueaderoModel Parqueadero){
        this.ParqueaderoService.guardarParqueadero(Parqueadero);

        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje","Se actualizó correctamente");

        return ResponseEntity.ok(respuesta);

    }



    
}

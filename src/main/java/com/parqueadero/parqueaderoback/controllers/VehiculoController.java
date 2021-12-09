package com.parqueadero.parqueaderoback.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.parqueadero.parqueaderoback.models.VehiculoModel;
import com.parqueadero.parqueaderoback.services.VehiculoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*") // Permitir origen de petición
@RequestMapping("/api")
public class VehiculoController {
    
    @Autowired //Instancia del servicio 
    VehiculoService VehiculoService;


    /*
    Definimos el método HTTP (POST) por el que se va a ejecutar el metodo
    dentro del controller
    */
    //        http://localhost:8080/api/Vehiculos   GET,POST,PUT,DELETE

    //---------------------------------------------------------------------
    @PostMapping("/Vehiculos") 
    public ResponseEntity<Map<String, String>> guardarVehiculo(@Valid @RequestBody VehiculoModel Vehiculo){
      this.VehiculoService.guardarVehiculos(Vehiculo);
      //Mostrar un mensaje personalizado al cliente
      Map<String, String> respuesta = new HashMap<>();
      respuesta.put("mensaje","Se añadió correctamente");
      respuesta.put("estado","true");
      /*
      {
          "mensaje":"Se añadió correctamente",
          "estado":"true"
      }
      */
      return ResponseEntity.ok(respuesta);

    }
    //-------------------------------------------------------------------------





    @GetMapping("/Vehiculos") //GET
    public List<VehiculoModel> traerVehiculos(){
        return this.VehiculoService.traerVehiculos();
    }


    @GetMapping("/Vehiculos/{id}") //GET
    public VehiculoModel traerVehiculoPorId(@PathVariable String id){
        return this.VehiculoService.buscarPorId(id).get();
    }
    

}

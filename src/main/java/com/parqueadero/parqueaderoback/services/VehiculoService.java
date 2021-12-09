package com.parqueadero.parqueaderoback.services;

import java.util.List;
import java.util.Optional;

import com.parqueadero.parqueaderoback.models.VehiculoModel;
import com.parqueadero.parqueaderoback.repositories.VehiculoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //Definimos la clase como un servicio
public class VehiculoService {

    @Autowired //Creamos la instancia del repository
    VehiculoRepository VehiculoRepository; 

    //Método para guardar Vehiculos
    public void guardarVehiculos(VehiculoModel Vehiculo) {
        this.VehiculoRepository.save(Vehiculo);
    }

    //Método para traer los Vehiculos
    public List<VehiculoModel> traerVehiculos() {
        return this.VehiculoRepository.findAll();
    }

    //Método para buscar Vehiculo por ID
    public Optional<VehiculoModel> buscarPorId(String id) {
         return this.VehiculoRepository.findById(id);
    }

    //Método para verificar si ya existe el Vehiculo
    public Boolean verificar(String id) {
        return this.VehiculoRepository.existsById(id);
    }

    //Método para eliminar un Vehiculo
    public void eliminar(String id) {
        this.VehiculoRepository.deleteById(id);
    }

    
}

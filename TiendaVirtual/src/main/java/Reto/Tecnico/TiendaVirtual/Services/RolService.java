/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto.Tecnico.TiendaVirtual.Services;


import Reto.Tecnico.TiendaVirtual.Entity.Rol;
import Reto.Tecnico.TiendaVirtual.Enums.RolNombre;
import Reto.Tecnico.TiendaVirtual.Repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Esta clase permite interactuar con la base de datos y java, siendo un intermediario
 * entre ambas partes. (servicos para la tabla rol de la base de datos)
 * @author Brayan Felipe Pardo Cortes
 */
@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository rolRepository;

    /**
     * Este servicio es para guardar un nuevo rol y añadirla a la base de datos
     * @param rol
     */
    public void save(Rol rol){
        rolRepository.save(rol);
    }

    /**
     * Este servicio es para encontrar un rol dado su nombre.
     * @param rolNombre
     * @return
     */
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }

    /**
     * Este servicio saber si existe o no un rol con cierto nombre dado.
     * @param rolNombre
     * @return
     */
    public boolean existsByRolNombre(RolNombre rolNombre){
        return rolRepository.existsByRolNombre(rolNombre);
    }
}

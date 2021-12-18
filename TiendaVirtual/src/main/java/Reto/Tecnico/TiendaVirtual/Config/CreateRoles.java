/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto.Tecnico.TiendaVirtual.Config;

import Reto.Tecnico.TiendaVirtual.Entity.Rol;
import Reto.Tecnico.TiendaVirtual.Enums.RolNombre;
import Reto.Tecnico.TiendaVirtual.Services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

/**
 * Esta clase es opcional y se encarga de crear los roles en la base de datos.
 * @author Brayan Felipe Pardo Cortes
 */
@Service
public class CreateRoles implements CommandLineRunner {

    @Autowired
    RolService rolService;

    /**
     * Este método se encarga de crear dos roles, el ROLE_ADMIN y el ROLE_USER.
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        /*Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
        Rol rolUser = new Rol(RolNombre.ROLE_USER);
        rolService.save(rolAdmin);
        rolService.save(rolUser);*/
    }
}

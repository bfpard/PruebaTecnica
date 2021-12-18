/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto.Tecnico.TiendaVirtual.Config;


import Reto.Tecnico.TiendaVirtual.Entity.Rol;
import Reto.Tecnico.TiendaVirtual.Entity.Usuario;
import Reto.Tecnico.TiendaVirtual.Enums.RolNombre;
import Reto.Tecnico.TiendaVirtual.Services.RolService;
import Reto.Tecnico.TiendaVirtual.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Esta clase es opcional y se encarga de crear un usuario admin o user en la base de datos
 * con una contraeña modificada con codigo hash. y asigna el / los roles deseados.
 * @author Brayan Felipe Pardo Cortes
 */
@Service
public class CreateAdmin implements CommandLineRunner {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RolService rolService;

    /**
     * Este método crea el usuario con datos deseados y modificables.
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        /*Usuario usuario = new Usuario();
        String passwordEncoded = passwordEncoder.encode("123");
        usuario.setNombre("Natalia Pardo");
        usuario.setCedula("123456");
        usuario.setNombreUsuario("napardo");
        usuario.setDineroDisponible("3200000");
        usuario.setPassword(passwordEncoded);
        Rol rolAdmin = rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get();
        Rol rolUser = rolService.getByRolNombre(RolNombre.ROLE_USER).get();
        Set<Rol> roles = new HashSet<>();
        roles.add(rolAdmin);
        roles.add(rolUser);
        usuario.setRoles(roles);
        usuarioService.save(usuario);*/
    }
}

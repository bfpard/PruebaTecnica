/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto.Tecnico.TiendaVirtual.Services;

import Reto.Tecnico.TiendaVirtual.Entity.Usuario;
import Reto.Tecnico.TiendaVirtual.Repository.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *Esta clase permite interactuar con la base de datos y java, siendo un intermediario
 * entre ambas partes. (servicos para la tabla usuario de la base de datos)
 * @author Brayan Felipe Pardo Cortes
 */
@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    /**
     * Este servicio es para listar los usuarios existentes en la base de datos.
     * @return
     */
    public List<Usuario> lista(){
        return usuarioRepository.findAll();
    }

    /**
     * Este servicio es para encontrar un usuario dado su id.
     * @param id
     * @return
     */
    public Optional<Usuario> getById(int id){
        return usuarioRepository.findById(id);
    }
    
    /**
     * Este servicio es para encontrar un usuario dado su cédula.
     * @param cedula
     * @return
     */
    public Optional<Usuario> getByCedula(String cedula){
        return usuarioRepository.findByCedula(cedula);
    }

    /**
     * Este servicio es para encontrar un usuario dado su username.
     * @param nombreUsuario
     * @return
     */
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    /**
     * Este servicio es para guardar un nuevo usuario y añadirla a la base de datos.
     * @param usuario
     */
    public void save(Usuario usuario){
        usuarioRepository.save(usuario);
    }
    
    /**
     * Este servicio es para eliminar un usuario en la base de datos.
     * @param id
     */
    public void delete(int id){
        usuarioRepository.deleteById(id);
    }

    /**
     * Este servicio es para si existe o no un usuario con cierto id dado.
     * @param id
     * @return
     */
    public boolean existsById(int id){
        return usuarioRepository.existsById(id);
    }

    /**
     * Este servicio es para si existe o no un usuario con cierto username dado.
     * @param nombreUsuario
     * @return
     */
    public boolean existsByNombreusuario(String nombreUsuario){
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }
    
    /**
     * Este servicio es para si existe o no un usuario con cierta cédula dada.
     * @param cedula
     * @return
     */
    public boolean existsByCedula(String cedula){
        return usuarioRepository.existsByCedula(cedula);
    }
    
}

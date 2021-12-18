/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reto.Tecnico.TiendaVirtual.Repository;

import Reto.Tecnico.TiendaVirtual.Entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio del usuario para poder realizar las transacciones con la base de
 * datos.
 * @author Brayan Felipe Pardo Cortes
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
    /**
     * Este método busca un usuario que coincida con la cédula solicitada.
     * @param cedula Cédula del usuario.
     * @return Retorna un usuario con la cédula solicitada.
     */
    Optional<Usuario> findByCedula(String cedula);

    /**
     * Este método determina si existe o nó un usuario con la cédula solicitada.
     * @param cedula Cédula del usuario.
     * @return Retorna true o false que dependerá si existe o nó el usuario con
     * la cédula dada.
     */
    boolean existsByCedula(String cedula);
    
    /**
     * Este método busca un usuario que coincida con el username solicitado.
     * @param nombreUsuario Username del usuario.
     * @return Retorna los datos de un usuario que contenga el username solicitado.
     */
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);

    /**
     * Este método determina si existe o nó un usuario con el username solicitado.
     * @param nombreUsuario Username del usuario.
     * @return Retorna un estado true o false que dependerá si existe o nó el usuario
     * con el username solicitado.
     */
    boolean existsByNombreUsuario(String nombreUsuario);
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reto.Tecnico.TiendaVirtual.Repository;

import Reto.Tecnico.TiendaVirtual.Entity.Rol;
import Reto.Tecnico.TiendaVirtual.Enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repositorio del rol para poder realizar las transacciones con la base de
 * datos.
 * @author Brayan Felipe Pardo Cortes
 */
@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

    /**
     * Este método se encarga de buscar un rol dado su nombre.
     * @param rolNombre Nombre del rol.
     * @return Retorna el nombre del rol solicitado.
     */
    Optional<Rol> findByRolNombre(RolNombre rolNombre);

    /**
     * Este método se encarga de definir si existe o no un rol dado su nombre.
     * @param rolNombre Nombre del rol.
     * @return Retorna un estado true o false dependiendo si existe o no el rol
     * solicitado.
     */
    boolean existsByRolNombre(RolNombre rolNombre);
}

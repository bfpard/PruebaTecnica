/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto.Tecnico.TiendaVirtual.Entity;

import Reto.Tecnico.TiendaVirtual.Enums.RolNombre;
import com.sun.istack.NotNull;
import javax.persistence.*;

/**
 * Clase Rol que hace referencia a los roles que se van a crear: en este caso
 * ROLE_ADMIN y ROLE_USER
 * @author Brayan Felipe Pardo Cortes
 */

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private RolNombre rolNombre;

    /**
     * Constructor vacío.
     */
    public Rol() {
    }

    /**
     * Constructor con los atributos de la clase Rol.
     * @param rolNombre Nombre del rol que se le va a asignar al usuario.
     */
    public Rol(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }

    /**
     * Retorna el id
     * @return Retorna el id del rol
     */
    public int getId() {
        return id;
    }

    /**
     * Este método es para asignar un dato al id del rol.
     * @param id Id del rol.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna el nombre.
     * @return Retorna el nombre del rol.
     */
    public RolNombre getRolNombre() {
        return rolNombre;
    }

    /**
     * Este método es para asignar un dato al nombre del rol.
     * @param rolNombre Nombre del rol.
     */
    public void setRolNombre(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
}

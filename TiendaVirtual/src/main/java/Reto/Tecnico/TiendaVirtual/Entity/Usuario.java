/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto.Tecnico.TiendaVirtual.Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase Usuario que hace referencia a los clientes que van a interactuar con la
 * tienda virtual.
 * @author Brayan Felipe Pardo Cortes
 */

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int id;

    @Column(name = "fullname", nullable = true)
    private String nombre;

    @Column(name = "cedula", unique = true, nullable = true)
    private String cedula;

    @Column(name = "userlogin", unique = true, nullable = true)
    private String nombreUsuario;

    @Column(name = "password", nullable = true)
    private String password;
    
    @Column(name = "dinero_actual")
    private String dineroDisponible;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();

    /**
     * Constructor vacío.
     */
    public Usuario() {
    }

    /**
     * Constructor con todos los atributos del usuario.
     * @param id Identificador del usuario.
     * @param nombre Nombre del usuario.
     * @param cedula Cédula del usuario.
     * @param nombreUsuario Username del usuario. (Requesito para loguarse en la tienda)
     * @param password Password del usuario. (Requesito para loguarse en la tienda)
     * @param dineroDisponible Dinero disponible en la cuenta del usuario.
     */
    public Usuario(int id, String nombre, String cedula, String nombreUsuario, String password, String dineroDisponible) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.dineroDisponible = dineroDisponible;
    }

    /**
     * Retorna el id
     * @return Retorna el id del usuario.
     */
    public int getId() {
        return id;
    }

    /**
     * Este método asigna un dato al id del usuario.
     * @param id Id del usuario.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna el nombre
     * @return Retorna el nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Este método asigna un dato al nombre del usuario.
     * @param nombre Nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna la cédula
     * @return Retorna la cédula del usuario.
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Este método asigna un dato a la cédula del usuario.
     * @param cedula Cédula del usuario.
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * Retorna el username
     * @return Retorna el username del usuario.
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Este método asigna un dato al username del usuario.
     * @param nombreUsuario Username del usuario.
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Retorna el password
     * @return Retorna el password del usuario.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Este método asigna un dato al password del usuario
     * @param password Password del usuario.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Retorna el dinero disponible
     * @return Retorna el dinero disponible del usuario.
     */
    public String getDineroDisponible() {
        return dineroDisponible;
    }

    /**
     * Este método asigna un dato al dineroDisponible del usuario.
     * @param dineroDisponible Dinero actual del usuario.
     */
    public void setDineroDisponible(String dineroDisponible) {
        this.dineroDisponible = dineroDisponible;
    }

    /**
     * Retorna el/los roles
     * @return Retorna el/los roles del usuario.
     */
    public Set<Rol> getRoles() {
        return roles;
    }

    /**
     * Este método asigna un dato al rol del usuario.
     * @param roles Rol del usuario.
     */
    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

    

}

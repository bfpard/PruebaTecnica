/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto.Tecnico.TiendaVirtual.Security.Services;

import Reto.Tecnico.TiendaVirtual.Entity.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Con este clase se crea un nuevo objeto de tipo Usuario con los atributos requeridos
 * para la autenticación que es el username, password y roles.
 * @author Brayan Felipe Pardo Cortes
 */
public class UsuarioPrincipal implements UserDetails {

    private int id;
    private String nombreUsuario;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    /**
     * Constructos de la clase con sus atributos.
     * @param id
     * @param nombreUsuario
     * @param password
     * @param authorities
     */
    public UsuarioPrincipal(int id, String nombreUsuario, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.authorities = authorities;
    }

    /**
     * Este método permite acceder los roles asociados al usuario logueado.
     * @param usuario
     * @return
     */
    public static UsuarioPrincipal build(Usuario usuario){
        List<GrantedAuthority> authorities =
                usuario.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getRolNombre().name())).collect(Collectors.toList());
        return new UsuarioPrincipal(usuario.getId(), usuario.getNombreUsuario(), usuario.getPassword(), authorities);
    }

    /**
     * Retorna los roles asociados al usuario logueado
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    /**
     * Retorna el password con la que el usuario fue logueado.
     * @return
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Retorna el usernma del usuario logueado.
     * @return
     */
    @Override
    public String getUsername() {
        return nombreUsuario;
    }

    /**
     * Retorna el estado activo o inactivo del usuario logueado.
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Retorna el estado para saber si el usuario tiene acceso total.
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Retorna el estado de las datos de autenticación.
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Retorna el estado true o false dependiendo si el usuario aun se encuentre
     * logueado.
     * @return
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     * Retorna el id de usuario logueado.
     * @return
     */
    public int getId() {
        return id;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto.Tecnico.TiendaVirtual.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase producto que hace referencia a los productos ofrecidos por la tienda
 * virtual
 * @author Brayan Felipe Pardo Cortes
 */

@Entity
@Table(name = "producto")
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int id;
    
    @Column(name = "nombre_producto")
    private String nombreProducto;
    
    @Column(name = "precio")
    private String precio;
    
    @Column(name = "fecha_expiracion")
    private String fechaExpiracion;
    
    @Column(name = "fecha_publicacion")
    private String fechaPublicacion;
    
    @Column(name = "carrito")
    private String estadoCarrito;

    /**
     * Constructor vacío.
     */
    public Producto() {
    }

    /**
     * Contructor con todos los atributos de la clase.
     * @param id identificador para el producto.
     * @param nombreProducto Nombre para el producto.
     * @param precio Precio correspondiente al producto.
     * @param fechaExpiracion Fecha de expiracion del producto
     * @param fechaPublicacion Fecha de publicación del producto
     * @param estadoCarrito Indica si esta "on" o "off" en el carrito de compras
     */
    public Producto(int id, String nombreProducto, String precio, String fechaExpiracion, String fechaPublicacion, String estadoCarrito) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.fechaExpiracion = fechaExpiracion;
        this.fechaPublicacion = fechaPublicacion;
        this.estadoCarrito = estadoCarrito;
    }

    /**
     * Retorna el id
     * @return Retorna el id del producto.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Este método es para asignar un dato al id del producto.
     * @param id id del producto.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna el nombre.
     * @return Retorna el nombre del producto.
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * Este método es para asignar un dato al nombre del producto.
     * @param nombreProducto nombre del producto
     */
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    /**
     * Retorna el precio
     * @return Retorna el precio del producto.
     */
    public String getPrecio() {
        return precio;
    }

    /**
     * Este método es para asignar un dato al precio del producto.
     * @param precio precio del producto
     */
    public void setPrecio(String precio) {
        this.precio = precio;
    }

    /**
     * Retorna la fecha de expiración
     * @return Retorna la fecha de expiración del producto.
     */
    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    /**
     * Este método es para asignar un dato a la fecha de expiración del producto.
     * @param fechaExpiracion fecha de expiración del producto.
     */
    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    /**
     * Retorna la fecha de publicación
     * @return Retorna la fecha de publicación del producto.
     */
    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    /**
     * Este método es para asignar un dato a la fecha de publicación del producto.
     * @param fechaPublicacion fecha de publicación del producto.
     */
    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    /**
     * Retorna el estado del carrito
     * @return Retorna el estado del carrito del producto.
     */
    public String getEstadoCarrito() {
        return estadoCarrito;
    }

    /**
     * Este método es para asignar un dato al estado del carrito del producto.
     * @param estadoCarrito Estado del carrito del producto.
     */
    public void setEstadoCarrito(String estadoCarrito) {
        this.estadoCarrito = estadoCarrito;
    }
    
    
    
}

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
 * Clase Ventas que hace referencia al reporte de todas las ventas hechas por los
 * usuarios.
 * 
 * @author Brayan Felipe Pardo Cortes
 */

@Entity
@Table(name = "ventas")
public class Ventas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ventas")
    private int idVentas;
    
    @Column(name = "cliente")
    private String cliente;
    
    @Column(name = "producto_vendido")
    private String productoVendido;
    
    @Column(name = "valor_producto")
    private String valorProducto;

    /**
     * Constructor vacío
     */
    public Ventas() {
    }

    /**
     * Constructor con los atributos de la clase venta.
     * @param idVentas Identificador de la venta.
     * @param cliente Nombre del usuario que hizo la compra.
     * @param productoVendido Nombre del producto comprado.
     * @param valorProducto Precio del producto vendido.
     */
    public Ventas(int idVentas, String cliente, String productoVendido, String valorProducto) {
        this.idVentas = idVentas;
        this.cliente = cliente;
        this.productoVendido = productoVendido;
        this.valorProducto = valorProducto;
    }

    /**
     * Retorna el id.
     * @return Retorna el id de la venta realizada.
     */
    public int getIdVentas() {
        return idVentas;
    }

    /**
     * Este método asigna un dato al id de la venta.
     * @param idVentas id de la venta.
     */
    public void setIdVentas(int idVentas) {
        this.idVentas = idVentas;
    }

    /**
     * Retorna el nombre.
     * @return Retorna el nombre del usuario que realizó la compra.
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * Este método asigna un dato al nombre del cliente que realizó la compra.
     * @param cliente Nombre del usuario que realizó la compra.
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * Retorna el nombre.
     * @return Retorna el nombre del producto vendido.
     */
    public String getProductoVendido() {
        return productoVendido;
    }

    /**
     * Este método asigna un dato al nombre del producto vendido.
     * @param productoVendido Nombre del producto vendido.
     */
    public void setProductoVendido(String productoVendido) {
        this.productoVendido = productoVendido;
    }

    /**
     * Retorna el precio.
     * @return Retorna el precio de la venta.
     */
    public String getValorProducto() {
        return valorProducto;
    }

    /**
     * Este método asigna un dato al precio del producto vendido.
     * @param valorProducto Precio del producto vendido.
     */
    public void setValorProducto(String valorProducto) {
        this.valorProducto = valorProducto;
    }
    
    
}

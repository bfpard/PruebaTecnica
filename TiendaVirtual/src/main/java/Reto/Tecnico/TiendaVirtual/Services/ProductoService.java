/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto.Tecnico.TiendaVirtual.Services;

import Reto.Tecnico.TiendaVirtual.Entity.Producto;
import Reto.Tecnico.TiendaVirtual.Repository.ProductoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Esta clase permite interactuar con la base de datos y java, siendo un intermediario
 * entre ambas partes. (servicos para la tabla producto de la base de datos)
 * @author Brayan Felipe Pardo Cortes
 */

@Service
public class ProductoService {
    
    @Autowired
    ProductoRepository productoRepository;
    
    /**
     * Este servicio es para listar los productos existentes en la base de datos.
     * @return Retorna una lista de tipo Producto.
     */
    public List<Producto> lista(){
        return productoRepository.findAll();
    }
    
    /**
     * Este servicio es para guardar un nuevo producto y añadirla a la base de datos.
     * @param producto
     */
    public void save(Producto producto){
        productoRepository.save(producto);
    }
    
    /**
     * Este servicio es para eliminar un producto en la base de datos.
     * @param id
     */
    public void delete(int id){
        productoRepository.deleteById(id);
    }
    
    /**
     * Este servicio es para encontrar un producto dado su id.
     * @param id
     * @return
     */
    public Optional<Producto> getById(int id){
        return productoRepository.findById(id);
    }
    
    
    
}

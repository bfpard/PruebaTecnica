/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reto.Tecnico.TiendaVirtual.Repository;

import Reto.Tecnico.TiendaVirtual.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio del producto para poder realizar las transacciones con la base de
 * datos.
 * @author Brayan Felipe Pardo Cortes
 */
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{ 
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto.Tecnico.TiendaVirtual.Services;

import Reto.Tecnico.TiendaVirtual.Entity.Ventas;
import Reto.Tecnico.TiendaVirtual.Repository.VentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Esta clase permite interactuar con la base de datos y java, siendo un intermediario
 * entre ambas partes. (servicos para la tabla ventas de la base de datos)
 * @author Brayan Felipe Pardo Cortes
 */

@Service
public class VentaService {
    
    @Autowired
    VentasRepository ventasRepository;
    
    /**
     * Este servicio permite guardar una nueva venta realizado por algún usuario.
     * @param venta
     */
    public void save(Ventas venta){
        ventasRepository.save(venta);
    }
    
}

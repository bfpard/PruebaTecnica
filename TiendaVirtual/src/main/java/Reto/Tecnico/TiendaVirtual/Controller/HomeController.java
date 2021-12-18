/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto.Tecnico.TiendaVirtual.Controller;

import Reto.Tecnico.TiendaVirtual.Services.ProductoService;
import Reto.Tecnico.TiendaVirtual.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * El controlador Home se encarga de redireccionar hacia la página index que es
 * el home de la página pero en estado sin logueo, y redireccionar al home que es
 * la página en estado logueado.
 * @author Brayan Felipe Pardo Cortes
 */
@Controller
public class HomeController {
    
    @Autowired
    ProductoService productoService;
    
    @Autowired
    UsuarioService usuarioService;
    
    /**
     * Redirecciona a la página index.html
     * @param model
     * @return
     */
    @GetMapping("/index")
    public String homeSinLogueo(Model model){
        var productos = productoService.lista();
        model.addAttribute("productos", productos);
        return "index";
    }
    
    /**
     * Redirecciona a la página home.html
     * @param model
     * @return
     */
    @GetMapping("/home")
    public String homeConLogueo(Model model){
        var usuario = usuarioService.getByNombreUsuario(SecurityContextHolder.getContext().getAuthentication().getName()).get();
        String saludoUsuarioLogueado = usuario.getNombre();
        var productos = productoService.lista();
        model.addAttribute("nombreLogueado", saludoUsuarioLogueado);
        model.addAttribute("productos", productos);
        return "home";
    }
    
}

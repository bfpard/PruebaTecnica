/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto.Tecnico.TiendaVirtual.Controller;


import Reto.Tecnico.TiendaVirtual.Entity.Ventas;
import Reto.Tecnico.TiendaVirtual.Services.ProductoService;
import Reto.Tecnico.TiendaVirtual.Services.UsuarioService;
import Reto.Tecnico.TiendaVirtual.Services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Brayan Felipe Pardo Cortes
 */
@Controller
public class CarritoController {

    @Autowired
    ProductoService productoService;
    
    @Autowired
    UsuarioService usuarioService;
    
    @Autowired
    VentaService ventaService;

    /**
     * Este método se encarga de:
     * 1- Buscar mediante el id el producto que fue seleccionado por el usuario
     * para ser visualizado en el carrito.
     * 
     * 2- Cambiar el atributo "estadoCarrito" de la clase producto a "on".
     * 
     * Esta lógica es teniendo en cuenta que el usuario no se ha logueado.
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/carrito/{id}")
    public String añadirAlCarritoSinLogueo(@PathVariable("id") int id, Model model) {
        var producto = productoService.getById(id).get();
        producto.setEstadoCarrito("on");
        productoService.save(producto);
        var productos = productoService.lista();
        model.addAttribute("productos", productos);
        model.addAttribute("mensaje", "Añadido con exito");
        return "index";
    }
    
    /**
     * Este método se encarga de:
     * 1- Buscar mediante el id el producto que fue seleccionado por el usuario
     * para ser visualizado en el carrito.
     * 
     * 2- Cambiar el atributo "estadoCarrito" de la clase producto a "on".
     * 
     * Esta lógica es teniendo en cuenta que el usuario ya se ha logueado.
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/carritoLogueo/{id}")
    public String añadirAlCarritoConLogueo(@PathVariable("id") int id, Model model) {
        var producto = productoService.getById(id).get();
        producto.setEstadoCarrito("on");
        productoService.save(producto);
        var productos = productoService.lista();
        model.addAttribute("productos", productos);
        model.addAttribute("mensaje", "Añadido con exito");
        return "home";
    }

    /**
     * Este método se encarga de:
     * 1- Filtrar todos los productos y listar solo los productos que el usuario
     * seleccionó para el carrito.
     * 
     * 2- Hacer la sumatoria de los productos seleccionados en el carrito.
     * 
     * 3- Mostrar el carrito con los productos seleccionados y la sumatoria de sus
     * precios.
     * 
     * Esta lógica es teniendo en cuenta que el usuario no se ha logueado.
     * 
     * @param model
     * @return
     */
    @GetMapping("/carrito")
    public String verProductosEnCarritoSinLogueo(Model model) {

        int totalSumaDeProductosEnCarrito = 0;
        var productosEnCarrito = productoService.lista();
        for (int i = 0; i < productosEnCarrito.size(); i++) {

            if ("off".equals(productosEnCarrito.get(i).getEstadoCarrito())) {
                productosEnCarrito.remove(i);
                i = -1;
            }
        }
        for (int i = 0; i < productosEnCarrito.size(); i++) {
            totalSumaDeProductosEnCarrito += Integer.parseInt(productosEnCarrito.get(i).getPrecio());
        }
        model.addAttribute("total", totalSumaDeProductosEnCarrito);
        model.addAttribute("productos", productosEnCarrito);
        return "carrito/carrito";
    }

    /**
     * Este método se encarga de:
     * 1- Filtrar todos los productos y listar solo los productos que el usuario
     * seleccionó para el carrito.
     * 
     * 2- Hacer la sumatoria de los productos seleccionados en el carrito.
     * 
     * 3- Mostrar el carrito con los productos seleccionados y la sumatoria de sus
     * precios.
     * 
     * Esta lógica es teniendo en cuenta que el usuario ya se ha logueado.
     * @param model
     * @return
     */
    @GetMapping("/carritoLogueo")
    public String verProductosEnCarritoConLogueo(Model model) {

        int totalSumaDeProductosEnCarrito = 0;
        var productosEnCarrito = productoService.lista();
        for (int i = 0; i < productosEnCarrito.size(); i++) {

            if ("off".equals(productosEnCarrito.get(i).getEstadoCarrito())) {
                productosEnCarrito.remove(i);
                i = -1;
            }
        }
        for (int i = 0; i < productosEnCarrito.size(); i++) {
            totalSumaDeProductosEnCarrito += Integer.parseInt(productosEnCarrito.get(i).getPrecio());
        }
        model.addAttribute("total", totalSumaDeProductosEnCarrito);
        model.addAttribute("productos", productosEnCarrito);
        return "carrito/carritoLogueo";
    }

    /**
     * Este método se encarga de:
     * 1- Eliminar el producto del carrito.
     * 
     * 2- El estadoCarrito del producto vuelve a estar en "off".
     * 
     * 3- Vuelve a filtrar los productos que tengan su estadoCarrito en "on".
     * 
     * Esta lógica es teniendo en cuenta que el usuario no se ha logueado.
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/carritoDelete/{id}")
    public String eliminarProductoDeCarritoSinLogueo(@PathVariable("id") int id, Model model) {

        var producto = productoService.getById(id).get();
        producto.setEstadoCarrito("off");
        productoService.save(producto);

        int totalSumaDeProductosEnCarrito = 0;
        var productosEnCarrito = productoService.lista();
        for (int i = 0; i < productosEnCarrito.size(); i++) {
            System.out.println(productosEnCarrito.get(i).getEstadoCarrito());
            if ("off".equals(productosEnCarrito.get(i).getEstadoCarrito())) {
                productosEnCarrito.remove(i);
                i = -1;
            }
        }
        for (int i = 0; i < productosEnCarrito.size(); i++) {
            totalSumaDeProductosEnCarrito += Integer.parseInt(productosEnCarrito.get(i).getPrecio());
        }
        model.addAttribute("total", totalSumaDeProductosEnCarrito);
        model.addAttribute("productos", productosEnCarrito);
        return "carrito/carrito";

    }

    /**
     * Este método se encarga de:
     * 1- Eliminar el producto del carrito.
     * 
     * 2- El estadoCarrito del producto vuelve a estar en "off".
     * 
     * 3- Vuelve a filtrar los productos que tengan su estadoCarrito en "on".
     * 
     * Esta lógica es teniendo en cuenta que el usuario ya se ha logueado.
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/carritoDeleteLogueo/{id}")
    public String eliminarProductoDeCarritoConLogueo(@PathVariable("id") int id, Model model) {

        var producto = productoService.getById(id).get();
        producto.setEstadoCarrito("off");
        productoService.save(producto);

        int totalSumaDeProductosEnCarrito = 0;
        var productosEnCarrito = productoService.lista();
        for (int i = 0; i < productosEnCarrito.size(); i++) {
            System.out.println(productosEnCarrito.get(i).getEstadoCarrito());
            if ("off".equals(productosEnCarrito.get(i).getEstadoCarrito())) {
                productosEnCarrito.remove(i);
                i = -1;
            }
        }
        for (int i = 0; i < productosEnCarrito.size(); i++) {
            totalSumaDeProductosEnCarrito += Integer.parseInt(productosEnCarrito.get(i).getPrecio());
        }
        model.addAttribute("total", totalSumaDeProductosEnCarrito);
        model.addAttribute("productos", productosEnCarrito);
        return "carrito/carritoLogueo";

    }

    /**
     *
     * @param model
     * @return
     */
    @GetMapping("/carritoComprar")
    public String comprarEnCarritoSinLogueo(Model model) {
        model.addAttribute("info", "Por favor Inicie Sesión para efectuar el pago");
        return "login";
    }

    /**
     *
     * @param model
     * @return
     */
    @GetMapping("/carritoComprarLogueo")
    public String comprarEnCarritoConLogueo(Model model) {

        int totalSumaDeProductosEnCarrito = 0;
        var productosEnCarrito = productoService.lista();
        for (int i = 0; i < productosEnCarrito.size(); i++) {
            
            if ("off".equals(productosEnCarrito.get(i).getEstadoCarrito())) {
                productosEnCarrito.remove(i);
                i = -1;
            }
        }
        for (int i = 0; i < productosEnCarrito.size(); i++) {
            totalSumaDeProductosEnCarrito += Integer.parseInt(productosEnCarrito.get(i).getPrecio());

        }

        var usuario = usuarioService.getByNombreUsuario(SecurityContextHolder.getContext().getAuthentication().getName()).get();
        int dineroDelUsuarioDisponible = Integer.parseInt(usuario.getDineroDisponible());
        if (dineroDelUsuarioDisponible > totalSumaDeProductosEnCarrito) {
            if (totalSumaDeProductosEnCarrito > 0) {
                int nuevoSaldoDisponibleDelUsuario = dineroDelUsuarioDisponible - totalSumaDeProductosEnCarrito;
                usuario.setDineroDisponible(Integer.toString(nuevoSaldoDisponibleDelUsuario));
                usuarioService.save(usuario);

                for (int i = 0; i < productosEnCarrito.size(); i++) {
                    Ventas venta = new Ventas();
                    venta.setCliente(usuario.getNombre());
                    venta.setProductoVendido(productosEnCarrito.get(i).getNombreProducto());
                    venta.setValorProducto(productosEnCarrito.get(i).getPrecio());
                    ventaService.save(venta);

                }

                
                var productosEnCarritoSuccess = productoService.lista();
                for (int i = 0; i < productosEnCarritoSuccess.size(); i++) {
                    
                    if ("off".equals(productosEnCarritoSuccess.get(i).getEstadoCarrito())) {
                        productosEnCarritoSuccess.remove(i);
                        i = -1;
                    }
                }

                for (int i = 0; i < productosEnCarritoSuccess.size(); i++) {
                    var cambioOffLosProductos = productosEnCarritoSuccess.get(i);
                    cambioOffLosProductos.setEstadoCarrito("off");
                    productoService.save(cambioOffLosProductos);

                }
                model.addAttribute("success", "Pago realizado con exito, gracias por su compra");
                return "carrito/carritoLogueo";
            } else {

                model.addAttribute("info", "Selecciona un producto para poder comprar");
                return "carrito/carritoLogueo";
            }
        } else {
            int totalSumaDeProductosEnCarritoSaldoInsuficiente = 0;
            var productosEnCarritoSaldoInsuficiente = productoService.lista();
            for (int i = 0; i < productosEnCarritoSaldoInsuficiente.size(); i++) {

                if ("off".equals(productosEnCarritoSaldoInsuficiente.get(i).getEstadoCarrito())) {
                    productosEnCarritoSaldoInsuficiente.remove(i);
                    i = -1;
                }
            }
            for (int i = 0; i < productosEnCarritoSaldoInsuficiente.size(); i++) {
                totalSumaDeProductosEnCarritoSaldoInsuficiente += Integer.parseInt(productosEnCarritoSaldoInsuficiente.get(i).getPrecio());
            }
            model.addAttribute("total", totalSumaDeProductosEnCarritoSaldoInsuficiente);
            model.addAttribute("productos", productosEnCarritoSaldoInsuficiente);
            model.addAttribute("info", "Saldo Insuficiente");
            return "carrito/carritoLogueo";
        }

    }

}

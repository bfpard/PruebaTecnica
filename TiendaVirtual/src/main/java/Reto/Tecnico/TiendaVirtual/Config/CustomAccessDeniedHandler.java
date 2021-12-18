/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto.Tecnico.TiendaVirtual.Config;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Esta clase se encarga de redireccionar a una pagina en dado caso que se presente
 * un acceso a la tienda de manera prohibida.
 * @author Brayan Felipe Pardo Cortes
 */
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    /**
     * Este método se encargar de redireccionar a la direccion /forbidden para aquellas
     * navegaciones sobre la tienda no validas.
     * @param httpServletRequest
     * @param httpServletResponse
     * @param e Contiene la información del error generado en el proceso.
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/forbidden");
    }
}

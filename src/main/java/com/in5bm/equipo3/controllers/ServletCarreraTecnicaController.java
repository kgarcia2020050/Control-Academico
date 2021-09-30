

package com.in5bm.equipo3.controllers;
import com.in5bm.equipo3.models.dao.CarreraTecnicaDaolmpl;
import com.in5bm.equipo3.models.domain.CarreraTecnica;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;

/**
 * 
 * @author Juan Diego Solís Martínez
 * @date 28/08/2021
 * @time 10:02:11 AM
 *
 */
@WebServlet("/ServletCarreraTecnicaController")
public class ServletCarreraTecnicaController extends HttpServlet{
    
    private static final String JSP_LISTAR= "vistas/carrera-tecnica/carrera-tecnica.jsp";
    private static final String JSP_EDITAR= "vistas/carrera-tecnica/editar-carrera-tecnica.jsp";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        request.setCharacterEncoding("UTF-8");
        
        String accion = request.getParameter("accion");
        
        if(accion != null) {
            switch(accion) {
                case "listar":
                    listarCarrerasTecnicas(request, response);
                    break;
                case "editar":
                    editarCarreraTecnica(request, response);
                    break;
                case "eliminar":
                    eliminarCarreraTecnica(request, response);
                    break;
            }
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, IOException{
        request.setCharacterEncoding("UTF-8");
        
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarCarreraTecnica(request, response);
                    break;
                case "actualizar":
                    actualizarCarreraTecnica(request,response);
                    break;
            }
        }
    }
    
    private void actualizarCarreraTecnica(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String nombre = request.getParameter("nombre"); 
        
        String codigoCarrera = request.getParameter("codigoCarrera");
        
        CarreraTecnica carreraTecnica = new CarreraTecnica (codigoCarrera, nombre);
        int registrosModificados = new CarreraTecnicaDaolmpl().actualizar(carreraTecnica);
        listarCarrerasTecnicas(request, response);
    }
    
    private void insertarCarreraTecnica(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String codigoCarrera = request.getParameter("codigoCarrera");
        String nombre = request.getParameter("nombre");
        
        CarreraTecnica carreraTecnica = new CarreraTecnica(codigoCarrera, nombre);
        
        int registrosInsertados = new CarreraTecnicaDaolmpl().insertar(carreraTecnica);
        
        listarCarrerasTecnicas(request, response);
    }
    
    private void editarCarreraTecnica(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String codigoCarrera = request.getParameter("codigoCarrera");
        CarreraTecnica carreraTecnica = new CarreraTecnicaDaolmpl().encontrar(new CarreraTecnica(codigoCarrera));
        request.setAttribute("carreraTecnica", carreraTecnica);
        request.getRequestDispatcher(JSP_EDITAR).forward(request, response);
    }
    
    private void eliminarCarreraTecnica(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String codigoCarrera = request.getParameter("codigoCarrera");
        CarreraTecnica carreraTecnica = new CarreraTecnica(codigoCarrera);
        int registrosEliminados = new CarreraTecnicaDaolmpl().eliminar(carreraTecnica);
        System.out.println("Cantidad de registros eliminados: "+ registrosEliminados);
        listarCarrerasTecnicas(request,response); 
    }
    
    private void listarCarrerasTecnicas(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        List<CarreraTecnica> listaCarreraTecnica = new CarreraTecnicaDaolmpl().listar();
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listadoCarreraTecnica", listaCarreraTecnica);
        response.sendRedirect(JSP_LISTAR);
    }
}



package com.in5bm.equipo3.controllers;
import com.in5bm.equipo3.models.dao.InstructorDaolmpl;
import com.in5bm.equipo3.models.domain.Instructor;
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
 * @author Omar Chocojay
 */
@WebServlet("/ServletInstructorController")
public class ServletInstructorController extends HttpServlet{
    
    private static final String JSP_LISTAR= "vistas/instructor/instructor.jsp";
    private static final String JSP_EDITAR= "vistas/instructor/editar-instructor.jsp";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String accion = request.getParameter("accion");
        
        if(accion != null) {
            switch(accion) {
                case "listar":
                    listarInstructores(request, response);
                    break;
                case "editar":
                     editarInstructor(request, response);
                    break;
                case "eliminar":
                    eliminarInstructor(request, response);
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
                    insertarInstructor(request, response);
                    break;
                case "actualizar":
                  actualizarInstructor(request,response);
            }
        }
        
    }
    
        private void actualizarInstructor(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int instructorId = Integer.parseInt(request.getParameter("instructorId"));
        String apellidos = request.getParameter("apellidos");
        String nombres = request.getParameter("nombres"); 
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");

        Instructor instructor = new Instructor(instructorId, apellidos, nombres, direccion, telefono);
        int registrosModificados = new InstructorDaolmpl().actualizar(instructor);
        listarInstructores(request, response);
        
    }
    
    
        private void insertarInstructor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String apellidos = request.getParameter("apellidos");
        String nombres = request.getParameter("nombres"); 
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        

        Instructor instructor = new Instructor( apellidos, nombres, direccion, telefono);
        int registrosInsertados = new InstructorDaolmpl().insertar(instructor);
        System.out.println ("Registros insertados: "+registrosInsertados);
        listarInstructores(request, response);

    }
    
        private void editarInstructor(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        int instructorId = Integer.parseInt(request.getParameter("instructorId"));
        Instructor instructor = new InstructorDaolmpl().encontrar(new Instructor(instructorId));
        request.setAttribute("instructor", instructor);
        System.out.println(instructor);
        request.getRequestDispatcher(JSP_EDITAR).forward(request, response);
        
    }
    
    private void eliminarInstructor(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int instructorId = Integer.parseInt(request.getParameter("instructorId"));
        Instructor instructor = new Instructor(instructorId);
        int registrosEliminados = new InstructorDaolmpl().eliminar(instructor);
        System.out.println("Cantidad de registros eliminados: "+ registrosEliminados);
        listarInstructores(request,response); 
    }
    
    private void listarInstructores(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        List<Instructor> listaInstructor = new InstructorDaolmpl().listar();
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listadoInstructor", listaInstructor);
        response.sendRedirect(JSP_LISTAR);
    }
    
}

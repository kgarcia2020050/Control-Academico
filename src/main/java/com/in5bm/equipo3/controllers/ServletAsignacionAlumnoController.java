/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.in5bm.equipo3.controllers;

import com.in5bm.equipo3.models.dao.AlumnoDaoImpl;
import com.in5bm.equipo3.models.dao.AsignacionAlumnoDaoImpl;
import com.in5bm.equipo3.models.dao.CursoDaoImpl;
import com.in5bm.equipo3.models.domain.Alumno;
import com.in5bm.equipo3.models.domain.AsignacionAlumno;
import com.in5bm.equipo3.models.domain.Curso;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;

/**
 *
 * @author Josdvin Alexander Macario Barán
 * @date 30/08/2021
 * @time 06:31:57 PM
 */
@WebServlet("/ServletAsignacionAlumnoController")
public class ServletAsignacionAlumnoController extends HttpServlet{
    
    private static final String JSP_LISTAR= "vistas/asignacion-alumno/asignacion-alumno.jsp";
    private static final String JSP_EDITAR= "vistas/asignacion-alumno/editar-asignacionalumno.jsp";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        
        String accion = request.getParameter("accion");
        if(accion!=null){
            switch(accion){
                case "listar":
                    listarAsignacionAlumno(request, response);
                break;
                case "editar":
                    editarAsignacionAlumno(request, response);
                    break;
                case "eliminar":
                    eliminarAsignacionAlumno(request, response);
                    break;
            }
        }
    }
    
    public void editarAsignacionAlumno(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        
        String asignacionId= request.getParameter("asignacionId");
        AsignacionAlumno asignacionAlumno = new AsignacionAlumnoDaoImpl().encontrar(new AsignacionAlumno(asignacionId));
        request.setAttribute("asignacionAlumno", asignacionAlumno);
        request.getRequestDispatcher(JSP_EDITAR).forward(request, response);
    }
    
    private List<Curso> listarCursos() {
        List<Curso> listaCursos = new CursoDaoImpl().listar();
        return listaCursos;
    }

    private List<Alumno> listarAlumno() {
        List<Alumno> listaAlumno = new AlumnoDaoImpl().listar();
        return listaAlumno;
    }
    
    private void eliminarAsignacionAlumno(HttpServletRequest request, HttpServletResponse response) throws IOException{
    String  asignacionId= request.getParameter("asignacionId");
    AsignacionAlumno asignacionAlumno = new AsignacionAlumno(asignacionId);
    int registrosEliminados = new AsignacionAlumnoDaoImpl().eliminar(asignacionAlumno);
    listarAsignacionAlumno(request, response);
    }
        
    private void listarAsignacionAlumno(HttpServletRequest request, HttpServletResponse response) throws IOException{
        List<AsignacionAlumno> listaAsignacionAlumno = new AsignacionAlumnoDaoImpl().listar();
        HttpSession sesion=request.getSession();
        sesion.setAttribute("listadoAsignacionAlumno", listaAsignacionAlumno);
        sesion.setAttribute("listadoCursos", listarCursos());
        sesion.setAttribute("listadoAlumno", listarAlumno());
        response.sendRedirect(JSP_LISTAR);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        if (accion!=null){
            switch(accion){
                case "insertar":
                    insertarAsignacionAlumno(request, response);
                    break;
                case "actualizar":
                    actualizarAsignacionAlumno(request, response);
                    break;
            }
        }
   }
    
    private void actualizarAsignacionAlumno(HttpServletRequest request, HttpServletResponse response) throws IOException{
       String asignacionId=request.getParameter("asignacionId");
        String fecha_hora_str = request.getParameter("fecha_asignacion");
        Timestamp fechaAsignacion = Timestamp.valueOf(fecha_hora_str.replace("T"," ") + ":00.00");
        String carne = request.getParameter("carne");
        String cursoStr = request.getParameter("cursoId");
        int cursoId=0;
        if(cursoStr.equals("curso")){
            cursoId=1;
        }else{
            cursoId = Integer.parseInt(request.getParameter("cursoId"));
        }
        AsignacionAlumno asignacionAlumno = new AsignacionAlumno(asignacionId, fechaAsignacion, carne, cursoId);
        int registrosActualizados = new AsignacionAlumnoDaoImpl().actualizar(asignacionAlumno);
        listarAsignacionAlumno(request, response);
   }
    
    private void insertarAsignacionAlumno(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String asignacionId = request.getParameter("ID");
        LocalDateTime ActualesFechaHora = LocalDateTime.now();
        Timestamp fechaAsignacion = Timestamp.valueOf(ActualesFechaHora);
        String carne = request.getParameter("carne");
        String cursoStr = request.getParameter("cursoId");
        int cursoId=0;
        if(cursoStr.equals("curso")){
            cursoId=1;
        }else{
            cursoId = Integer.parseInt(request.getParameter("cursoId"));
        }
        AsignacionAlumno asignacionAlumno = new AsignacionAlumno(asignacionId, fechaAsignacion, carne, cursoId);
        int registrosInsertados = new AsignacionAlumnoDaoImpl().insertar(asignacionAlumno);
        listarAsignacionAlumno(request, response);
    }

}

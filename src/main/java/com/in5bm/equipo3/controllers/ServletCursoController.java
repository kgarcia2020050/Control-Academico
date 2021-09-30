/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.in5bm.equipo3.controllers;

import com.in5bm.equipo3.models.dao.CarreraTecnicaDaolmpl;
import com.in5bm.equipo3.models.dao.CursoDaoImpl;
import com.in5bm.equipo3.models.dao.HorarioDaoImpl;
import com.in5bm.equipo3.models.dao.InstructorDaolmpl;
import com.in5bm.equipo3.models.dao.SalonDaoImpl;
import com.in5bm.equipo3.models.domain.CarreraTecnica;
import com.in5bm.equipo3.models.domain.Curso;
import com.in5bm.equipo3.models.domain.Horario;
import com.in5bm.equipo3.models.domain.Instructor;
import com.in5bm.equipo3.models.domain.Salon;
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
 * @time 10:38:49 AM
 *
 */

@WebServlet("/ServletCursoController")
public class ServletCursoController extends HttpServlet{
    
    private static final String JSP_LISTAR= "vistas/curso/curso.jsp";
    private static final String JSP_EDITAR = "vistas/curso/editar-curso.jsp";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        request.setCharacterEncoding("UTF-8");
        
        String accion = request.getParameter("accion");
        
        if(accion != null) {
            switch(accion) {
                case "listar":
                    listarCursos(request, response);
                    break;
                case "editar":
                    editarCurso(request, response);
                    break;
                case "eliminar":
                    eliminarCurso(request, response);
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
                    insertarCurso(request, response);
                    break;
                case "actualizar":
                    actualizarCurso(request,response);
                    break;
            }
        }
    }
    
    private void actualizarCurso(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int cursoId = Integer.parseInt(request.getParameter("cursoId"));
        int ciclo = Integer.parseInt(request.getParameter("ciclo"));
        int cupoMaximo = Integer.parseInt(request.getParameter("cupoMaximo"));
        int cupoMinimo = Integer.parseInt(request.getParameter("cupoMinimo"));
        String descripcion = request.getParameter("descripcion");
        String codigoCarrera = request.getParameter("codigoCarrera");
        int horarioId = Integer.parseInt(request.getParameter("horarioId"));
        int instructorId = Integer.parseInt(request.getParameter("instructorId"));
        int salonId = Integer.parseInt(request.getParameter("salonId"));
        
        Curso curso = new Curso(cursoId, ciclo, cupoMaximo, cupoMinimo, descripcion, codigoCarrera, horarioId, instructorId, salonId);
        
        int registrosModificados = new CursoDaoImpl().actualizar(curso);
        listarCursos(request, response);
    }
    
    private void insertarCurso(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int ciclo = Integer.parseInt(request.getParameter("ciclo"));
        int cupoMaximo = Integer.parseInt(request.getParameter("cupoMaximo"));
        int cupoMinimo = Integer.parseInt(request.getParameter("cupoMinimo"));
        String descripcion = request.getParameter("descripcion");
        String codigoCarrera = request.getParameter("codigoCarrera");
        int horarioId = Integer.parseInt(request.getParameter("horarioId"));
        int instructorId = Integer.parseInt(request.getParameter("instructorId"));
        int salonId = Integer.parseInt(request.getParameter("salonId"));
        
        Curso curso = new Curso(ciclo, cupoMaximo, cupoMinimo, descripcion, codigoCarrera, horarioId, instructorId, salonId);
        
        int registrosInsertados = new CursoDaoImpl().insertar(curso);
        
        listarCursos(request, response);
    }
    
    private void editarCurso(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        int cursoId = Integer.parseInt(request.getParameter("cursoId"));
        Curso curso = new CursoDaoImpl().encontrar(new Curso(cursoId));
        request.setAttribute("curso", curso);
        request.getRequestDispatcher(JSP_EDITAR).forward(request, response);
    }
    
    private void eliminarCurso(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int cursoId = Integer.parseInt(request.getParameter("cursoId"));
        Curso curso = new Curso(cursoId);
        int registrosEliminados = new CursoDaoImpl().eliminar(curso);
        System.out.println("Cantidad de registros eliminados: "+ registrosEliminados);
        listarCursos(request, response);
    }
    
    private void listarCursos(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        List<Curso> listaCurso = new CursoDaoImpl().listar();
        List<CarreraTecnica> listaCarreraTecnica = new CarreraTecnicaDaolmpl().listar();
        List<Horario> listaHorario = new HorarioDaoImpl().listar();
        List<Instructor> listaInstructor = new InstructorDaolmpl().listar();
        List<Salon> listaSalon = new SalonDaoImpl().listar();
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listadoCurso", listaCurso);
        sesion.setAttribute("listadoCarreraTecnica", listaCarreraTecnica);
        sesion.setAttribute("listadoHorario", listaHorario);
        sesion.setAttribute("listadoInstructor", listaInstructor);
        sesion.setAttribute("listadoSalones", listaSalon);
        response.sendRedirect(JSP_LISTAR);
    }
}

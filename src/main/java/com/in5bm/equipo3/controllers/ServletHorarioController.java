package com.in5bm.equipo3.controllers;

import com.in5bm.equipo3.models.dao.HorarioDaoImpl;
import com.in5bm.equipo3.models.domain.Horario;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.ws.rs.OPTIONS;
import javax.xml.bind.DatatypeConverter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author Brandon Andree Palma Hernandez
 * @date 31/08/2021
 * @time 03:43:34 PM
 */
@WebServlet("/ServletHorarioController")
public class ServletHorarioController extends HttpServlet{
    
    private static final String JSP_LISTAR= "vistas/horario/horario.jsp";
    private static final String JSP_EDITAR= "vistas/horario/editar-horario.jsp";
    
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
        request.setCharacterEncoding("UTF-8");
        
        String accion = request.getParameter("accion");
        
        if (accion != null){
            switch(accion){
                case "listar":
                    listarHorario(request, response);
                    break;
                case "editar":
                    editarHorario(request, response);
                    break;
                case "eliminar":
                    eliminarHorario(request, response);
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
                    insertarHorario(request, response);
                    break;
                case "actualizar":
                    actualizarHorario(request,response);
            }
        }
        
    }
    
    private void actualizarHorario(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String horaf = request.getParameter("horaFinal");
        String horai = request.getParameter("horaInicio");
        System.out.println(horaf);
        System.out.println(horai);
        
        int idHorario = Integer.parseInt(request.getParameter("idHorario"));
        Time horaFinal = Time.valueOf(horaf+":00");
        Time horaInicio = Time.valueOf(horai+":00");

        Horario horario = new Horario(idHorario, horaFinal, horaInicio);
        int registrosModificados = new HorarioDaoImpl().actualizar(horario);
        listarHorario(request, response);
        
    }
    
    private void insertarHorario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        String horaf = request.getParameter("horaFinal");
        String horai = request.getParameter("horaInicio");

        Time horaFinal = Time.valueOf(horaf+":00");
        Time horaInicio = Time.valueOf(horai+":00");
        System.out.println(horaInicio);
        Horario horario = new Horario(horaFinal, horaInicio);
        int registrosInsertados = new HorarioDaoImpl().insertar(horario);
        System.out.println ("Registros insertados: "+registrosInsertados);
        listarHorario(request, response);

    }
    
    private void editarHorario(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        int idHorario = Integer.parseInt(request.getParameter("idHorario"));
        Horario horario = new HorarioDaoImpl().encontrar(new Horario(idHorario));
        request.setAttribute("horario", horario);
        System.out.println(horario);
        request.getRequestDispatcher(JSP_EDITAR).forward(request, response);
        
    }
    
   
    private void eliminarHorario(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int idHorario = Integer.parseInt(request.getParameter("idHorario"));
        Horario horario = new Horario(idHorario);
        int registrosEliminados = new HorarioDaoImpl().eliminar(horario);
        System.out.println("Cantidad de registros eliminados: "+ registrosEliminados);
        listarHorario(request,response);
        
        
    }
    
    private void listarHorario(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        List<Horario> listaHorario = new HorarioDaoImpl().listar();
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listadoHorario", listaHorario);
        response.sendRedirect(JSP_LISTAR);
        
        
    }

}

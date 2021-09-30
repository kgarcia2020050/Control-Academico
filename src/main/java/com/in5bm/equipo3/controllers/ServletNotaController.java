/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.in5bm.equipo3.controllers;

import com.in5bm.equipo3.models.dao.AsignacionAlumnoDaoImpl;
import com.in5bm.equipo3.models.dao.NotaDaoJPA;
import com.in5bm.equipo3.models.domain.AsignacionAlumno;
import com.in5bm.equipo3.models.domain.Nota;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kenneth Gerardo García Lemus
 */
@WebServlet("/ServletNotaController")
public class ServletNotaController extends HttpServlet {

    private static final String JSP_LISTAR = "vistas/nota/nota.jsp";
    private static final String JSP_EDITAR = "vistas/nota/editar-nota.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");

        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "listar":
                    listarNotas(request, response);
                    break;
                case "editar":
                    editarNotas(request, response);
                    break;
                case "eliminar":
                    eliminarNotas(request, response);
                    break;

            }
        }

    }

    private void editarNotas(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int idNota = Integer.parseInt(request.getParameter("idNota"));

        List<AsignacionAlumno> listaAsignacionAlumno = new AsignacionAlumnoDaoImpl().listar();
        Nota nota = new NotaDaoJPA().encontrar(new Nota(idNota));
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listadoAsignacion", listaAsignacionAlumno);
        
        AsignacionAlumno asignacionAlumno = new AsignacionAlumnoDaoImpl().encontrar(new AsignacionAlumno(nota.getAsignacionId()));
        request.setAttribute("notas", nota);
        request.setAttribute("idAsignaciones", asignacionAlumno.getAsignacionId());
        request.getRequestDispatcher(JSP_EDITAR).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "insertar":
                    agregarNotas(request, response);
                    break;
                case "actualizar":
                    actualizarNotas(request, response);
                    break;
            }
        }

    }

    private void actualizarNotas(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idNota = Integer.parseInt(request.getParameter("idNota"));
        String nombreActividad = request.getParameter("nombreActividad");
        String notaString = request.getParameter("notaActividad");
        String fechaString = request.getParameter("fechaEntrega");
        String asignacionId = request.getParameter("asignacionId");
        int notaActividad = 0;
        Date fechaEntrega = null;

        if ((notaString != null) && (!notaString.equals(""))) {
            notaActividad = Integer.parseInt(request.getParameter("notaActividad"));

        }

        if ((fechaString != null) && (!fechaString.equals(""))) {
            fechaEntrega = Date.valueOf(request.getParameter("fechaEntrega"));
        }

        Nota nota = new Nota(idNota, nombreActividad, notaActividad, fechaEntrega, asignacionId);

        int modificaciones = new NotaDaoJPA().actualizar(nota);

        listarNotas(request, response);

    }

    private void agregarNotas(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nombreActividad = request.getParameter("nombreActividad");
        String notaString = request.getParameter("notaActividad");
        String asignacionId = request.getParameter("asignacionId");
        int notaActividad = 0;

        LocalDate fechaActual = LocalDate.now();
        Date fechaEntrega = Date.valueOf(fechaActual);

        if ((notaString != null) && (!notaString.equals(""))) {
            notaActividad = Integer.parseInt(request.getParameter("notaActividad"));

        }

        Nota nota = new Nota(nombreActividad, notaActividad, fechaEntrega, asignacionId);

        int inserciones = new NotaDaoJPA().insertar(nota);

        listarNotas(request, response);

    }

    private void eliminarNotas(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idNota = Integer.parseInt(request.getParameter("idNota"));

        Nota nota = new NotaDaoJPA().encontrar(new Nota(idNota));
        int registrosEliminados = new NotaDaoJPA().eliminar(nota);
        listarNotas(request, response);

    }

    private void listarNotas(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Nota> listaNotas = new NotaDaoJPA().listar();

        List<AsignacionAlumno> listaAsignacionAlumno = new AsignacionAlumnoDaoImpl().listar();

        HttpSession sesion = request.getSession();
        sesion.setAttribute("listadoNota", listaNotas);
        sesion.setAttribute("listadoAsignacion", listaAsignacionAlumno);
        sesion.setAttribute("notasGanadas", notasGanadas());
        sesion.setAttribute("notasPerdidas", notasPerdidas());
        sesion.setAttribute("promedioNotas", promedio());
        response.sendRedirect(JSP_LISTAR);

    }

    private int notasGanadas() {
        int ganadas = 0;
        List<Nota> listaNotas = new NotaDaoJPA().listar();
        for (Nota notas : listaNotas) {
            if ((notas.getNotaActividad() >= 70)) {
                ganadas++;
            }
        }
        return ganadas;
    }

    private int notasPerdidas() {
        int perdidas = 0;
        List<Nota> listaNotas = new NotaDaoJPA().listar();
        for (Nota notas : listaNotas) {
            if ((notas.getNotaActividad() <= 69)) {
                perdidas++;
            }
        }
        return perdidas;
    }

    private double promedio() {
        double suma = 0;
        double promedio = 0;
        List<Nota> listaNotas = new NotaDaoJPA().listar();
        for (Nota notas : listaNotas) {
            suma = suma + notas.getNotaActividad();
            promedio = suma / listaNotas.size();
            promedio = Math.round(promedio * 100d) / 100d;
        }
        return promedio;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.in5bm.equipo3.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import com.in5bm.equipo3.models.domain.Alumno;
import com.in5bm.equipo3.models.dao.AlumnoDaoImpl;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author garci
 * @date 31/08/2021
 * @time 07:12:03 PM
 */
@WebServlet("/ServletAlumnoController")
public class ServletAlumnoController extends HttpServlet {

    private static final String JSP_LISTAR = "vistas/alumno/alumno.jsp";
    private static final String JSP_EDITAR = "vistas/alumno/editar-alumnos.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "listar":
                    listarAlumnos(request, response);
                    break;
                case "editar":
                    editarAlumno(request, response);
                    break;
                case "eliminar":
                    eliminarAlumnos(request, response);
                    break;

            }
        }

    }

    private void editarAlumno(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String carne = request.getParameter("carne");

        Alumno alumno = new AlumnoDaoImpl().encontrar(new Alumno(carne));

        request.setAttribute("alumno", alumno);

        System.out.println(alumno);

        request.getRequestDispatcher(JSP_EDITAR).forward(request, response);
    }

    private void listarAlumnos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Alumno> listaAlumno = new AlumnoDaoImpl().listar();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listadoAlumno", listaAlumno);

        response.sendRedirect(JSP_LISTAR);

    }

    private void eliminarAlumnos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String carne = request.getParameter("carne");
        Alumno asignacionAlumno = new Alumno(carne);
        int registrosEliminados = new AlumnoDaoImpl().eliminar(asignacionAlumno);
        listarAlumnos(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");

        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarAlumno(request, response);
                    break;
                      case"actualizar":
                    actualizarAlumno(request, response);
                    break;
            }
        }

    }

    private void insertarAlumno(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String carne = request.getParameter("carne");
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String email = request.getParameter("email");

        Alumno alumno = new Alumno(carne, apellidos, nombres, email);
        System.out.println(alumno);

        int registrosInsertados = new AlumnoDaoImpl().insertar(alumno);
        System.out.println("Registros Insertdos:" + registrosInsertados);

        listarAlumnos(request, response);

    }

    private void actualizarAlumno(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String carne =request.getParameter("carne");
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String email = request.getParameter("email");

        Alumno alumno = new Alumno(carne, apellidos, nombres, email);

        int registrosActualizados = new AlumnoDaoImpl().actualizar(alumno);

        listarAlumnos(request, response);

    }

}

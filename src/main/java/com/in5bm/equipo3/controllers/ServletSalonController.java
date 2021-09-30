/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.in5bm.equipo3.controllers;

import com.in5bm.equipo3.models.dao.SalonDaoImpl;
import com.in5bm.equipo3.models.domain.Salon;
import java.io.IOException;
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
@WebServlet("/ServletSalonController")
public class ServletSalonController extends HttpServlet {

    private static final String JSP_LISTAR = "vistas/salon/salon.jsp";
    private static final String RUTA_EDICION = "vistas/salon/editar_salon.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");

        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "listar":
                    listarSalones(request, response);
                    break;
                case "editar":
                    editarSalon(request, response);
                    break;
                case "eliminar":
                    eliminarSalon(request, response);
                    break;

            }
        }
    }

    private void listarSalones(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<Salon> listaSalon = new SalonDaoImpl().listar();

        HttpSession sesion = request.getSession();
        sesion.setAttribute("listadoSalones", listaSalon);
        sesion.setAttribute("totalSalones", listaSalon.size());

        response.sendRedirect(JSP_LISTAR);

    }

    private void editarSalon(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int salonId = Integer.parseInt(request.getParameter("salonId"));

        Salon salon = new SalonDaoImpl().encontrar(new Salon(salonId));

        request.setAttribute("salon", salon);

        request.getRequestDispatcher(RUTA_EDICION).forward(request, response);
    }

    private void actualizarSalon(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int salonId = Integer.parseInt(request.getParameter("salonId"));

        int capacidad = Integer.parseInt(request.getParameter("capacidad"));

        String descripcion = request.getParameter("descripcion");

        String nombreSalon = request.getParameter("nombreSalon");

        Salon salon = new Salon(salonId, capacidad, descripcion, nombreSalon);

        int registrosModificados = new SalonDaoImpl().actualizar(salon);

        listarSalones(request, response);
    }

    private void insertarSalon(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int capacidad = Integer.parseInt(request.getParameter("capacidad"));
        String descripcion = request.getParameter("descripcion");
        String nombreSalon = request.getParameter("nombreSalon");
        

        Salon salon = new Salon(capacidad, descripcion, nombreSalon);

        int registrosInsertados = new SalonDaoImpl().insertar(salon);
        System.out.println("registros insertados "+registrosInsertados);
        System.out.println(salon);
        listarSalones(request, response);
    }

    private void eliminarSalon(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int salonId = Integer.parseInt(request.getParameter("salonId"));

        Salon salon = new Salon(salonId);

        int registrosEliminados = new SalonDaoImpl().eliminar(salon);
        System.out.println("Cantidad de registros eliminados: " + registrosEliminados);

        listarSalones(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarSalon(request, response);
                    break;
                case "actualizar":
                    actualizarSalon(request, response);
                    break;
            }
        }
    }
}

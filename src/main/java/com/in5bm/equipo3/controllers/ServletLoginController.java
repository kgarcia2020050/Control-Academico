/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.in5bm.equipo3.controllers;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import com.in5bm.equipo3.models.dao.LoginDaoImpl;
import com.in5bm.equipo3.models.domain.Login;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;

/**
 *
 * @author Brandon Andree Palma Hernandez
 * @date 16/09/2021
 * @time 08:31:08 AM
 */
@WebServlet("/ServletLoginController")
public class ServletLoginController extends HttpServlet {

    private static final String JSP_INICIO = "inicio.jsp";
    private static final String JSP_LOGIN = "login_1.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {

            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "validar":
                    validarLogin(request, response);
                    break;
            }
        }

    }

    private void validarLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String pass64 = Base64.getEncoder().encodeToString(pass.getBytes());
        List<Login> listaLogin = new LoginDaoImpl().listar();

        for (int i = 0; i < listaLogin.size(); i++) {
            if (user.equals(listaLogin.get(i).getUser()) && pass64.equals(listaLogin.get(i).getPass())) {
                request.getRequestDispatcher(JSP_INICIO).forward(request, response);
            }
        }
        for (int i = 0; i < listaLogin.size(); i++) {
            if (!user.equals(listaLogin.get(i).getUser()) || !pass64.equals(listaLogin.get(i).getPass())) {
                request.getRequestDispatcher(JSP_LOGIN).forward(request, response);
            }
        }
        

    }

}

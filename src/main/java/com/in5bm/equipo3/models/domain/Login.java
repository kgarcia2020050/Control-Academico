/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.in5bm.equipo3.models.domain;

/**
 * 
 * @author Brandon Andree Palma Hernandez
 * @date 16/09/2021
 * @time 08:13:36 AM
 */
public class Login {
    
    private String user;
    private String pass;
    private String nombre;

    public Login() {
    }

    public Login(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public Login(String user, String pass, String nombre) {
        this.user = user;
        this.pass = pass;
        this.nombre = nombre;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Login{" + "user=" + user + ", pass=" + pass + ", nombre=" + nombre + '}';
    }
    
    

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.in5bm.equipo3.models.domain;

/**
 *
 * @author garci
 * @date 31/08/2021
 * @time 06:54:46 PM
 */
public class Alumno {

    private String carne;
    private String apellidos;
    private String nombres;
    private String email;

    public Alumno() {
        
        
    }

    public Alumno(String carne) {
        this.carne = carne;
    }

    public Alumno(String apellidos, String nombres, String email) {
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.email = email;
    }
    

    public Alumno(String carne, String apellidos, String nombres, String email) {
        this.carne = carne;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.email = email;
    }

    public String getCarne() {
        return carne;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Alumno{" + "carne=" + carne + ", nombres=" + nombres + ", apellidos=" + apellidos + ", email=" + email + '}';
    }
    
}

package com.in5bm.equipo3.models.domain;

/**
 * 
 * @author Juan Diego Solís Martínez
 * @date 28/08/2021
 * @time 10:02:11 AM
 *
 */
public class CarreraTecnica {
    private String codigoCarrera;
    private String nombre;

    public CarreraTecnica() {
    }

    public CarreraTecnica(String codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }
    
    public CarreraTecnica(String codigoCarrera, String nombre) {
        this.codigoCarrera = codigoCarrera;
        this.nombre = nombre;
    }

    public String getCodigoCarrera() {
        return codigoCarrera;
    }

    public void setCodigoCarrera(String codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "CarreraTecnica{" + "codigoCarrera=" + codigoCarrera + ", nombre=" + nombre + '}';
    }
}

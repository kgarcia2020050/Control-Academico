/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.in5bm.equipo3.models.domain;

/**
 *
 * @author Kenneth Gerardo García Lemus
 */
public class Salon {
    private int salonId;
    private int capacidad;
    private String descripcion;
    private String nombreSalon;

    public Salon() {
    }

    public Salon(int salonId) {
        this.salonId = salonId;
    }

    public Salon(int capacidad, String descripcion, String nombreSalon) {
        this.capacidad = capacidad;
        this.descripcion = descripcion;
        this.nombreSalon = nombreSalon;
    }

    public Salon(int salonId, int capacidad, String descripcion, String nombreSalon) {
        this.salonId = salonId;
        this.capacidad = capacidad;
        this.descripcion = descripcion;
        this.nombreSalon = nombreSalon;
    }

   

    public int getSalonId() {
        return salonId;
    }

    public void setSalonId(int salonId) {
        this.salonId = salonId;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreSalon() {
        return nombreSalon;
    }

    public void setNombreSalon(String nombreSalon) {
        this.nombreSalon = nombreSalon;
    }

    @Override
    public String toString() {
        return "Salon{" + "salonId=" + salonId + ", capacidad=" + capacidad + ", descripcion=" + descripcion + ", nombreSalon=" + nombreSalon + '}';
    }

}

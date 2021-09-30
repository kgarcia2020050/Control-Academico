/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.in5bm.equipo3.models.domain;

import java.sql.Time;

/**
 * 
 * @author Juan Diego Solís Martínez
 * @date 28/08/2021
 * @time 10:02:11 AM
 *
 */
public class Curso {
    private int cursoId;
    private int ciclo;
    private int cupoMaximo;
    private int cupoMinimo;
    private String descripcion;
    private String codigoCarrera;
    private String nombre;
    private int horarioId;
    private Time horaFinal;
    private Time horaInicio;
    private int instructorId;
    private String nombres;
    private int salonId;
    private String descripcionSalon;

    public Curso() {
    }

    public Curso(int cursoId) {
        this.cursoId = cursoId;
    }

    public Curso(int ciclo, int cupoMaximo, int cupoMinimo, String descripcion, String codigoCarrera, int horarioId, int instructorId, int salonId) {
        this.ciclo = ciclo;
        this.cupoMaximo = cupoMaximo;
        this.cupoMinimo = cupoMinimo;
        this.descripcion = descripcion;
        this.codigoCarrera = codigoCarrera;
        this.horarioId = horarioId;
        this.instructorId = instructorId;
        this.salonId = salonId;
    }

    public Curso(int cursoId, int ciclo, int cupoMaximo, int cupoMinimo, String descripcion, String codigoCarrera, int horarioId, int instructorId, int salonId) {
        this.cursoId = cursoId;
        this.ciclo = ciclo;
        this.cupoMaximo = cupoMaximo;
        this.cupoMinimo = cupoMinimo;
        this.descripcion = descripcion;
        this.codigoCarrera = codigoCarrera;
        this.horarioId = horarioId;
        this.instructorId = instructorId;
        this.salonId = salonId;
    }

    public Curso(int cursoId, int ciclo, int cupoMaximo, int cupoMinimo, String descripcion, String codigoCarrera, String nombre, int horarioId, Time horaFinal, Time horaInicio, int instructorId, String nombres, int salonId, String descripcionSalon) {
        this.cursoId = cursoId;
        this.ciclo = ciclo;
        this.cupoMaximo = cupoMaximo;
        this.cupoMinimo = cupoMinimo;
        this.descripcion = descripcion;
        this.codigoCarrera = codigoCarrera;
        this.nombre = nombre;
        this.horarioId = horarioId;
        this.horaFinal = horaFinal;
        this.horaInicio = horaInicio;
        this.instructorId = instructorId;
        this.nombres = nombres;
        this.salonId = salonId;
        this.descripcionSalon = descripcionSalon;
    }

    public int getCursoId() {
        return cursoId;
    }

    public void setCursoId(int cursoId) {
        this.cursoId = cursoId;
    }

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    public int getCupoMinimo() {
        return cupoMinimo;
    }

    public void setCupoMinimo(int cupoMinimo) {
        this.cupoMinimo = cupoMinimo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public int getHorarioId() {
        return horarioId;
    }

    public void setHorarioId(int horarioId) {
        this.horarioId = horarioId;
    }

    public Time getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Time horaFinal) {
        this.horaFinal = horaFinal;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getSalonId() {
        return salonId;
    }

    public void setSalonId(int salonId) {
        this.salonId = salonId;
    }

    public String getDescripcionSalon() {
        return descripcionSalon;
    }

    public void setDescripcionSalon(String descripcionSalon) {
        this.descripcionSalon = descripcionSalon;
    }
    
    

    @Override
    public String toString() {
        return "Curso{" + "cursoId=" + cursoId + ", ciclo=" + ciclo + ", cupoMaximo=" + cupoMaximo + ", cupoMinimo=" + cupoMinimo + ", descripcion=" + descripcion + ", codigoCarrera=" + codigoCarrera + ", horarioId=" + horarioId + ", instructorId=" + instructorId + ", salonId=" + salonId + '}';
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.in5bm.equipo3.models.domain;
import java.sql.Time;

/**
 * 
 * @author Brandon Andree Palma Hernandez
 * @date 31/08/2021
 * @time 04:12:32 PM
 */
public class Horario {
    
    private int idHorario;
    private Time horaFinal;
    private Time horaInicio;

    public Horario() {
    }

    public Horario(int idHorario) {
        this.idHorario = idHorario;
    }

    public Horario(int idHorario, Time horaFinal, Time horaInicio) {
        this.idHorario = idHorario;
        this.horaFinal = horaFinal;
        this.horaInicio = horaInicio;
    }

    public Horario(Time horaFinal, Time horaInicio) {
        this.horaFinal = horaFinal;
        this.horaInicio = horaInicio;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public Time getHoraFinal() {
        return horaFinal;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public void setHoraFinal(Time horaFinal) {
        this.horaFinal = horaFinal;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    @Override
    public String toString() {
        return "Horario{" + "idHorario=" + idHorario + ", horaFinal=" + horaFinal + ", horaInicio=" + horaInicio + '}';
    }
}

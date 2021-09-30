/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.in5bm.equipo3.models.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.sql.Date;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Kenneth Gerardo García Lemus
 */
@Entity
@Table(name = "nota")
@NamedQueries({
    @NamedQuery(
            name = "Nota.findAll",
            query = "from Nota"
    ),
    @NamedQuery(
            name = "Nota.find",
            query = "from Nota WHERE id_nota = :id"
    )
})
public class Nota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_nota")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNota;
    
    @Column(name = "nombre_actividad")
    private String nombreActividad;
    
    @Column(name = "nota_actividad")
    private int notaActividad;
    
    @Column(name="fecha_entrega")
    private Date fechaEntrega;
    
    @Column(name="asignacion_id")
    private String asignacionId;

    public Nota() {
    }

    public Nota(int idNota) {
        this.idNota = idNota;
    }

    public Nota(String nombreActividad, int notaActividad, Date fechaEntrega, String asignacionId) {
        this.nombreActividad = nombreActividad;
        this.notaActividad = notaActividad;
        this.fechaEntrega = fechaEntrega;
        this.asignacionId = asignacionId;
    }

    public Nota(int idNota, String nombreActividad, int notaActividad, Date fechaEntrega, String asignacionId) {
        this.idNota = idNota;
        this.nombreActividad = nombreActividad;
        this.notaActividad = notaActividad;
        this.fechaEntrega = fechaEntrega;
        this.asignacionId = asignacionId;
    }

    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public int getNotaActividad() {
        return notaActividad;
    }

    public void setNotaActividad(int notaActividad) {
        this.notaActividad = notaActividad;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getAsignacionId() {
        return asignacionId;
    }

    public void setAsignacionId(String asignacionId) {
        this.asignacionId = asignacionId;
    }

    @Override
    public String toString() {
        return "Nota{" + "idNota=" + idNota + ", nombreActividad=" + nombreActividad + ", notaActividad=" + notaActividad + ", fechaEntrega=" + fechaEntrega + ", asignacionId=" + asignacionId + '}';
    }
    
    


}

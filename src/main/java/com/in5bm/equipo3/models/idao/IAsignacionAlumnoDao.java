/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.in5bm.equipo3.models.idao;

import com.in5bm.equipo3.models.domain.*;
import java.util.List;

/**
 *
 * @author Brandon Andree Palma Hernandez
 */
public interface IAsignacionAlumnoDao {
    
    public List<AsignacionAlumno> listar();
    public AsignacionAlumno encontrar(AsignacionAlumno asignacionAlumno);
    public int insertar(AsignacionAlumno asignacionAlumno);
    public int actualizar(AsignacionAlumno asignacionAlumno);
    public int eliminar(AsignacionAlumno asignacionAlumno);
    
}

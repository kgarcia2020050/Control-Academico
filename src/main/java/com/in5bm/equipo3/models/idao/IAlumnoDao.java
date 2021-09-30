/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.in5bm.equipo3.models.idao;

import com.in5bm.equipo3.models.domain.Alumno;
import java.util.List;

/**
 *
 * @author garci
 */
public interface IAlumnoDao {
    public List<Alumno> listar();
    public Alumno encontrar(Alumno alumno);
    public int insertar(Alumno alumno);
    public int actualizar(Alumno alumno);
    public int eliminar(Alumno alumno);
}

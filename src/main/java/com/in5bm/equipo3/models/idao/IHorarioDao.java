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
public interface IHorarioDao {
    
    public List<Horario> listar();
    public Horario encontrar(Horario horario);
    public int insertar(Horario horario);
    public int actualizar(Horario horario);
    public int eliminar(Horario horario);
    
}

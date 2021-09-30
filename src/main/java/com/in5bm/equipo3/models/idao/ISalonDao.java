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
public interface ISalonDao {
    
    public List<Salon> listar();
    public Salon encontrar(Salon salon);
    public int insertar(Salon salon);
    public int actualizar(Salon salon);
    public int eliminar(Salon salon);
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.in5bm.equipo3.db;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Kenneth Gerardo García Lemus
 */
public class ConexionPU {

    private static final String UNIDAD_PERSISTENCIA = "ControlAcademicoPU";
    private EntityManager entityManager;
    private static ConexionPU instancia;

    private ConexionPU() {
        try {
            entityManager = Persistence.createEntityManagerFactory(UNIDAD_PERSISTENCIA).createEntityManager();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public static ConexionPU getInstance() {
        if (instancia == null) {
            instancia = new ConexionPU();
        }
        return instancia;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

}

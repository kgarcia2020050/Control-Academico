/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.in5bm.equipo3.models.dao;

import com.in5bm.equipo3.db.ConexionPU;
import com.in5bm.equipo3.models.domain.Nota;
import com.in5bm.equipo3.models.idao.INotaDao;
import java.util.List;

/**
 *
 * @author Kenneth Gerardo García Lemus
 */
public class NotaDaoJPA implements INotaDao {

    private ConexionPU conn = ConexionPU.getInstance();

    @Override
    public List<Nota> listar() {
        return conn.getEntityManager().createNamedQuery("Nota.findAll").getResultList();
    }

    @Override
    public Nota encontrar(Nota nota) {
        nota=(Nota)conn.getEntityManager().createNamedQuery("Nota.find").setParameter("id", nota.getIdNota()).getSingleResult();
        return nota;
    }

    @Override
    public int insertar(Nota nota) {
        int rows = 0;
        try {
            conn.getEntityManager().getTransaction().begin();
            conn.getEntityManager().persist(nota);
            conn.getEntityManager().getTransaction().commit();
            rows = 1;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            conn.getEntityManager().getTransaction().rollback();
        }
        return rows;
    }

    @Override
    public int actualizar(Nota nota) {
        int rows = 0;
        try {
            conn.getEntityManager().getTransaction().begin();
            conn.getEntityManager().merge(nota);
            conn.getEntityManager().getTransaction().commit();
            rows=1;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            conn.getEntityManager().getTransaction().rollback();
        }
        return rows;
    }

    @Override
    public int eliminar(Nota nota) {
        int rows = 0;
        try {
            conn.getEntityManager().getTransaction().begin();
            conn.getEntityManager().remove(nota);
            conn.getEntityManager().getTransaction().commit();
            rows = 1;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            conn.getEntityManager().getTransaction().rollback();
        }
        return rows;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.in5bm.equipo3.models.dao;

import com.in5bm.equipo3.models.domain.Salon;
import com.in5bm.equipo3.db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.in5bm.equipo3.models.idao.ISalonDao;

/**
 *
 * @author Kenneth Gerardo García Lemus
 */
public class SalonDaoImpl implements ISalonDao {

    private static final String SQL_SELECT = "SELECT * FROM salon";
    private static final String SQL_DELETE = "DELETE FROM salon WHERE salon_id=?";
    private static final String SQL_INSERT = "INSERT INTO salon (capacidad,descripcion,nombre_salon) VALUES (?,?,?)";
    private static final String SQL_EDITAR = "UPDATE salon set capacidad=?,descripcion=?,nombre_salon=? WHERE salon_id=?";
    private static final String SQL_BUSQUEDA = "SELECT * FROM salon WHERE salon_id=?";

    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    private Salon salon = null;

    List<Salon> listaSalones = new ArrayList<>();

    @Override
    public List<Salon> listar() {
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int salonId = rs.getInt("salon_id");
                int capacidad = rs.getInt("capacidad");
                String descripcion = rs.getString("descripcion");
                String nombreSalon = rs.getString("nombre_salon");
                salon = new Salon(salonId, capacidad, descripcion, nombreSalon);
                listaSalones.add(salon);
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return listaSalones;
    }

    @Override
    public Salon encontrar(Salon salon) {
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_BUSQUEDA);
            pstmt.setInt(1, salon.getSalonId());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int capacidad = rs.getInt("capacidad");
                String descripcion = rs.getString("descripcion");
                String nombreSalon = rs.getString("nombre_salon");

                salon.setCapacidad(capacidad);
                salon.setDescripcion(descripcion);
                salon.setNombreSalon(nombreSalon);

            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return salon;
    }

    @Override
    public int actualizar(Salon salon) {
        int variable = 0;

        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareCall(SQL_EDITAR);
            pstmt.setInt(1, salon.getCapacidad());
            pstmt.setString(2, salon.getDescripcion());
            pstmt.setString(3, salon.getNombreSalon());
            pstmt.setInt(4, salon.getSalonId());

            variable = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return variable;
    }

    @Override
    public int insertar(Salon salon) {

        int rows = 0;

        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareCall(SQL_INSERT);
            pstmt.setInt(1, salon.getCapacidad());
            pstmt.setString(2, salon.getDescripcion());
            pstmt.setString(3, salon.getNombreSalon());

            rows = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return rows;

    }

    @Override
    public int eliminar(Salon salon) {
        int variable = 0;
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, salon.getSalonId());
            System.out.println(pstmt.toString());
            variable = pstmt.executeUpdate();
        } catch (SQLException e) {
            if (e.getErrorCode() == 1451) {
                System.out.println("El salon a eliminar puede estar asignado a un curso."
                        + "\nElimine el curso seleccionado ");
            }
        } finally {
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return variable;
    }

}

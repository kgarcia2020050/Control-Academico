package com.in5bm.equipo3.models.dao;

import com.in5bm.equipo3.db.Conexion;
import com.in5bm.equipo3.models.domain.CarreraTecnica;
import com.in5bm.equipo3.models.idao.ICarreraTecnicaDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan Diego Solís Martínez
 * @date 28/08/2021
 * @time 10:02:11 AM
 *
 */
public class CarreraTecnicaDaolmpl implements ICarreraTecnicaDao {

    private static final String SQL_SELECT = "SELECT codigo_carrera, nombre FROM carrera_tecnica";
    private static final String SQL_DELETE = "DELETE FROM carrera_tecnica WHERE codigo_carrera = ?";
    private static final String SQL_INSERT = "INSERT INTO carrera_tecnica (codigo_carrera, nombre) values (?, ?)";
    private static final String SQL_UPDATE = "UPDATE carrera_tecnica SET nombre = ? WHERE codigo_carrera = ?";
    private static final String SQL_SELECT_BY_ID = "SELECT codigo_carrera, nombre FROM carrera_tecnica WHERE codigo_carrera = ?";
    
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private CarreraTecnica carreraTecnica = null;
    private List<CarreraTecnica> listaCarrerasTecnicas = new ArrayList<>();

    @Override
    public List<CarreraTecnica> listar() {
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String codigoCarrera = rs.getString("codigo_carrera");
                String nombre = rs.getString("nombre");

                carreraTecnica = new CarreraTecnica(codigoCarrera, nombre);
                listaCarrerasTecnicas.add(carreraTecnica);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return listaCarrerasTecnicas;
    }

    @Override
    public CarreraTecnica encontrar(CarreraTecnica carreraTecnica) {
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setString(1, carreraTecnica.getCodigoCarrera());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                
                carreraTecnica.setNombre(nombre);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return carreraTecnica;
    }

    @Override
    public int insertar(CarreraTecnica carreraTecnica) {
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_INSERT);
            pstmt.setString(1, carreraTecnica.getCodigoCarrera());
            pstmt.setString(2, carreraTecnica.getNombre());
            System.out.println(pstmt.toString());

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
    public int actualizar(CarreraTecnica carreraTecnica) {
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_UPDATE);
            pstmt.setString(1, carreraTecnica.getNombre());
            pstmt.setString(2, carreraTecnica.getCodigoCarrera());
            System.out.println(pstmt.toString());

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
    public int eliminar(CarreraTecnica carreraTecnica) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_DELETE);
            pstmt.setString(1, carreraTecnica.getCodigoCarrera());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            if (e.getErrorCode() == 1451) {
                System.out.println("La carrera a eliminar puede estar asignada a un curso.");
                System.out.println("Primero elimine el curso.");
            }
        } finally {
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return rows;
    }
}

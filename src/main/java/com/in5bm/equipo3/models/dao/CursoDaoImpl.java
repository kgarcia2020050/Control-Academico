/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.in5bm.equipo3.models.dao;

import com.in5bm.equipo3.db.Conexion;
import com.in5bm.equipo3.models.domain.Curso;
import com.in5bm.equipo3.models.idao.ICursoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan Diego Solís Martínez
 * @date 28/08/2021
 * @time 10:10:24 AM
 *
 */
public class CursoDaoImpl implements ICursoDao {

    private static final String SQL_SELECT = "SELECT curso.curso_id, curso.ciclo, curso.cupo_maximo, curso.cupo_minimo, curso.descripcion, carrera_tecnica.codigo_carrera, "
            + "carrera_tecnica.nombre, horario.horario_id, horario.horario_final, horario.horario_inicio, instructor.instructor_id, instructor.nombres, salon.salon_id, "
            + "salon.descripcion FROM curso INNER JOIN carrera_tecnica ON curso.codigo_carrera = carrera_tecnica.codigo_carrera INNER JOIN horario "
            + "ON curso.horario_id = horario.horario_id INNER JOIN instructor ON curso.instructor_id = instructor.instructor_id INNER JOIN salon "
            + "ON curso.salon_id = salon.salon_id;";
    private static final String SQL_DELETE = "DELETE FROM curso WHERE curso_id = ?";
    private static final String SQL_INSERT = "INSERT INTO curso (ciclo, cupo_maximo, cupo_minimo, descripcion, codigo_carrera, horario_id, instructor_id, salon_id) values (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_SELECT_BY_ID = "SELECT curso_id, ciclo, cupo_maximo, cupo_minimo, descripcion, codigo_carrera, horario_id, instructor_id, salon_id FROM curso WHERE curso_id = ?";
    private static final String SQL_UPDATE = "UPDATE curso SET ciclo = ?, cupo_maximo = ?, cupo_minimo = ?, descripcion = ?, codigo_carrera = ?, horario_id = ?, instructor_id = ?, salon_id = ? WHERE curso_id = ?";
    
    
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private Curso curso = null;
    private List<Curso> listaCursos = new ArrayList<>();

    @Override
    public List<Curso> listar() {
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int cursoId = rs.getInt("curso_id");
                int ciclo = rs.getInt("ciclo");
                int cupoMaximo = rs.getInt("cupo_maximo");
                int cupoMinimo = rs.getInt("cupo_minimo");
                String descripcion = rs.getString("descripcion");
                String codigoCarrera = rs.getString("codigo_carrera");
                String nombre = rs.getString("nombre");
                int horarioId = rs.getInt("horario_id");
                Time horaFinal = rs.getTime("horario_final");
                Time horaInicio = rs.getTime("horario_inicio");
                int instructorId = rs.getInt("instructor_id");
                String nombres = rs.getString("nombres");
                int salonId = rs.getInt("salon_id");
                String descripcionSalon = rs.getString("salon.descripcion");

                curso = new Curso(cursoId, ciclo, cupoMaximo, cupoMinimo, descripcion, codigoCarrera, nombre, horarioId, horaFinal, horaInicio, instructorId, nombres, salonId, descripcionSalon);
                listaCursos.add(curso);
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
        return listaCursos;
    }

    @Override
    public Curso encontrar(Curso curso) {
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setInt(1, curso.getCursoId());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int ciclo = rs.getInt("ciclo");
                int cupoMaximo = rs.getInt("cupo_maximo");
                int cupoMinimo = rs.getInt("cupo_minimo");
                String descripcion = rs.getString("descripcion");
                String codigoCarrera = rs.getString("codigo_carrera");
                int horarioId = rs.getInt("horario_id");
                int instructorId = rs.getInt("instructor_id");
                int salonId = rs.getInt("salon_id");

                curso.setCiclo(ciclo);
                curso.setCupoMaximo(cupoMaximo);
                curso.setCupoMinimo(cupoMinimo);
                curso.setDescripcion(descripcion);
                curso.setCodigoCarrera(codigoCarrera);
                curso.setHorarioId(horarioId);
                curso.setInstructorId(instructorId);
                curso.setSalonId(salonId);
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
        return curso;
    }

    @Override
    public int insertar(Curso curso) {
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_INSERT);
            pstmt.setInt(1, curso.getCiclo());
            pstmt.setInt(2, curso.getCupoMaximo());
            pstmt.setInt(3, curso.getCupoMinimo());
            pstmt.setString(4, curso.getDescripcion());
            pstmt.setString(5, curso.getCodigoCarrera());
            pstmt.setInt(6, curso.getHorarioId());
            pstmt.setInt(7, curso.getInstructorId());
            pstmt.setInt(8, curso.getSalonId());
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
    public int actualizar(Curso curso) {
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_UPDATE);
            pstmt.setInt(1, curso.getCiclo());
            pstmt.setInt(2, curso.getCupoMaximo());
            pstmt.setInt(3, curso.getCupoMinimo());
            pstmt.setString(4, curso.getDescripcion());
            pstmt.setString(5, curso.getCodigoCarrera());
            pstmt.setInt(6, curso.getHorarioId());
            pstmt.setInt(7, curso.getInstructorId());
            pstmt.setInt(8, curso.getSalonId());
            pstmt.setInt(9, curso.getCursoId());
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
    public int eliminar(Curso curso) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, curso.getCursoId());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return rows;
    }
}

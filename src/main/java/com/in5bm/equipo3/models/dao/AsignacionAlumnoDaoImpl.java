/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.in5bm.equipo3.models.dao;

import com.in5bm.equipo3.db.Conexion;
import com.in5bm.equipo3.models.domain.AsignacionAlumno;
import com.in5bm.equipo3.models.idao.IAsignacionAlumnoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Josdvin Alexander Macario Barán
 * @date 30/08/2021
 * @time 04:57:50 PM
 */
public class AsignacionAlumnoDaoImpl implements IAsignacionAlumnoDao{
    
    private static String SQL_SELECT="select asignacion_alumno.asignacion_id, asignacion_alumno.fecha_asignacion, asignacion_alumno.carne, concat (alumno.nombres,' ',alumno.apellidos) as Nombre_Completo, alumno.email, asignacion_alumno.curso_id, curso.ciclo, curso.cupo_maximo, curso.cupo_minimo from asignacion_alumno inner join alumno on asignacion_alumno.carne=alumno.carne inner join curso on asignacion_alumno.curso_id=curso.curso_id;";
    private static String SQL_DELETE="DELETE FROM asignacion_alumno WHERE asignacion_id = ?";
    private static String SQL_INSERT="insert into asignacion_alumno(asignacion_id, fecha_asignacion, carne, curso_id) values(?, ?, ?, ?)";
    private static String SQL_SELECT_BY_ID="select asignacion_id, fecha_asignacion, carne, curso_id from asignacion_alumno where asignacion_id=?";
    private static String SQL_UPDATE="update asignacion_alumno set fecha_asignacion=?, carne=?, curso_id=? where asignacion_id=?";
    private Connection conn=null;
    private PreparedStatement pstmt=null;
    private ResultSet rs=null;
    private AsignacionAlumno asignacionAlumno=null;
    List <AsignacionAlumno> listaAsignacionAlumno = new ArrayList<>();
    
    @Override
    public List<AsignacionAlumno> listar() {
        try{
            conn=Conexion.getConnection();
            pstmt=conn.prepareStatement(SQL_SELECT);
            rs=pstmt.executeQuery();
            while(rs.next()){
                String asignacionId=rs.getString("asignacion_alumno.asignacion_id");
                Timestamp fechaAsignacion=rs.getTimestamp("asignacion_alumno.fecha_asignacion");
                String carne=rs.getString("asignacion_alumno.carne");
                String nombreCompleto=rs.getString("Nombre_Completo");
                String email=rs.getString("alumno.email");
                int cursoId=rs.getInt("asignacion_alumno.curso_id");
                int ciclo=rs.getInt("curso.ciclo");
                int cupoMaximo=rs.getInt("curso.cupo_maximo");
                int cupoMinimo=rs.getInt("curso.cupo_minimo");
               
                asignacionAlumno=new AsignacionAlumno(asignacionId, fechaAsignacion, carne, nombreCompleto, email, cursoId, ciclo, cupoMaximo, cupoMinimo);
                listaAsignacionAlumno.add(asignacionAlumno);
            }
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }catch(Exception e){
            e.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return listaAsignacionAlumno;
    }

    @Override
    public AsignacionAlumno encontrar(AsignacionAlumno asignacionAlumno) {
        try{
            conn=Conexion.getConnection();
            pstmt=conn.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setString(1, asignacionAlumno.getAsignacionId());
            rs=pstmt.executeQuery();
            while(rs.next()){
                Timestamp fechaAsignacion=rs.getTimestamp("fecha_asignacion");
                String carne=rs.getString("carne");
                int cursoId=rs.getInt("curso_id");
                
                asignacionAlumno.setFechaAsignacion(fechaAsignacion);
                asignacionAlumno.setCarne(carne);
                asignacionAlumno.setCursoId(cursoId);
            }
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return asignacionAlumno;
    }

    @Override
    public int insertar(AsignacionAlumno asignacionAlumno) {
        int rows=0;
        try{
            conn=Conexion.getConnection();
            pstmt=conn.prepareStatement(SQL_INSERT);
            pstmt.setString(1, asignacionAlumno.getAsignacionId());
            pstmt.setTimestamp(2, asignacionAlumno.getFechaAsignacion());
            pstmt.setString(3, asignacionAlumno.getCarne());
            pstmt.setInt(4, asignacionAlumno.getCursoId());
            rows=pstmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }catch(Exception e){
            e.printStackTrace(System.out);
        }finally{
            Conexion.close(pstmt);
            Conexion.close(conn);
            
        }
        return rows;
    }

    @Override
    public int actualizar(AsignacionAlumno asignacionAlumno) {
        int rows=0;
        try{
            conn=Conexion.getConnection();
            pstmt=conn.prepareStatement(SQL_UPDATE);
            
            pstmt.setTimestamp(1, asignacionAlumno.getFechaAsignacion());
            pstmt.setString(2, asignacionAlumno.getCarne());
            pstmt.setInt(3, asignacionAlumno.getCursoId());
            pstmt.setString(4, asignacionAlumno.getAsignacionId());
            rows=pstmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }catch(Exception e){
            e.printStackTrace(System.out);
        }finally{
            Conexion.close(pstmt);
            Conexion.close(conn);
            
        }
        return rows;
    }

    @Override
    public int eliminar(AsignacionAlumno asignacionAlumno){
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_DELETE);
            pstmt.setString(1, asignacionAlumno.getAsignacionId());
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

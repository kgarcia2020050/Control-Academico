/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.in5bm.equipo3.models.dao;
import com.in5bm.equipo3.db.Conexion;
import com.in5bm.equipo3.models.domain.Alumno;
import com.in5bm.equipo3.models.idao.IAlumnoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author garci
 * @date 31/08/2021
 * @time 07:17:11 PM
 */
public class AlumnoDaoImpl implements IAlumnoDao{

    private static final String SQL_SELECT ="SELECT carne, apellidos, nombres, email  FROM alumno";
    private static final String SQL_DELETE="DELETE FROM alumno where carne = ?";
    private static final String SQL_SELECT_BY_ID = "SELECT  carne, nombres, apellidos, email FROM alumno WHERE carne = ? ";
    private static final String SQL_INSERT = "INSERT INTO alumno(carne,nombres,apellidos,email)VALUES (?,?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE alumno SET nombres = ?,apellidos = ?,email = ? WHERE carne = ?";
    
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private Alumno alumno= null;
    List<Alumno> listaAlumnos = new ArrayList<>();
    
    @Override
    public List<Alumno> listar() {
        try{
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();
            while(rs.next()){
                String carne = rs.getString("carne");
                String apellidos = rs.getString("apellidos");
                String nombres = rs.getString("nombres");
                String email = rs.getString("email");
              
                alumno = new Alumno(carne, apellidos, nombres, email);
                listaAlumnos.add(alumno);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return listaAlumnos;
    }

    @Override
    public Alumno encontrar(Alumno alumno) {
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setString(1, alumno.getCarne());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String carne = rs.getString("carne");
                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                String email = rs.getString("email");
               
               alumno.setCarne(carne);
               alumno.setNombres(nombres);
               alumno.setApellidos(apellidos);
               alumno.setEmail(email);
              
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
       return alumno;
    }

    @Override
    public int insertar(Alumno alumno) {
      int rows = 0;
        
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_INSERT);
            pstmt.setString(1, alumno.getCarne());
            pstmt.setString(2,alumno.getNombres());
            pstmt.setString(3,alumno.getApellidos());
            pstmt.setString(4,alumno.getEmail());
            
           
            
            
            System.out.println(pstmt.toString());
            
            rows = pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }finally{
          Conexion.close(pstmt);
          Conexion.close(conn);
        }
        
        return rows;
    }

    @Override
    public int actualizar(Alumno alumno) {
       int rows = 0;

        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_UPDATE);
            pstmt.setString(1, alumno.getNombres());
            pstmt.setString(2, alumno.getApellidos());
            pstmt.setString(3, alumno.getEmail());
            pstmt.setString(4, alumno.getCarne());
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
    public int eliminar(Alumno alumno) {
       int rows = 0;
      try{
          conn = Conexion.getConnection();
          pstmt = conn.prepareStatement(SQL_DELETE);
          pstmt.setString(1, alumno.getCarne());
          System.out.println(pstmt.toString());
          rows = pstmt.executeUpdate();
      }catch(SQLException ex){
          ex.printStackTrace();
      }finally{
          Conexion.close(pstmt);
          Conexion.close(conn);
      }
      return rows;
    }
    
    
    
    }

    
    


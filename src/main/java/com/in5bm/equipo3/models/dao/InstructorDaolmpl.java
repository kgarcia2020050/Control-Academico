

package com.in5bm.equipo3.models.dao;

import com.in5bm.equipo3.db.Conexion;
import com.in5bm.equipo3.models.domain.Instructor;
import com.in5bm.equipo3.models.idao.IInstructorDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Omar Chocojay
 */
 public class InstructorDaolmpl implements IInstructorDao {
     
     
    private static final String SQL_SELECT = "SELECT * FROM instructor";
    private static final String SQL_DELETE = "DELETE FROM instructor WHERE instructor_id = ?";
    private static final String SQL_UPDATE = "UPDATE instructor SET apellidos = ?, nombres = ?, direccion = ?, telefono = ? WHERE instructor_id = ?";
    private static final String SQL_SELECT_BY_ID = "SELECT instructor_id, apellidos, nombres, direccion, telefono FROM instructor WHERE instructor_id = ?";
    private static final String SQL_INSERT = "INSERT into instructor  (apellidos, nombres, direccion, telefono) values (?, ?, ?, ?)";

    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private Instructor instructor = null;
    private List<Instructor> listaInstructores = new ArrayList<>();
   
  
   
    @Override
    public List<Instructor> listar() {
        try{
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();
            
            while (rs.next()){
                int instructorId = rs.getInt("instructor_id");
                String apellidos = rs.getString("apellidos");
                String nombres = rs.getString("nombres");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                
                instructor = new Instructor(instructorId, apellidos, nombres, direccion, telefono);
                listaInstructores.add(instructor);
            }
        } catch(SQLException e){
            e.printStackTrace(System.out);
        } catch(Exception e){
            e.printStackTrace(System.out);
        } finally{
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return listaInstructores;
    }
    
    
    @Override
    public Instructor encontrar(Instructor instructor) {
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setInt(1, instructor.getInstructorId());
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                int instructorId = rs.getInt("instructor_id");
                String apellidos = rs.getString("apellidos");
                String nombres = rs.getString("nombres");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");

                instructor.setApellidos(apellidos);
                instructor.setNombres(nombres);
                instructor.setDireccion(direccion);
                instructor.setTelefono(telefono);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return instructor;
        
    }

    @Override
    public int insertar(Instructor instructor) {
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_INSERT);
            pstmt.setString(1, instructor.getApellidos());
            pstmt.setString(2, instructor.getNombres());
            pstmt.setString(3, instructor.getDireccion());
            pstmt.setString(4, instructor.getTelefono());

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
    public int actualizar(Instructor instructor) {
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_UPDATE);
            pstmt.setString(1, instructor.getApellidos());
            pstmt.setString(2, instructor.getNombres());
            pstmt.setString(3, instructor.getDireccion());
            pstmt.setString(4, instructor.getTelefono());
            pstmt.setInt(5, instructor.getInstructorId());


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
    public int eliminar(Instructor instructor) {
        int rows = 0;
        try{
            conn = Conexion.getConnection();
            pstmt= conn.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, instructor.getInstructorId());
            rows = pstmt.executeUpdate();
        } catch(SQLException e){
            if(e.getErrorCode()==1451){
                System.out.println("El instructor a eliminar puede estar asignado a un curso.");
                System.out.println("Primero elimine el curso.");
            }
        } finally{
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.in5bm.equipo3.models.dao;

import com.in5bm.equipo3.db.Conexion;
import com.in5bm.equipo3.models.domain.Login;
import com.in5bm.equipo3.models.idao.ILoginDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Brandon Andree Palma Hernandez
 * @date 16/09/2021
 * @time 08:31:59 AM
 */
public class LoginDaoImpl implements ILoginDao{
    
    private static final String SQL_SELECT = "SELECT * FROM usuario";
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private Login login = null;
    private List<Login> listaLogin = new ArrayList<>();

    @Override
    public List<Login> listar() {
        try{
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();
            if(rs!=null){
              while (rs.next()){
                String user = rs.getString("user");
                String pass = rs.getString("pass");
                String nombre = rs.getString("nombre");
                
                login = new Login(user, pass, user);
                listaLogin.add(login);  
            }
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
        return listaLogin;
    }
    
    public Login getLogin(){
        return login;
    }
    
    public void setLogin(Login login){
        this.login = login;
    }

   

}

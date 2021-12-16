/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.POJO.Registro;
import modelo.utilidades.DBUtil;

/**
 *
 * @author Usuario
 */
public class DAOUsuario {
    private Connection conexion;

    public DAOUsuario(Connection conexion) throws SQLException, ClassNotFoundException {
        conexion =  DBUtil.getConexion();
    }

    public DAOUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public void guardarUsuario(Registro usuario) throws SQLException {
        String sql = "INSERT INTO USUARIOS "
                + "(NOMBRE_COMPLETO, CORREO, PASSWORD, PRESUPUESTO_TOTAL)"
                + "VALUES(?,?,?,?)";

        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, usuario.getNombre());
        ps.setString(2, usuario.getCorreo());
        ps.setString(3, usuario.getContraseña());
        ps.setLong(4, usuario.getPresupuesto());
        
        ps.executeUpdate();
    }
    
}

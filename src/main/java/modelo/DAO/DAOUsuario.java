/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.POJO.Registro;
import modelo.utilidades.DBUtil;

/**
 *
 * @author Usuario
 */
public class DAOUsuario {

 

    public DAOUsuario() {
    }
    
     public void guardarUsuario(Registro usuario) throws SQLException {
        try {
            String sql = "INSERT INTO US_DINERO.USUARIOS"
                    + "(NOMBRE_COMPLETO, CORREO, PASSWORD, PRESUPUESTO_TOTAL)"
                    + "VALUES(?,?,?,?)";
            Connection conexion =  DBUtil.getConexion();
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, usuario.getContraseña());
            ps.setLong(4, usuario.getPresupuesto());
            
            int respuesta=ps.executeUpdate();
            System.out.println("inserto "+respuesta); //1 inserto 0 no inserto
            
            ps.close();
            conexion.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}

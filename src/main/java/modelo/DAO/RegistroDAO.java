/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.POJO.Registro;
import modelo.POJO.Usuario;
import modelo.utilidades.Conexion;
import modelo.utilidades.DBUtil;

/**
 *
 * @author Usuario
 */
public class RegistroDAO {
    //private Connection conexion;
    PreparedStatement ps;
    ResultSet rs;
    Conexion c = new Conexion();
    Connection con;

    public RegistroDAO() {
    }
    
     public int guardarUsuario(Registro usuario) throws SQLException {
       int respuesta=0;
         try {
            String sql = "INSERT INTO US_DINERO.USUARIOS"
                    + "(ID_USUARIO,NOMBRE_USUARIO, CORREO, PASSWORD, PRESUPUESTO_TOTAL,ESTADO,BIT_ADMIN)"
                    + "VALUES(1,?,?,?,?,1,0)";

            con = c.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, usuario.getContraseña());
            ps.setLong(4, usuario.getPresupuesto());
            
            respuesta=ps.executeUpdate();
            System.out.println("inserto "+respuesta); //1 inserto 0 no inserto
            
            ps.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return respuesta;
    }
     
  
}

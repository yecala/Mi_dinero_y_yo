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
    
     public void guardarUsuario(Registro usuario) throws SQLException {
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
            
            int respuesta=ps.executeUpdate();
            System.out.println("inserto "+respuesta); //1 inserto 0 no inserto
            
            ps.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
     
      public Usuario obtenerUsuarioPorEmail(String email) throws SQLException, ClassNotFoundException {
        String sql = "SELECT ID_USUARIO,NOMBRE_USUARIO, CORREO,"
                + " PASSWORD, PRESUPUESTO_TOTAL,ESTADO, BIT_ADMIN"
                +" WHERE CORREO=? AND ESTADO=1";

        Connection conexion =  DBUtil.getConexion();
        // Se asigna el parámetro email a instrucción de SQL
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, email);

        // El resultado de la consulta queda en una tabla en memoria conocida
        // como ResultSet
        ResultSet rs = ps.executeQuery();

        // El método next hace avanzar el cursor del ResultSet al siguiente registro
        if (rs.next()) {
            int id_usuario = rs.getInt("id_usuario");
            String nombre_usuario = rs.getString("nombre_usuario");
            String correo = rs.getString("correo");
            String password = rs.getString("password");
            long presupuesto_total = rs.getLong("presupuesto_total");
            int bit_admin = rs.getInt("bit_admin");
            int estado=1;
            
            Usuario u = new Usuario(id_usuario, nombre_usuario, correo, password, presupuesto_total,estado,bit_admin);
            return u;
        }

        return null;
    }
      
      
    
}

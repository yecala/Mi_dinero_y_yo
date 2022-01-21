/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.POJO.Usuario;
import modelo.utilidades.Conexion;

/**
 *
 * @author Usuario
 */
public class UsuarioDAO {
    
    PreparedStatement ps;
    ResultSet rs;
    Conexion c = new Conexion();
    Connection con;
    
    public List listar() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "select * from usuarios";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario us = new Usuario();
                us.setId_usuario(rs.getInt(1));
                us.setNombre_completo(rs.getString(2));
                us.setCorreo(rs.getString(3));
                us.setPassword(rs.getString(4));
                us.setPresupuesto_total(rs.getLong(5));
                lista.add(us);
            }
            
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return lista;
    }
}

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
import modelo.POJO.Bolsillo;
import modelo.utilidades.Conexion;

/**
 *
 * @author Usuario
 */
public class BolsilloDAO {
    PreparedStatement ps;
    ResultSet rs;
    Conexion c = new Conexion();
    Connection con;
    
    public List listar() {
        List<Bolsillo> lista = new ArrayList<>();
        String sql = "select * from bolsillos";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Bolsillo bol = new Bolsillo();
                bol.setId_bolsillo(rs.getInt(1));
                bol.setNombre_bolsillo(rs.getString(2));
                bol.setPresupuesto_bolsillo(rs.getLong(3));
                bol.setGasto_bolsillo(rs.getLong(4));
                bol.setId_categoria(rs.getInt(5));
                bol.setId_usuario(rs.getInt(6));
                lista.add(bol);
            }

        } catch (SQLException e) {
            e.getStackTrace();
        }
        return lista;
    }
}

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
import modelo.POJO.Categoria;
import modelo.utilidades.Conexion;

/**
 *
 * @author Usuario
 */
public class CategoriaDAO {
    
    PreparedStatement ps;
    ResultSet rs;
    Conexion c = new Conexion();
    Connection con;

    public List listar() {
        List<Categoria> lista = new ArrayList<>();
        String sql = "select * from categorias";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Categoria cat = new Categoria();
                cat.setId_categoria(rs.getInt(1));
                cat.setNombre_categoria(rs.getString(2));
                cat.setPresupuesto_categoria(rs.getLong(3));
                cat.setGasto_categoria(rs.getLong(4));
                
                lista.add(cat);
            }

        } catch (SQLException e) {
            e.getStackTrace();
        }
        return lista;
    }

    public Categoria ListarId(String id) {
        String sql = "select * from categorias where id_categoria=" + id;
        Categoria cat = new Categoria();

        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cat.setId_categoria(rs.getInt(1));
                cat.setNombre_categoria(rs.getString(2));
                cat.setPresupuesto_categoria(rs.getLong(3));
                cat.setGasto_categoria(rs.getLong(4));
            }
        } catch (SQLException e) {
        }
        return cat;
    }

    public int actualizar(Categoria cat) {

        int r = 0;
        String sql = "update categorias set nombre_categoria=?, presupuesto_categoria=?, gasto_categoria=? where id_categoria=?";
        try {

            con = c.conectar();
            ps = con.prepareStatement(sql);

            ps.setString(1, cat.getNombre_categoria());
            ps.setLong(2, cat.getPresupuesto_categoria());
            ps.setLong(3, cat.getGasto_categoria());

            ps.setInt(5, cat.getId_categoria());

            r = ps.executeUpdate();
            if (r == 1) {
                r = 1;
            } else {
                r = 0;
            }

        } catch (SQLException e) {
            e.toString();

        }
        return r;

    }

    public void delete(String id) {
        String sql = "delete from categorias where id_categoria=" + id;
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public int agregar(Categoria cat) {
        int r = 0;
        String sql = "insert into categorias (id_categoria,nombre_categoria,presupuesto_categoria,gasto_categoria) values(?,?,?,?)";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);

            ps.setInt(1, cat.getId_categoria());
            ps.setString(2, cat.getNombre_categoria());
            ps.setLong(3, cat.getPresupuesto_categoria());
            ps.setLong(4, cat.getGasto_categoria());
            
            r = ps.executeUpdate();

            if (r == 1) {
                r = 1;

            } else {
                r = 0;
            }

        } catch (Exception e) {

        }
        return r;
    }
}

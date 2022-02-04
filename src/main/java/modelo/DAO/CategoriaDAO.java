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
import modelo.POJO.Usuario;
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

//select id_categoria,sum(presupuesto_bolsillo) total from bolsillos where id_usuario=44 AND id_categoria=1 group by id_categoria;
    public List listar() {
        List<Categoria> lista = new ArrayList<>();
        String sql = "select id_categoria, nombre_categoria from categorias";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Categoria cat = new Categoria();
                cat.setId_categoria(rs.getInt(1));
                cat.setNombre_categoria(rs.getString(2));

                lista.add(cat);
            }

        } catch (SQLException e) {
            e.getStackTrace();
        }
        return lista;
    }

    public Categoria ListarId(String id) {
        String sql = "select id_categoria, nombre_categoria from categorias where id_categoria=" + id;
        Categoria cat = new Categoria();

        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cat.setId_categoria(rs.getInt(1));
                cat.setNombre_categoria(rs.getString(2));

            }
        } catch (SQLException e) {
        }
        return cat;
    }

    public int actualizar(Categoria cat) {

        int r = 0;
        String sql = "update categorias set nombre_categoria=? where id_categoria=?";
        try {

            con = c.conectar();
            ps = con.prepareStatement(sql);

            ps.setString(1, cat.getNombre_categoria());

            ps.setInt(2, cat.getId_categoria());

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

    public int num_bolsillos(String id) {
        String sql = "select id_bolsillo from bolsillos where id_categoria=" + id;
        Categoria cat = new Categoria();
        int num = 0;
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                num = rs.getInt(1);
            }
        } catch (SQLException e) {
        }
        return num;

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
        String sql = "insert into categorias (id_categoria,nombre_categoria) values(?,?)";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);

            ps.setInt(1, cat.getId_categoria());
            ps.setString(2, cat.getNombre_categoria());

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

    public Categoria sumarPresupuestoGasto(int id_usuario, int id_categoria) {
        String sql = "select id_categoria,sum(presupuesto_bolsillo),nvl(sum(gasto_bolsillo),0) from bolsillos where id_usuario=" + id_usuario + " AND id_categoria=" + id_categoria + " group by id_categoria";
        Categoria cat = new Categoria();

        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                cat.setId_categoria(rs.getInt(1));

                cat.setPresupuesto_categoria(rs.getLong(2));
                
                cat.setGasto_categoria(rs.getLong(3));

            }
        } catch (SQLException e) {
        }
        return cat;
    }

    public Usuario presupuestoDisponible(int id_usuario) {
        String sql = "SELECT usuarios.id_usuario, usuarios.presupuesto_total, nvl(sum(presupuesto_bolsillo),0) FROM bolsillos \n"
                + "RIGHT JOIN usuarios \n"
                + "ON bolsillos.id_usuario = usuarios.id_usuario \n"
                + "WHERE usuarios.id_usuario="+ id_usuario+"\n" 
                + "GROUP BY usuarios.id_usuario,usuarios.presupuesto_total";
        
        Usuario usu = new Usuario();

        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                usu.setId_usuario(rs.getInt(1));

                usu.setPresupuesto_total(rs.getLong(2));
                
                usu.setPresupuesto_disponible(rs.getLong(3));

            }
        } catch (SQLException e) {
        }
        return usu;

    }

    
}

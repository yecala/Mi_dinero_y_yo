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

    public Usuario ListarId(String id) {
        String sql = "select * from usuarios where id_usuario=" + id;
        Usuario u = new Usuario();

        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                u.setId_usuario(rs.getInt(1));
                u.setNombre_completo(rs.getString(2));
                u.setCorreo(rs.getString(3));
                u.setPassword(rs.getString(4));
                u.setPresupuesto_total(rs.getLong(5));
            }
        } catch (SQLException e) {
        }
        return u;
    }

    public int actualizar(Usuario u) {

        int r = 0;
        String sql = "update usuarios set nombre_completo=?, correo=?,password=?, presupuesto_total=? where id_usuario=?";
        try {

            con = c.conectar();
            ps = con.prepareStatement(sql);

            ps.setString(1, u.getNombre_completo());
            ps.setString(2, u.getCorreo());
            ps.setString(3, u.getPassword());
            ps.setLong(4, u.getPresupuesto_total());

            ps.setInt(5, u.getId_usuario());

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
        String sql = "delete from usuarios where id_usuario=" + id;
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public int agregar(Usuario p) {
        int r = 0;
        String sql = "insert into usuarios (id_usuario,nombre_completo,correo,password,presupuesto_total) values(?,?,?,?,?)";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);

            ps.setInt(1, p.getId_usuario());
            ps.setString(2, p.getNombre_completo());
            ps.setString(3, p.getCorreo());
            ps.setString(4, p.getPassword());
            ps.setLong(5, p.getPresupuesto_total());
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

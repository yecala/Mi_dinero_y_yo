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
                us.setNombre_usuario(rs.getString(2));
                us.setCorreo(rs.getString(3));
                us.setPassword(rs.getString(4));
                us.setPresupuesto_total(rs.getLong(5));
                us.setEstado(rs.getInt(6));
                us.setBit_admin(rs.getInt(7));
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
                u.setNombre_usuario(rs.getString(2));
                u.setCorreo(rs.getString(3));
                u.setPassword(rs.getString(4));
                u.setPresupuesto_total(rs.getLong(5));
                u.setEstado(rs.getInt(6));
                u.setBit_admin(rs.getInt(7));
            }
        } catch (SQLException e) {
        }
        return u;
    }

    public int actualizar(Usuario u) {

        int r = 0;
        String sql = "update usuarios set nombre_usuario=?, correo=?,password=?, presupuesto_total=?, estado=?, bit_admin=? where id_usuario=?";
        try {

            con = c.conectar();
            ps = con.prepareStatement(sql);

            ps.setString(1, u.getNombre_usuario());
            ps.setString(2, u.getCorreo());
            ps.setString(3, u.getPassword());
            ps.setLong(4, u.getPresupuesto_total());
            ps.setInt(5, u.getEstado());
            ps.setInt(6, u.getBit_admin());

            ps.setInt(7, u.getId_usuario());

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

    public int delete(Usuario u) {

        int r = 0;
        String sql = "update usuarios set estado=? where id_usuario=?";
        try {

            con = c.conectar();
            ps = con.prepareStatement(sql);

            ps.setInt(1, 0);

            ps.setInt(2, u.getId_usuario());

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

    public int agregar(Usuario p) {
        int r = 0;
        String sql = "insert into usuarios (id_usuario,nombre_usuario,correo,password,presupuesto_total,estado,bit_admin) values(?,?,?,?,?,?,?)";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);

            ps.setInt(1, p.getId_usuario());
            ps.setString(2, p.getNombre_usuario());
            ps.setString(3, p.getCorreo());
            ps.setString(4, p.getPassword());
            ps.setLong(5, p.getPresupuesto_total());
            ps.setInt(6, p.getEstado());
            ps.setInt(7, p.getBit_admin());
          
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

    public Usuario obtenerUsuarioPorEmail(String correo) {
        String sql =String.format("select * from usuarios WHERE correo='%s'", correo) ;
        Usuario u = new Usuario();
        //esta es la linea que debes ver
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);

            //ps.setString(1, correo);
            
            rs = ps.executeQuery();

            while (rs.next()) {
                u.setId_usuario(rs.getInt(1));
                u.setNombre_usuario(rs.getString(2));
                u.setCorreo(rs.getString(3));
                u.setPassword(rs.getString(4));
                u.setPresupuesto_total(rs.getLong(5));
                u.setEstado(rs.getInt(6));
                u.setBit_admin(rs.getInt(7));
            }
        } catch (SQLException e) {
        }
        return u;
    }
    
    public int actualizarPerfil(Usuario u) {

        int r = 0;
        String sql = "update usuarios set nombre_usuario=?, password=?, presupuesto_total=? where id_usuario=?";
        try {

            con = c.conectar();
            ps = con.prepareStatement(sql);

            ps.setString(1, u.getNombre_usuario());
            ps.setString(2, u.getPassword());
            ps.setLong(3, u.getPresupuesto_total());
            ps.setInt(4, u.getId_usuario());

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
    

}

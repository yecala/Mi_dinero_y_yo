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
        String sql = "select * from categorias order by id_categoria";
        try{
           con = c.conectar();  
        }catch(Exception ex){
             ex.getStackTrace();
             System.out.println("Fallo al intentar conectar con base de datos");
        }
            
        try {    
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Categoria cat = new Categoria();
                cat.setId_categoria(rs.getInt(1));
                cat.setNombre_categoria(rs.getString(2));
                cat.setConsejo(rs.getString(3));
                lista.add(cat);
            }

        } catch (SQLException e) {
            e.getStackTrace();
        }
        return lista;
    }

    public Categoria ListarId(String id) {
        String sql = "select id_categoria, nombre_categoria, consejo from categorias where id_categoria=" + id;
        Categoria cat = new Categoria();

        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cat.setId_categoria(rs.getInt(1));
                cat.setNombre_categoria(rs.getString(2));
                cat.setConsejo(rs.getString(3));
            }
        } catch (SQLException e) {
        }
        return cat;
    }

    public int actualizar(Categoria cat) {

        int r = 0;
        String sql = "update categorias set nombre_categoria='" + cat.getNombre_categoria() + "' , consejo='" + cat.getConsejo() +"' where id_categoria=" + cat.getId_categoria();
        
        try {

            con = c.conectar();
            ps = con.prepareStatement(sql);

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

    public int delete(String id) {
        int r = 0;
        String sql = "delete from categorias where id_categoria=" + id;
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
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

    public int agregar(Categoria cat) {
        int r = 0;
        String sql = "insert into categorias (id_categoria,nombre_categoria,consejo) values(?,?,?)";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);

            ps.setInt(1, cat.getId_categoria());
            ps.setString(2, cat.getNombre_categoria());
            ps.setString(3, cat.getConsejo());
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
        String sql = "select categorias.id_categoria,categorias.nombre_categoria,sum(presupuesto_bolsillo)sumapre,nvl(sum(gasto_bolsillo),0)sumagasto from bolsillos\n"
                + "right join categorias on bolsillos.id_categoria=categorias.id_categoria\n"
                + "where bolsillos.id_usuario="+id_usuario+" AND bolsillos.id_categoria="+id_categoria+" \n"
                + "group by categorias.id_categoria,categorias.nombre_categoria";
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

    public Usuario presupuestoDisponible(int id_usuario) {
        String sql = "SELECT usuarios.id_usuario, usuarios.presupuesto_total, nvl(sum(presupuesto_bolsillo),0) FROM bolsillos \n"
                + "RIGHT JOIN usuarios \n"
                + "ON bolsillos.id_usuario = usuarios.id_usuario \n"
                + "WHERE usuarios.id_usuario=" + id_usuario + "\n"
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

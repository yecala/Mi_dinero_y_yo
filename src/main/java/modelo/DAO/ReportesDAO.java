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
public class ReportesDAO {

    PreparedStatement ps;
    ResultSet rs;
    Conexion c = new Conexion();
    Connection con;

    public List listar(int id_usuario) {
        List<Categoria> lista = new ArrayList<>();
        String sql = "select categorias.id_categoria, categorias.nombre_categoria, sum(presupuesto_bolsillo)sumap,nvl(sum(gasto_bolsillo),0)sumag from bolsillos\n"
                + "right join categorias\n"
                + "on categorias.id_categoria = bolsillos.id_categoria\n"
                + "where bolsillos.id_usuario="+id_usuario+"\n"
                + "group by categorias.id_categoria, categorias.nombre_categoria";
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

    public long PresupuestoTotal(int id_usuario) {
        long PresuTotal=0;
        String sql = "select presupuesto_total from usuarios where id_usuario="+id_usuario;
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                PresuTotal=(rs.getLong(1));
                
            }

        } catch (SQLException e) {
            e.getStackTrace();
        }
        return PresuTotal;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.POJO;

/**
 *
 * @author Usuario
 */
public class Usuario {
    
        int id_usuario;
        String nombre_completo;
        String correo;
        String password;
        long presupuesto_total;

    public Usuario() {
    }

    public Usuario(int id_usuario, String nombre_completo, String correo, String password, long presupuesto_total) {
        this.id_usuario = id_usuario;
        this.nombre_completo = nombre_completo;
        this.correo = correo;
        this.password = password;
        this.presupuesto_total = presupuesto_total;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getPresupuesto_total() {
        return presupuesto_total;
    }

    public void setPresupuesto_total(long presupuesto_total) {
        this.presupuesto_total = presupuesto_total;
    }
        
    
}

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
    
        int id_usuario=0;
        String nombre_usuario="";
        String correo="";
        String password="";
        long presupuesto_total=0;
        int estado;
        int bit_admin;
        long presupuesto_disponible;

    

    public Usuario() {
    }

    public Usuario(int id_usuario, String nombre_usuario, String correo, String password, long presupuesto_total, int estado, int bit_admin) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.correo = correo;
        this.password = password;
        this.presupuesto_total = presupuesto_total;
        this.estado = estado;
        this.bit_admin = bit_admin;
    }
    public long getPresupuesto_disponible() {
        return presupuesto_disponible;
    }

    public void setPresupuesto_disponible(long presupuesto_disponible) {
        this.presupuesto_disponible = presupuesto_disponible;
    }

    public int getBit_admin() {
        return bit_admin;
    }

    public void setBit_admin(int bit_admin) {
        this.bit_admin = bit_admin;
    }

  

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
   
    
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.POJO;

/**
 *
 * @author Usuario
 */
public class Bolsillo {
    int id_bolsillo;
    String nombre_bolsillo;
    long presupuesto_bolsillo;
    long gasto_bolsillo;
    int id_categoria;
    int id_usuario;

    public Bolsillo(int id_bolsillo, String nombre_bolsillo, long presupuesto_bolsillo, long gasto_bolsillo, int id_categoria, int id_usuario) {
        this.id_bolsillo = id_bolsillo;
        this.nombre_bolsillo = nombre_bolsillo;
        this.presupuesto_bolsillo = presupuesto_bolsillo;
        this.gasto_bolsillo = gasto_bolsillo;
        this.id_categoria = id_categoria;
        this.id_usuario = id_usuario;
    }

    public Bolsillo() {
    }

    public int getId_bolsillo() {
        return id_bolsillo;
    }

    public void setId_bolsillo(int id_bolsillo) {
        this.id_bolsillo = id_bolsillo;
    }

    public String getNombre_bolsillo() {
        return nombre_bolsillo;
    }

    public void setNombre_bolsillo(String nombre_bolsillo) {
        this.nombre_bolsillo = nombre_bolsillo;
    }

    public long getPresupuesto_bolsillo() {
        return presupuesto_bolsillo;
    }

    public void setPresupuesto_bolsillo(long presupuesto_bolsillo) {
        this.presupuesto_bolsillo = presupuesto_bolsillo;
    }

    public long getGasto_bolsillo() {
        return gasto_bolsillo;
    }

    public void setGasto_bolsillo(long gasto_bolsillo) {
        this.gasto_bolsillo = gasto_bolsillo;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.POJO;

/**
 *
 * @author Usuario
 */
public class Categoria {
    int id_categoria;
    String nombre_categoria;
    long presupuesto_categoria;
    long gasto_categoria;
    String consejo;
    
    public Categoria(int id_categoria, String nombre_categoria, long presupuesto_categoria, long gasto_categoria, String consejo) {
        this.id_categoria = id_categoria;
        this.nombre_categoria = nombre_categoria;
        this.presupuesto_categoria = presupuesto_categoria;
        this.gasto_categoria = gasto_categoria;
        this.consejo = consejo;
    }
    
    public Categoria(int id_categoria, String nombre_categoria, long presupuesto_categoria, long gasto_categoria) {
        this.id_categoria = id_categoria;
        this.nombre_categoria = nombre_categoria;
        this.presupuesto_categoria = presupuesto_categoria;
        this.gasto_categoria = gasto_categoria;
    }

    public Categoria(int id_categoria, String nombre_categoria) {
        this.id_categoria = id_categoria;
        this.nombre_categoria = nombre_categoria;
       
    }

    public Categoria() {
    }

    
    public long getPresupuesto_categoria() {
        return presupuesto_categoria;
    }

    public void setPresupuesto_categoria(long presupuesto_categoria) {
        this.presupuesto_categoria = presupuesto_categoria;
    }

    public long getGasto_categoria() {
        return gasto_categoria;
    }

    public void setGasto_categoria(long gasto_categoria) {
        this.gasto_categoria = gasto_categoria;
    }

    

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    public String getConsejo() {
        return consejo;
    }

    public void setConsejo(String consejo) {
        this.consejo = consejo;
    }

}

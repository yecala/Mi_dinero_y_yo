/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class Conexion {
    Connection con;
    String url="jdbc:oracle:thin:@localhost:1521:xe";
    String user="us_dinero";
    String pass="1234";
    
    public Connection conectar(){
    
        try {
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection(url,user,pass);
        } catch (ClassNotFoundException | SQLException e) {
        }
        return con;
    }
}

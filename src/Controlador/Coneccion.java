/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import java.sql.DriverManager;
import java.sql.Connection;


/**
 *
 * @author Tottus
 */
public class Coneccion {
    Connection conectar=null;
    
    public Connection conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar=DriverManager.getConnection("jdbc:mysql://edserver/registro","eddie","123");
            System.out.println("conecto n.n");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return conectar;
    }
}

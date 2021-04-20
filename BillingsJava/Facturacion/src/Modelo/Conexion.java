/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.sql.*;
/**
 *
 * @author Jamartinez
 */
public class Conexion 
{    private static Connection cn;
   public static Connection GetConexion()
   {
       try 
       {
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=PuntoVenta", "sa", "Tecnologia01");              
       } 
       catch (ClassNotFoundException | SQLException e) 
       {
       System.out.print(e);
       
       }
       return cn;
   }
    
}

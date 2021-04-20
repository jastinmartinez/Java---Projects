/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import static Modelo.Conexion.GetConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jamartinez
 */
public class ConsultaCliente extends Conexion
{

    public boolean Registrar(Cliente Clie)
    {
        PreparedStatement ps = null;
        Connection con = GetConexion();
      
        String sql = "insert into Cliente(cedula,nombre,direccion,genero) values(?,?,?,?)";
            try 
            {
                ps = con.prepareStatement(sql);
                    ps.setString(1, Clie.getCedula());
                     ps.setString(2, Clie.getNombre());
                      ps.setString(3, Clie.getDireccion()); 
                      ps.setString(4, Clie.getGenero());
                      ps.execute();
                         return true;
            } 
            catch (SQLException e)
            {
                System.err.println(e);
                return false;
            }
            finally
            {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println(e);
                }
            }
        }
    
    public boolean Modificar(Cliente Clie)
    {
        PreparedStatement ps = null;
        Connection con = GetConexion();
      
        String sql = "update Cliente set nombre = ?,direccion = ?,genero = ? where cedula = ?";
            try 
            {
                ps = con.prepareStatement(sql);                    
                     ps.setString(1,Clie.getNombre());
                      ps.setString(2,Clie.getDireccion()); 
                      ps.setString(3,Clie.getGenero());
                      ps.setString(4,Clie.getCedula());                    
                      ps.execute();
                         return true;
            } 
            catch (SQLException e)
            {
                System.err.println(e);
                return false;
            }
            finally
            {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println(e);
                }
            }
        }
    public boolean Eliminar(Cliente Clie)
    {
        PreparedStatement ps = null;
        Connection con = GetConexion();
      
        String sql = "delete from Cliente where cedula = ?";
            try 
            {
                ps = con.prepareStatement(sql);
                    ps.setString(1, Clie.getCedula());
                    ps.execute();
                    return true;
            } 
            catch (SQLException e)
            {
                System.err.println(e);
                return false;
            }
            finally
            {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println(e);
                }
            }
        }
        public void Tabla(JTable Tabla)
    {
        try 
         {
            DefaultTableModel modelo = new DefaultTableModel();
            Tabla.setModel(modelo);

            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection con = GetConexion();

            String sql = "SELECT cedula, nombre, direccion,genero FROM Cliente";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("Cedula");
            modelo.addColumn("Nombre");
            modelo.addColumn("Direccion");
            modelo.addColumn("Genero");
            
            int[] anchos = {50, 200, 50, 50};
            for (int i = 0; i < Tabla.getColumnCount(); i++) 
            {
                Tabla.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

            while (rs.next()) 
            {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
         }
        catch (SQLException ex)
        {
            System.err.println(ex.toString());
        }
    }
}

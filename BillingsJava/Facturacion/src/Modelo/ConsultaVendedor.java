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
public class ConsultaVendedor extends Conexion
{
    public boolean Registrar(Vendedor prov)
    {
        PreparedStatement ps = null;
        Connection con = GetConexion();
      
        String sql = "insert into Vendedor(Codigo,Nombre) values(?,?)";
            try 
            {
                ps = con.prepareStatement(sql);
                    ps.setInt(1, prov.getCodigo());
                     ps.setString(2, prov.getNombre());
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
    public boolean Modificar(Vendedor prov)
    {
        PreparedStatement ps = null;
        Connection con = GetConexion();
      
        String sql = "update Vendedor set Nombre = ? where Codigo = ?";
            try 
            {
                ps = con.prepareStatement(sql);
                    ps.setString(1, prov.getNombre());
                     ps.setInt(2, prov.getCodigo());
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
    
     public boolean Eliminar(Vendedor prov)
    {
        PreparedStatement ps = null;
        Connection con = GetConexion();
      
        String sql = "delete from Vendedor where Codigo = ?";
            try 
            {
                ps = con.prepareStatement(sql);
                     ps.setInt(1, prov.getCodigo());
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

            String sql = "SELECT Codigo, Nombre FROM Vendedor";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("Codigo");
            modelo.addColumn("Nombre");
            
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

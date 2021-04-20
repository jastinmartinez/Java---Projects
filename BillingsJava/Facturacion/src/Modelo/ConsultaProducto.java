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
public class ConsultaProducto extends Conexion
{
    public boolean Registrar(Producto pro)
    {
        PreparedStatement ps = null;
        Connection con = GetConexion();
      
        String sql = "insert into Producto(Codigo,Descripcion,PrecioUnitario) values(?,?,?)";
            try 
            {
                ps = con.prepareStatement(sql);
                    ps.setInt(1, pro.getCodigo());
                     ps.setString(2, pro.getDescripcion());
                      ps.setDouble(3, pro.getPrecioUnitario()); 
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
    public boolean Actualizar(Producto pro)
    {
        PreparedStatement ps = null;
        Connection con = GetConexion();
      
        String sql = "update Producto set Descripcion = ?,PrecioUnitario = ? where Codigo = ?";
            try 
            {
                ps = con.prepareStatement(sql);
                     ps.setString(1, pro.getDescripcion());
                     ps.setDouble(2, pro.getPrecioUnitario()); 
                     ps.setInt(3, pro.getCodigo()); 
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
    public boolean Eliminar(Producto pro)
    {
        PreparedStatement ps = null;
        Connection con = GetConexion();
      
        String sql = "delete from Producto where Codigo = ?";
            try 
            {
                ps = con.prepareStatement(sql);
                     ps.setInt(1, pro.getCodigo());
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

            String sql = "SELECT Codigo, Descripcion, PrecioUnitario FROM Producto";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("Codigo");
            modelo.addColumn("Descripcion");
            modelo.addColumn("PrecioUnitario");
            
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

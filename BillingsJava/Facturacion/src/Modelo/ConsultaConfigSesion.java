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
public class ConsultaConfigSesion 
{
    public boolean Registrar(ConfiguracionSesion Clie)
    {
        PreparedStatement ps = null;
        Connection con = GetConexion();
      
        String sql = "insert into InicioSesion(Usuario,Contrasena) values(?,?)";
            try 
            {
                ps = con.prepareStatement(sql);
                     ps.setString(1, Clie.getUsuario());
                      ps.setString(2, Clie.getContrasena()); 
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
    public boolean Modificar(ConfiguracionSesion Clie)
    {
        PreparedStatement ps = null;
        Connection con = GetConexion();
      
        String sql = "update InicioSesion set Usuario = ?,Contrasena = ? where Id = ?";
            try 
            {
                      ps = con.prepareStatement(sql);
                      ps.setString(1, Clie.getUsuario());
                      ps.setString(2, Clie.getContrasena()); 
                      ps.setInt(3, Clie.getId()); 
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
    public boolean Eliminar(ConfiguracionSesion Clie)
    {
        PreparedStatement ps = null;
        Connection con = GetConexion();
      
        String sql = "delete from InicioSesion where Id = ?";
            try 
            {
                      ps = con.prepareStatement(sql);
                      ps.setInt(1, Clie.getId()); 
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
    public boolean Buscar(ConfiguracionSesion Clie)
    {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = GetConexion();
      
        String sql = "select * from InicioSesion where Id = ?";
            try 
            {
                      ps = con.prepareStatement(sql);
                      ps.setInt(1, Clie.getId()); 
                      rs = ps.executeQuery();
                      if (rs.next()) 
                      {
                          Clie.setId(Integer.parseInt(rs.getString("Id")));
                          Clie.setUsuario(rs.getString("Usuario"));
                          Clie.setContrasena(rs.getString("Contrasena"));
                          return true;
                       }
                return false;         
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

            String sql = "SELECT Id, Usuario, Contrasena FROM InicioSesion";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("Id");
            modelo.addColumn("Usuario");
            modelo.addColumn("Contraseña");
            
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

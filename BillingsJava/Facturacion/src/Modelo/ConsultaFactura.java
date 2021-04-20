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
import java.sql.SQLException;

/**
 *
 * @author Jamartinez
 */
public class ConsultaFactura extends Conexion
{
   public boolean Registrar(Factura Fac)
    {
        PreparedStatement ps = null;
        Connection con = GetConexion();
      
        String sql = "insert into Factura (NoFactura,Cedula,Fecha,Vendedor,TipoCompra,Articulo,Cantidad,PrecioUnitario,Total) values (?,?,?,?,?,?,?,?,?)";
            try 
            {
                      ps = con.prepareStatement(sql);
                      ps.setInt(1, Fac.getNoFactura());
                      ps.setString(2, Fac.getCedula());
                      ps.setString(3, Fac.getFecha()); 
                      ps.setString(4, Fac.getVendedor());
                      ps.setString(5, Fac.getTipoCompra());
                      ps.setString(6, Fac.getArticulo());
                      ps.setInt(7, Fac.getCantidad());
                      ps.setInt(8, Fac.getPrecioUnitario());
                      ps.setInt(9, Fac.getTotal());
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
}

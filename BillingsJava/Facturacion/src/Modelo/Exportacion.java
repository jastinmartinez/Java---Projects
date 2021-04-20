/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Formularios.FConsulta;
import static Modelo.Conexion.GetConexion;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jamartinez
 */
public class Exportacion extends FConsulta
{
   public void Tabla(JTable Tabla,JComboBox Combobox)
    {
        try 
         {
            DefaultTableModel modelo = new DefaultTableModel();
            Tabla.setModel(modelo);

            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection con = GetConexion();

            String sql = "SELECT Fecha, Vendedor, TipoCompra, Cantidad ,PrecioUnitario,Total,TotalGeneral =(select sum(Total) as total from Exportacion where cedula = '"+Combobox.getSelectedItem()+"') FROM Exportacion where cedula = '"+Combobox.getSelectedItem()+"'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("Fecha");
            modelo.addColumn("Vendedor");
            modelo.addColumn("TipoCompra");
            modelo.addColumn("Cantidad");
            modelo.addColumn("PrecioUnitario");
            modelo.addColumn("Total");
            modelo.addColumn("TotalGeneral");

            for (int i = 0; i < Tabla.getColumnCount(); i++) 
            {
                Tabla.getColumnModel().getColumn(i);
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
    public void guardaTabla(JTable table,String cedula,String cliente){
        try {
                     
            String sucursalesCSVFile = "src/Export/DatosTabla.txt";
            BufferedWriter bfw = new BufferedWriter(new FileWriter(sucursalesCSVFile ));
            bfw.write("Consulta");
            bfw.newLine();
            bfw.write("Cedula: " + cedula + " " + "Cliente: " + cliente);
            bfw.newLine();
            bfw.newLine(); 
            bfw.write("Fecha" + " | " + "Vendedor" + " | " + "TipoCompra" + " | " + "Cantidad" + " | " + "PrcioUnitario" + " | " + "Total" + " | ");
            bfw.newLine();
            for (int i = 0 ; i < table.getRowCount(); i++) 
            {                
                for(int j = 0 ; j < table.getColumnCount() - 1;j++) 
                {                    
                    bfw.write((String)(table.getValueAt(i,j).toString()));                   
                    if (j < table.getColumnCount()) 
                    {
                        bfw.write("| ");                   
                    }
                }
                bfw.newLine();                          
            }
            bfw.newLine();
            bfw.write("Total General: " + table.getValueAt(0,6).toString());
            bfw.close(); 
            
            JOptionPane.showMessageDialog(null, "Exportacion Completa");
        } 
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, "ERROR: Ocurrio un problema al salvar el archivo!","Denied",JOptionPane.ERROR_MESSAGE);
        }
    }
    
}

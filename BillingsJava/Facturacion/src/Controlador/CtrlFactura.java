/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Formularios.FConsulta;
import Formularios.FFactura;
import static Modelo.Conexion.GetConexion;
import Modelo.ConsultaFactura;
import Modelo.Factura;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author Jamartinez
 */
public class CtrlFactura implements ActionListener
{
private Factura Fac;
private ConsultaFactura ConFac;
private FFactura Ff;
public CtrlFactura(Factura Fac,ConsultaFactura ConFac,FFactura Ff)
{
this.ConFac = ConFac;
this.Fac = Fac;
this.Ff = Ff;
this.Ff.BtnGuardar.addActionListener(this);
}

    @Override
    public void actionPerformed(ActionEvent e)
    { 
        if (e.getSource() == Ff.BtnGuardar) 
        {  
                int NoFactura = 0;
                Connection Con = GetConexion();
                ResultSet rs = null;
            try {
                rs = Con.prepareStatement("select count(NoFactura) + 1 from Factura").executeQuery();
                if (rs.next())
                {
                    NoFactura = Integer.parseInt(rs.getString(1));
                }
                Con.close();
            } catch (SQLException ex) {
                Logger.getLogger(CtrlFactura.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            String a = Ff.JCmbCliente.getSelectedItem().toString();  
            String b = Ff.JCmbProducto.getSelectedItem().toString();
            String c = Ff.JCmbVendedor.getSelectedItem().toString();
            int d = Integer.parseInt(Ff.Jtotal.getText());
            if(a.isEmpty()|| b.isEmpty() || c.isEmpty() || d <= 0)
            {
                JOptionPane.showMessageDialog(null, "Seleccione Valor / Total igual 0","Denied",JOptionPane.ERROR_MESSAGE);
            }
            else
            {

            Date now = new Date(System.currentTimeMillis());
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");  
             Fac.setNoFactura(NoFactura);
             Fac.setCedula(String.valueOf(Ff.JCmbCliente.getSelectedItem()));
             Fac.setFecha(date.format(now));
             Fac.setVendedor(String.valueOf(Ff.JCmbVendedor.getSelectedItem()));
             Fac.setTipoCompra(String.valueOf(Ff.JCmbTipoCompra.getSelectedItem()));
             Fac.setArticulo(String.valueOf(Ff.JCmbProducto.getSelectedItem()));
             Fac.setCantidad(Integer.parseInt(Ff.JtCantidad.getText()));
             Fac.setPrecioUnitario(Integer.parseInt(Ff.JtPrecioUnitario.getText()));
             Fac.setTotal(Integer.parseInt(Ff.Jtotal.getText()));
             if (ConFac.Registrar(Fac))
             {              
             JOptionPane.showMessageDialog(null, "Registro Guardado");
             imprimir(NoFactura);
             Limpiar();
             NoFactura = 0;
             }
             else
             {
             JOptionPane.showMessageDialog(null, "Error al guardar","Denied",JOptionPane.ERROR_MESSAGE);
             Limpiar();
             }
            }
        }
    }
       public void imprimir(int nFac)
       {
        String reportSrcFile = "C:\\Users\\jamartinez\\Documents\\UNAPEC\\2018Enero\\INF111\\Projectos\\Facturacion\\src\\Reporte\\RFactura.jrxml";
        Connection con = GetConexion();
        try 
        {
            JasperReport jasperReport;
            jasperReport = JasperCompileManager.compileReport(reportSrcFile);
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("NFac", nFac);
            JasperPrint print;
            print = JasperFillManager.fillReport(jasperReport,parameters,con);
            JasperPrintManager.printReport( print, true);
            System.out.print("Done!");
        } 
        catch (JRException ex)
        {
            Logger.getLogger(FConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
      public void Limpiar()
        {
          Ff.JtCantidad.setText("0");
          Ff.JtPrecioUnitario.setText("0");
          Ff.Jtotal.setText("0");       
        }
}

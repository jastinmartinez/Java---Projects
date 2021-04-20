/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Formularios.FProducto;
import Modelo.ConsultaProducto;
import Modelo.Producto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Jamartinez
 */
public class CtrlProducto implements ActionListener
{
    private ConsultaProducto Cp;
    private Producto P;
    private FProducto Fp;
    
    public CtrlProducto(Producto P, ConsultaProducto Cp,FProducto Fp)
    {
      this.Cp = Cp;
      this.P = P;
      this.Fp = Fp;
      this.Fp.BtnGuardar.addActionListener(this);
      this.Fp.BtnModificar.addActionListener(this);
      this.Fp.BtnEliminar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        
        if (e.getSource() == Fp.BtnGuardar)
        {
            int a = Integer.parseInt(Fp.TxtCodigo.getText());  
            String b = Fp.TxtDescripcion.getText();
            int c = Integer.parseInt(Fp.TxtPrecioUnitario.getText());
            if(a <= 0|| b.isEmpty() || c <= 0)
            {
                JOptionPane.showMessageDialog(null, "Seleccione Valor / Total igual 0","Denied",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                P.setCodigo(Integer.parseInt(Fp.TxtCodigo.getText()));
                P.setDescripcion(Fp.TxtDescripcion.getText());
                P.setPrecioUnitario(Double.parseDouble(Fp.TxtPrecioUnitario.getText()));

                if (Cp.Registrar(P))
                {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                Limpiar();
                }       
                else
                {
                 JOptionPane.showMessageDialog(null, "Error al guardar","Denied",JOptionPane.ERROR_MESSAGE);
                 Limpiar();
                }
            }
        }
            
        if (e.getSource() == Fp.BtnModificar)
        {
         P.setCodigo(Integer.parseInt(Fp.TxtCodigo.getText()));
         P.setDescripcion(Fp.TxtDescripcion.getText());
         P.setPrecioUnitario(Double.parseDouble(Fp.TxtPrecioUnitario.getText()));
        
            if (Cp.Actualizar(P))
            {
            JOptionPane.showMessageDialog(null, "Registro Modificado");
            Limpiar();
            }           
            else
            {
             JOptionPane.showMessageDialog(null, "Error al modificar","Denied",JOptionPane.ERROR_MESSAGE);
            Limpiar();
            }
        } 
       
        if (e.getSource() == Fp.BtnEliminar)
        {
            int a = Integer.parseInt(Fp.TxtCodigo.getText()); 
            if(a <= 0)
            {
            JOptionPane.showMessageDialog(null, "Seleccione Valor / Total igual 0","Denied",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
            P.setCodigo(Integer.parseInt(Fp.TxtCodigo.getText()));     
            if (Cp.Eliminar(P))
            {
            JOptionPane.showMessageDialog(null, "Registro Eliminado");   
            Limpiar();
            }
            else
            {
             JOptionPane.showMessageDialog(null, "Error al Eliminar","Denied",JOptionPane.ERROR_MESSAGE);
            Limpiar();
            }
            }
        }
    }
         public void Limpiar()
        {
          Fp.TxtCodigo.setText("0");
          Fp.TxtDescripcion.setText(null); 
          Fp.TxtPrecioUnitario.setText("0"); 
        }
}

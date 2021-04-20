/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Formularios.FVendedor;
import Modelo.ConsultaVendedor;
import Modelo.Vendedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Jamartinez
 */
public class CtrlVendedor implements ActionListener
{
    private Vendedor V;
    private ConsultaVendedor Cv;
    private FVendedor Fv;
    public CtrlVendedor(Vendedor V, ConsultaVendedor Cv,FVendedor Fv)
    {
      this.Fv = Fv;
      this.Cv = Cv;
      this.V = V;
      this.Fv.BtnGuardar.addActionListener(this);
      this.Fv.BtnModificar.addActionListener(this);
      this.Fv.BtnEliminar.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == Fv.BtnGuardar)
        {
             V.setCodigo(Integer.parseInt(Fv.TxtCodigo.getText()));
             V.setNombre(Fv.TxtDescripcion.getText());
        
             if (Cv.Registrar(V))
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
        
        if (e.getSource() == Fv.BtnModificar)
        {
             V.setCodigo(Integer.parseInt(Fv.TxtCodigo.getText()));
             V.setNombre(Fv.TxtDescripcion.getText());
        
             if (Cv.Modificar(V))
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
        
        if (e.getSource() == Fv.BtnEliminar)
        {
             V.setCodigo(Integer.parseInt(Fv.TxtCodigo.getText()));
             
             if (Cv.Eliminar(V))
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
     public void Limpiar()
        {
          Fv.TxtCodigo.setText(null);
          Fv.TxtDescripcion.setText(null); 
        }
}

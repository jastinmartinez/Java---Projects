/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Formularios.FCliente;
import Modelo.Cliente;
import Modelo.ConsultaCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Jamartinez
 */
public class CtrlCliente implements ActionListener
{
    private Cliente C;
    private ConsultaCliente Cl;
    private FCliente Fc;
    
    public CtrlCliente(Cliente C,ConsultaCliente Cl,FCliente Fc)
    {
    this.C = C;
    this.Cl = Cl;
    this.Fc = Fc;   
      this.Fc.BtnGuardar.addActionListener(this);
      this.Fc.BtnModificar.addActionListener(this);
      this.Fc.BtnEliminar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
         if (e.getSource() == Fc.BtnGuardar)
        {
             C.setCedula(Fc.TxtCedula.getText());
             C.setNombre(Fc.TxtDescripcion.getText());
             C.setDireccion(Fc.TxtDireccion.getText());
             C.setGenero((String)Fc.CmbGenero.getSelectedItem());
        
             if (Cl.Registrar(C))
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
        
        if (e.getSource() == Fc.BtnModificar)
        {
             C.setCedula(Fc.TxtCedula.getText());
             C.setNombre(Fc.TxtDescripcion.getText());
             C.setDireccion(Fc.TxtDireccion.getText());
             C.setGenero((String)Fc.CmbGenero.getSelectedItem());
        
             if (Cl.Modificar(C))
             {
             JOptionPane.showMessageDialog(null, "Registro Modificado"); 
                Limpiar(); 
             }
             else{
            JOptionPane.showMessageDialog(null, "Error al Modificar","Denied",JOptionPane.ERROR_MESSAGE);
                Limpiar(); 
             }
        }
        
        if (e.getSource() == Fc.BtnEliminar)
        {
             C.setCedula(Fc.TxtCedula.getText());
             
             if (Cl.Eliminar(C))
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
          Fc.TxtCedula.setText(null);
          Fc.TxtDescripcion.setText(null);
          Fc.TxtDireccion.setText(null);
        
        }
    
}

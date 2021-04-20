/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Formularios.FConfiguracionSesion;
import Modelo.ConfiguracionSesion;
import Modelo.ConsultaConfigSesion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Jamartinez
 */
public class CtrlConfSesion implements ActionListener
{
    private FConfiguracionSesion Fc;
    private ConfiguracionSesion Config;
    private ConsultaConfigSesion Cconfig;
    
    public CtrlConfSesion(ConfiguracionSesion Config,ConsultaConfigSesion Cconfig,FConfiguracionSesion Fc)
    {
      this.Fc = Fc;
      this.Config = Config;
      this.Cconfig = Cconfig;
      this.Fc.BtnGuardar.addActionListener(this);
      this.Fc.BtnModificar.addActionListener(this);
      this.Fc.BtnEliminar.addActionListener(this);
      this.Fc.BtnBuscar.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == Fc.BtnGuardar) 
        {
             Config.setUsuario(Fc.TxtUser.getText());
             Config.setContrasena(Fc.TxtClave.getText());     
             if (Cconfig.Registrar(Config))
             {              
             JOptionPane.showMessageDialog(null, "Registro Guardado");          
             Limpiar();
             }
             else
             {
             JOptionPane.showMessageDialog(null, "Error al Guardar","Denied",JOptionPane.ERROR_MESSAGE);
             Limpiar();
             }
        }
        
        
                if (e.getSource() == Fc.BtnModificar) 
        {
             Config.setId(Integer.parseInt(Fc.TxtId.getText()));
             Config.setUsuario(Fc.TxtUser.getText());
             Config.setContrasena(Fc.TxtClave.getText());     
             if (Cconfig.Modificar(Config))
             {
                 JOptionPane.showMessageDialog(null, "Registro Modificado");          
                 Limpiar();
             }
             else
             {
             JOptionPane.showMessageDialog(null, "Error al Modificar","Denied",JOptionPane.ERROR_MESSAGE);
             Limpiar();
             }
            
        }
                
                
                
                        if (e.getSource() == Fc.BtnEliminar) 
        {
             Config.setId(Integer.parseInt(Fc.TxtId.getText()));   
             if (Cconfig.Eliminar(Config))
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
                        
                        
                        
                 if (e.getSource() == Fc.BtnBuscar) 
                 {
               Config.setId(Integer.parseInt(Fc.TxtBuscar.getText()));
               if (Cconfig.Buscar(Config))
               {
                   Fc.TxtId.setText(String.valueOf(Config.getId())); 
                   Fc.TxtUser.setText(String.valueOf(Config.getUsuario()));
                   Fc.TxtClave.setText(String.valueOf(Config.getContrasena()));
               }
               else
               {
               JOptionPane.showMessageDialog(null, "No se econtro resultados","Denied",JOptionPane.ERROR_MESSAGE);
               }
            
        }
        
    }
       public void Limpiar()
        {
          Fc.TxtId.setText("0");
          Fc.TxtUser.setText(null);
          Fc.TxtClave.setText(null);      
        }
    
}

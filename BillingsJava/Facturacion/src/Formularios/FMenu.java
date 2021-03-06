/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import static Modelo.Conexion.GetConexion;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRTextExporter;

/**
 *
 * @author Jamartinez
 */
public class FMenu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public FMenu() 
    {
        Iniciar();
        initComponents();
    }
    public void Iniciar()
{
this.setLocationRelativeTo(null);
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JpnlBack = new javax.swing.JPanel();
        BtnProducto = new javax.swing.JButton();
        LblProducto = new javax.swing.JLabel();
        panel1 = new java.awt.Panel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        LblProducto1 = new javax.swing.JLabel();
        BtnCliente = new javax.swing.JButton();
        LblProducto2 = new javax.swing.JLabel();
        BtnVendedor = new javax.swing.JButton();
        BtnProducto3 = new javax.swing.JButton();
        LblProducto3 = new javax.swing.JLabel();
        LblProducto4 = new javax.swing.JLabel();
        BtnProducto4 = new javax.swing.JButton();
        LblProducto5 = new javax.swing.JLabel();
        BtnProducto5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        LblProducto6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("MenuPrincipal"); // NOI18N
        setResizable(false);

        JpnlBack.setBackground(new java.awt.Color(255, 255, 255));

        BtnProducto.setBackground(new java.awt.Color(255, 255, 255));
        BtnProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Producto.png"))); // NOI18N
        BtnProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnProductoActionPerformed(evt);
            }
        });

        LblProducto.setText("Producto");

        panel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-recibo-96.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Menu Principal");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(177, Short.MAX_VALUE))
        );

        jLabel1.getAccessibleContext().setAccessibleName("LblLogo");

        LblProducto1.setText("Cliente");

        BtnCliente.setBackground(new java.awt.Color(255, 255, 255));
        BtnCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-webcam-hombre-96.png"))); // NOI18N
        BtnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnClienteActionPerformed(evt);
            }
        });

        LblProducto2.setText("Vendedor");

        BtnVendedor.setBackground(new java.awt.Color(255, 255, 255));
        BtnVendedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-mostrador-de-facturaci??n-80.png"))); // NOI18N
        BtnVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVendedorActionPerformed(evt);
            }
        });

        BtnProducto3.setBackground(new java.awt.Color(255, 255, 255));
        BtnProducto3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-ajustes-96.png"))); // NOI18N
        BtnProducto3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnProducto3ActionPerformed(evt);
            }
        });

        LblProducto3.setText("Configuracion");

        LblProducto4.setText("Factura");

        BtnProducto4.setBackground(new java.awt.Color(255, 255, 255));
        BtnProducto4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-recibo-96.png"))); // NOI18N
        BtnProducto4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnProducto4ActionPerformed(evt);
            }
        });

        LblProducto5.setText("Consulta");

        BtnProducto5.setBackground(new java.awt.Color(255, 255, 255));
        BtnProducto5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-search-96.png"))); // NOI18N
        BtnProducto5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnProducto5ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-exportar-80.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        LblProducto6.setText("Exportacion");

        javax.swing.GroupLayout JpnlBackLayout = new javax.swing.GroupLayout(JpnlBack);
        JpnlBack.setLayout(JpnlBackLayout);
        JpnlBackLayout.setHorizontalGroup(
            JpnlBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnlBackLayout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(JpnlBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JpnlBackLayout.createSequentialGroup()
                        .addGroup(JpnlBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JpnlBackLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(JpnlBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(BtnProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LblProducto))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(JpnlBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(BtnCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LblProducto1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(JpnlBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(LblProducto2)
                                    .addComponent(BtnVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(JpnlBackLayout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addGroup(JpnlBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(LblProducto4)
                                    .addComponent(BtnProducto4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(JpnlBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(LblProducto5)
                                    .addComponent(BtnProducto5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 83, Short.MAX_VALUE))
                    .addGroup(JpnlBackLayout.createSequentialGroup()
                        .addGroup(JpnlBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JpnlBackLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(JpnlBackLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(LblProducto6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(JpnlBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JpnlBackLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(LblProducto3))
                            .addComponent(BtnProducto3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        JpnlBackLayout.setVerticalGroup(
            JpnlBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(JpnlBackLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(JpnlBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpnlBackLayout.createSequentialGroup()
                        .addComponent(BtnProducto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LblProducto))
                    .addGroup(JpnlBackLayout.createSequentialGroup()
                        .addGroup(JpnlBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(BtnVendedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JpnlBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblProducto1)
                            .addComponent(LblProducto2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(JpnlBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnProducto5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnProducto4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JpnlBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblProducto4)
                    .addComponent(LblProducto5))
                .addGroup(JpnlBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(JpnlBackLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(BtnProducto3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LblProducto3)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpnlBackLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LblProducto6)
                        .addGap(17, 17, 17))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JpnlBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JpnlBack, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(710, 486));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnProductoActionPerformed
        FProducto FProductos = new FProducto();          
            FProductos.setVisible(true);
    }//GEN-LAST:event_BtnProductoActionPerformed

    private void BtnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClienteActionPerformed
            FCliente FClientes = new FCliente();          
            FClientes.setVisible(true);
    }//GEN-LAST:event_BtnClienteActionPerformed

    private void BtnVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVendedorActionPerformed
           FVendedor FVendedors = new FVendedor();          
            FVendedors.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_BtnVendedorActionPerformed

    private void BtnProducto3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnProducto3ActionPerformed
        FConfiguracionSesion FConfiguracionSesions = new FConfiguracionSesion();          
            FConfiguracionSesions.setVisible(true);
    }//GEN-LAST:event_BtnProducto3ActionPerformed

    private void BtnProducto4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnProducto4ActionPerformed
        FFactura FFacturas = new FFactura();
        FFacturas.setVisible(true);
    }//GEN-LAST:event_BtnProducto4ActionPerformed

    private void BtnProducto5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnProducto5ActionPerformed
        FConsulta FExportacions = new FConsulta();
        FExportacions.setVisible(true);
    }//GEN-LAST:event_BtnProducto5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String reportSrcFile = "C:\\Users\\jamartinez\\Documents\\UNAPEC\\2018Enero\\INF111\\Projectos\\Facturacion\\src\\Reporte\\RExportacion.jrxml";
        Connection con = GetConexion();
        try 
        {
            JasperReport jasperReport;
            jasperReport = JasperCompileManager.compileReport(reportSrcFile);
            Map<String, Object> parameters = new HashMap<>(); 
            JasperPrint print;
            print = JasperFillManager.fillReport(jasperReport,parameters,con);
            JRTextExporter exporter = new JRTextExporter();      
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("Reporte.txt"));
            exporter.exportReport();
            JOptionPane.showMessageDialog(null, "Exportacion Completa");
        } 
        catch (JRException ex)
        {
            Logger.getLogger(FConsulta.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCliente;
    private javax.swing.JButton BtnProducto;
    private javax.swing.JButton BtnProducto3;
    private javax.swing.JButton BtnProducto4;
    private javax.swing.JButton BtnProducto5;
    private javax.swing.JButton BtnVendedor;
    private javax.swing.JPanel JpnlBack;
    private javax.swing.JLabel LblProducto;
    private javax.swing.JLabel LblProducto1;
    private javax.swing.JLabel LblProducto2;
    private javax.swing.JLabel LblProducto3;
    private javax.swing.JLabel LblProducto4;
    private javax.swing.JLabel LblProducto5;
    private javax.swing.JLabel LblProducto6;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private java.awt.Panel panel1;
    // End of variables declaration//GEN-END:variables
}

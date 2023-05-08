/*
 * Copyright (C) 2022 Roger Lovera <roger.lovera>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package aplicacion;

import clases.Queries;
import clases.Reports;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import servicios.ConnectionDB;

/**
 *
 * @author Roger Lovera <rloverab@yahoo.es>
 */
public class MDIPrincipal extends javax.swing.JFrame {
    private ConnectionDB conn;
    private Queries queries;
    private Reports reports;

    /**
     * Creates new form MDIPrincipal
     */
    public MDIPrincipal() {
        initComponents();
        
        prepareWindow();
    }    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        itemServicio = new javax.swing.JMenuItem();
        itemConsulta = new javax.swing.JMenuItem();
        itemEstadisticas = new javax.swing.JMenuItem();
        btnUsuarios = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        exitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Servicio de Comedor - Escuela Latinoamericana de Medicina Dr. Salvador Allende");

        fileMenu.setMnemonic('a');
        fileMenu.setText("Archivo");

        itemServicio.setMnemonic('s');
        itemServicio.setText("Servicio");
        itemServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemServicioActionPerformed(evt);
            }
        });
        fileMenu.add(itemServicio);

        itemConsulta.setMnemonic('c');
        itemConsulta.setText("Consulta");
        itemConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemConsultaActionPerformed(evt);
            }
        });
        fileMenu.add(itemConsulta);

        itemEstadisticas.setMnemonic('e');
        itemEstadisticas.setText("Estadísticas");
        itemEstadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEstadisticasActionPerformed(evt);
            }
        });
        fileMenu.add(itemEstadisticas);

        btnUsuarios.setMnemonic('u');
        btnUsuarios.setText("Usuarios");
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });
        fileMenu.add(btnUsuarios);

        jMenuItem1.setMnemonic('h');
        jMenuItem1.setText("Horarios");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem1);
        fileMenu.add(jSeparator1);

        exitMenuItem.setMnemonic('a');
        exitMenuItem.setText("Salir");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void prepareWindow(){
        this.setExtendedState(MAXIMIZED_BOTH);
        conn = new ConnectionDB("localhost", "3306", "sccusuario", "cambiame", "sccdb");
        conn.open();
        queries = new Queries(conn);      
        reports = new Reports(conn);
    }
    
    private void abrirVentana(
            JInternalFrame internalFrame,
            boolean multiplesInstancias) {
        if (multiplesInstancias) {
            this.desktopPane.add(internalFrame);
            internalFrame.setVisible(true);
        } else {
            for (JInternalFrame frame : this.desktopPane.getAllFrames()) {
                if (frame.getClass() == internalFrame.getClass()) {
                    frame.toFront();
                    try {
                        frame.setSelected(true);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(MDIPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    return;
                }
            }
            this.desktopPane.add(internalFrame);
            internalFrame.setVisible(true);
        }
    }
    
    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        conn.close();
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void itemServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemServicioActionPerformed
        abrirVentana(new IFrameServicio(queries), false);
    }//GEN-LAST:event_itemServicioActionPerformed

    private void itemConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemConsultaActionPerformed
        abrirVentana(new IFrameConsulta(queries, reports), false);
    }//GEN-LAST:event_itemConsultaActionPerformed

    private void itemEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEstadisticasActionPerformed
        abrirVentana(new IFrameEstadisticas(reports), false);        
    }//GEN-LAST:event_itemEstadisticasActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        abrirVentana(new IFrameUsuariosServicio(queries), false);
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        abrirVentana(new IFrameHorario(queries), false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(MDIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MDIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MDIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MDIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MDIPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnUsuarios;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem itemConsulta;
    private javax.swing.JMenuItem itemEstadisticas;
    private javax.swing.JMenuItem itemServicio;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

}

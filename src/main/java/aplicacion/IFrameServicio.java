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

import clases.Comida;
import clases.Controls;
import clases.Queries;
import clases.StringTools;
import clases.TimestampTools;
import clases.UsuarioAtendido;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Roger Lovera <rloverab@yahoo.es>
 */
public final class IFrameServicio extends javax.swing.JInternalFrame {

    private Queries queries;
    private Comida comida;
    private List<UsuarioAtendido> usuariosAtendidos;
    private Timestamp timestamp;
    private Timestamp fechaInicio;
    private Timestamp fechaFinal;
    private MonitorThread monitorThread;

    /**
     * Creates new form Servicio
     */
    public IFrameServicio() {
        initComponents();
    }

    public IFrameServicio(Queries queries) {
        this();               
        
        this.queries = queries;
        comida = queries.getComidaActual();
        timestamp = queries.getTimestamp();

        if (comida != null) {
            fechaInicio = TimestampTools.getTimestamp(
                    timestamp.getTime(),
                    comida.getInicio().getTime());
            fechaFinal = TimestampTools.getTimestamp(
                    timestamp.getTime(),
                    comida.getFin().getTime());
        }
        
        prepareWindow();
        
        monitorThread = new MonitorThread(this);
        Thread thread = new Thread(monitorThread);
        thread.start();
            
        
    }

    public void prepareWindow() {
        if (comida != null) {
            lblServicio.setText(comida.getComida());
            txtDocumentoIdentidad.setEnabled(true);
            btnAtender.setEnabled(true);
            refresh();
        } else {
            lblServicio.setText("Cerrado");
            txtDocumentoIdentidad.setEnabled(false);
            btnAtender.setEnabled(false);
            usuariosAtendidos = new ArrayList<>();
        }

        fillTableUsuariosAtendidos();
    }

    public Queries getQueries() {
        return queries;
    }

    public void setComida(Comida comida) {
        this.comida = comida;
    }

    public Comida getComida() {
        return comida;
    }
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtDocumentoIdentidad = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblServicio = new javax.swing.JLabel();
        btnAtender = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuariosAtendidos = new javax.swing.JTable();

        setTitle("Servicio");
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        txtDocumentoIdentidad.setBackground(new java.awt.Color(0, 0, 0));
        txtDocumentoIdentidad.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        txtDocumentoIdentidad.setForeground(new java.awt.Color(255, 255, 255));
        txtDocumentoIdentidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocumentoIdentidadActionPerformed(evt);
            }
        });
        txtDocumentoIdentidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDocumentoIdentidadKeyTyped(evt);
            }
        });

        jLabel1.setText("Documento de identidad");

        jLabel2.setText("Servicio:");

        lblServicio.setText("jLabel3");

        btnAtender.setText("Atender");
        btnAtender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtenderActionPerformed(evt);
            }
        });

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblServicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDocumentoIdentidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAtender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDocumentoIdentidad)
                    .addComponent(btnAtender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblServicio)
                    .addComponent(jLabel2)
                    .addComponent(btnCerrar))
                .addContainerGap())
        );

        tblUsuariosAtendidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "DI", "Usuario", "Pais", "Tipo", "Hora"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblUsuariosAtendidos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atender() {
        String documentoIdentidad;
        String _title = "Atención al usuario";
        
        documentoIdentidad = txtDocumentoIdentidad.getText();

        if (documentoIdentidad == null || documentoIdentidad.isBlank()) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Por favor, indique un documento de identidad.",
                    _title,
                    JOptionPane.ERROR_MESSAGE);
        } else {
            String message = "";
            int messageType = -1;

            if (comida == null) {
                message = "El servicio se encuentra cerrado en este momento";
                messageType = JOptionPane.ERROR_MESSAGE;
            } else {
                int insertServicio = queries.insertServicio(documentoIdentidad, comida.getId());

                switch (insertServicio) {
                    case 0:
                        message = "Datos del usuario registrado correctamente";
                        messageType = JOptionPane.INFORMATION_MESSAGE;
                        refresh();
                        break;
                    case 1:
                        message = "El usuario no está registrado o no se encuentra activo.";
                        messageType = JOptionPane.ERROR_MESSAGE;
                        break;
                    case 2:
                        message = "El usuario ya fue atendido.";
                        messageType = JOptionPane.ERROR_MESSAGE;
                        break;
                    default:
                }
            }

            if (!message.isBlank()) {
                JOptionPane.showInternalMessageDialog(this, message, _title, messageType);
            }
        }
        
        txtDocumentoIdentidad.requestFocus();
    }

    private void close() {
        int response;
        if (!txtDocumentoIdentidad.getText().isBlank()) {
            response = JOptionPane.showInternalConfirmDialog(
                    this, "¿Desea cerrar esta ventana?",
                    "Advertencia",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                dispose();
            }
        } else {
            monitorThread.saveStop();
            dispose();
        }
    }

    private void refresh() {
        txtDocumentoIdentidad.setText("");
        //usuariosAtendidos =queries.getUsuarioAtendidos(comida);
        usuariosAtendidos = queries.getUsuariosAtendidos(
                null,
                null,
                null,
                null,
                comida.getId(),
                fechaInicio,
                fechaFinal);
        Collections.sort(usuariosAtendidos, (e1, e2) -> e2.getFechaHoraAtencion().compareTo(e1.getFechaHoraAtencion()));
        fillTableUsuariosAtendidos();
    }
    
    private void fillTableUsuariosAtendidos() {
        DefaultTableModel dtm;

        Controls.removeAllRowsTable(tblUsuariosAtendidos);
        dtm = (DefaultTableModel) tblUsuariosAtendidos.getModel();

        usuariosAtendidos.forEach(usuario -> {
            Object[] row;

            row = new Object[]{
                usuario.getDocumentoIdentidad(),
                String.format(
                "%s, %s",
                usuario.getApellido1().toUpperCase(),
                StringTools.proper(usuario.getNombre1().toUpperCase())),
                usuario.getPais().getPais(),
                usuario.getTipoUsuario(),
                usuario.getFechaHoraAtencion("hh:mm:ss a")
            };

            dtm.addRow(row);
        });
    }

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        close();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void txtDocumentoIdentidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocumentoIdentidadKeyTyped
        char key;
        key = evt.getKeyChar();

        if (!StringTools.isAlphanumeric(key)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDocumentoIdentidadKeyTyped

    private void btnAtenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtenderActionPerformed
        atender();
    }//GEN-LAST:event_btnAtenderActionPerformed

    private void txtDocumentoIdentidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocumentoIdentidadActionPerformed
        atender();
    }//GEN-LAST:event_txtDocumentoIdentidadActionPerformed

    class MonitorThread implements Runnable {        
        private final IFrameServicio iFrameServicio;
        private boolean running;
        private final Queries queries;

        public MonitorThread(IFrameServicio iFrameServicio) {
            this.iFrameServicio = iFrameServicio;
            queries = iFrameServicio.getQueries();
            running = true;
        }

        public void saveStop() {
            this.running = false;
        }

        @Override
        public void run() {
            while (running) {
                Comida comidaActual;
                Comida comidaOld;
                
                comidaActual = queries.getComidaActual();
                comidaOld = iFrameServicio.getComida();
                
                if(comidaActual == null){
                    iFrameServicio.setComida(null);
                    iFrameServicio.prepareWindow();
                }else{
                    if(comidaOld == null){
                        iFrameServicio.setComida(comidaActual);
                        iFrameServicio.prepareWindow();
                    }else{
                        if(comidaActual.hashCode() != comidaOld.hashCode()){
                            iFrameServicio.setComida(comidaActual);
                            iFrameServicio.prepareWindow();
                        }
                    }                    
                }                

                try {
                    Thread.sleep(2500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(IFrameServicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtender;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblServicio;
    private javax.swing.JTable tblUsuariosAtendidos;
    private javax.swing.JTextField txtDocumentoIdentidad;
    // End of variables declaration//GEN-END:variables
}

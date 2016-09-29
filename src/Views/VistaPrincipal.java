/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

/**
 *
 * @author Eduardo
 */
public class VistaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VistaPrincipal
     */
    public VistaPrincipal() {
        this.setExtendedState(MAXIMIZED_BOTH);
        initComponents();
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jButtonPanes = new javax.swing.JButton();
        jButtonVentas = new javax.swing.JButton();
        jButtonInventario = new javax.swing.JButton();
        jButtonReporte = new javax.swing.JButton();
        jLabelHora = new javax.swing.JLabel();
        jLabelFecha = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane1.setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(150, 67, 12));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jButtonPanes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/panes.png"))); // NOI18N
        jButtonPanes.setActionCommand("Panes");
        jButtonPanes.setBorder(null);
        jButtonPanes.setBorderPainted(false);
        jButtonPanes.setContentAreaFilled(false);
        jButtonPanes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonPanes.setFocusPainted(false);
        jButtonPanes.setRequestFocusEnabled(false);
        jButtonPanes.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/panesHover.png"))); // NOI18N
        jButtonPanes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPanesActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 162, 22, 0);
        jPanel1.add(jButtonPanes, gridBagConstraints);

        jButtonVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ventas2.png"))); // NOI18N
        jButtonVentas.setActionCommand("Ventas");
        jButtonVentas.setBorder(null);
        jButtonVentas.setBorderPainted(false);
        jButtonVentas.setContentAreaFilled(false);
        jButtonVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonVentas.setFocusPainted(false);
        jButtonVentas.setFocusable(false);
        jButtonVentas.setRequestFocusEnabled(false);
        jButtonVentas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ventas2Hover.png"))); // NOI18N
        jButtonVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVentasActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 160, 22, 0);
        jPanel1.add(jButtonVentas, gridBagConstraints);

        jButtonInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/inventario2.png"))); // NOI18N
        jButtonInventario.setActionCommand("Inventario");
        jButtonInventario.setBorder(null);
        jButtonInventario.setContentAreaFilled(false);
        jButtonInventario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonInventario.setFocusable(false);
        jButtonInventario.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/inventarioHover2.png"))); // NOI18N
        jButtonInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInventarioActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        jPanel1.add(jButtonInventario, gridBagConstraints);

        jButtonReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/graficas2.png"))); // NOI18N
        jButtonReporte.setActionCommand("Reporte");
        jButtonReporte.setBorder(null);
        jButtonReporte.setContentAreaFilled(false);
        jButtonReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonReporte.setFocusPainted(false);
        jButtonReporte.setFocusable(false);
        jButtonReporte.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/graficasHover2.png"))); // NOI18N
        jButtonReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReporteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.ipady = -4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 160, 0, 43);
        jPanel1.add(jButtonReporte, gridBagConstraints);

        jLabelHora.setBackground(new java.awt.Color(150, 67, 12));
        jLabelHora.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabelHora.setForeground(new java.awt.Color(255, 251, 245));
        jLabelHora.setOpaque(true);

        jLabelFecha.setBackground(new java.awt.Color(150, 67, 12));
        jLabelFecha.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabelFecha.setForeground(new java.awt.Color(255, 251, 245));
        jLabelFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFecha.setOpaque(true);

        jPanel2.setBackground(new java.awt.Color(255, 251, 245));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/superFondo3.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = -4;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 3);
        jPanel2.add(jLabel1, gridBagConstraints);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jLabelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelHora, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(jLabelFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelHora, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelFecha, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInventarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonInventarioActionPerformed

    private void jButtonReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReporteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonReporteActionPerformed

    private void jButtonPanesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPanesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonPanesActionPerformed

    private void jButtonVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonVentasActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonInventario;
    public javax.swing.JButton jButtonPanes;
    public javax.swing.JButton jButtonReporte;
    public javax.swing.JButton jButtonVentas;
    public javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabelFecha;
    public javax.swing.JLabel jLabelHora;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
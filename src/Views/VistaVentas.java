package Views;

public class VistaVentas extends javax.swing.JInternalFrame {


    public VistaVentas() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanelFondo = new javax.swing.JPanel();
        jButtonCerrar = new javax.swing.JButton();
        jTextFieldCodigoBarras = new javax.swing.JTextField();
        jTextFieldCantidadProducto = new javax.swing.JTextField();
        jTextFieldPrecioProducto = new javax.swing.JTextField();
        jTextFieldSumaCantidadPorPrecio = new javax.swing.JTextField();
        jButtonAgregar = new javax.swing.JButton();
        jButtonQuitar = new javax.swing.JButton();
        jButtonConfirmar = new javax.swing.JButton();
        jTextFieldNombreProducto = new javax.swing.JLabel();
        jTextFieldIdPan = new javax.swing.JLabel();
        jLabelTotal = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabelMensaje = new javax.swing.JLabel();
        jLabelIdVenta = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelImagen = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 153));
        setOpaque(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanelFondo.setBackground(new java.awt.Color(238, 220, 208));
        jPanelFondo.setLayout(null);

        jButtonCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/botonCerrar.png"))); // NOI18N
        jButtonCerrar.setActionCommand("Cerrar");
        jButtonCerrar.setBorder(null);
        jButtonCerrar.setBorderPainted(false);
        jButtonCerrar.setContentAreaFilled(false);
        jButtonCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCerrar.setFocusPainted(false);
        jButtonCerrar.setFocusable(false);
        jButtonCerrar.setRequestFocusEnabled(false);
        jButtonCerrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/botonCerrarHover.png"))); // NOI18N
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarActionPerformed(evt);
            }
        });
        jPanelFondo.add(jButtonCerrar);
        jButtonCerrar.setBounds(10, 420, 53, 50);

        jTextFieldCodigoBarras.setBackground(new java.awt.Color(51, 51, 51));
        jTextFieldCodigoBarras.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jTextFieldCodigoBarras.setForeground(java.awt.Color.white);
        jTextFieldCodigoBarras.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldCodigoBarras.setBorder(null);
        jTextFieldCodigoBarras.setCaretColor(new java.awt.Color(255, 255, 255));
        jTextFieldCodigoBarras.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jTextFieldCodigoBarras.setFocusCycleRoot(true);
        jTextFieldCodigoBarras.setFocusTraversalPolicyProvider(true);
        jTextFieldCodigoBarras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCodigoBarrasActionPerformed(evt);
            }
        });
        jPanelFondo.add(jTextFieldCodigoBarras);
        jTextFieldCodigoBarras.setBounds(100, 110, 210, 30);

        jTextFieldCantidadProducto.setBackground(new java.awt.Color(51, 51, 51));
        jTextFieldCantidadProducto.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jTextFieldCantidadProducto.setForeground(java.awt.Color.white);
        jTextFieldCantidadProducto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldCantidadProducto.setBorder(null);
        jTextFieldCantidadProducto.setCaretColor(new java.awt.Color(255, 255, 255));
        jTextFieldCantidadProducto.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jPanelFondo.add(jTextFieldCantidadProducto);
        jTextFieldCantidadProducto.setBounds(100, 190, 210, 30);

        jTextFieldPrecioProducto.setBackground(new java.awt.Color(51, 51, 51));
        jTextFieldPrecioProducto.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jTextFieldPrecioProducto.setForeground(java.awt.Color.white);
        jTextFieldPrecioProducto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldPrecioProducto.setBorder(null);
        jTextFieldPrecioProducto.setCaretColor(new java.awt.Color(255, 255, 255));
        jTextFieldPrecioProducto.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jPanelFondo.add(jTextFieldPrecioProducto);
        jTextFieldPrecioProducto.setBounds(100, 270, 210, 30);

        jTextFieldSumaCantidadPorPrecio.setBackground(new java.awt.Color(51, 51, 51));
        jTextFieldSumaCantidadPorPrecio.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jTextFieldSumaCantidadPorPrecio.setForeground(java.awt.Color.white);
        jTextFieldSumaCantidadPorPrecio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldSumaCantidadPorPrecio.setBorder(null);
        jTextFieldSumaCantidadPorPrecio.setCaretColor(new java.awt.Color(255, 255, 255));
        jTextFieldSumaCantidadPorPrecio.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jPanelFondo.add(jTextFieldSumaCantidadPorPrecio);
        jTextFieldSumaCantidadPorPrecio.setBounds(100, 350, 210, 30);

        jButtonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btnAgregar2.png"))); // NOI18N
        jButtonAgregar.setActionCommand("Agregar");
        jButtonAgregar.setBorder(null);
        jButtonAgregar.setBorderPainted(false);
        jButtonAgregar.setContentAreaFilled(false);
        jButtonAgregar.setFocusPainted(false);
        jButtonAgregar.setRequestFocusEnabled(false);
        jButtonAgregar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btnAgregarHover2.png"))); // NOI18N
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });
        jPanelFondo.add(jButtonAgregar);
        jButtonAgregar.setBounds(260, 420, 56, 47);

        jButtonQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btnQuitar2.png"))); // NOI18N
        jButtonQuitar.setActionCommand("Quitar");
        jButtonQuitar.setBorder(null);
        jButtonQuitar.setBorderPainted(false);
        jButtonQuitar.setContentAreaFilled(false);
        jButtonQuitar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonQuitar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btnQuitarHover2.png"))); // NOI18N
        jButtonQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuitarActionPerformed(evt);
            }
        });
        jPanelFondo.add(jButtonQuitar);
        jButtonQuitar.setBounds(170, 420, 56, 47);

        jButtonConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btnAceptar2.png"))); // NOI18N
        jButtonConfirmar.setActionCommand("Confirmar");
        jButtonConfirmar.setBorder(null);
        jButtonConfirmar.setContentAreaFilled(false);
        jButtonConfirmar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonConfirmar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btnAceptarHover2.png"))); // NOI18N
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });
        jPanelFondo.add(jButtonConfirmar);
        jButtonConfirmar.setBounds(90, 420, 56, 47);

        jTextFieldNombreProducto.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jTextFieldNombreProducto.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldNombreProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanelFondo.add(jTextFieldNombreProducto);
        jTextFieldNombreProducto.setBounds(620, 30, 210, 40);

        jTextFieldIdPan.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jTextFieldIdPan.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldIdPan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanelFondo.add(jTextFieldIdPan);
        jTextFieldIdPan.setBounds(440, 30, 60, 40);

        jLabelTotal.setBackground(new java.awt.Color(22, 21, 21));
        jLabelTotal.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabelTotal.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanelFondo.add(jLabelTotal);
        jLabelTotal.setBounds(1200, 430, 130, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LABELtotal.png"))); // NOI18N
        jPanelFondo.add(jLabel2);
        jLabel2.setBounds(1100, 420, 242, 60);

        jTable.setBackground(new java.awt.Color(23, 23, 23));
        jTable.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jTable.setForeground(new java.awt.Color(255, 255, 255));
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ARTICULO", "CANTIDAD", "PRECIO", "IMPORTE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable);
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(0).setResizable(false);
            jTable.getColumnModel().getColumn(1).setResizable(false);
            jTable.getColumnModel().getColumn(2).setResizable(false);
            jTable.getColumnModel().getColumn(3).setResizable(false);
            jTable.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanelFondo.add(jScrollPane1);
        jScrollPane1.setBounds(630, 100, 710, 290);

        jLabelMensaje.setBackground(new java.awt.Color(22, 21, 21));
        jLabelMensaje.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelMensaje.setForeground(new java.awt.Color(255, 255, 255));
        jPanelFondo.add(jLabelMensaje);
        jLabelMensaje.setBounds(920, 30, 350, 40);

        jLabelIdVenta.setBackground(new java.awt.Color(22, 21, 21));
        jLabelIdVenta.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabelIdVenta.setForeground(new java.awt.Color(0, 0, 0));
        jLabelIdVenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanelFondo.add(jLabelIdVenta);
        jLabelIdVenta.setBounds(180, 30, 130, 40);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconLabelVentasId.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setRequestFocusEnabled(false);
        jPanelFondo.add(jButton1);
        jButton1.setBounds(10, 100, 50, 47);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconLabelVentasCantidad.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusPainted(false);
        jButton2.setRequestFocusEnabled(false);
        jPanelFondo.add(jButton2);
        jButton2.setBounds(10, 180, 50, 47);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconLabelVentasPrecio.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusPainted(false);
        jPanelFondo.add(jButton3);
        jButton3.setBounds(10, 260, 50, 47);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconLabelVentasTotal.png"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton4.setFocusPainted(false);
        jButton4.setRequestFocusEnabled(false);
        jPanelFondo.add(jButton4);
        jButton4.setBounds(10, 340, 50, 47);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/mensaje.png"))); // NOI18N
        jPanelFondo.add(jLabel1);
        jLabel1.setBounds(850, 26, 490, 50);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/labelIDventas2.png"))); // NOI18N
        jPanelFondo.add(jLabel3);
        jLabel3.setBounds(10, 20, 310, 60);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/labelidpanproducto.png"))); // NOI18N
        jPanelFondo.add(jLabel4);
        jLabel4.setBounds(340, 20, 498, 60);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/labelCajas.png"))); // NOI18N
        jPanelFondo.add(jLabel5);
        jLabel5.setBounds(90, 100, 230, 48);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/labelCajas.png"))); // NOI18N
        jPanelFondo.add(jLabel6);
        jLabel6.setBounds(90, 180, 230, 48);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/labelCajas.png"))); // NOI18N
        jLabel7.setText("jLabel7");
        jPanelFondo.add(jLabel7);
        jLabel7.setBounds(90, 260, 230, 48);

        jLabelImagen.setBackground(new java.awt.Color(51, 51, 51));
        jLabelImagen.setOpaque(true);
        jPanelFondo.add(jLabelImagen);
        jLabelImagen.setBounds(350, 110, 260, 270);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/labelImagen.png"))); // NOI18N
        jLabel9.setText("jLabel9");
        jPanelFondo.add(jLabel9);
        jLabel9.setBounds(340, 100, 290, 290);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/labelCajas.png"))); // NOI18N
        jLabel8.setText("jLabel8");
        jPanelFondo.add(jLabel8);
        jLabel8.setBounds(90, 340, 230, 48);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 1355;
        gridBagConstraints.ipady = 553;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        getContentPane().add(jPanelFondo, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldCodigoBarrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodigoBarrasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCodigoBarrasActionPerformed

    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCerrarActionPerformed

    private void jButtonQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonQuitarActionPerformed

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonConfirmarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    public javax.swing.JButton jButtonAgregar;
    public javax.swing.JButton jButtonCerrar;
    public javax.swing.JButton jButtonConfirmar;
    public javax.swing.JButton jButtonQuitar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JLabel jLabelIdVenta;
    public javax.swing.JLabel jLabelImagen;
    public javax.swing.JLabel jLabelMensaje;
    public javax.swing.JLabel jLabelTotal;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable;
    public javax.swing.JTextField jTextFieldCantidadProducto;
    public javax.swing.JTextField jTextFieldCodigoBarras;
    public javax.swing.JLabel jTextFieldIdPan;
    public javax.swing.JLabel jTextFieldNombreProducto;
    public javax.swing.JTextField jTextFieldPrecioProducto;
    public javax.swing.JTextField jTextFieldSumaCantidadPorPrecio;
    // End of variables declaration//GEN-END:variables
}

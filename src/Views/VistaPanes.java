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
public class VistaPanes extends javax.swing.JInternalFrame {

    /**
     * Creates new form VistaPanes
     */
    public VistaPanes() {
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

        jPanelFondo = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePanes = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtIdPan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtPrecioVenta = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPrecioProduccion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        txtCodigoPan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();

        jPanelFondo.setBackground(javax.swing.UIManager.getDefaults().getColor("ToolTip.background"));
        jPanelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCerrar.setForeground(new java.awt.Color(255, 51, 51));
        btnCerrar.setText("Cerrar");
        jPanelFondo.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, -1, -1));

        jTablePanes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTablePanes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePanesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePanes);

        jPanelFondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, 700, 140));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1466760798_Add.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        jPanelFondo.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, -1, -1));

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1466760662_Refresh.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanelFondo.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, -1, -1));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1466760575_Cancel.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        jPanelFondo.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 60, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
        );

        jPanelFondo.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 440, 290));

        jPanel2.setBackground(javax.swing.UIManager.getDefaults().getColor("ToolTip.background"));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(txtIdPan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 210, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Nueva Std", 1, 18)); // NOI18N
        jLabel3.setText("Descripcion");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Nueva Std", 1, 18)); // NOI18N
        jLabel5.setText("Precio Venta");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 210, -1));
        jPanel2.add(txtPrecioVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 210, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Nueva Std", 1, 18)); // NOI18N
        jLabel1.setText("Codigo Pan");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel6.setFont(new java.awt.Font("Nueva Std", 1, 18)); // NOI18N
        jLabel6.setText("Id Pan");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));
        jPanel2.add(txtPrecioProduccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 210, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Nueva Std", 1, 18)); // NOI18N
        jLabel4.setText("Precio Produccion");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));
        jPanel2.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 210, -1));
        jPanel2.add(txtCodigoPan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 210, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Nueva Std", 1, 18)); // NOI18N
        jLabel2.setText("Nombre");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jPanelFondo.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 240, 330));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1466760632_Preview.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        jPanelFondo.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 60, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void jTablePanesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePanesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTablePanesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnCerrar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTablePanes;
    public javax.swing.JTextField txtCodigoPan;
    public javax.swing.JTextField txtDescripcion;
    public javax.swing.JTextField txtIdPan;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtPrecioProduccion;
    public javax.swing.JTextField txtPrecioVenta;
    // End of variables declaration//GEN-END:variables
}

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
public class VistaLogin extends javax.swing.JFrame {
    public VistaLogin() {
        initComponents();
        setLocationRelativeTo(null);
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jTextField2 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldUser = new javax.swing.JTextField();
        jTextFieldPassword = new javax.swing.JPasswordField();
        jButtonEntrar = new javax.swing.JButton();
        jLabelMensaje = new javax.swing.JLabel();
        jLabelMensajeFondo = new javax.swing.JLabel();
        jLabelLogo = new javax.swing.JLabel();

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(90, 30, 1));

        jPanel2.setBackground(new java.awt.Color(90, 30, 1));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(90, 30, 1));
        jPanel1.setLayout(null);

        jTextFieldUser.setBackground(new java.awt.Color(255, 225, 131));
        jTextFieldUser.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jTextFieldUser.setForeground(new java.awt.Color(116, 36, 0));
        jTextFieldUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldUser.setBorder(null);
        jPanel1.add(jTextFieldUser);
        jTextFieldUser.setBounds(107, 294, 195, 38);

        jTextFieldPassword.setBackground(new java.awt.Color(255, 225, 131));
        jTextFieldPassword.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTextFieldPassword.setForeground(new java.awt.Color(103, 35, 0));
        jTextFieldPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldPassword.setBorder(null);
        jPanel1.add(jTextFieldPassword);
        jTextFieldPassword.setBounds(107, 350, 195, 38);

        jButtonEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btnLogin2.png"))); // NOI18N
        jButtonEntrar.setActionCommand("Entrar");
        jButtonEntrar.setBorder(null);
        jButtonEntrar.setBorderPainted(false);
        jButtonEntrar.setContentAreaFilled(false);
        jButtonEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEntrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btnLoginHover2.png"))); // NOI18N
        jPanel1.add(jButtonEntrar);
        jButtonEntrar.setBounds(107, 406, 195, 57);

        jLabelMensaje.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelMensaje.setForeground(new java.awt.Color(204, 51, 0));
        jLabelMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabelMensaje);
        jLabelMensaje.setBounds(110, 500, 190, 30);

        jLabelMensajeFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fondoMensajeLogin.png"))); // NOI18N
        jPanel1.add(jLabelMensajeFondo);
        jLabelMensajeFondo.setBounds(110, 462, 200, 110);

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logopana.png"))); // NOI18N
        jPanel1.add(jLabelLogo);
        jLabelLogo.setBounds(69, 25, 251, 251);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 409;
        gridBagConstraints.ipady = 639;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 18, 14);
        jPanel2.add(jPanel1, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonEntrar;
    private javax.swing.JLabel jLabelLogo;
    public javax.swing.JLabel jLabelMensaje;
    public javax.swing.JLabel jLabelMensajeFondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField2;
    public javax.swing.JPasswordField jTextFieldPassword;
    public javax.swing.JTextField jTextFieldUser;
    // End of variables declaration//GEN-END:variables
}

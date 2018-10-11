package view;

import javax.swing.JFrame;

/**
 *
 * @author Programador-03
 */
public class FormConta extends javax.swing.JFrame {

    public FormConta() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        Nome = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jTextFieldEmail = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        Email = new javax.swing.JLabel();
        User = new javax.swing.JLabel();
        jTextFieldUser = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        Senha = new javax.swing.JLabel();
        jPasswordFieldSenha = new javax.swing.JPasswordField();
        jSeparator6 = new javax.swing.JSeparator();
        jPasswordFieldSenhaRetry = new javax.swing.JPasswordField();
        jSeparator7 = new javax.swing.JSeparator();
        Retry_senha = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        Cadastrar = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        Cancel = new javax.swing.JLabel();
        Voltar = new javax.swing.JLabel();
        Logo = new javax.swing.JLabel();
        Novo_cadastro2 = new javax.swing.JLabel();
        fechar = new javax.swing.JLabel();
        minimizar = new javax.swing.JLabel();
        fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        Nome.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        Nome.setForeground(new java.awt.Color(0, 77, 64));
        Nome.setText("nome");

        jTextFieldName.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTextFieldName.setForeground(new java.awt.Color(0, 77, 64));
        jTextFieldName.setText("Digite seu nome");
        jTextFieldName.setBorder(null);
        jTextFieldName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldNameMouseClicked(evt);
            }
        });
        jTextFieldName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNameActionPerformed(evt);
            }
        });

        jSeparator3.setForeground(new java.awt.Color(0, 77, 64));

        jTextFieldEmail.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTextFieldEmail.setForeground(new java.awt.Color(0, 77, 64));
        jTextFieldEmail.setText("Digite seu e-mail");
        jTextFieldEmail.setBorder(null);
        jTextFieldEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldEmailMouseClicked(evt);
            }
        });
        jTextFieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEmailActionPerformed(evt);
            }
        });

        jSeparator4.setForeground(new java.awt.Color(0, 77, 64));

        Email.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        Email.setForeground(new java.awt.Color(0, 77, 64));
        Email.setText("e-mail");

        User.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        User.setForeground(new java.awt.Color(0, 77, 64));
        User.setText("usuário");

        jTextFieldUser.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTextFieldUser.setForeground(new java.awt.Color(0, 77, 64));
        jTextFieldUser.setText("Digite um usuário");
        jTextFieldUser.setBorder(null);
        jTextFieldUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldUserMouseClicked(evt);
            }
        });
        jTextFieldUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUserActionPerformed(evt);
            }
        });

        jSeparator5.setForeground(new java.awt.Color(0, 77, 64));

        Senha.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        Senha.setForeground(new java.awt.Color(0, 77, 64));
        Senha.setText("senha");

        jPasswordFieldSenha.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPasswordFieldSenha.setForeground(new java.awt.Color(0, 77, 64));
        jPasswordFieldSenha.setText("jPasswordField1");
        jPasswordFieldSenha.setBorder(null);
        jPasswordFieldSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPasswordFieldSenhaMouseClicked(evt);
            }
        });
        jPasswordFieldSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldSenhaActionPerformed(evt);
            }
        });

        jSeparator6.setForeground(new java.awt.Color(0, 77, 64));

        jPasswordFieldSenhaRetry.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPasswordFieldSenhaRetry.setForeground(new java.awt.Color(0, 77, 64));
        jPasswordFieldSenhaRetry.setText("jPasswordField1");
        jPasswordFieldSenhaRetry.setBorder(null);
        jPasswordFieldSenhaRetry.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPasswordFieldSenhaRetryMouseClicked(evt);
            }
        });
        jPasswordFieldSenhaRetry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldSenhaRetryActionPerformed(evt);
            }
        });

        jSeparator7.setForeground(new java.awt.Color(0, 77, 64));

        Retry_senha.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        Retry_senha.setForeground(new java.awt.Color(0, 77, 64));
        Retry_senha.setText("repita senha");

        jPanel5.setBackground(new java.awt.Color(51, 105, 30));

        Cadastrar.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        Cadastrar.setForeground(new java.awt.Color(255, 255, 255));
        Cadastrar.setText("cadastrar");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Cadastrar)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(Cadastrar)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(214, 0, 0));

        Cancel.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        Cancel.setForeground(new java.awt.Color(255, 255, 255));
        Cancel.setText("CANCEL");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(Cancel)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(Cancel)
                .addContainerGap())
        );

        Voltar.setFont(new java.awt.Font("Perpetua Titling MT", 1, 10)); // NOI18N
        Voltar.setForeground(new java.awt.Color(0, 77, 64));
        Voltar.setText("voltar tela login");
        Voltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VoltarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Nome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldName)
                                .addComponent(jSeparator3)
                                .addComponent(Email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldEmail)
                                .addComponent(jSeparator4)
                                .addComponent(User, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldUser)
                                .addComponent(jSeparator5)
                                .addComponent(Senha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPasswordFieldSenha)
                                .addComponent(jSeparator6)
                                .addComponent(Retry_senha, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                                .addComponent(jPasswordFieldSenhaRetry))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(Voltar)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(Nome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Email)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(User)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Senha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Retry_senha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordFieldSenhaRetry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(Voltar)
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 136, 510, 550));

        Logo.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        Logo.setForeground(new java.awt.Color(255, 255, 255));
        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Sergeant_SGT_60px_1.png"))); // NOI18N
        Logo.setText("sgva");
        getContentPane().add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, 40));

        Novo_cadastro2.setFont(new java.awt.Font("Perpetua Titling MT", 1, 10)); // NOI18N
        Novo_cadastro2.setForeground(new java.awt.Color(255, 255, 255));
        Novo_cadastro2.setText("cadastrar novo parceiro");
        getContentPane().add(Novo_cadastro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, -1, 18));

        fechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Delete_16px_1.png"))); // NOI18N
        fechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fecharMouseClicked(evt);
            }
        });
        getContentPane().add(fechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 20, -1));

        minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Subtract_16px_1.png"))); // NOI18N
        minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizarMouseClicked(evt);
            }
        });
        getContentPane().add(minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, -1, -1));

        fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Ativo 4.png"))); // NOI18N
        getContentPane().add(fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 130));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VoltarMouseClicked
        Login telaLogin = new Login();
        telaLogin.setVisible(true);
        telaLogin.pack();
        telaLogin.setLocationRelativeTo(null);
        telaLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_VoltarMouseClicked

    private void jPasswordFieldSenhaRetryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldSenhaRetryActionPerformed
        jPasswordFieldSenhaRetry.setText("");
    }//GEN-LAST:event_jPasswordFieldSenhaRetryActionPerformed

    private void jPasswordFieldSenhaRetryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordFieldSenhaRetryMouseClicked
        jPasswordFieldSenhaRetry.setText("");
    }//GEN-LAST:event_jPasswordFieldSenhaRetryMouseClicked

    private void jPasswordFieldSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldSenhaActionPerformed
        jPasswordFieldSenha.setText("");
    }//GEN-LAST:event_jPasswordFieldSenhaActionPerformed

    private void jPasswordFieldSenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordFieldSenhaMouseClicked
        jPasswordFieldSenha.setText("");
    }//GEN-LAST:event_jPasswordFieldSenhaMouseClicked

    private void jTextFieldUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUserActionPerformed
        jTextFieldUser.setText("");
    }//GEN-LAST:event_jTextFieldUserActionPerformed

    private void jTextFieldUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldUserMouseClicked
        jTextFieldUser.setText("");
    }//GEN-LAST:event_jTextFieldUserMouseClicked

    private void jTextFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEmailActionPerformed
        jTextFieldEmail.setText("");
    }//GEN-LAST:event_jTextFieldEmailActionPerformed

    private void jTextFieldEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldEmailMouseClicked
        jTextFieldEmail.setText("");
    }//GEN-LAST:event_jTextFieldEmailMouseClicked

    private void jTextFieldNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNameActionPerformed
        jTextFieldName.setText("");
    }//GEN-LAST:event_jTextFieldNameActionPerformed

    private void jTextFieldNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldNameMouseClicked
        jTextFieldName.setText("");
    }//GEN-LAST:event_jTextFieldNameMouseClicked

    private void fecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fecharMouseClicked
        this.dispose();
        Login login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_fecharMouseClicked

    private void minimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimizarMouseClicked

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
            java.util.logging.Logger.getLogger(FormConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormConta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cadastrar;
    private javax.swing.JLabel Cancel;
    private javax.swing.JLabel Email;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel Nome;
    private javax.swing.JLabel Novo_cadastro2;
    private javax.swing.JLabel Retry_senha;
    private javax.swing.JLabel Senha;
    private javax.swing.JLabel User;
    private javax.swing.JLabel Voltar;
    private javax.swing.JLabel fechar;
    private javax.swing.JLabel fundo;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPasswordField jPasswordFieldSenha;
    private javax.swing.JPasswordField jPasswordFieldSenhaRetry;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldUser;
    private javax.swing.JLabel minimizar;
    // End of variables declaration//GEN-END:variables
}

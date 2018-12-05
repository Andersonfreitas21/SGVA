package view;

import javax.swing.JFrame;

/**
 *
 * @author Programador-03
 */
public class Form_Func extends javax.swing.JFrame {

    public Form_Func() {
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
        jTextFieldCpf = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        Email = new javax.swing.JLabel();
        User = new javax.swing.JLabel();
        jTextFieldLogin = new javax.swing.JTextField();
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

        Nome.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Nome.setForeground(new java.awt.Color(0, 77, 64));
        Nome.setText("NOME");

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

        jTextFieldCpf.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTextFieldCpf.setForeground(new java.awt.Color(0, 77, 64));
        jTextFieldCpf.setText("Digite seu CPF");
        jTextFieldCpf.setBorder(null);
        jTextFieldCpf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldCpfMouseClicked(evt);
            }
        });
        jTextFieldCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCpfActionPerformed(evt);
            }
        });

        jSeparator4.setForeground(new java.awt.Color(0, 77, 64));

        Email.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Email.setForeground(new java.awt.Color(0, 77, 64));
        Email.setText("CPF");

        User.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        User.setForeground(new java.awt.Color(0, 77, 64));
        User.setText("LOGIN");

        jTextFieldLogin.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTextFieldLogin.setForeground(new java.awt.Color(0, 77, 64));
        jTextFieldLogin.setText("Digite um usuário de login");
        jTextFieldLogin.setBorder(null);
        jTextFieldLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldLoginMouseClicked(evt);
            }
        });
        jTextFieldLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldLoginActionPerformed(evt);
            }
        });

        jSeparator5.setForeground(new java.awt.Color(0, 77, 64));

        Senha.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Senha.setForeground(new java.awt.Color(0, 77, 64));
        Senha.setText("SENHA");

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

        Retry_senha.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Retry_senha.setForeground(new java.awt.Color(0, 77, 64));
        Retry_senha.setText("REPITA A SENHA");

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
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Nome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldName)
                            .addComponent(jSeparator3)
                            .addComponent(Email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldCpf)
                            .addComponent(jSeparator4)
                            .addComponent(User, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldLogin)
                            .addComponent(jSeparator5)
                            .addComponent(Senha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPasswordFieldSenha)
                            .addComponent(jSeparator6)
                            .addComponent(Retry_senha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPasswordFieldSenhaRetry, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Voltar)
                .addGap(166, 166, 166))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(Nome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Email)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(User)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(29, 29, 29)
                .addComponent(Voltar)
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 450, 530));

        Logo.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        Logo.setForeground(new java.awt.Color(255, 255, 255));
        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Sergeant_SGT_60px_1.png"))); // NOI18N
        Logo.setText("sgva");
        getContentPane().add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, 40));

        Novo_cadastro2.setFont(new java.awt.Font("Perpetua Titling MT", 1, 10)); // NOI18N
        Novo_cadastro2.setForeground(new java.awt.Color(255, 255, 255));
        Novo_cadastro2.setText("cadastrar novo FUNCIONÁRIO");
        getContentPane().add(Novo_cadastro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, -1, 18));

        fechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Delete_16px_1.png"))); // NOI18N
        fechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fecharMouseClicked(evt);
            }
        });
        getContentPane().add(fechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 20, -1));

        minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Subtract_16px_1.png"))); // NOI18N
        minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizarMouseClicked(evt);
            }
        });
        getContentPane().add(minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, -1));

        fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Ativo 4.png"))); // NOI18N
        getContentPane().add(fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 120));

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

    private void jTextFieldLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldLoginActionPerformed
        jTextFieldLogin.setText("");
    }//GEN-LAST:event_jTextFieldLoginActionPerformed

    private void jTextFieldLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldLoginMouseClicked
        jTextFieldLogin.setText("");
    }//GEN-LAST:event_jTextFieldLoginMouseClicked

    private void jTextFieldCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCpfActionPerformed
        jTextFieldCpf.setText("");
    }//GEN-LAST:event_jTextFieldCpfActionPerformed

    private void jTextFieldCpfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldCpfMouseClicked
        jTextFieldCpf.setText("");
    }//GEN-LAST:event_jTextFieldCpfMouseClicked

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

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form_Func.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Func.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Func.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Func.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Func().setVisible(true);
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
    private javax.swing.JTextField jTextFieldCpf;
    private javax.swing.JTextField jTextFieldLogin;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JLabel minimizar;
    // End of variables declaration//GEN-END:variables
}

package view;

import conexao.Conexao;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import mensagens.ViewInfo;

/**
 *
 * @author Programador-03
 */
public class Login extends javax.swing.JFrame {

    private final Conexao conexao = new Conexao();
    private ResultSet rs = null;
    private PreparedStatement preparedStatement = null;
    private String senha = "";
    
    //private static final Login view = new Login();
    private ViewInfo mensagem = new ViewInfo(null, true);

    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private void efetuarLogin() {
        new SwingWorker<Void, Void>() {
            int resposta = 0;
            String nome;

            @Override
            protected Void doInBackground() {
                if (!conexao.obterConexao()) {
                    mensagem.setMensagem("ATENÇÃO", "Não foi possível conectar-se ao Banco de Dados!", "/image/icons8_Warning_Shield_32px_3.png", 255, 171, 0);
                    mensagem.setVisible(true);
                } else {
                    try {
                        preparedStatement = conexao.con.prepareStatement("SELECT login , func_senha  FROM funcionario WHERE login = ? AND func_senha = ?");
                        preparedStatement.setString(1, tfUsuario.getText());
                        preparedStatement.setString(2, senha);
                        rs = preparedStatement.executeQuery();

                        if (rs.next() && rs != null) {
                            resposta = 1;
                            nome = rs.getString("login");
                            senha = rs.getString("func_senha");

                        } else {
                            resposta = 0;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                return null;
            }

            @Override
            protected void done() {
                try {
                    if (resposta == 1) {
                        conexao.close();
                        preparedStatement.close();

                        Principal viewPrincipal = new Principal();
//                        Login view = new Login();
                        viewPrincipal.setVisible(true);
                        viewPrincipal.pack();
                        viewPrincipal.setLocationRelativeTo(null);
                        viewPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        
                        
                    } else {
                        conexao.close();
                        preparedStatement.close();
                        mensagem.setMensagem("ATENÇÃO", "Usuário e/ou Senha incorreto(s)!", "/image/icons8_Warning_Shield_32px_3.png", 255, 171, 0);
                        mensagem.setVisible(true);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }.execute();
        this.dispose();
    }

    private void verificaLogin() {
        senha = new String(tfSenha.getPassword());
        
        if (tfUsuario.getText().isEmpty() && senha.equals("")) {
            jlMsgLogin.setText("*Campo obrigatório");
            jlMsgLogin.setForeground(Color.red);
            jsLogin.setForeground(Color.red);

            jlMsgSenha.setText("*Campo obrigatório");
            jlMsgSenha.setForeground(Color.red);
            jsSenha.setForeground(Color.red);
        } else if (tfUsuario.getText().isEmpty()) {
            jlMsgLogin.setText("*Campo obrigatório");
            jlMsgLogin.setForeground(Color.red);
            jsLogin.setForeground(Color.red);
        } else if (senha.equals("")) {
            jlMsgSenha.setText("*Campo obrigatório");
            jlMsgSenha.setForeground(Color.red);
            jsSenha.setForeground(Color.red);
        } else {
            java.awt.EventQueue.invokeLater(() -> {
                efetuarLogin();
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        fundo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        sgva = new javax.swing.JLabel();
        Login = new javax.swing.JLabel();
        Senha = new javax.swing.JLabel();
        jsLogin = new javax.swing.JSeparator();
        jsSenha = new javax.swing.JSeparator();
        tfSenha = new javax.swing.JPasswordField();
        tfUsuario = new javax.swing.JTextField();
        Logo = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        Cancel = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        Logar = new javax.swing.JLabel();
        conta_nova = new javax.swing.JLabel();
        fechar = new javax.swing.JLabel();
        minimizar = new javax.swing.JLabel();
        jlMsgSenha = new javax.swing.JLabel();
        jlMsgLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 77, 64));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Ativo 3.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 260, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, 210, 15));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, 130, 17));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, 70, 17));

        fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Ativo 4.png"))); // NOI18N
        jPanel1.add(fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 560));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        sgva.setFont(new java.awt.Font("Perpetua Titling MT", 1, 10)); // NOI18N
        sgva.setForeground(new java.awt.Color(0, 77, 64));
        sgva.setText("Sistema de gestão de vendas de armas");

        Login.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        Login.setForeground(new java.awt.Color(0, 77, 64));
        Login.setText("login");

        Senha.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        Senha.setForeground(new java.awt.Color(0, 77, 64));
        Senha.setText("senha");

        jsLogin.setForeground(new java.awt.Color(0, 77, 64));

        jsSenha.setForeground(new java.awt.Color(0, 77, 64));

        tfSenha.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tfSenha.setForeground(new java.awt.Color(0, 77, 64));
        tfSenha.setText("jPasswordField1");
        tfSenha.setBorder(null);
        tfSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfSenhaMouseClicked(evt);
            }
        });
        tfSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSenhaActionPerformed(evt);
            }
        });

        tfUsuario.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tfUsuario.setForeground(new java.awt.Color(0, 77, 64));
        tfUsuario.setText("Entre com seu login ");
        tfUsuario.setBorder(null);
        tfUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfUsuarioMouseClicked(evt);
            }
        });
        tfUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUsuarioActionPerformed(evt);
            }
        });

        Logo.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        Logo.setForeground(new java.awt.Color(0, 77, 64));
        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Sergeant_SGT_60px.png"))); // NOI18N
        Logo.setText("sgva");

        jPanel4.setBackground(new java.awt.Color(214, 0, 0));

        Cancel.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        Cancel.setForeground(new java.awt.Color(255, 255, 255));
        Cancel.setText("CANCEL");
        Cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelMouseClicked(evt);
            }
        });

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

        jPanel5.setBackground(new java.awt.Color(0, 77, 64));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });

        Logar.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        Logar.setForeground(new java.awt.Color(255, 255, 255));
        Logar.setText("login");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(Logar)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(Logar)
                .addContainerGap())
        );

        conta_nova.setFont(new java.awt.Font("Perpetua Titling MT", 1, 10)); // NOI18N
        conta_nova.setForeground(new java.awt.Color(0, 77, 64));
        conta_nova.setText("criar nova conta");
        conta_nova.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                conta_novaMouseClicked(evt);
            }
        });

        fechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Delete_16px.png"))); // NOI18N
        fechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fecharMouseClicked(evt);
            }
        });

        minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Subtract_16px.png"))); // NOI18N
        minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizarMouseClicked(evt);
            }
        });

        jlMsgSenha.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N

        jlMsgLogin.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(Logo)
                                    .addComponent(sgva)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addComponent(conta_nova)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(23, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(88, 88, 88)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jsLogin, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Login, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                                    .addComponent(jsSenha)
                                    .addComponent(tfSenha)
                                    .addComponent(Senha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlMsgLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlMsgSenha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(minimizar, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fechar)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(minimizar)
                    .addComponent(fechar))
                .addGap(36, 36, 36)
                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(sgva)
                .addGap(85, 85, 85)
                .addComponent(Login)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jsLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(Senha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jsSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlMsgLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlMsgSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(conta_nova)
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUsuarioActionPerformed
        tfUsuario.setText("");
    }//GEN-LAST:event_tfUsuarioActionPerformed

    private void tfUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfUsuarioMouseClicked
        tfUsuario.setText("");
    }//GEN-LAST:event_tfUsuarioMouseClicked

    private void tfSenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfSenhaMouseClicked
        tfSenha.setText("");
    }//GEN-LAST:event_tfSenhaMouseClicked

    private void conta_novaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_conta_novaMouseClicked
        Form_Func novaConta = new Form_Func();
        novaConta.setVisible(true);
        novaConta.pack();
        novaConta.setLocationRelativeTo(null);
        novaConta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_conta_novaMouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        verificaLogin();
    }//GEN-LAST:event_jPanel5MouseClicked

    private void tfSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSenhaActionPerformed
        // TODO add your handling code here:
        tfSenha.setText("");
    }//GEN-LAST:event_tfSenhaActionPerformed

    private void fecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fecharMouseClicked
        System.exit(0);
    }//GEN-LAST:event_fecharMouseClicked

    private void minimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimizarMouseClicked

    private void CancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelMouseClicked
        System.exit(0);
    }//GEN-LAST:event_CancelMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cancel;
    private javax.swing.JLabel Logar;
    private javax.swing.JLabel Login;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel Senha;
    private javax.swing.JLabel conta_nova;
    private javax.swing.JLabel fechar;
    private javax.swing.JLabel fundo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel jlMsgLogin;
    private javax.swing.JLabel jlMsgSenha;
    private javax.swing.JSeparator jsLogin;
    private javax.swing.JSeparator jsSenha;
    private javax.swing.JLabel minimizar;
    private javax.swing.JLabel sgva;
    private javax.swing.JPasswordField tfSenha;
    private javax.swing.JTextField tfUsuario;
    // End of variables declaration//GEN-END:variables
}

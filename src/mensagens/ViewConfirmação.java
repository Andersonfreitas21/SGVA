package mensagens;

import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 *
 * @author Programador-03
 */

public class ViewConfirmação extends javax.swing.JDialog {
   
    public ViewConfirmação(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Icones/128x128.png")));
        
        btnSim.requestFocus();
    }
    
    public void setMensagem(String titulo, String mensagem, String caminhoImagem) {
        labelTitulo.setText(titulo);
        labelMensagem.setText(mensagem);
        labelMensagem.setIcon(new ImageIcon(getClass().getResource(caminhoImagem)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        labelMensagem = new javax.swing.JLabel();
        btnSim = new javax.swing.JButton();
        btnNao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        labelTitulo.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("Atenção");

        labelMensagem.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        labelMensagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMensagem.setText("<html><p style=\\\"text-align:center;\\\">Nome da Agência não encontrado! <br/>Deseja cadastra-la no Banco de Dados!</p></html>");

        btnSim.setBackground(new java.awt.Color(40, 167, 69));
        btnSim.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnSim.setForeground(new java.awt.Color(255, 255, 255));
        btnSim.setText("Sim");
        btnSim.setBorder(null);
        btnSim.setContentAreaFilled(false);
        btnSim.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSim.setFocusPainted(false);
        btnSim.setOpaque(true);
        btnSim.setPreferredSize(new java.awt.Dimension(65, 24));
        btnSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimActionPerformed(evt);
            }
        });

        btnNao.setBackground(new java.awt.Color(212, 51, 67));
        btnNao.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnNao.setForeground(new java.awt.Color(255, 255, 255));
        btnNao.setText("Não");
        btnNao.setBorder(null);
        btnNao.setContentAreaFilled(false);
        btnNao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNao.setFocusPainted(false);
        btnNao.setOpaque(true);
        btnNao.setPreferredSize(new java.awt.Dimension(65, 24));
        btnNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSim, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNao, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelMensagem, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNaoActionPerformed
        Ação = "NÃO";
        this.dispose();
    }//GEN-LAST:event_btnNaoActionPerformed

    public static String Ação = "NÃO";
    
    private void btnSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimActionPerformed
        Ação = "SIM";
        this.dispose();
    }//GEN-LAST:event_btnSimActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNao;
    private javax.swing.JButton btnSim;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelMensagem;
    private javax.swing.JLabel labelTitulo;
    // End of variables declaration//GEN-END:variables
}

package mensagens;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 *
 * @author Programador-03
 */

public class ViewInfo extends javax.swing.JDialog {

    public ViewInfo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
       
        btnFrchar.requestFocus();
    }
    
    public void setMensagem(String titulo, String mensagem, String caminhoImagem, int r, int g, int b) {
        labelTitulo.setText(titulo);
        labelMensagem.setText(mensagem);
        btnFrchar.setBackground(new Color(r, g, b));
        labelMensagem.setIcon(new ImageIcon(getClass().getResource(caminhoImagem)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        labelMensagem = new javax.swing.JLabel();
        btnFrchar = new javax.swing.JButton();

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
        labelMensagem.setText("Produção gravada com sucesso!");

        btnFrchar.setBackground(new java.awt.Color(255, 171, 0));
        btnFrchar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnFrchar.setForeground(new java.awt.Color(255, 255, 255));
        btnFrchar.setText("OK");
        btnFrchar.setBorder(null);
        btnFrchar.setContentAreaFilled(false);
        btnFrchar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFrchar.setFocusPainted(false);
        btnFrchar.setOpaque(true);
        btnFrchar.setPreferredSize(new java.awt.Dimension(65, 24));
        btnFrchar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFrcharMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFrchar, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo)
                .addGap(12, 12, 12)
                .addComponent(labelMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFrchar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnFrcharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFrcharMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnFrcharMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFrchar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelMensagem;
    private javax.swing.JLabel labelTitulo;
    // End of variables declaration//GEN-END:variables
}

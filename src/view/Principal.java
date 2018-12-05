package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author Programador-03
 */
public class Principal extends javax.swing.JFrame {

    String nomeSemana, data, hora, funcao;

    public Principal() {
        initComponents();

        Timer timer = new Timer(1000, new hora());
        timer.start();
        //fundo.setIcon(new ImageIcon(getClass().getResource("/image/Ativo 4.png")));
    }
    
    private static final Principal view = new Principal();
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel21 = new javax.swing.JPanel();
        jlHora = new javax.swing.JLabel();
        jlDiaDataSemana = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        fechar = new javax.swing.JLabel();
        minimizar = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        fundo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel21.setBackground(new java.awt.Color(0, 77, 64));

        jlHora.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jlHora.setForeground(new java.awt.Color(255, 255, 255));

        jlDiaDataSemana.setBackground(new java.awt.Color(255, 255, 255));
        jlDiaDataSemana.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jlDiaDataSemana.setForeground(new java.awt.Color(255, 255, 255));
        jlDiaDataSemana.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlDiaDataSemana.setText("Terça- Feira 08/05/2018");

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Versão 1.0.0");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(jlDiaDataSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlHora, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 480, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlHora, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(jlDiaDataSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 591, 953, -1));

        jPanel1.setBackground(new java.awt.Color(0, 77, 64));

        jLabel6.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Sergeant_SGT_60px_1.png"))); // NOI18N
        jLabel6.setText("sgva");

        fechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Delete_16px_1.png"))); // NOI18N
        fechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fecharMouseClicked(evt);
            }
        });

        minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Subtract_16px_1.png"))); // NOI18N
        minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 761, Short.MAX_VALUE)
                .addComponent(minimizar)
                .addGap(14, 14, 14)
                .addComponent(fechar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(minimizar)
                    .addComponent(fechar))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 953, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Ativo 3 - Copia.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, 290, 210));

        fundo.setBackground(getBackground());
        fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Ativo 4.png"))); // NOI18N
        getContentPane().add(fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 51, 759, 540));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 77, 64));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Assault_Rifle_45px.png"))); // NOI18N
        jLabel9.setText("PRODUTOS");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 77, 64));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Battelefield_45px_1.png"))); // NOI18N
        jLabel2.setText("ESTOQUE");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 77, 64));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Defense_45px.png"))); // NOI18N
        jLabel3.setText("CLIENTES");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 120, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 77, 64));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Magazine_45px.png"))); // NOI18N
        jLabel4.setText("CONTROLE");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 77, 64));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Swiss_Army_Knife_45px.png"))); // NOI18N
        jLabel5.setText("FERRAMENTAS");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 77, 64));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_US_Army_45px.png"))); // NOI18N
        jLabel7.setText("RESTRITO");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 51, 194, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fecharMouseClicked
        this.dispose();
        Login login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_fecharMouseClicked

    private void minimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimizarMouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        PrincipalProduto cadProduto = new PrincipalProduto();
        cadProduto.setVisible(true);
        cadProduto.pack();
        cadProduto.setLocationRelativeTo(null);
        cadProduto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.dispose();

    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        PrincipalCliente cadCliente = new PrincipalCliente();
        cadCliente.setVisible(true);
        cadCliente.pack();
        cadCliente.setLocationRelativeTo(null);
        cadCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void diaDataSemana() {
        Date d = new Date();

        Calendar c = new GregorianCalendar();
        c.setTime(d);

        int dia = c.get(Calendar.DAY_OF_WEEK);

        switch (dia) {
            case Calendar.SUNDAY:
                nomeSemana = "domingo";
                break;
            case Calendar.SATURDAY:
                nomeSemana = "sábado";
                break;
            case Calendar.MONDAY:
                nomeSemana = "segunda-feira";
                break;
            case Calendar.TUESDAY:
                nomeSemana = "terça-feira";
                break;
            case Calendar.WEDNESDAY:
                nomeSemana = "quarta-feira";
                break;
            case Calendar.THURSDAY:
                nomeSemana = "quinta-feira";
                break;
            case Calendar.FRIDAY:
                nomeSemana = "sexta-feira";
                break;
        }

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        data = dateFormat.format(d);

        jlDiaDataSemana.setText(nomeSemana + " " + data);
    }

    class hora implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Calendar now = Calendar.getInstance();
            jlHora.setText(String.format("%1$tH:%1$tM:%1$tS", now));
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fechar;
    private javax.swing.JLabel fundo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JLabel jlDiaDataSemana;
    private javax.swing.JLabel jlHora;
    private javax.swing.JLabel minimizar;
    // End of variables declaration//GEN-END:variables
}

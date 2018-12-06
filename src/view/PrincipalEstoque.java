package view;

import conexao.Conexao;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import mensagens.ViewInfo;
import util.Utilitarios;
import mensagens.ViewConfirmação;

/**
 *
 * @author Programador-03
 */
public class PrincipalEstoque extends javax.swing.JFrame {

    private final Conexao conexao = new Conexao();
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;
    private final Utilitarios utils = new Utilitarios();
    private final ViewInfo mensagem = new ViewInfo(null, true);
    private final ViewConfirmação Confirmação = new ViewConfirmação(null, true);
    DefaultTableModel modelo;
    String nomeSemana, data, hora, funcao;

    public PrincipalEstoque() {
        initComponents();
        preencheTabela();
        diaDataSemana();
        Timer timer = new Timer(1000, new hora());
        timer.start();
    }

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

    private void preencheTabela() {
        try {
            if (!conexao.obterConexao()) {
                mensagem.setMensagem("ATENÇÃO", "Falha ao conectar com o Banco de Dados!", "/Icones/icons8_Cancel_32px_1.png", 183, 28, 28);
                mensagem.setVisible(true);
            } else {
                modelo = (DefaultTableModel) jTable1.getModel();
                modelo.setNumRows(0);
                jTable1.setRowHeight(20);

                preparedStatement = conexao.con.prepareStatement("SELECT "
                        + "id_produto, "
                        + "prod_nome, "
                        + "prod_valor, "
                        + "prod_categoria, "
                        + "prod_estoque "
                        + "FROM produto");
                rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    modelo.addRow(new Object[]{
                        rs.getString("id_produto"),
                        rs.getString("prod_nome"),
                        rs.getString("prod_valor"),
                        rs.getString("prod_categoria"),
                        rs.getString("prod_estoque")
                    });
                }

                jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
                    @Override
                    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {

                        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

                        if (isSelected == true) {
                            setBackground(new Color(51, 153, 255));
                            setForeground(Color.WHITE);
                        } else if (row % 2 == 0) {
                            setBackground(new Color(248, 248, 248));
                            setForeground(Color.BLACK);
                        } else {
                            setBackground(table.getBackground());
                            setForeground(table.getForeground());
                        }

                        return this;
                    }
                });

                jTable1.repaint();

                conexao.close();
                preparedStatement.close();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "OCORREU O SEGUINTE ERRO:\n" + e, "ERRO", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

//    public void limparCampos() {
//        jtfNomeProduto.setText("");
//        jtfValorProduto.setText("");
//        jtfCategoria.setText("");
//        jDateCad.setDate(null);
//        jtfEstoque.setText("");
//        jTextAreaDesc.setText("");
//    }

//    private void Salvar() {
//        if (jtfNomeProduto.getText().isEmpty() || jtfNomeProduto.getText() == null && jtfValorProduto.getText().isEmpty() || jtfValorProduto.getText() == null) {
//            mensagem.setMensagem("ATENÇÃO", "Prencha todos os dados!", "/Icones/icons8_Cancel_32px_1.png", 183, 28, 28);
//            mensagem.setVisible(true);
//        } else {
//            if (!conexao.obterConexao()) {
//                mensagem.setMensagem("ATENÇÃO", "Falha ao conectar com o Banco de Dados!", "/Icones/icons8_Cancel_32px_1.png", 183, 28, 28);
//                mensagem.setVisible(true);
//                return;
//            }
//
//            try {
//
//                preparedStatement = conexao.con.prepareStatement("INSERT INTO produto "
//                        + "(prod_nome, prod_valor, prod_descricao, prod_estoque, prod_categoria, prod_data_cadastro) VALUES (?, ?, ?, ?, ?, ?)");
//                preparedStatement.setString(1, jtfNomeProduto.getText());
//                preparedStatement.setDouble(2, Double.parseDouble(jtfValorProduto.getText()));
//                preparedStatement.setString(3, jTextAreaDesc.getText());
//                preparedStatement.setString(4, jtfEstoque.getText());
//                preparedStatement.setString(5, jtfCategoria.getText());
//
//                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//                String dataCad = simpleDateFormat.format(jDateCad.getDate());
//
//                preparedStatement.setDate(6, utils.FormatarData(dataCad));
//
//                int resposta = preparedStatement.executeUpdate();
//
//                if (resposta > 0) {
//                    limparCampos();
//                    preencheTabela();
//                    mensagem.setMensagem("MENSAGEM", "Dados inseridos com sucesso!", "/image/icons8_Ok_32px.png", 1, 87, 155);
//                    mensagem.setVisible(true);
//                }
//
//                conexao.close();
//                preparedStatement.close();
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, "OCORREU O SEGUINTE ERRO:\n" + e, "ERRO", JOptionPane.ERROR_MESSAGE);
//                e.printStackTrace();
//            }
//        }
//
//    }

//    private void SelecionarProduto() {
//
//        switch (jTable1.getSelectedRows().length) {
//            case 1:
//                jtfNomeProduto.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
//                jtfValorProduto.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
//                jtfCategoria.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
//                jtfEstoque.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
//
//                //Fazer Update pelo Id do Cliente
//                
//                //UPDATE `lojaarms`.`produto` SET `prod_nome`='Escopeta 12 calibres', `prod_valor`='3450.02', `prod_descricao`='Escopeta 12 - calibres', `prod_estoque`='2', `prod_categoria`='escopeta_', `prod_data_cadastro`='2018-12-05' WHERE `id_produto`='18';
//                break;
//            case 0:
//                mensagem.setMensagem("ATENÇÃO", "Selecione um registro para editar!", "/image/icons8_Warning_Shield_32px_3.png", 255, 171, 0);
//                mensagem.setVisible(true);
//                break;
//            default:
//                mensagem.setMensagem("ATENÇÃO", "Selecione apenas um Cliente pra editar!", "/image/icons8_Warning_Shield_32px_3.png", 255, 171, 0);
//                mensagem.setVisible(true);
//                break;
//        }
//    }
//
//    private void ExcluirProduto() {
//        switch (jTable1.getSelectedRows().length) {
//            case 1:
//                try {
//                    Confirmação.setMensagem("ATENÇÃO", "<html><p style=\"text-align:center;\">Deseja realmente excluir<br/> esse produto?</p></html>", "/image/icons8_Warning_Shield_32px_3.png");
//                    Confirmação.setVisible(true);
//
//                    if (ViewConfirmação.Ação.equals("SIM")) {
//
//                        if (!conexao.obterConexao()) {
//                            mensagem.setMensagem("ATENÇÃO", "Falha ao conectar com o Banco de Dados!", "/image/icons8_Cancel_32px_1.png", 183, 28, 28);
//                            mensagem.setVisible(true);
//                        } else {
//                            int Id_produto = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
//                            preparedStatement = conexao.con.prepareStatement("DELETE FROM produto WHERE id_produto = ?");
//                            preparedStatement.setInt(1, Id_produto);
//                            preparedStatement.executeUpdate();
//
//                            modelo.removeRow(jTable1.getSelectedRow());
//
//                            conexao.close();
//                            preparedStatement.close();
//
//                            mensagem.setMensagem("MENSAGEM", "Produto excluído com Sucesso!", "/image/icons8_Ok_32px.png", 1, 87, 155);
//                            mensagem.setVisible(true);
//                        }
//                    }
//                } catch (Exception e) {
//                    JOptionPane.showMessageDialog(null, "OCORREU O SEGUINTE ERRO:\n" + e, "ERRO", JOptionPane.ERROR_MESSAGE);
//                    e.printStackTrace();
//                }
//                break;
//            case 0:
//                mensagem.setMensagem("ATENÇÃO", "Selecione um produto para excluir!", "/image/icons8_Warning_Shield_32px_3.png", 255, 171, 0);
//                mensagem.setVisible(true);
//                break;
//            default:
//                mensagem.setMensagem("ATENÇÃO", "Selecione apenas um produto para excluir!", "/image/icons8_Warning_Shield_32px_3.png", 255, 171, 0);
//                mensagem.setVisible(true);
//                break;
//        }
//    }

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
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabelCidade = new javax.swing.JLabel();
        Novo_cadastro2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

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

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 77, 64));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Assault_Rifle_45px.png"))); // NOI18N
        jLabel9.setText("PRODUTOS");
        jLabel9.setFocusable(false);

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 77, 64));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Battelefield_45px_1.png"))); // NOI18N
        jLabel2.setText("COMPRAS");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 77, 64));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Magazine_45px.png"))); // NOI18N
        jLabel4.setText("ESTOQUE");
        jLabel4.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 77, 64));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Defense_45px.png"))); // NOI18N
        jLabel8.setText("CLIENTES");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(43, 43, 43))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(285, 285, 285))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 51, 194, 540));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabelCidade.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelCidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCidadeMouseClicked(evt);
            }
        });

        Novo_cadastro2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Novo_cadastro2.setForeground(new java.awt.Color(0, 77, 64));
        Novo_cadastro2.setText("ESTOQUE");

        jTable1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME DO PROODUTO", "VALOR", "CATEGORIA", "ESTOQUE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMaxWidth(30);
            jTable1.getColumnModel().getColumn(2).setMinWidth(30);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(3).setMinWidth(30);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(4).setMinWidth(20);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(20);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(152, 420, Short.MAX_VALUE)
                        .addComponent(jLabelCidade)
                        .addGap(320, 320, 320))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(318, 318, 318)
                        .addComponent(Novo_cadastro2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(Novo_cadastro2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabelCidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 760, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fecharMouseClicked
        this.dispose();
    }//GEN-LAST:event_fecharMouseClicked

    private void minimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimizarMouseClicked

    private void jLabelCidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCidadeMouseClicked
    }//GEN-LAST:event_jLabelCidadeMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

    }//GEN-LAST:event_jTable1MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        PrincipalCliente cadCliente = new PrincipalCliente();
        cadCliente.setVisible(true);
        cadCliente.pack();
        cadCliente.setLocationRelativeTo(null);
        cadCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

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
            java.util.logging.Logger.getLogger(PrincipalEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalEstoque().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Novo_cadastro2;
    private javax.swing.JLabel fechar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCidade;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jlDiaDataSemana;
    private javax.swing.JLabel jlHora;
    private javax.swing.JLabel minimizar;
    // End of variables declaration//GEN-END:variables
}

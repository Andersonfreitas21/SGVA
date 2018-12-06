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
public class PrincipalProduto extends javax.swing.JFrame {

    private final Conexao conexao = new Conexao();
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;
    private final Utilitarios utils = new Utilitarios();
    private final ViewInfo mensagem = new ViewInfo(null, true);
    private final ViewConfirmação Confirmação = new ViewConfirmação(null, true);
    DefaultTableModel modelo;
    String nomeSemana, data, hora, funcao;

    public PrincipalProduto() {
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

    public void limparCampos() {
        jtfNomeProduto.setText("");
        jtfValorProduto.setText("");
        jtfCategoria.setText("");
        jDateCad.setDate(null);
        jtfEstoque.setText("");
        jTextAreaDesc.setText("");
    }

    private void Salvar() {
        if (jtfNomeProduto.getText().isEmpty() || jtfNomeProduto.getText() == null && jtfValorProduto.getText().isEmpty() || jtfValorProduto.getText() == null) {
            mensagem.setMensagem("ATENÇÃO", "Prencha todos os dados!", "/Icones/icons8_Cancel_32px_1.png", 183, 28, 28);
            mensagem.setVisible(true);
        } else {
            if (!conexao.obterConexao()) {
                mensagem.setMensagem("ATENÇÃO", "Falha ao conectar com o Banco de Dados!", "/Icones/icons8_Cancel_32px_1.png", 183, 28, 28);
                mensagem.setVisible(true);
                return;
            }

            try {

                preparedStatement = conexao.con.prepareStatement("INSERT INTO produto "
                        + "(prod_nome, prod_valor, prod_descricao, prod_estoque, prod_categoria, prod_data_cadastro) VALUES (?, ?, ?, ?, ?, ?)");
                preparedStatement.setString(1, jtfNomeProduto.getText());
                preparedStatement.setDouble(2, Double.parseDouble(jtfValorProduto.getText()));
                preparedStatement.setString(3, jTextAreaDesc.getText());
                preparedStatement.setString(4, jtfEstoque.getText());
                preparedStatement.setString(5, jtfCategoria.getText());

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String dataCad = simpleDateFormat.format(jDateCad.getDate());

                preparedStatement.setDate(6, utils.FormatarData(dataCad));

                int resposta = preparedStatement.executeUpdate();

                if (resposta > 0) {
                    limparCampos();
                    preencheTabela();
                    mensagem.setMensagem("MENSAGEM", "Dados inseridos com sucesso!", "/image/icons8_Ok_32px.png", 1, 87, 155);
                    mensagem.setVisible(true);
                }

                conexao.close();
                preparedStatement.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "OCORREU O SEGUINTE ERRO:\n" + e, "ERRO", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }

    }

    private void SelecionarProduto() {

        switch (jTable1.getSelectedRows().length) {
            case 1:
                jtfNomeProduto.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
                jtfValorProduto.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
                jtfCategoria.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
                jtfEstoque.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());

                //Fazer Update pelo Id do Cliente
                
                //UPDATE `lojaarms`.`produto` SET `prod_nome`='Escopeta 12 calibres', `prod_valor`='3450.02', `prod_descricao`='Escopeta 12 - calibres', `prod_estoque`='2', `prod_categoria`='escopeta_', `prod_data_cadastro`='2018-12-05' WHERE `id_produto`='18';
                break;
            case 0:
                mensagem.setMensagem("ATENÇÃO", "Selecione um registro para editar!", "/image/icons8_Warning_Shield_32px_3.png", 255, 171, 0);
                mensagem.setVisible(true);
                break;
            default:
                mensagem.setMensagem("ATENÇÃO", "Selecione apenas um Cliente pra editar!", "/image/icons8_Warning_Shield_32px_3.png", 255, 171, 0);
                mensagem.setVisible(true);
                break;
        }
    }

    private void ExcluirProduto() {
        switch (jTable1.getSelectedRows().length) {
            case 1:
                try {
                    Confirmação.setMensagem("ATENÇÃO", "<html><p style=\"text-align:center;\">Deseja realmente excluir<br/> esse produto?</p></html>", "/image/icons8_Warning_Shield_32px_3.png");
                    Confirmação.setVisible(true);

                    if (ViewConfirmação.Ação.equals("SIM")) {

                        if (!conexao.obterConexao()) {
                            mensagem.setMensagem("ATENÇÃO", "Falha ao conectar com o Banco de Dados!", "/image/icons8_Cancel_32px_1.png", 183, 28, 28);
                            mensagem.setVisible(true);
                        } else {
                            int Id_produto = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
                            preparedStatement = conexao.con.prepareStatement("DELETE FROM produto WHERE id_produto = ?");
                            preparedStatement.setInt(1, Id_produto);
                            preparedStatement.executeUpdate();

                            modelo.removeRow(jTable1.getSelectedRow());

                            conexao.close();
                            preparedStatement.close();

                            mensagem.setMensagem("MENSAGEM", "Produto excluído com Sucesso!", "/image/icons8_Ok_32px.png", 1, 87, 155);
                            mensagem.setVisible(true);
                        }
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "OCORREU O SEGUINTE ERRO:\n" + e, "ERRO", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
                break;
            case 0:
                mensagem.setMensagem("ATENÇÃO", "Selecione um produto para excluir!", "/image/icons8_Warning_Shield_32px_3.png", 255, 171, 0);
                mensagem.setVisible(true);
                break;
            default:
                mensagem.setMensagem("ATENÇÃO", "Selecione apenas um produto para excluir!", "/image/icons8_Warning_Shield_32px_3.png", 255, 171, 0);
                mensagem.setVisible(true);
                break;
        }
    }

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
        jLabel10 = new javax.swing.JLabel();
        jtfNomeProduto = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jtfCategoria = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabelCidade = new javax.swing.JLabel();
        jDateCad = new com.toedter.calendar.JDateChooser();
        jtfValorProduto = new javax.swing.JTextField();
        Novo_cadastro2 = new javax.swing.JLabel();
        jtfEstoque = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaDesc = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

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
        jLabel9.setEnabled(false);
        jLabel9.setFocusable(false);

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 77, 64));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Battelefield_45px_1.png"))); // NOI18N
        jLabel2.setText("ESTOQUE");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 77, 64));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Magazine_45px.png"))); // NOI18N
        jLabel4.setText("CONTROLE");

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

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 77, 64));
        jLabel10.setText("Nome do Produto");
        jLabel10.setToolTipText("");

        jtfNomeProduto.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jtfNomeProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfNomeProdutoKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 77, 64));
        jLabel11.setText("Valor");
        jLabel11.setToolTipText("");

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 77, 64));
        jLabel12.setText("Categoria");
        jLabel12.setToolTipText("");

        jtfCategoria.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jtfCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCategoriaActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 77, 64));
        jLabel13.setText("Data do Cadastro");
        jLabel13.setToolTipText("");

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 77, 64));
        jLabel14.setText("Quantidade em estoque");
        jLabel14.setToolTipText("");

        jLabelCidade.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelCidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCidadeMouseClicked(evt);
            }
        });

        jtfValorProduto.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jtfValorProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfValorProdutoKeyTyped(evt);
            }
        });

        Novo_cadastro2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Novo_cadastro2.setForeground(new java.awt.Color(0, 77, 64));
        Novo_cadastro2.setText("Cadastro de Produtos");

        jtfEstoque.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

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
            jTable1.getColumnModel().getColumn(0).setMinWidth(10);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(1).setMinWidth(80);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(2).setMinWidth(30);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(3).setMinWidth(30);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(4).setMinWidth(20);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(20);
        }

        jTextAreaDesc.setColumns(20);
        jTextAreaDesc.setRows(5);
        jScrollPane2.setViewportView(jTextAreaDesc);

        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 77, 64));
        jLabel15.setText("Descrição");
        jLabel15.setToolTipText("");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jDateCad, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 111, Short.MAX_VALUE)
                                        .addComponent(jLabelCidade))
                                    .addComponent(jtfCategoria)))
                            .addComponent(jtfNomeProduto, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfValorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Novo_cadastro2)
                .addGap(282, 282, 282))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(Novo_cadastro2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtfValorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(30, 30, 30)))
                        .addGap(2, 2, 2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateCad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel15))
                    .addComponent(jLabelCidade))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        btnCancelar.setBackground(new java.awt.Color(213, 0, 0));
        btnCancelar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setFocusPainted(false);
        btnCancelar.setOpaque(true);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalvar.setBackground(new java.awt.Color(0, 77, 64));
        btnSalvar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnSalvar.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvar.setText("Salvar");
        btnSalvar.setContentAreaFilled(false);
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalvar.setFocusPainted(false);
        btnSalvar.setOpaque(true);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnAtualizar.setBackground(new java.awt.Color(51, 153, 0));
        btnAtualizar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnAtualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnAtualizar.setText("Atualizar");
        btnAtualizar.setContentAreaFilled(false);
        btnAtualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtualizar.setFocusPainted(false);
        btnAtualizar.setOpaque(true);
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(102, 0, 0));
        btnExcluir.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluir.setText("Excluir");
        btnExcluir.setContentAreaFilled(false);
        btnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluir.setFocusPainted(false);
        btnExcluir.setOpaque(true);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAtualizar)
                .addGap(14, 14, 14)
                .addComponent(btnExcluir)
                .addGap(11, 11, 11)
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtualizar)
                    .addComponent(btnExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void jtfNomeProdutoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNomeProdutoKeyTyped

    }//GEN-LAST:event_jtfNomeProdutoKeyTyped

    private void jLabelCidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCidadeMouseClicked
    }//GEN-LAST:event_jLabelCidadeMouseClicked

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Salvar();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jtfValorProdutoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfValorProdutoKeyTyped

    }//GEN-LAST:event_jtfValorProdutoKeyTyped

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

    }//GEN-LAST:event_jTable1MouseClicked

    private void jtfCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCategoriaActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        PrincipalCliente cadCliente = new PrincipalCliente();
        cadCliente.setVisible(true);
        cadCliente.pack();
        cadCliente.setLocationRelativeTo(null);
        cadCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        SelecionarProduto();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        ExcluirProduto();
    }//GEN-LAST:event_btnExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(PrincipalProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Novo_cadastro2;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel fechar;
    private com.toedter.calendar.JDateChooser jDateCad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextAreaDesc;
    private javax.swing.JLabel jlDiaDataSemana;
    private javax.swing.JLabel jlHora;
    private javax.swing.JTextField jtfCategoria;
    private javax.swing.JTextField jtfEstoque;
    private javax.swing.JTextField jtfNomeProduto;
    private javax.swing.JTextField jtfValorProduto;
    private javax.swing.JLabel minimizar;
    // End of variables declaration//GEN-END:variables
}

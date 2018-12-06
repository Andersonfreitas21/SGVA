package view;

import conexao.Conexao;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class PrincipalCompras extends javax.swing.JFrame {

    private final Conexao conexao = new Conexao();
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;
    private final Utilitarios utils = new Utilitarios();
    private final ViewInfo mensagem = new ViewInfo(null, true);
    private final ViewConfirmação Confirmação = new ViewConfirmação(null, true);
    DefaultTableModel modelo;
    String nomeSemana, data, hora, funcao;

    public PrincipalCompras() {
        initComponents();
//        preencheTabela();
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

//    private void preencheTabela() {
//        try {
//            if (!conexao.obterConexao()) {
//                mensagem.setMensagem("ATENÇÃO", "Falha ao conectar com o Banco de Dados!", "/Icones/icons8_Cancel_32px_1.png", 183, 28, 28);
//                mensagem.setVisible(true);
//            } else {
//                modelo = (DefaultTableModel) jTable1.getModel();
//                modelo.setNumRows(0);
//                jTable1.setRowHeight(20);
//
//                preparedStatement = conexao.con.prepareStatement("SELECT "
//                        + "id_cliente, "
//                        + "cliente_nome, "
//                        + "cliente_cpf, "
//                        + "cliente_cpa, "
//                        + "cliente_telefone "
//                        + "FROM cliente");
//                rs = preparedStatement.executeQuery();
//
//                while (rs.next()) {
//                    modelo.addRow(new Object[]{
//                        rs.getString("id_cliente"),
//                        rs.getString("cliente_nome"),
//                        rs.getString("cliente_cpf"),
//                        rs.getString("cliente_cpa"),
//                        rs.getString("cliente_telefone")
//                    });
//                }
//
//                jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
//                    @Override
//                    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
//
//                        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
//
//                        if (isSelected == true) {
//                            setBackground(new Color(51, 153, 255));
//                            setForeground(Color.WHITE);
//                        } else if (row % 2 == 0) {
//                            setBackground(new Color(248, 248, 248));
//                            setForeground(Color.BLACK);
//                        } else {
//                            setBackground(table.getBackground());
//                            setForeground(table.getForeground());
//                        }
//
//                        return this;
//                    }
//                });
//
//                jTable1.repaint();
//
//                conexao.close();
//                preparedStatement.close();
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "OCORREU O SEGUINTE ERRO:\n" + e, "ERRO", JOptionPane.ERROR_MESSAGE);
//            e.printStackTrace();
//        }
//    }
//
//    public void limparCampos() {
//        jtfNome.setText("");
//        jtfCpf.setText("");
//        jtfCompra.setText("");
//        jDateNasc.setDate(null);
//        jDateCad.setDate(null);
//        jtfEnd.setText("");
//        jtfTelefone.setText("");
//    }

//    private void Salvar() {
//        if (jtfNome.getText().isEmpty() || jtfNome.getText() == null && jtfCpf.getText().isEmpty() || jtfCpf.getText() == null) {
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
//                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//
//                preparedStatement = conexao.con.prepareStatement("INSERT INTO cliente "
//                        + "(cliente_nome, cliente_DataNasc, cliente_cpf, cliente_DataCad, cliente_end, cliente_telefone, cliente_cpa) VALUES (?, ?, ?, ?, ?, ?, ?)");
//
//                preparedStatement.setString(1, jtfNome.getText());
//                String DateNasc = format.format(jDateNasc.getDate());
//                preparedStatement.setDate(2, utils.FormatarData(DateNasc));
//                preparedStatement.setString(3, jtfCpf.getText());
//                String DateCad = format.format(jDateCad.getDate());
//                preparedStatement.setDate(4, utils.FormatarData(DateCad));
//                preparedStatement.setString(5, jtfEnd.getText());
//                preparedStatement.setString(6, jtfTelefone.getText());
//                preparedStatement.setString(7, jtfCompra.getText());
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

//    private void SelecionarCliente() throws SQLException, ParseException {
//        
//        switch (jTable1.getSelectedRows().length) {
//            case 1:
//                jtfNome.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
//                jtfCpf.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
//                jtfCompra.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
//                jtfTelefone.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
//
//                //Fazer Update pelo Id do Cliente
//                //UPDATE `lojaarms`.`cliente` SET `cliente_nome`='ANDERSON FREITAS NOGUEIRA', `cliente_DataNasc`='1991-10-21', `cliente_cpf`='4651228311', `cliente_DataCad`='2018-12-06', `cliente_end`='Rua Valdivino Santiago,212', `cliente_telefone`='(88) 997128991', `cliente_cpa`='9876543' WHERE `id_cliente`='7';
//                if (!conexao.obterConexao()) {
//                    mensagem.setMensagem("ATENÇÃO", "Falha ao conectar com o Banco de Dados!", "/image/icons8_Cancel_32px_1.png", 183, 28, 28);
//                    mensagem.setVisible(true);
//                } else {
//                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//                    preparedStatement = conexao.con.prepareStatement("UPDATE cliente SET cliente_nome = ?, cliente_DataNasc = ?, cliente_cpf = ?, cliente_DataCad = ?,cliente_end = ?, cliente_telefone = ?, cliente_cpa = ? WHERE id_cliente = ?");
//                    preparedStatement.setString(1, jtfNome.getText());
//                    String DateNasc = format.format(jDateNasc.getDate());
//                    preparedStatement.setDate(2, utils.FormatarData(DateNasc));
//                    preparedStatement.setString(3, jtfCpf.getText());
//                    String DateCad = format.format(jDateCad.getDate());
//                    preparedStatement.setDate(4, utils.FormatarData(DateCad));
//                    preparedStatement.setString(5, jtfEnd.getText());
//                    preparedStatement.setString(6, jtfTelefone.getText());
//                    preparedStatement.setString(7, jtfCompra.getText());
//                    preparedStatement.executeUpdate();
//
//                    //modelo.removeRow(jTable1.getSelectedRow());
//                    preencheTabela();
//                    conexao.close();
//                    preparedStatement.close();
//
//                    mensagem.setMensagem("MENSAGEM", "Cliente atualizado com Sucesso!", "/image/icons8_Ok_32px.png", 1, 87, 155);
//                    mensagem.setVisible(true);
//                }
//
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

//    private void ExcluirCliente() {
//        switch (jTable1.getSelectedRows().length) {
//            case 1:
//                try {
//                    Confirmação.setMensagem("ATENÇÃO", "<html><p style=\"text-align:center;\">Deseja realmente excluir<br/> esse cliente?</p></html>", "/image/icons8_Warning_Shield_32px_3.png");
//                    Confirmação.setVisible(true);
//
//                    if (ViewConfirmação.Ação.equals("SIM")) {
//
//                        if (!conexao.obterConexao()) {
//                            mensagem.setMensagem("ATENÇÃO", "Falha ao conectar com o Banco de Dados!", "/image/icons8_Cancel_32px_1.png", 183, 28, 28);
//                            mensagem.setVisible(true);
//                        } else {
//                            int Id_cliente = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
//                            preparedStatement = conexao.con.prepareStatement("DELETE FROM cliente WHERE id_cliente = ?");
//                            preparedStatement.setInt(1, Id_cliente);
//                            preparedStatement.executeUpdate();
//
//                            modelo.removeRow(jTable1.getSelectedRow());
//
//                            conexao.close();
//                            preparedStatement.close();
//
//                            mensagem.setMensagem("MENSAGEM", "Cliente excluído com Sucesso!", "/image/icons8_Ok_32px.png", 1, 87, 155);
//                            mensagem.setVisible(true);
//                        }
//                    }
//                } catch (Exception e) {
//                    JOptionPane.showMessageDialog(null, "OCORREU O SEGUINTE ERRO:\n" + e, "ERRO", JOptionPane.ERROR_MESSAGE);
//                    e.printStackTrace();
//                }
//                break;
//            case 0:
//                mensagem.setMensagem("ATENÇÃO", "Selecione um cliente para excluir!", "/image/icons8_Warning_Shield_32px_3.png", 255, 171, 0);
//                mensagem.setVisible(true);
//                break;
//            default:
//                mensagem.setMensagem("ATENÇÃO", "Selecione apenas um cliente para excluir!", "/image/icons8_Warning_Shield_32px_3.png", 255, 171, 0);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabelCidade = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jtfCompra = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Novo_cadastro2 = new javax.swing.JLabel();
        jcbNomeCliente = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jtfCodProduto = new javax.swing.JTextField();
        jcbNomeProduto = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jtfQtd = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
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
        jLabel9.setFocusable(false);
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 77, 64));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Battelefield_45px_1.png"))); // NOI18N
        jLabel2.setText("COMPRAS");
        jLabel2.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 77, 64));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Defense_45px.png"))); // NOI18N
        jLabel3.setText("CLIENTES");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 77, 64));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Magazine_45px.png"))); // NOI18N
        jLabel4.setText("ESTOQUE");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(265, 265, 265))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 51, 194, 540));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 77, 64));
        jLabel16.setText("Cód. Cliente");
        jLabel16.setToolTipText("");

        jtfNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfNomeKeyTyped(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 77, 64));
        jLabel17.setText("Nome Cliente");
        jLabel17.setToolTipText("");

        jLabelCidade.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelCidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCidadeMouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 77, 64));
        jLabel11.setText("Número da Compra");
        jLabel11.setToolTipText("");

        jTable1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME DO CLIENTE", "CPF", "CAP", "TELEFONE"
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
            jTable1.getColumnModel().getColumn(1).setMinWidth(120);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(120);
        }

        Novo_cadastro2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Novo_cadastro2.setForeground(new java.awt.Color(0, 77, 64));
        Novo_cadastro2.setText("REALIZAR UMA COMPRA");

        jcbNomeCliente.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jcbNomeCliente.setForeground(new java.awt.Color(0, 77, 64));
        jcbNomeCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar" }));

        jLabel18.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 77, 64));
        jLabel18.setText("Cód. Produto");
        jLabel18.setToolTipText("");

        jtfCodProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfCodProdutoKeyTyped(evt);
            }
        });

        jcbNomeProduto.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jcbNomeProduto.setForeground(new java.awt.Color(0, 77, 64));
        jcbNomeProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar" }));

        jLabel19.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 77, 64));
        jLabel19.setText("Nome do Produto");
        jLabel19.setToolTipText("");

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 77, 64));
        jLabel12.setText("Quantidade");
        jLabel12.setToolTipText("");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfCodProduto)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(jtfNome)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelCidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbNomeCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbNomeProduto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfCompra)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(Novo_cadastro2)
                .addContainerGap(291, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Novo_cadastro2)
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcbNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelCidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(13, 13, 13)
                                .addComponent(jtfCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcbNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addContainerGap())
        );

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir))
                .addContainerGap())
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

    private void jtfNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNomeKeyTyped
        char keyChar = evt.getKeyChar();
        if (Character.isLowerCase(keyChar)) {
            evt.setKeyChar(Character.toUpperCase(keyChar));
        }
    }//GEN-LAST:event_jtfNomeKeyTyped

    private void jLabelCidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCidadeMouseClicked

    }//GEN-LAST:event_jLabelCidadeMouseClicked

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
//        Salvar();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
//        if (evt.getClickCount() == 2) {
//            try {
//                SelecionarCliente();
//            } catch (SQLException ex) {
//                Logger.getLogger(PrincipalCompras.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (ParseException ex) {
//                Logger.getLogger(PrincipalCompras.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        PrincipalProduto cadProduto = new PrincipalProduto();
        cadProduto.setVisible(true);
        cadProduto.pack();
        cadProduto.setLocationRelativeTo(null);
        cadProduto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
//        try {
//            SelecionarCliente();
//        } catch (SQLException ex) {
//            Logger.getLogger(PrincipalCompras.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ParseException ex) {
//            Logger.getLogger(PrincipalCompras.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
//        ExcluirCliente();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jtfCodProdutoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCodProdutoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCodProdutoKeyTyped

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
            java.util.logging.Logger.getLogger(PrincipalCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalCompras().setVisible(true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCidade;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> jcbNomeCliente;
    private javax.swing.JComboBox<String> jcbNomeProduto;
    private javax.swing.JLabel jlDiaDataSemana;
    private javax.swing.JLabel jlHora;
    private javax.swing.JTextField jtfCodProduto;
    private javax.swing.JTextField jtfCompra;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfQtd;
    private javax.swing.JLabel minimizar;
    // End of variables declaration//GEN-END:variables
}

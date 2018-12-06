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

/**
 *
 * @author Programador-03
 */
public class PrincipalCliente extends javax.swing.JFrame {

    private final Conexao conexao = new Conexao();
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;
    private final Utilitarios utils = new Utilitarios();
    private final ViewInfo mensagem = new ViewInfo(null, true);
    private static final PrincipalCliente view = new PrincipalCliente();
    DefaultTableModel modelo;
    String nomeSemana, data, hora, funcao;
    
    public PrincipalCliente() {
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
                        + "id_cliente, "
                        + "cliente_nome, "
                        + "cliente_cpf, "
                        + "cliente_cpa, "
                        + "cliente_telefone "
                        + "FROM cliente");
                rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    modelo.addRow(new Object[]{
                        rs.getString("id_cliente"),
                        rs.getString("cliente_nome"),
                        rs.getString("cliente_cpf"),
                        rs.getString("cliente_cpa"),
                        rs.getString("cliente_telefone")
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
        jtfNome.setText("");
        jtfCpf.setText("");
        jtfCpa.setText("");
        jDateNasc.setDate(null);
        jDateCad.setDate(null);
        jtfEnd.setText("");
        jtfTelefone.setText("");
    }

    private void Salvar() {
        if (jtfNome.getText().isEmpty() || jtfNome.getText() == null && jtfCpf.getText().isEmpty() || jtfCpf.getText() == null) {
            mensagem.setMensagem("ATENÇÃO", "Prencha todos os dados!", "/Icones/icons8_Cancel_32px_1.png", 183, 28, 28);
            mensagem.setVisible(true);
        } else {
            if (!conexao.obterConexao()) {
                mensagem.setMensagem("ATENÇÃO", "Falha ao conectar com o Banco de Dados!", "/Icones/icons8_Cancel_32px_1.png", 183, 28, 28);
                mensagem.setVisible(true);
                return;
            }

            try {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

                preparedStatement = conexao.con.prepareStatement("INSERT INTO lojaarms.cliente "
                        + "(cliente_nome, cliente_DataNasc, cliente_cpf, cliente_DataCad, cliente_end, cliente_telefone, cliente_cpa) VALUES (?, ?, ?, ?, ?, ?, ?)");

                preparedStatement.setString(1, jtfNome.getText());
                String DateNasc = format.format(jDateNasc.getDate());
                preparedStatement.setDate(2, utils.FormatarData(DateNasc));
                preparedStatement.setString(3, jtfCpf.getText());
                String DateCad = format.format(jDateCad.getDate());
                preparedStatement.setDate(4, utils.FormatarData(DateCad));
                preparedStatement.setString(5, jtfEnd.getText());
                preparedStatement.setString(6, jtfTelefone.getText());
                preparedStatement.setString(7, jtfCpa.getText());

                int resposta = preparedStatement.executeUpdate();

                if (resposta > 0) {
                    limparCampos();
                    mensagem.setMensagem("MENSAGEM", "Dados inseridos com sucesso!", "/Icones/icons8_Ok_32px.png", 1, 87, 155);
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
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabelCidade = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jtfEnd = new javax.swing.JTextField();
        jDateNasc = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jtfTelefone = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jtfCpa = new javax.swing.JTextField();
        jtfCpf = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Novo_cadastro2 = new javax.swing.JLabel();
        jDateCad = new com.toedter.calendar.JDateChooser();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

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
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jLabel3.setEnabled(false);
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

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

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 77, 64));
        jLabel16.setText("Nome");
        jLabel16.setToolTipText("");

        jtfNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfNomeKeyTyped(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 77, 64));
        jLabel17.setText("CPF");
        jLabel17.setToolTipText("");

        jLabel19.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 77, 64));
        jLabel19.setText("Data de Nascimento");
        jLabel19.setToolTipText("");

        jLabel20.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 77, 64));
        jLabel20.setText("Data de Cadastro");
        jLabel20.setToolTipText("");

        jLabelCidade.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelCidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCidadeMouseClicked(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 77, 64));
        jLabel21.setText("Endereço");
        jLabel21.setToolTipText("");

        jtfEnd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfEndKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 77, 64));
        jLabel10.setText("Telefone");
        jLabel10.setToolTipText("");

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 77, 64));
        jLabel11.setText("CPA");
        jLabel11.setToolTipText("");

        jtfCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfCpfKeyTyped(evt);
            }
        });

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
            jTable1.getColumnModel().getColumn(0).setMinWidth(10);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(1).setMinWidth(120);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(120);
        }

        Novo_cadastro2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Novo_cadastro2.setForeground(new java.awt.Color(0, 77, 64));
        Novo_cadastro2.setText("Cadastro de Clientes");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(274, 274, 274)
                .addComponent(Novo_cadastro2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(291, 291, 291))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfNome)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfCpf)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(jDateNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                                .addComponent(jLabelCidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jDateCad, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jtfEnd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jtfCpa, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfTelefone, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(16, 16, 16))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Novo_cadastro2)
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfCpa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabelCidade)
                            .addGap(22, 22, 22)
                            .addComponent(jtfEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel21)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel19)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jDateNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel20)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jDateCad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, -1, 540));

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

    private void jtfNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNomeKeyTyped
        char keyChar = evt.getKeyChar();
        if (Character.isLowerCase(keyChar)) {
            evt.setKeyChar(Character.toUpperCase(keyChar));
        }
    }//GEN-LAST:event_jtfNomeKeyTyped

    private void jLabelCidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCidadeMouseClicked

    }//GEN-LAST:event_jLabelCidadeMouseClicked

    private void jtfEndKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfEndKeyTyped
        char keyChar = evt.getKeyChar();
        if (Character.isLowerCase(keyChar)) {
            evt.setKeyChar(Character.toUpperCase(keyChar));
        }
    }//GEN-LAST:event_jtfEndKeyTyped

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Salvar();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jtfCpfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCpfKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfCpfKeyTyped

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 2) {
            //SelecionarCliente();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        PrincipalProduto cadProduto = new PrincipalProduto();
        cadProduto.setVisible(true);
        cadProduto.pack();
        cadProduto.setLocationRelativeTo(null);
        cadProduto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.dispose();
    }//GEN-LAST:event_jLabel9MouseClicked

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
            java.util.logging.Logger.getLogger(PrincipalCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Novo_cadastro2;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel fechar;
    private com.toedter.calendar.JDateChooser jDateCad;
    private com.toedter.calendar.JDateChooser jDateNasc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCidade;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jlDiaDataSemana;
    private javax.swing.JLabel jlHora;
    private javax.swing.JTextField jtfCpa;
    private javax.swing.JTextField jtfCpf;
    private javax.swing.JTextField jtfEnd;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfTelefone;
    private javax.swing.JLabel minimizar;
    // End of variables declaration//GEN-END:variables
}

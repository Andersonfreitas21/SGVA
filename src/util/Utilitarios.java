package util;

import conexao.Conexao;
import java.awt.Color;
import java.awt.Component;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableCellRenderer;
import mensagens.ViewInfo;

/**
 *
 * @author Romario Cordeiro
 */
public class Utilitarios {


    private final Conexao conexao = new Conexao();
    private PreparedStatement preparedStatement = null;
    private PreparedStatement preparedStatement2 = null;
    private ResultSet rs = null;
    private ResultSet rs2 = null;
    private final ViewInfo mensagem = new ViewInfo(null, true);
    public static int idUsuario, numeroLinha, idPromotor, idTomador, idFilial;
    public static String nomeUsuario;

    private NumberFormat nf = null;

    public String formtarData(String dataEmUmFormato, String formatoData) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat(formatoData);
        Date data = formato.parse(dataEmUmFormato);
        formato.applyPattern("dd/MM/yyyy");
        return formato.format(data);
    }

    public String convertStringToDate(Date indate, String formatoData) {
        String dateString = null;
        SimpleDateFormat sdfr = new SimpleDateFormat(formatoData);

        try {
            dateString = sdfr.format(indate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateString;
    }

    public boolean verificaSeInteiro(String s) {
        boolean d = true;
        for (int i = 0; i < s.length(); i++) {
            // verifica se o char não é um dígito  
            if (!Character.isDigit(s.charAt(i))) {
                d = false;
                break;
            }
        }
        return d;
    }

    public java.sql.Date FormatarData(String Data) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return new java.sql.Date(df.parse(Data).getTime());
    }

    public String FormatarData(Date data) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(data);
    }

    public String FormatarHora(Date data) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        return formatter.format(data);
    }

    static public void modeloOverrideJtableCorDefault(JTable tabelaCtl) {
        tabelaCtl.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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
    }

}

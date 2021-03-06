package bentech_01_Views;

import bentech_01_Conexao.ConectarMydb;
import bentech_01_Model.Cadastro;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FrmDeletar extends JFrame {

    //botões
    JButton btnSair = new JButton();
    JButton btnDeletar = new JButton();

    //painel
    JPanel painel = new JPanel();

    //tabela
    JTable tabelaPesquisar = new JTable();

    //Barra de Rolagem
    JScrollPane rolagem = new JScrollPane();

    //Modelo da tabela
    DefaultTableModel modelo = new DefaultTableModel();

    //Rotulos
    JLabel lblNome = new JLabel("Nome Completo");
    JLabel lblTelRes = new JLabel("Tel. Casa");
    JLabel lblTelCel = new JLabel("Tel. Celular");
    JLabel lblTelCom = new JLabel("Tel. Outros");
    JLabel lblEmail = new JLabel("E-mail ");
    JLabel lblTitulo = new JLabel("Deletar Cadastro ");
    JLabel lblPesNome = new JLabel("Pesquisar por nome.: ");
    JLabel lblID = new JLabel("ID.: ");
    JLabel lblIdTabela = new JLabel("ID ");

    //caixas de textos
    JTextField txtNome = new JTextField();
    JTextField txtID = new JTextField();

    //ações dos botões
    ButtonHandler handler = new ButtonHandler();
    TextoDigitado textoDigitado = new TextoDigitado();
    MouseEventos mouseEventos = new MouseEventos();

    //variavies
    String sql = "SELECT * FROM pessoa ORDER BY nome DESC";
    String colunas[] = {"nome", "telefoneResidencial", "telefoneCelular", "telefoneComercial", "email"};

    //icones
    ImageIcon sair = new ImageIcon(getClass().getResource("/img/retornar.png"));
    ImageIcon deletar = new ImageIcon(getClass().getResource("/img/deletar.png"));
    ImageIcon cliente = new ImageIcon(getClass().getResource("/img/cliente.png"));

    //https://www.devmedia.com.br/jtable-utilizando-o-componente-em-interfaces-graficas-swing/28857
    //construtor
    public FrmDeletar() {
        //icon propriedades

        //panel
        painel.setLayout(null);
        painel.setBackground(new Color(26, 51, 210));
        this.add(painel);

        //titulo
        lblTitulo.setBounds(100, 50, 724, 100);
        lblTitulo.setIcon(cliente);
        lblTitulo.setOpaque(true);
        lblTitulo.setBackground(new Color(26, 51, 230));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Courier New", Font.BOLD, 48));
        painel.add(lblTitulo);

        //pesquisar por nome ou cpf rotulos
        lblPesNome.setBounds(5, 200, 250, 30);
        lblPesNome.setForeground(Color.WHITE);
        lblPesNome.setFont(new Font("Courier New", Font.BOLD, 18));
        painel.add(lblPesNome);

        //texto paras as pesquisas
        txtNome.setBounds(252, 200, 392, 30);
        txtNome.setFont(new Font("Courier New", Font.BOLD, 24));
        txtNome.setBackground(new Color(163, 184, 204));
        txtNome.setForeground(new Color(255, 255, 150));
        txtNome.setBorder(null);
        txtNome.setToolTipText("Digite o nome para pesquisar...");
        txtNome.addKeyListener(textoDigitado);
        txtNome.setFocusable(true);
        painel.add(txtNome);

        //Rotulo para o id da linha selecionada
        lblID.setBounds(670, 200, 70, 30);
        lblID.setForeground(Color.WHITE);
        lblID.setFont(new Font("Courier New", Font.BOLD, 18));
        painel.add(lblID);

        //texto que mostra o ida da linha selecionada,não é editavel
        txtID.setBounds(730, 200, 95, 30);
        txtID.setFont(new Font("Courier New", Font.BOLD, 24));
        txtID.setBackground(new Color(163, 184, 204));
        txtID.setForeground(new Color(255, 255, 150));
        txtID.setBorder(null);
        txtID.setEditable(false);
        txtID.setEnabled(false);
        txtID.setToolTipText("Mostra o ID do cadastro");
        txtID.addKeyListener(textoDigitado);
        txtID.setFocusable(true);
        painel.add(txtID);

        //barra de rolagem
        rolagem.setLayout(null);
        rolagem.setBackground(new Color(26, 51, 230));
        rolagem.setBounds(5, 250, 1014, 418);
        painel.add(rolagem);

        //propriedades da tabela
        modelo.addColumn("idpessoa");
        modelo.addColumn("nome");
        modelo.addColumn("telefoneResidencial");
        modelo.addColumn("telefoneCelular");
        modelo.addColumn("telefoneComercial");
        modelo.addColumn("email");

        lblIdTabela.setBounds(10, 10, 60, 50);
        lblIdTabela.setForeground(Color.WHITE);
        lblIdTabela.setFont(new Font("Courier New", Font.BOLD, 18));
        rolagem.add(lblIdTabela);

        lblNome.setBounds(60, 10, 250, 50);
        lblNome.setForeground(Color.WHITE);
        lblNome.setFont(new Font("Courier New", Font.BOLD, 18));
        rolagem.add(lblNome);

        lblTelRes.setBounds(288, 10, 200, 50);
        lblTelRes.setForeground(Color.WHITE);
        lblTelRes.setFont(new Font("Courier New", Font.BOLD, 18));
        rolagem.add(lblTelRes);

        lblTelCel.setBounds(440, 10, 200, 50);
        lblTelCel.setForeground(Color.WHITE);
        lblTelCel.setFont(new Font("Courier New", Font.BOLD, 18));
        rolagem.add(lblTelCel);

        lblTelCom.setBounds(600, 10, 200, 50);
        lblTelCom.setForeground(Color.WHITE);
        lblTelCom.setFont(new Font("Courier New", Font.BOLD, 18));
        rolagem.add(lblTelCom);

        lblEmail.setBounds(758, 10, 200, 50);
        lblEmail.setForeground(Color.WHITE);
        lblEmail.setFont(new Font("Courier New", Font.BOLD, 18));
        rolagem.add(lblEmail);

        tabelaPesquisar.setSelectionBackground(Color.yellow);
        tabelaPesquisar.setSelectionForeground(Color.BLACK);
        tabelaPesquisar.setModel(modelo);
        tabelaPesquisar.setBounds(10, 50, 994, 348);
        tabelaPesquisar.setBackground(new Color(122, 72, 221));
        tabelaPesquisar.setForeground(Color.WHITE);
        tabelaPesquisar.setFont(new Font("Courier New", Font.BOLD, 15));
        tabelaPesquisar.setRowHeight(25);

        tabelaPesquisar.getColumnModel().getColumn(0).setMaxWidth(50);
        tabelaPesquisar.getColumnModel().getColumn(1).setMaxWidth(230);
        tabelaPesquisar.getColumnModel().getColumn(2).setMaxWidth(160);
        tabelaPesquisar.getColumnModel().getColumn(3).setMaxWidth(160);
        tabelaPesquisar.getColumnModel().getColumn(4).setMaxWidth(160);
        tabelaPesquisar.getColumnModel().getColumn(5).setMaxWidth(250);
        tabelaPesquisar.addMouseListener(mouseEventos);
        rolagem.add(tabelaPesquisar);
        //fim das propriedades da tabela

        //botão sair
        btnSair.setBounds(574, 693, 400, 50);
        btnSair.setBackground(Color.DARK_GRAY.darker());
        btnSair.setForeground(Color.WHITE);
        btnSair.setFont(new Font("Courier New", Font.BOLD, 24));
        btnSair.setText("Retornar");
        btnSair.setIcon(sair);
        btnSair.setToolTipText("Tecle para retornar a tela principal...");
        btnSair.setFocusable(false);
        btnSair.setBorder(null);
        painel.add(btnSair);
        btnSair.addActionListener(handler);

        //botão pesquisar
        btnDeletar.setBounds(50, 693, 400, 50);
        btnDeletar.setBackground(Color.DARK_GRAY.darker());
        btnDeletar.setForeground(Color.WHITE);
        btnDeletar.setFont(new Font("Courier New", Font.BOLD, 24));
        btnDeletar.setText("Deletar");
        btnDeletar.setIcon(deletar);
        btnDeletar.setToolTipText("Selecione na tabela a linha desejada para deletar...");
        btnDeletar.setFocusable(false);
        btnDeletar.setBorder(null);
        painel.add(btnDeletar);
        btnDeletar.addActionListener(handler);

        //janela principal com todos os componentes
        this.setSize(1024, 768);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setVisible(true);

    }//fim do construtor

    //dados buscados no banco de dados
    public void dadosTabela(String sql) {

        try {
            Connection conn;
            conn = ConectarMydb.getconectar();

            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            modelo = (DefaultTableModel) tabelaPesquisar.getModel();
            modelo.setRowCount(0);

            while (rs.next()) {

                modelo.addRow(new Object[]{
                    rs.getInt("idpessoa"),
                    rs.getString("nome"),
                    rs.getString("telefoneResidencial"),
                    rs.getString("telefoneCelular"),
                    rs.getString("telefoneComercial"),
                    rs.getString("email")
                });
            }
            ConectarMydb.fecharConectar(conn, stmt, rs);

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }//fim da classe dados buscados no banco de dados

    //classe criada para as  ações dos botões e outros componentes
    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            if (ae.getSource() == btnSair) {
                dispose();
            }

            if (ae.getSource() == btnDeletar) {
                if (txtID.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Por favor selecionar a linha desejada na tabela para deletar...     ");
                } else {
                    Cadastro.idPessoa = Integer.parseInt(txtID.getText());

                    //confirmar se realmente queres deletar!
                    int resposta = JOptionPane.OK_CANCEL_OPTION;
                    JOptionPane.showConfirmDialog(null, "Desejas realmente deletar estes dados?", "Deletar Dados?", resposta);

                    if (resposta == JOptionPane.OK_OPTION) {

                        deletarLinhaEscolhida();
                        dadosTabela(sql);
                        JOptionPane.showMessageDialog(null, "Dados Deletados...     ");

                    }

                    txtID.setText("");
                    txtNome.setText("");
                }
            }
        }
    }// fim da classe criada para as  ações dos botões e outros componente

    //eventos de digitação de texto
    private class TextoDigitado implements KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) {
            if (ke.getSource() == txtNome) {
                String sqlPesquisar = "SELECT * FROM pessoa WHERE nome LIKE '%"
                        + txtNome.getText() + "%'" + "ORDER BY nome DESC";

                dadosTabela(sqlPesquisar);
            }
        }

        @Override
        public void keyPressed(KeyEvent ke) {
            if (ke.getSource() == txtNome) {
                String sqlPesquisar = "SELECT * FROM pessoa WHERE nome LIKE '%"
                        + txtNome.getText() + "%'" + "ORDER BY nome DESC";

                dadosTabela(sqlPesquisar);
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            if (ke.getSource() == txtNome) {
                String sqlPesquisar = "SELECT * FROM pessoa WHERE nome LIKE '%"
                        + txtNome.getText() + "%'" + "ORDER BY nome DESC";

                dadosTabela(sqlPesquisar);
            }
        }

    }//fim do evento de digitação de texto

    //eventos de click do mouse
    private class MouseEventos implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
            if (me.getSource() == tabelaPesquisar) {

                int linha = tabelaPesquisar.getSelectedRow();

                if (tabelaPesquisar.getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(null, "Linha da tabela vazia ou tabela Vazia...     ");
                } else {
                    txtID.setText(tabelaPesquisar.getValueAt(linha, 0).toString());
                    txtNome.setText(tabelaPesquisar.getValueAt(linha, 1).toString());
                }

            }

            if (me.getClickCount() == 2) {

                if (txtID.getText().equals("")) {

                    JOptionPane.showMessageDialog(null, "Por favor selecionar a linha desejada na tabela para deletar...     ");

                } else {
                    Cadastro.idPessoa = Integer.parseInt(txtID.getText());

                    //confirmar se realmente queres deletar!
                    int resposta = JOptionPane.OK_CANCEL_OPTION;

                    JOptionPane.showConfirmDialog(null, "Desejas realmente deletar estes dados?", "Deletar Dados?", resposta);

                    if (resposta == JOptionPane.OK_OPTION) {

                        deletarLinhaEscolhida();
                        dadosTabela(sql);
                        JOptionPane.showMessageDialog(null, "Dados Deletados...     ");

                    }

                    txtID.setText("");
                    txtNome.setText("");

                }

            }
        }

        @Override
        public void mousePressed(MouseEvent me) {
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        }

        @Override
        public void mouseEntered(MouseEvent me) {
        }

        @Override
        public void mouseExited(MouseEvent me
        ) {
        }

    }//Fim dos eventos de click do mouse

    //metodo para deletar a linha escolhida
    public void deletarLinhaEscolhida() {

        Connection conn = ConectarMydb.getconectar();
        String sqlDeletar = "DELETE FROM pessoa WHERE idpessoa = ?";
        PreparedStatement stmt = null;

        try {

            stmt = conn.prepareStatement(sqlDeletar);
            stmt.setInt(1, Cadastro.idPessoa);
            stmt.executeUpdate();
            ConectarMydb.fecharConectar(conn, stmt);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }//fim do metodo

}

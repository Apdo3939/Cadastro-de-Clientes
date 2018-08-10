package bentech_01_Views;

import bentech_01_Conexao.ConectarMydb;
import bentech_01_Model.Cadastro;
import bentech_01_Model.CadastroConectar;
import bentech_01_Model.EstadosBrasil;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class FrmCadAtualizar extends JFrame {

    //classes especiais
    EstadosBrasil cbEstadosBrasil = new EstadosBrasil();

    //paineis
    JPanel painel = new JPanel();
    JPanel painel1 = new JPanel();

    //rotulos
    JLabel lblTitulo = new JLabel();
    JLabel lblId = new JLabel();
    JLabel lblNome = new JLabel();
    JLabel lblDataNascimento = new JLabel();
    JLabel lblCpf = new JLabel();
    JLabel lblRg = new JLabel();
    JLabel lblTelResidencial = new JLabel();
    JLabel lblTelComercial = new JLabel();
    JLabel lblTelCelular = new JLabel();
    JLabel lblEmail = new JLabel();
    JLabel lblSexo = new JLabel();
    JLabel lblLogradouro = new JLabel();
    JLabel lblNumero = new JLabel();
    JLabel lblComplemento = new JLabel();
    JLabel lblCep = new JLabel();
    JLabel lblBairro = new JLabel();
    JLabel lblCidade = new JLabel();
    JLabel lblEstado = new JLabel();

    //campos de textos
    JTextField txtNome = new JTextField();
    JTextField txtId = new JTextField();
    JFormattedTextField txtDataNascimento = new JFormattedTextField();
    JFormattedTextField txtCpf = new JFormattedTextField();
    JFormattedTextField txtRg = new JFormattedTextField();
    JFormattedTextField txtTelResidencial = new JFormattedTextField();
    JFormattedTextField txtTelComercial = new JFormattedTextField();
    JFormattedTextField txtTelCelular = new JFormattedTextField();
    JTextField txtEmail = new JTextField();
    JTextField txtLogradouro = new JTextField();
    JTextField txtNumero = new JTextField();
    JTextField txtComplemento = new JTextField();
    JTextField txtBairro = new JTextField();
    JTextField txtCidade = new JTextField();
    JFormattedTextField txtCep = new JFormattedTextField();

    //Comboboxes
    JComboBox cbSexo = new JComboBox();

    //botões
    JButton btnBuscarCep = new JButton();
    JButton btnAtualizar = new JButton();
    JButton btnSair = new JButton();

    //a ação dos botões
    ButtonHandler handler = new ButtonHandler();

    //icones
    ImageIcon sair = new ImageIcon(getClass().getResource("/img/retornar.png"));
    ImageIcon atualizar = new ImageIcon(getClass().getResource("/img/atualizar.png"));
    ImageIcon limpar = new ImageIcon(getClass().getResource("/img/limpar.png"));
    ImageIcon principal = new ImageIcon(getClass().getResource("/img/Cadastro.png"));
    ImageIcon pesquisar = new ImageIcon(getClass().getResource("/img/pesquisar.png"));

    //construtor
    public FrmCadAtualizar() {

        try {
            //data de nascimento
            MaskFormatter maskData = new MaskFormatter("##/##/####");
            maskData.install(txtDataNascimento);

            //cpf
            MaskFormatter maskCpf = new MaskFormatter("###.###.###-##");
            maskCpf.install(txtCpf);

            //cep
            MaskFormatter maskCep = new MaskFormatter("#####-###");
            maskCep.install(txtCep);

            //telefone Residencial
            MaskFormatter maskTelRes = new MaskFormatter("##-####-####");
            maskTelRes.install(txtTelResidencial);

            //telefone Celular
            MaskFormatter maskTelCel = new MaskFormatter("##-#-####-####");
            maskTelCel.install(txtTelCelular);

            //telefone Comercial
            MaskFormatter maskTelCom = new MaskFormatter("##-####-####");
            maskTelCom.install(txtTelComercial);

            //RG
            MaskFormatter maskRg = new MaskFormatter(" ###.###.###.##");
            maskRg.install(txtRg);

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        //painel principal
        painel.setBackground(new Color(122, 72, 221));
        painel.setLayout(null);
        this.add(painel);

        //rotulo para o titulo
        lblTitulo.setBounds(50, 10, 924, 50);
        lblTitulo.setIcon(principal);
        lblTitulo.setText("ATUALIZAÇÃO DE CLIENTES");
        lblTitulo.setForeground(new Color(255, 255, 150));
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 48));
        painel.add(lblTitulo);

        //painel dados pessoais
        painel1.setBackground(new Color(26, 51, 213));
        painel1.setLayout(null);
        painel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Pessoais", 1, 2, new Font("Arial", Font.BOLD, 12), Color.WHITE));
        painel1.setBounds(50, 70, 924, 600);
        painel.add(painel1);

        //rotulos para o painel1 dados pessoais
        lblId.setBounds(25, 25, 50, 25);
        lblId.setText("ID: ");
        lblId.setForeground(Color.WHITE);
        lblId.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 24));
        painel1.add(lblId);

        lblNome.setBounds(100, 25, 474, 25);
        lblNome.setText("Nome: ");
        lblNome.setForeground(Color.WHITE);
        lblNome.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 24));
        painel1.add(lblNome);

        lblSexo.setBounds(624, 25, 250, 25);
        lblSexo.setText("Sexo: ");
        lblSexo.setForeground(Color.WHITE);
        lblSexo.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 24));
        painel1.add(lblSexo);

        lblCpf.setBounds(25, 105, 200, 25);
        lblCpf.setText("Cpf: ");
        lblCpf.setForeground(Color.WHITE);
        lblCpf.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 24));
        painel1.add(lblCpf);

        lblRg.setBounds(325, 105, 275, 25);
        lblRg.setText("RG: ");
        lblRg.setForeground(Color.WHITE);
        lblRg.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 24));
        painel1.add(lblRg);

        lblDataNascimento.setBounds(624, 105, 275, 25);
        lblDataNascimento.setText("Data Nasc.: ");
        lblDataNascimento.setForeground(Color.WHITE);
        lblDataNascimento.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 24));
        painel1.add(lblDataNascimento);

        lblTelResidencial.setBounds(25, 185, 275, 25);
        lblTelResidencial.setText("Tel Res.: ");
        lblTelResidencial.setForeground(Color.WHITE);
        lblTelResidencial.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 24));
        painel1.add(lblTelResidencial);

        lblTelComercial.setBounds(325, 185, 274, 25);
        lblTelComercial.setText("Tel Com.: ");
        lblTelComercial.setForeground(Color.WHITE);
        lblTelComercial.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 24));
        painel1.add(lblTelComercial);

        lblTelCelular.setBounds(624, 185, 275, 25);
        lblTelCelular.setText("Tel Cel.: ");
        lblTelCelular.setForeground(Color.WHITE);
        lblTelCelular.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 24));
        painel1.add(lblTelCelular);

        lblLogradouro.setBounds(25, 265, 275, 25);
        lblLogradouro.setText("Lougradouro: ");
        lblLogradouro.setForeground(Color.WHITE);
        lblLogradouro.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 24));
        painel1.add(lblLogradouro);

        lblNumero.setBounds(624, 265, 80, 25);
        lblNumero.setText("Num.: ");
        lblNumero.setForeground(Color.WHITE);
        lblNumero.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 24));
        painel1.add(lblNumero);

        lblCep.setBounds(729, 265, 80, 25);
        lblCep.setText("Cep: ");
        lblCep.setForeground(Color.WHITE);
        lblCep.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 24));
        painel1.add(lblCep);

        lblComplemento.setBounds(25, 345, 275, 25);
        lblComplemento.setText("Complemento: ");
        lblComplemento.setForeground(Color.WHITE);
        lblComplemento.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 24));
        painel1.add(lblComplemento);

        lblBairro.setBounds(25, 425, 275, 25);
        lblBairro.setText("Bairro: ");
        lblBairro.setForeground(Color.WHITE);
        lblBairro.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 24));
        painel1.add(lblBairro);

        lblCidade.setBounds(325, 425, 274, 25);
        lblCidade.setText("Cidade: ");
        lblCidade.setForeground(Color.WHITE);
        lblCidade.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 24));
        painel1.add(lblCidade);

        lblEstado.setBounds(624, 425, 275, 25);
        lblEstado.setText("UF: ");
        lblEstado.setForeground(Color.WHITE);
        lblEstado.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 24));
        painel1.add(lblEstado);

        lblEmail.setBounds(25, 505, 599, 25);
        lblEmail.setText("E-mail: ");
        lblEmail.setForeground(Color.WHITE);
        lblEmail.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 24));
        painel1.add(lblEmail);

        //campos de texto para o painel1 dados pessoais
        txtId.setBounds(25, 60, 50, 25);
        txtId.setFont(new Font("Courier New", Font.BOLD, 24));
        txtId.setBackground(Color.DARK_GRAY);
        txtId.setForeground(Color.WHITE);
        txtId.setBorder(null);
        txtId.setEnabled(false);
        txtId.setToolTipText("O id é automático do sistema");
        painel1.add(txtId);

        txtNome.setBounds(100, 60, 499, 25);
        txtNome.setFont(new Font("Courier New", Font.BOLD, 24));
        txtNome.setBackground(new Color(163, 184, 204));
        txtNome.setForeground(new Color(255, 255, 150));
        txtNome.setBorder(null);
        txtNome.setToolTipText("Digite o nome completo...");
        txtNome.setFocusable(true);
        painel1.add(txtNome);

        cbSexo.setBounds(624, 60, 275, 25);
        cbSexo.addItem("Masculino");
        cbSexo.addItem("Feminino");
        cbSexo.setBackground(new Color(163, 184, 204));
        cbSexo.setForeground(new Color(255, 255, 150));
        cbSexo.setFont(new Font("Courier New", Font.BOLD, 24));
        painel1.add(cbSexo);

        txtCpf.setBounds(25, 140, 200, 25);
        txtCpf.setFont(new Font("Courier New", Font.BOLD, 24));
        txtCpf.setBackground(Color.DARK_GRAY);
        txtCpf.setForeground(Color.WHITE);
        txtCpf.setBorder(null);
        txtCpf.setToolTipText("Digite o seu Cpf...");
        painel1.add(txtCpf);

        txtRg.setBounds(325, 140, 200, 25);
        txtRg.setFont(new Font("Courier New", Font.BOLD, 24));
        txtRg.setBackground(Color.DARK_GRAY);
        txtRg.setForeground(Color.WHITE);
        txtRg.setBorder(null);
        txtRg.setToolTipText("Digite o seu Rg...");
        painel1.add(txtRg);

        txtDataNascimento.setBounds(624, 140, 148, 25);
        txtDataNascimento.setFont(new Font("Courier New", Font.BOLD, 24));
        txtDataNascimento.setBackground(Color.DARK_GRAY);
        txtDataNascimento.setForeground(Color.WHITE);
        txtDataNascimento.setBorder(null);
        txtDataNascimento.setToolTipText("Digite a sua data de nascimento...");
        painel1.add(txtDataNascimento);

        txtTelResidencial.setBounds(25, 220, 200, 25);
        txtTelResidencial.setFont(new Font("Courier New", Font.BOLD, 24));
        txtTelResidencial.setBackground(Color.DARK_GRAY);
        txtTelResidencial.setForeground(Color.WHITE);
        txtTelResidencial.setBorder(null);
        txtTelResidencial.setToolTipText("Digite o telefone residêncial...");
        painel1.add(txtTelResidencial);

        txtTelComercial.setBounds(325, 220, 200, 25);
        txtTelComercial.setFont(new Font("Courier New", Font.BOLD, 24));
        txtTelComercial.setBackground(Color.DARK_GRAY);
        txtTelComercial.setForeground(Color.WHITE);
        txtTelComercial.setBorder(null);
        txtTelComercial.setToolTipText("Digite o telefone comercial...");
        painel1.add(txtTelComercial);

        txtTelCelular.setBounds(624, 220, 200, 25);
        txtTelCelular.setFont(new Font("Courier New", Font.BOLD, 24));
        txtTelCelular.setBackground(Color.DARK_GRAY);
        txtTelCelular.setForeground(Color.WHITE);
        txtTelCelular.setBorder(null);
        txtTelCelular.setToolTipText("Digite o telefone celular...");
        painel1.add(txtTelCelular);

        txtLogradouro.setBounds(25, 300, 574, 25);
        txtLogradouro.setFont(new Font("Courier New", Font.BOLD, 24));
        txtLogradouro.setBackground(Color.DARK_GRAY);
        txtLogradouro.setForeground(Color.WHITE);
        txtLogradouro.setBorder(null);
        txtLogradouro.setToolTipText("Digite o seu endereço, rua, avenida, beco e etc...");
        painel1.add(txtLogradouro);

        txtNumero.setBounds(624, 300, 80, 25);
        txtNumero.setFont(new Font("Courier New", Font.BOLD, 24));
        txtNumero.setBackground(Color.DARK_GRAY);
        txtNumero.setForeground(Color.WHITE);
        txtNumero.setBorder(null);
        txtNumero.setToolTipText("Digite o numero do seu logradouro...");
        painel1.add(txtNumero);

        txtCep.setBounds(729, 300, 148, 25);
        txtCep.setFont(new Font("Courier New", Font.BOLD, 24));
        txtCep.setBackground(Color.DARK_GRAY);
        txtCep.setForeground(Color.WHITE);
        txtCep.setBorder(null);
        txtCep.setToolTipText("Digite o numero do seu cep...");
        painel1.add(txtCep);

        txtComplemento.setBounds(25, 380, 574, 25);
        txtComplemento.setFont(new Font("Courier New", Font.BOLD, 24));
        txtComplemento.setBackground(Color.DARK_GRAY);
        txtComplemento.setForeground(Color.WHITE);
        txtComplemento.setBorder(null);
        txtComplemento.setToolTipText("Digite o seu endereço, rua, avenida, beco e etc...");
        painel1.add(txtComplemento);

        txtBairro.setBounds(25, 460, 275, 25);
        txtBairro.setFont(new Font("Courier New", Font.BOLD, 24));
        txtBairro.setBackground(Color.DARK_GRAY);
        txtBairro.setForeground(Color.WHITE);
        txtBairro.setBorder(null);
        txtBairro.setToolTipText("Digite o nome do seu bairro...");
        painel1.add(txtBairro);

        txtCidade.setBounds(325, 460, 274, 25);
        txtCidade.setFont(new Font("Courier New", Font.BOLD, 24));
        txtCidade.setBackground(Color.DARK_GRAY);
        txtCidade.setForeground(Color.WHITE);
        txtCidade.setBorder(null);
        txtCidade.setToolTipText("Digite o nome da sua cidade...");
        painel1.add(txtCidade);

        cbEstadosBrasil.setBounds(624, 460, 275, 25);
        cbEstadosBrasil.setBackground(Color.DARK_GRAY);
        cbEstadosBrasil.setForeground(Color.WHITE);
        cbEstadosBrasil.setFont(new Font("Courier New", Font.BOLD, 18));
        painel1.add(cbEstadosBrasil);

        txtEmail.setBounds(25, 540, 574, 25);
        txtEmail.setFont(new Font("Courier New", Font.BOLD, 24));
        txtEmail.setBackground(Color.DARK_GRAY);
        txtEmail.setForeground(Color.WHITE);
        txtEmail.setBorder(null);
        txtEmail.setToolTipText("Digite o seu e-mail...");
        painel1.add(txtEmail);

        //pesquisar cep
        btnBuscarCep.setBounds(624, 367, 275, 50);
        btnBuscarCep.setBackground(new Color(100, 150, 150));
        btnBuscarCep.setForeground(Color.WHITE);
        btnBuscarCep.setFont(new Font("Courier New", Font.BOLD, 24));
        btnBuscarCep.setText("Buscar Cep");
        btnBuscarCep.setIcon(pesquisar);
        btnBuscarCep.setToolTipText("Tecle para acessar o site dos correios");
        btnBuscarCep.setFocusable(false);
        btnBuscarCep.setBorder(null);
        painel1.add(btnBuscarCep);
        btnBuscarCep.addActionListener(handler);

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

        //botão cadastrar
        btnAtualizar.setBounds(50, 693, 400, 50);
        btnAtualizar.setBackground(Color.DARK_GRAY.darker());
        btnAtualizar.setForeground(Color.WHITE);
        btnAtualizar.setFont(new Font("Courier New", Font.BOLD, 24));
        btnAtualizar.setText("Atualizar");
        btnAtualizar.setIcon(atualizar);
        btnAtualizar.setToolTipText("Tecle para atualizar o cadastro...");
        btnAtualizar.setFocusable(false);
        btnAtualizar.setBorder(null);
        painel.add(btnAtualizar);
        btnAtualizar.addActionListener(handler);

        //janela principal com todos os componentes
        this.setSize(1024, 768);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setVisible(true);

    }//fim do construtor

//------------------------------------------------------------------------------    
    //classe criada para dar ações para os botões e outros componentes
    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            if (ae.getSource() == btnSair) {
                dispose();
            }

            if (ae.getSource() == btnAtualizar) {
                atualizarTexto();
                limpaTexto();
            }

            if (ae.getSource() == btnBuscarCep) {
                try {
                    Runtime.getRuntime().exec("C:/Program Files (x86)/Mozilla Firefox/firefox http://www.correios.com.br");

                } catch (IOException e) {

                    JOptionPane.showMessageDialog(null, "Não Conseguiu Carregar !" + e.getMessage());
                }
            }
        }

    }//fim da classe ações de botões e outros componentes

    public void limpaTexto() {

        txtNome.setText("");
        txtId.setText("");
        txtDataNascimento.setText("");
        txtCpf.setText("");
        txtRg.setText("");
        txtTelResidencial.setText("");
        txtTelComercial.setText("");
        txtTelCelular.setText("");
        txtEmail.setText("");
        txtLogradouro.setText("");
        txtNumero.setText("");
        txtComplemento.setText("");
        txtBairro.setText("");
        txtCidade.setText("");
        txtCep.setText("");
        cbEstadosBrasil.setSelectedIndex(0);
        cbSexo.setSelectedIndex(0);
    }

    public void atualizarTexto() {

        CadastroConectar cadastro = new CadastroConectar();

        if (txtNome.getText().equals("") || txtCpf.getText().equals("") || txtRg.getText().equals("")
                || txtDataNascimento.getText().equals("") || txtTelResidencial.getText().equals("")
                || txtEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Os campos nome, cpf, rg, data de nascimento, telefone residencial e e-mail são obrigatórios!");
        } else {
            Cadastro.nome = txtNome.getText();

            //convertendo date em string
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            try {
                java.util.Date date = sdf.parse(txtDataNascimento.getText());
                java.sql.Date dateSql = new java.sql.Date(date.getTime());
                Cadastro.dataNasc = dateSql;
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

            Cadastro.cpf = txtCpf.getText();
            Cadastro.rg = txtRg.getText();
            Cadastro.telRes = txtTelResidencial.getText();
            Cadastro.telCom = txtTelComercial.getText();
            Cadastro.telCel = txtTelCelular.getText();
            Cadastro.email = txtEmail.getText();
            Cadastro.logradouro = txtLogradouro.getText();
            Cadastro.numero = txtNumero.getText();
            Cadastro.complemento = txtComplemento.getText();
            Cadastro.bairro = txtBairro.getText();
            Cadastro.cidade = txtCidade.getText();
            Cadastro.cep = txtCep.getText();
            Cadastro.sexo = cbSexo.getSelectedItem().toString();
            Cadastro.uf = cbEstadosBrasil.getSelectedItem().toString();
            cadastro.atualizarCliente();
        }
    }

    public void carregarDados() {

        String sqlCarregar = "SELECT * FROM pessoa WHERE idpessoa = '" + Cadastro.idPessoa + "'";

        Connection conn = ConectarMydb.getconectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement(sqlCarregar);
            stmt.execute();
            rs = stmt.executeQuery();

            while (rs.next()) {

                txtNome.setText(rs.getString("nome"));
                txtId.setText(rs.getString("idpessoa"));

                DateFormat data = new SimpleDateFormat("dd/MM/yyyy");
                txtDataNascimento.setText(data.format(rs.getDate("datanascimento")));

                txtCpf.setText(rs.getString("cpf"));
                txtRg.setText(rs.getString("rg"));
                txtTelResidencial.setText(rs.getString("telefoneResidencial"));
                txtTelComercial.setText(rs.getString("telefoneComercial"));
                txtTelCelular.setText(rs.getString("telefoneCelular"));
                txtEmail.setText(rs.getString("email"));
                txtLogradouro.setText(rs.getString("logradouro"));
                txtNumero.setText(rs.getString("numero"));
                txtComplemento.setText(rs.getString("complemento"));
                txtBairro.setText(rs.getString("bairro"));
                txtCidade.setText(rs.getString("cidade"));
                txtCep.setText(rs.getString("cep"));
                cbSexo.setSelectedItem(rs.getString("sexo"));
                cbEstadosBrasil.setSelectedItem(rs.getString("uf"));

            }
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ConectarMydb.fecharConectar(conn, stmt, rs);
        }
    }
}

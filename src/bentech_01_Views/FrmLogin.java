package bentech_01_Views;

import bentech_01_Model.LoginConectar;
import bentech_01_Model.Login;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class FrmLogin extends JFrame {

    //icones
    ImageIcon icon = new ImageIcon(getClass().getResource("/img/login.png"));
    ImageIcon entrar = new ImageIcon(getClass().getResource("/img/Entrar.png"));
    ImageIcon sair = new ImageIcon(getClass().getResource("/img/Sair.png"));
    ImageIcon ok = new ImageIcon(getClass().getResource("/img/ok.png"));

    //painel
    JPanel painel = new JPanel();

    //rotulos
    JLabel lblUser = new JLabel("Usuário");
    JLabel lblPassword = new JLabel("Senha");
    JLabel lblLogo = new JLabel();
    JLabel lblEsqueceu = new JLabel("Esqueceu sua senha?");

    //textos
    JTextField txtUser = new JTextField();
    JPasswordField txtPassword = new JPasswordField();

    //botões
    JButton btnLogar = new JButton();
    JButton btnSair = new JButton();

    //a ações dos botões e outros componentes
    ButtonHandler handler = new ButtonHandler();
    TextoDigitado kl = new TextoDigitado();

    //Construtor
    public FrmLogin() {

        //painel principal
        painel.setBackground(new Color(26, 51, 213));
        painel.setLayout(null);
        this.add(painel);

        //label para a logomarca
        lblLogo.setIcon(icon);
        lblLogo.setBounds(100, 15, 256, 256);
        painel.add(lblLogo);

        //label para o usuário
        lblUser.setBounds(50, 250, 200, 50);
        lblUser.setForeground(Color.WHITE);
        lblUser.setFont(new Font("Arial", Font.BOLD, 24));
        painel.add(lblUser);

        //texto para digitação do usuario
        txtUser.setBounds(50, 300, 400, 50);
        txtUser.setFont(new Font("Arial", Font.BOLD, 24));
        txtUser.setBackground(Color.GRAY);
        txtUser.setForeground(Color.WHITE);
        txtUser.setToolTipText("Digite o seu usuário...");
        painel.add(txtUser);

        //label para a senha
        lblPassword.setBounds(50, 350, 200, 50);
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setFont(new Font("Arial", Font.BOLD, 24));
        painel.add(lblPassword);

        //texto para a digitação da senha
        txtPassword.setBounds(50, 400, 400, 50);
        txtPassword.setFont(new Font("Arial", Font.BOLD, 24));
        txtPassword.setBackground(Color.GRAY);
        txtPassword.setForeground(Color.WHITE);
        txtPassword.setToolTipText("Digite a sua senha...");
        painel.add(txtPassword);

        //botão para logar
        btnLogar.setBounds(50, 500, 400, 50);
        btnLogar.setBackground(Color.DARK_GRAY.darker());
        btnLogar.setForeground(Color.WHITE);
        btnLogar.setFont(new Font("Courier New", Font.BOLD, 24));
        btnLogar.setText("Logar");
        btnLogar.setIcon(entrar);
        btnLogar.setToolTipText("Tecle para fazer o logon...");
        btnLogar.setFocusable(false);
        btnLogar.setBorder(null);
        painel.add(btnLogar);
        btnLogar.addActionListener(handler);

        lblEsqueceu.setBounds(325, 455, 200, 20);
        lblEsqueceu.setForeground(Color.WHITE);
        lblEsqueceu.setFont(new Font("Arial", Font.BOLD, 12));
        painel.add(lblEsqueceu);
        lblEsqueceu.addMouseListener(kl);

        //botão para sair
        btnSair.setBounds(50, 600, 400, 50);
        btnSair.setBackground(Color.DARK_GRAY.darker());
        btnSair.setForeground(Color.WHITE);
        btnSair.setFont(new Font("Courier New", Font.BOLD, 24));
        btnSair.setText("Sair");
        btnSair.setIcon(sair);
        btnSair.setToolTipText("Tecle para sair...");
        btnSair.setFocusable(false);
        btnSair.setBorder(null);
        painel.add(btnSair);
        btnSair.addActionListener(handler);

        //janela principal
        this.setSize(500, 700);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setVisible(true);
    }//fim do construtor

    //classe criada para dar ações para os botões e outros componentes
    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            if (ae.getSource() == btnSair) {
                System.exit(0);
            }

            if (ae.getSource() == btnLogar) {
                Login.user = txtUser.getText();
                Login.senha = new String(txtPassword.getPassword());
                if ("".equals(Login.user) && "".equals(Login.senha)) {
                    JOptionPane.showMessageDialog(null, "Por favor digite o usuario e a senha!");
                } else {
                    LoginConectar login = new LoginConectar();
                    login.verificarUsuario();
                    dispose();
                }
            }
        }

    }//fim da classe criada para dar ações para os botões e outros componentes

    private class TextoDigitado implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
            if (me.getSource() == lblEsqueceu) {
                JOptionPane.showMessageDialog(null, "O usuário é:    teste   , "
                        +  "   e a senha é:    teste   !         ", 
                        "Usuário e Senha", 1, ok);
                txtPassword.setText("");
                txtUser.setText("");

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
        public void mouseExited(MouseEvent me) {
        }

    }
}

package bentech_01_Views;

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
import javax.swing.JTextArea;

public class FrmPrincipal extends JFrame {
    
    //painel
    JPanel painel = new JPanel();
    JPanel painel1 = new JPanel();
    JPanel painel2 = new JPanel();
    JPanel painel3 = new JPanel();
    
    //rotulos
    JLabel lblTitulo = new JLabel();
    
    JLabel lblFoto = new JLabel();
    JLabel lblSobremimNome = new JLabel();
    JLabel lblSobremimLocalidade = new JLabel();
    JLabel lblSobremimEmail1 = new JLabel();
    JLabel lblSobremimEmail2 = new JLabel();
    
    //campo de texto
    JTextArea direitosAutorais = new JTextArea();
    
    
    
    //botões
    JButton btnSair = new JButton();
    JButton btnCadastrar = new JButton();
    JButton btnAtualizar = new JButton();
    JButton btnPesquisar = new JButton();
    JButton btnDeletar = new JButton();
    JButton btnAjuda = new JButton();
    JButton btnSobremimFacebook = new JButton();
    JButton btnSobremimLinkdin = new JButton();
    
    //a ações dos botões e outros componentes
    ButtonHandler handler = new ButtonHandler();
    MouseEventos mouseEventos = new MouseEventos();
    
    //icones
    ImageIcon sair = new ImageIcon(getClass().getResource("/img/cancelar.png"));
    ImageIcon cadastrar = new ImageIcon(getClass().getResource("/img/salvar.png"));
    ImageIcon atualizar = new ImageIcon(getClass().getResource("/img/atualizar.png"));
    ImageIcon pesquisar = new ImageIcon(getClass().getResource("/img/pesquisar.png"));
    ImageIcon deletar = new ImageIcon(getClass().getResource("/img/deletar.png"));
    ImageIcon titulo = new ImageIcon(getClass().getResource("/img/Cadastro.png"));
    ImageIcon ajuda = new ImageIcon(getClass().getResource("/img/Cadastro.png"));
    ImageIcon foto = new ImageIcon(getClass().getResource("/img/alex_01.png"));
    ImageIcon facebook = new ImageIcon(getClass().getResource("/img/facebook.png"));
    ImageIcon linkedin = new ImageIcon(getClass().getResource("/img/linkedIn.png"));
    
    //construtor
    public FrmPrincipal(){
        
        
        //painel principal
        painel.setBackground(new Color(122,72,221));
        painel.setLayout(null);
        this.add(painel);
        
        lblTitulo.setBounds(50, 30, 924, 50);
        lblTitulo.setIcon(titulo);
        lblTitulo.setText("ALEX INFO CADASTRO DE CLIENTES MENU");
        lblTitulo.setForeground(new Color(255,255,150));
        lblTitulo.setFont(new Font("Courier New",Font.BOLD,36));
        painel.add(lblTitulo);
        
        //painel que contem os botões de menu
        painel1.setBackground(new Color(26,51,213));
        painel1.setLayout(null);
        painel1.setBounds(50, 150, 350, 568);
        painel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null,"Menu",1, 2, new Font("Courier New", Font.BOLD,18),Color.WHITE));
        painel.add(painel1);
        
        //painel que contem minhas informações pessoais
        painel2.setBackground(new Color(26,51,213));
        painel2.setLayout(null);
        painel2.setBounds(450, 150, 524, 268);
        painel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null,"Sobre Mim...",1, 2, new Font("Courier New", Font.BOLD,18),Color.WHITE));
        painel.add(painel2);
        
        //painel sobre permissões e direitos legais
        painel3.setBackground(new Color(26,51,213));
        painel3.setLayout(null);
        painel3.setBounds(450, 468, 524, 250);
        painel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null,"Observações...",1, 2, new Font("Courier New", Font.BOLD,18),Color.WHITE));
        painel.add(painel3);
        
        //componentes do painel 1
        //botão cadastrar
        btnCadastrar.setBounds(50, 40, 250, 50);
        btnCadastrar.setBackground(Color.DARK_GRAY.darker());
        btnCadastrar.setForeground(Color.WHITE);
        btnCadastrar.setFont(new Font("Courier New", Font.BOLD,24));
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setIcon(cadastrar);
        btnCadastrar.setToolTipText("Tecle para ir ao formulário de cadastro...");
        btnCadastrar.setFocusable(false);
        btnCadastrar.setBorder(null);
        painel1.add(btnCadastrar);
        btnCadastrar.addActionListener(handler);
        btnCadastrar.addMouseListener(mouseEventos);
        
        //botão pesquisar
        btnPesquisar.setBounds(50, 130, 250, 50);
        btnPesquisar.setBackground(Color.DARK_GRAY.darker());
        btnPesquisar.setForeground(Color.WHITE);
        btnPesquisar.setFont(new Font("Courier New", Font.BOLD,24));
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.setIcon(pesquisar);
        btnPesquisar.setToolTipText("Tecle para ir ao formulário de pesquisa...");
        btnPesquisar.setFocusable(false);
        btnPesquisar.setBorder(null);
        painel1.add(btnPesquisar);
        btnPesquisar.addActionListener(handler);
        btnPesquisar.addMouseListener(mouseEventos);
        
        //botão atualizar
        btnAtualizar.setBounds(50, 220, 250, 50);
        btnAtualizar.setBackground(Color.DARK_GRAY.darker());
        btnAtualizar.setForeground(Color.WHITE);
        btnAtualizar.setFont(new Font("Courier New", Font.BOLD,24));
        btnAtualizar.setText("Atualizar");
        btnAtualizar.setIcon(atualizar);
        btnAtualizar.setToolTipText("Tecle para ir ao formulário de atualização...");
        btnAtualizar.setFocusable(false);
        btnAtualizar.setBorder(null);
        painel1.add(btnAtualizar);
        btnAtualizar.addActionListener(handler);
        btnAtualizar.addMouseListener(mouseEventos);
         
        //botão deletar 
        btnDeletar.setBounds(50, 310, 250, 50);
        btnDeletar.setBackground(Color.DARK_GRAY.darker());
        btnDeletar.setForeground(Color.WHITE);
        btnDeletar.setFont(new Font("Courier New", Font.BOLD,24));
        btnDeletar.setText("Deletar");
        btnDeletar.setIcon(deletar);
        btnDeletar.setToolTipText("Tecle para ir ao formulário de deleção...");
        btnDeletar.setFocusable(false);
        btnDeletar.setBorder(null);
        painel1.add(btnDeletar);
        btnDeletar.addActionListener(handler);
        btnDeletar.addMouseListener(mouseEventos);
        
        //botão sobre
        btnAjuda.setBounds(50, 400, 250, 50);
        btnAjuda.setBackground(Color.DARK_GRAY.darker());
        btnAjuda.setForeground(Color.WHITE);
        btnAjuda.setFont(new Font("Courier New", Font.BOLD,24));
        btnAjuda.setText("Ajuda");
        btnAjuda.setIcon(ajuda);
        btnAjuda.setToolTipText("Tecle para dúvidas...");
        btnAjuda.setFocusable(false);
        btnAjuda.setBorder(null);
        painel1.add(btnAjuda);
        btnAjuda.addActionListener(handler);
        btnAjuda.addMouseListener(mouseEventos);
        
        //botão sair
        btnSair.setBounds(50, 490, 250, 50);
        btnSair.setBackground(Color.DARK_GRAY.darker());
        btnSair.setForeground(Color.WHITE);
        btnSair.setFont(new Font("Courier New", Font.BOLD,24));
        btnSair.setText("Sair");
        btnSair.setIcon(sair);
        btnSair.setToolTipText("Tecle para sair...");
        btnSair.setFocusable(false);
        btnSair.setBorder(null);
        painel1.add(btnSair);
        btnSair.addActionListener(handler);
        btnSair.addMouseListener(mouseEventos);
        //Fim dos componentes do painel 1
        
        //componentes do painel 2
        lblFoto.setBounds(30, 40,100 , 166);
        lblFoto.setIcon(foto);
        painel2.add(lblFoto);
        
        lblSobremimNome.setBounds(150, 40, 350, 50);
        lblSobremimNome.setText("ALEXANDRE PEREIRA DE OLIVEIRA");
        lblSobremimNome.setForeground(new Color(255,255,150));
        lblSobremimNome.setFont(new Font("Courier New",Font.BOLD,18));
        painel2.add(lblSobremimNome);
        
        lblSobremimLocalidade.setBounds(150, 80, 350, 50);
        lblSobremimLocalidade.setText("RIO DE JANEIRO, BRASIL");
        lblSobremimLocalidade.setForeground(new Color(255,255,150));
        lblSobremimLocalidade.setFont(new Font("Courier New",Font.BOLD,18));
        painel2.add(lblSobremimLocalidade);
        
        lblSobremimEmail1.setBounds(150, 120, 350, 50);
        lblSobremimEmail1.setText("APDO13@HOTMAIL.COM");
        lblSobremimEmail1.setForeground(new Color(255,255,150));
        lblSobremimEmail1.setFont(new Font("Courier New",Font.BOLD,18));
        painel2.add(lblSobremimEmail1);
        
        lblSobremimEmail2.setBounds(150, 160, 350, 50);
        lblSobremimEmail2.setText("APDO3939@GMAIL.COM");
        lblSobremimEmail2.setForeground(new Color(255,255,150));
        lblSobremimEmail2.setFont(new Font("Courier New",Font.BOLD,18));
        painel2.add(lblSobremimEmail2);
        
        btnSobremimFacebook.setBounds(30, 210, 150, 50);
        btnSobremimFacebook.setIcon(facebook);
        btnSobremimFacebook.setText("FACEBOOK");
        btnSobremimFacebook.setBackground(new Color(26,51,213));
        btnSobremimFacebook.setForeground(Color.WHITE);
        btnSobremimFacebook.setToolTipText("Tecle para ir ao meu facebook...");
        btnSobremimFacebook.setFocusable(false);
        btnSobremimFacebook.setBorder(null);
        painel2.add(btnSobremimFacebook);
        
        btnSobremimLinkdin.setBounds(344, 210, 150, 50);
        btnSobremimLinkdin.setIcon(linkedin);
        btnSobremimLinkdin.setText("LINKEDIN");
        btnSobremimLinkdin.setBackground(new Color(26,51,213));
        btnSobremimLinkdin.setForeground(Color.WHITE);
        btnSobremimLinkdin.setToolTipText("Tecle para ir ao meu LinkedIN...");
        btnSobremimLinkdin.setFocusable(false);
        btnSobremimLinkdin.setBorder(null);
        painel2.add(btnSobremimLinkdin);
        
        //Fim dos componentes do painel 2
        
        //componentes do painel 3
        direitosAutorais.setBounds(30, 30, 464, 190);
        direitosAutorais.setBackground(new Color(122,72,221));
        direitosAutorais.setFont(new Font("Courier New",Font.BOLD,14));
        direitosAutorais.setEditable(false);
        direitosAutorais.setEnabled(false);
        painel3.add(direitosAutorais);
        
        //Fim dos componentes do painel 2
        
        //janela principal com todos os componentes
        this.setSize(1024, 768);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setVisible(true);
        
    }//fim do contrutor
    
    //classe criada para as  ações dos botões e outros componentes
    private class ButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            if(ae.getSource()== btnSair){
                System.exit(0);
            }
            
            if(ae.getSource() == btnCadastrar){
                
                FrmCadastro frmCadastro = new FrmCadastro();
            }
            
            if(ae.getSource() == btnAjuda){
                
                JOptionPane.showMessageDialog(null, "Somente um projeto acadêmico, não voltado para fins comerciais !" );       
                
            }
            
            if(ae.getSource() == btnPesquisar){
                FrmPesquisar pesquisar = new FrmPesquisar();
            }
            
            if(ae.getSource() == btnDeletar){
                FrmDeletar del = new FrmDeletar();
            }
            
           if(ae.getSource() == btnAtualizar){
               FrmAtualizar atual = new FrmAtualizar();
            }
        }
        
    }// fim da classe criada para as  ações dos botões e outros componentes
    
    private class MouseEventos implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent me) {
        }

        @Override
        public void mousePressed(MouseEvent me) {
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            if(me.getSource()== btnSair){
                btnSair.setBackground(new Color(122,72,221));
                direitosAutorais.setText("Ao clicar o botão sair,\nVocê fechará toda a aplicação.");
            }
            if(me.getSource()== btnAjuda){
                btnAjuda.setBackground(new Color(122,72,221));
                direitosAutorais.setText("Ao clicar o botão ajuda,\nVocê terá informações sobre a aplicação.\n"
                        + "A mesma é um projeto acadêmico\ne sem fins comerciais\n"
                        + "Porem se quiseres usares a mesma,\nsomente com finalidade acadêmica e \n"
                        + "dandos os créditos aos seus devidos criadores\n"
                        + "Fabiano Schincariol e Alexandre Pereira.");
            }
            if(me.getSource()== btnAtualizar){
                btnAtualizar.setBackground(new Color(122,72,221));
                direitosAutorais.setText("Ao clicar o botão atualizar,\n"
                        + "Você irá para as telas de atualização de cadastro.");
            }
            if(me.getSource()== btnPesquisar){
                btnPesquisar.setBackground(new Color(122,72,221));
                direitosAutorais.setText("Ao clicar o botão Pesquisar,\nVocê irá para a tela de pesquisas.");
            }
            if(me.getSource()== btnDeletar){
                btnDeletar.setBackground(new Color(122,72,221));
                direitosAutorais.setText("Ao clicar o botão deletar,\nVocê irá para tela de deletar os dados.");
            }
            if(me.getSource() == btnCadastrar){
                btnCadastrar.setBackground(new Color(122,72,221));
                direitosAutorais.setText("Ao clicar o botão cadastrar,\nVocê irá para tela de inserir os dados.");
            }
        }

        @Override
        public void mouseExited(MouseEvent me) {
            
            if(me.getSource()== btnSair){
                btnSair.setBackground(Color.DARK_GRAY.darker());
                direitosAutorais.setText("");
            }
            if(me.getSource()== btnAjuda){
                btnAjuda.setBackground(Color.DARK_GRAY.darker());
                direitosAutorais.setText("");
            }
            if(me.getSource()== btnAtualizar){
                btnAtualizar.setBackground(Color.DARK_GRAY.darker());
                direitosAutorais.setText("");
            }
            if(me.getSource()== btnPesquisar){
                btnPesquisar.setBackground(Color.DARK_GRAY.darker());
                direitosAutorais.setText("");
            }
            if(me.getSource()== btnDeletar){
                btnDeletar.setBackground(Color.DARK_GRAY.darker());
                direitosAutorais.setText("");
            }
            if(me.getSource()== btnCadastrar){
                btnCadastrar.setBackground(Color.DARK_GRAY.darker());
                direitosAutorais.setText("");
            }
            
            
        }
        
    }
}

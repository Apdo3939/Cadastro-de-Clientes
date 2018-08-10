package bentech_01_Views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

public class FrmSplash extends JFrame {
    
    private Timer t;
    private ActionListener al;
    
    JLabel lblLogotipo = new JLabel();
    JLabel lblVersao = new JLabel("Versão 0.0.1");
    JLabel lblDesc = new JLabel("ALEX INFO...");
    JLabel lblSair = new JLabel("X");
    JLabel lblprogresso = new JLabel();
    
    JPanel painel = new JPanel();
    
    ImageIcon icon = new ImageIcon(getClass().getResource("/img/splash.png"));
    
    JProgressBar progresso = new JProgressBar();
    
    EventoMouse me = new EventoMouse();
    
    
    public FrmSplash(){
        
        painel.setBackground(new Color(26, 51, 213));
        painel.setLayout(null);
        this.add(painel);
        
        lblLogotipo.setBounds(2, 2, 476, 316);
        lblLogotipo.setForeground(Color.WHITE);
        lblLogotipo.setFont(new Font("Courier New", Font.BOLD, 24));
        lblLogotipo.setIcon(icon);
        painel.add(lblLogotipo);
        
        lblSair.setBounds(460, 5, 20, 20);
        lblSair.setForeground(new Color(26, 51, 213));
        lblSair.setFont(new Font("Courier New", Font.BOLD, 24));
        lblSair.addMouseListener(me);
        lblLogotipo.add(lblSair);
        
        lblVersao.setBounds(350,280,130,20);
        lblVersao.setForeground(new Color(26, 51, 213));
        lblVersao.setFont(new Font("Courier New", Font.BOLD, 16));
        lblLogotipo.add(lblVersao);
        
        lblprogresso.setBounds(5,280,350,20);
        lblprogresso.setForeground(new Color(26, 51, 213));
        lblprogresso.setFont(new Font("Courier New", Font.BOLD, 16));
        lblprogresso.setText("Carregando ...");
        lblLogotipo.add(lblprogresso);
        
        lblDesc.setBounds(260,140,150,20);
        lblDesc.setForeground(new Color(26, 51, 213));
        lblDesc.setFont(new Font("Courier New", Font.BOLD, 20));
        lblLogotipo.add(lblDesc);
        
        
        progresso.setBounds(0, 300, 480, 20);
        progresso.setBackground(new Color(26, 51, 213));
        progresso.setForeground(new Color(122,72,221));
        lblLogotipo.add(progresso);
        
        this.setSize(480, 320);
        this.setResizable(false);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        
        al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(progresso.getValue() < 100){
                    
                    progresso.setValue(progresso.getValue() + 2);
                    
                }
                else{
                    t.stop();
                }
                if(progresso.getValue()== 98){
                    FrmLogin log = new FrmLogin();
                    dispose();
                    
                }
                
                if(progresso.getValue()== 16){
                    lblprogresso.setText("Carregando arquivos...");
                }
                
                if(progresso.getValue()== 30){
                    lblprogresso.setText("Carregando diretorios...");
                }
                if(progresso.getValue()== 46){
                    lblprogresso.setText("Carregando banco de dados...");
                }
                if(progresso.getValue()== 60){
                    lblprogresso.setText("Finalizando arquivos...");
                }
                if(progresso.getValue()== 76){
                    lblprogresso.setText("Finalizando diretorios...");
                }
                if(progresso.getValue()== 90){
                    lblprogresso.setText("Iniciando a aplicação...");
                }
            }
            
        };
        
        t = new Timer(100, al);
        t.start();
        
        
    }
    
    private class EventoMouse implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent me) {
            if(me.getSource() == lblSair){
                System.exit(0);
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

package bentech_01_Model;

import bentech_01_Conexao.ConectarMydb;
import bentech_01_Views.FrmPrincipal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class LoginConectar {

    String sql = "INSERT INTO Login (usuario,senha) VALUES (?,?)";
    String sql1 = "SELECT * FROM Login WHERE usuario = '" + Login.user + "'";
    ImageIcon ok = new ImageIcon(getClass().getResource("/img/ok.png"));

    //inserir usuário
    public void inserirUsuario() {
        Connection conn;
        conn = ConectarMydb.getconectar();

        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, Login.user);
            stmt.setString(2, Login.senha);
            stmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar no banco de dados     " + e);
        } finally {
            ConectarMydb.fecharConectar(conn, stmt);
        }
    }//fim da classe inserir usuario 

    //verificar se o usuario e a senha estao corretos
    public void verificarUsuario() {

        Connection conn;
        conn = ConectarMydb.getconectar();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement(sql1);
            rs = stmt.executeQuery();
            rs.next();
            String usuario1 = rs.getString("usuario");
            String senha1 = rs.getString("senha");

            if (usuario1.equals(Login.user) && senha1.equals(Login.senha)) {

                JOptionPane.showMessageDialog(null, "Usuário ok!    ", "Usuario", 1, ok);
                FrmPrincipal principal = new FrmPrincipal();
                principal.setVisible(true);

            } else {

                JOptionPane.showMessageDialog(null, "Por favor digitar novamente a senha!    ");

            }
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Usuario não encontrado!     ");

        } finally {

            ConectarMydb.fecharConectar(conn, stmt);

        }
    }//fim da classe verificar usuario 
}

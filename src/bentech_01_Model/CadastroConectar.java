package bentech_01_Model;

import bentech_01_Conexao.ConectarMydb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class CadastroConectar {
    
    
    //inserir usuário
    public void inserirCliente(){
        Connection conn;
        
        String sql = "INSERT INTO pessoa (nome, telefoneResidencial, telefoneCelular, telefoneComercial, "
            + "email, sexo, logradouro, numero, complemento, cep, cpf, bairro, cidade, "
            + "uf, rg, datanascimento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        
        conn = ConectarMydb.getconectar();
        
        PreparedStatement stmt = null;
        
        try{
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, Cadastro.nome);
            stmt.setString(2, Cadastro.telRes);
            stmt.setString(3, Cadastro.telCel);
            stmt.setString(4, Cadastro.telCom);
            stmt.setString(5, Cadastro.email);
            stmt.setString(6, Cadastro.sexo);
            stmt.setString(7, Cadastro.logradouro);
            stmt.setString(8, Cadastro.numero);
            stmt.setString(9, Cadastro.complemento);
            stmt.setString(10, Cadastro.cep);
            stmt.setString(11, Cadastro.cpf);
            stmt.setString(12, Cadastro.bairro);
            stmt.setString(13, Cadastro.cidade);
            stmt.setString(14, Cadastro.uf);
            stmt.setString(15, Cadastro.rg);
            stmt.setDate(16, Cadastro.dataNasc);
            
            
            stmt.executeUpdate();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Erro ao salvar no banco de dados     " + e.getMessage());
        }
        finally{
            ConectarMydb.fecharConectar(conn, stmt);
        }
    }//fim da classe cadastrar usuário 
    
    //atualizar usuário
    public void atualizarCliente(){
        Connection conn;
        
        String sql = "UPDATE pessoa SET nome = ?, telefoneResidencial = ?, telefoneCelular = ?, telefoneComercial = ?, "
            + "email = ?, sexo = ?, logradouro = ?, numero = ?, complemento = ?, cep = ?, cpf = ?, bairro = ?, cidade = ?, "
            + "uf = ?, rg = ?, datanascimento = ? " 
            + "WHERE idpessoa = '" + Cadastro.idPessoa + "'";

        
        conn = ConectarMydb.getconectar();
        
        PreparedStatement stmt = null;
        
        try{
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, Cadastro.nome);
            stmt.setString(2, Cadastro.telRes);
            stmt.setString(3, Cadastro.telCel);
            stmt.setString(4, Cadastro.telCom);
            stmt.setString(5, Cadastro.email);
            stmt.setString(6, Cadastro.sexo);
            stmt.setString(7, Cadastro.logradouro);
            stmt.setString(8, Cadastro.numero);
            stmt.setString(9, Cadastro.complemento);
            stmt.setString(10, Cadastro.cep);
            stmt.setString(11, Cadastro.cpf);
            stmt.setString(12, Cadastro.bairro);
            stmt.setString(13, Cadastro.cidade);
            stmt.setString(14, Cadastro.uf);
            stmt.setString(15, Cadastro.rg);
            stmt.setDate(16,Cadastro.dataNasc);
            
            
            stmt.executeUpdate();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Erro ao salvar no banco de dados     " + e.getLocalizedMessage());
        }
        finally{
            ConectarMydb.fecharConectar(conn, stmt);
        }
    }
}//fim da classe cadastrar e atualizar usuário 

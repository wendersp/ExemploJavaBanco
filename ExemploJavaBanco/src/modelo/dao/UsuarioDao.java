package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.entidade.Usuario;

/**
 *
 * @author wender
 */
public class UsuarioDao {

    private Connection con;

    private void iniciarConexaoDB() {
        ConexaoDB conexaoDB = new ConexaoDB();
        con = conexaoDB.getConexaoDB();
    }

    public void salvar(Usuario usuario) {
        if (usuario.getId() != null) {
            this.update(usuario);
        } else {
            this.insert(usuario);
        }
    }

    private void insert(Usuario usuario) {
        iniciarConexaoDB();
        String sql = "INSERT INTO usuario (nome, email, nome_usuario, senha)"
                + " VALUES (?,?,?,?)";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, usuario.getNome());
            pstmt.setString(2, usuario.getEmail());
            pstmt.setString(3, usuario.getNomeUsuario());
            pstmt.setString(4, usuario.getSenha());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Usuario inserido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir o usuario. " + ex.getMessage());
        }
    }

    private void update(Usuario usuario) {
        iniciarConexaoDB();
        String sql = "UPDATE usuario SET nome = ?, email = ?, nome_usuario = ?, "
                + " senha = ? WHERE id = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, usuario.getNome());
            pstmt.setString(2, usuario.getEmail());
            pstmt.setString(3, usuario.getNomeUsuario());
            pstmt.setString(4, usuario.getSenha());
            pstmt.setLong(5, usuario.getId());
            pstmt.execute();
            JOptionPane.showMessageDialog(null,
                    "Usuario atualizado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar o usuario. " + ex.getMessage());
        }
    }

    public void excluir(Usuario usuario) {
        iniciarConexaoDB();
        String sql = "DELETE FROM usuario WHERE id = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setLong(1, usuario.getId());
            pstmt.execute();
            JOptionPane.showMessageDialog(null,
                    "Usuario excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o usuario. "
                    + ex.getMessage());
        }
    }

    private Usuario montarDados(ResultSet resultado) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setId(resultado.getLong("id"));
        usuario.setNome(resultado.getString("nome"));
        usuario.setEmail(resultado.getString("email"));
        usuario.setNomeUsuario(resultado.getString("nome_usuario"));
        usuario.setSenha(resultado.getString("senha"));
        return usuario;
    }

    public Usuario pesquisar(int id) {
        iniciarConexaoDB();
        Usuario usuario = null;
        String sql = "SELECT id, nome, email, nome_usuario, senha FROM usuario "
                + " WHERE id = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet resultado = pstmt.executeQuery();
            if (resultado.next()) {
                usuario = this.montarDados(resultado);
            }
            return usuario;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar Usuairo por Id." + ex.getMessage());
            return null;
        }
    }

    public List<Usuario> pesquisar(String nome) {
        iniciarConexaoDB();        
        List<Usuario> lstUsuario = new ArrayList();
        String sql = "SELECT id, nome, email, nome_usuario, senha FROM usuario "
                + " WHERE nome LIKE ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, nome + "%");
            ResultSet resultado = pstmt.executeQuery();
            while (resultado.next()) {                
                lstUsuario.add(montarDados(resultado));
            }
            return lstUsuario;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar Usuario por Nome. " + ex.getMessage());
            return null;
        }
    }
    
    public Usuario login(String nomeUsuario, String senha) {
        iniciarConexaoDB();
        Usuario usuario = null;
        String sql = "SELECT id, nome, email, nome_usuario, senha FROM usuario "
                + " WHERE nome_usuario = ? AND senha = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, nomeUsuario);
            pstmt.setString(2, senha);
            ResultSet resultado = pstmt.executeQuery();
            if (resultado.next()) {
                usuario = this.montarDados(resultado);
            }
            return usuario;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Usuario ou senha invalido." + ex.getMessage());
            return null;
        }
    }

    

}

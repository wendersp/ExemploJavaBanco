package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.entidade.Banco;

/**
 *
 * @author wender
 */
public class BancoDao {

    private Connection con;

    private void iniciarConexaoDB() {
        ConexaoDB conexaoDB = new ConexaoDB();
        con = conexaoDB.getConexaoDB();
    }

    public void salvar(Banco banco) {
        if (banco.getId() != null) {
            this.update(banco);
        } else {
            this.insert(banco);
        }
    }

    private void insert(Banco banco) {
        iniciarConexaoDB();
        String sql = "INSERT INTO banco (numero, nome)"
                + " VALUES (?,?)";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, banco.getNumero());
            pstmt.setString(2, banco.getNome());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Banco inserido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir o banco. " + ex.getMessage());
        }
    }

    private void update(Banco banco) {
        iniciarConexaoDB();
        String sql = "UPDATE banco SET numero = ?, nome = ? "
                + " WHERE id = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, banco.getNumero());
            pstmt.setString(2, banco.getNome());
            pstmt.setLong(3, banco.getId());
            pstmt.execute();
            JOptionPane.showMessageDialog(null,
                    "Banco atualizado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar o banco. " + ex.getMessage());
        }
    }

    public void excluir(Banco banco) {
        iniciarConexaoDB();
        String sql = "DELETE FROM banco WHERE id = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setLong(1, banco.getId());
            pstmt.execute();
            JOptionPane.showMessageDialog(null,
                    "Banco excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o banco. "
                    + ex.getMessage());
        }
    }

    private Banco montarDados(ResultSet resultado) throws SQLException {
        Banco banco = new Banco();
        banco.setId(resultado.getLong("id"));
        banco.setNumero(resultado.getInt("numero"));
        banco.setNome(resultado.getString("nome"));
        return banco;
    }

    public Banco pesquisar(Long id) {
        iniciarConexaoDB();
        Banco banco = null;
        String sql = "SELECT id, numero, nome FROM banco WHERE id = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setLong(1, id);
            ResultSet resultado = pstmt.executeQuery();
            if (resultado.next()) {
                banco = montarDados(resultado);
            }
            return banco;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar Banco por Id." + ex.getMessage());
            return null;
        }
    }
    
    public Banco pesquisarNumero(Integer numero) {
        iniciarConexaoDB();
        Banco banco = null;
        String sql = "SELECT id, numero, nome FROM banco WHERE numero = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, numero);
            ResultSet resultado = pstmt.executeQuery();
            if (resultado.next()) {
                banco = montarDados(resultado);
            }
            return banco;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar Banco por Numero." + ex.getMessage());
            return null;
        }
    }

    public List<Banco> pesquisar(String nome) {
        iniciarConexaoDB();
        
        List<Banco> lstBancos = new ArrayList();
        String sql = "SELECT id, numero, nome FROM banco  WHERE nome LIKE ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, nome + "%");
            ResultSet resultado = pstmt.executeQuery();
            while (resultado.next()) {
                lstBancos.add(montarDados(resultado));
            }
            return lstBancos;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar Banco por Nome. " + ex.getMessage());
            return null;
        }
    }
    
    

    
}

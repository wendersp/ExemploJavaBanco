
package modelo.dao;

import modelo.entidade.Estado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author wender
 */
public class EstadoDao {
    
    private Connection con;

    private void iniciarConexaoDB() {
        ConexaoDB conexaoDB = new ConexaoDB();
        con = conexaoDB.getConexaoDB();
    }
    
    public void salvar(Estado estado) {
        if (estado.getId() != null) {
            this.update(estado);
        } else {
            this.insert(estado);
        }
    }
    
    
    private void insert(Estado estado) {
        iniciarConexaoDB();
        String sql = "INSERT INTO estado (nome, sigla)"
                + " VALUES (?,?)";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, estado.getNome());
            pstmt.setString(2, estado.getSigla());
            pstmt.execute();
            JOptionPane.showMessageDialog(null,"Estado inserido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir o estado. " + ex.getMessage());
        }
    }

    private void update(Estado estado) {
         iniciarConexaoDB();
        String sql = "UPDATE estado SET nome = ?, sigla = ? "
                + " WHERE id = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, estado.getNome());
            pstmt.setString(2, estado.getSigla());
            pstmt.setInt(3, estado.getId());
            pstmt.execute();
            JOptionPane.showMessageDialog(null,
                    "Estado atualizado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao atualizar o estado. " + ex.getMessage());
        }
    }
    
    public void excluir(Estado estado) {
        iniciarConexaoDB();
        String sql = "DELETE FROM estado WHERE id = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);            
            pstmt.setInt(1, estado.getId());
            pstmt.execute();
            JOptionPane.showMessageDialog(null,
                    "Estado excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao excluir o estado. " 
                    + ex.getMessage());
        }
    }
        
    public Estado pesquisar(int id) {
        iniciarConexaoDB();
        Estado estado = null;
        String sql = "SELECT id, nome, sigla FROM estado WHERE id = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet resultado = pstmt.executeQuery();
            if (resultado.next()) {
                estado = new Estado();
                estado.setId(resultado.getInt("id"));
                estado.setNome(resultado.getString("nome"));
                estado.setSigla(resultado.getString("sigla"));                 
            }
            return estado;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao pesquisar Estado por Id." + ex.getMessage());
            return null;
        }      
    }
    
    public List<Estado> pesquisar(String nome) {
        iniciarConexaoDB();
        Estado estado;
        List<Estado> lstEstados = new ArrayList();
        String sql = "SELECT id, nome, sigla FROM estado WHERE nome LIKE ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, nome + "%");
            ResultSet resultado = pstmt.executeQuery();
            while (resultado.next()) {
                estado = new Estado();
                estado.setId(resultado.getInt("id"));
                estado.setNome(resultado.getString("nome"));
                estado.setSigla(resultado.getString("sigla"));  
                lstEstados.add(estado);
            }
            return lstEstados;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao pesquisar Estado por Nome. " + ex.getMessage());
            return null;
        }      
    }
    
    public List<Estado> pesquisarPorSigla(String sigla) {
        iniciarConexaoDB();
        Estado estado;
        List<Estado> lstEstados = new ArrayList();
        String sql = "SELECT id, nome, sigla FROM estado WHERE sigla = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, sigla);
            ResultSet resultado = pstmt.executeQuery();
            while (resultado.next()) {
                estado = new Estado();
                estado.setId(resultado.getInt("id"));
                estado.setNome(resultado.getString("nome"));
                estado.setSigla(resultado.getString("sigla"));  
                lstEstados.add(estado);
            }
            return lstEstados;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao pesquisar Estado por Sigla. " + ex.getMessage());
            return null;
        }      
    }

}

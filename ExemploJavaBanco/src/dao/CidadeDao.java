package dao;

import entidade.Cidade;
import entidade.Estado;
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
public class CidadeDao {
    
    private Connection con;

    private void iniciarConexaoDB() {
        ConexaoDB conexaoDB = new ConexaoDB();
        con = conexaoDB.getConexaoDB();
    }
    
    public void salvar(Cidade cidade) {
        if (cidade.getId() != null) {
            this.update(cidade);
        } else {
            this.insert(cidade);
        }
    }
    
    
    private void insert(Cidade cidade) {
        iniciarConexaoDB();
        String sql = "INSERT INTO cidade (nome, id_estado)"
                + " VALUES (?,?)";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, cidade.getNome());
            pstmt.setInt(2, cidade.getEstado().getId());            
            pstmt.execute();           
            JOptionPane.showMessageDialog(null,"Cidade inserido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir o cidade. " + ex.getMessage());
        }
    }

    private void update(Cidade cidade) {
         iniciarConexaoDB();
        String sql = "UPDATE cidade SET nome = ?, id_estado = ? "
                + " WHERE id = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, cidade.getNome());
            pstmt.setInt(2, cidade.getEstado().getId());
            pstmt.setLong(3, cidade.getId());
            pstmt.execute();
            JOptionPane.showMessageDialog(null,
                    "Cidade atualizado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao atualizar o cidade. " 
                    + ex.getMessage());
        }
    }
    
    public void excluir(Cidade cidade) {
        iniciarConexaoDB();
        String sql = "DELETE FROM cidade WHERE id = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);            
            pstmt.setLong(1, cidade.getId());
            pstmt.execute();
            JOptionPane.showMessageDialog(null,
                    "Cidade excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao excluir o cidade. " 
                    + ex.getMessage());
        }
    }
    EstadoDao estadoDao;
    private Estado pesquisarEstado(int idEstado) {        
        if (estadoDao == null) {
            estadoDao = new EstadoDao();
        }
        return estadoDao.pesquisar(idEstado);
    }
        
    public Cidade pesquisar(Long id) {
        iniciarConexaoDB();
        Cidade cidade = null;
        String sql = "SELECT id, nome, id_estado FROM cidade WHERE id = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setLong(1, id);
            ResultSet resultado = pstmt.executeQuery();
            if (resultado.next()) {
                cidade = new Cidade();
                cidade.setId(resultado.getLong("id"));
                cidade.setNome(resultado.getString("nome"));                
                cidade.setEstado(pesquisarEstado(resultado.getInt("id_estado")));                 
            }
            return cidade;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao pesquisar Cidade por Id." + ex.getMessage());
            return null;
        }      
    }
    
    public List<Cidade> pesquisar(String nome) {
        iniciarConexaoDB();
        Cidade cidade;
        List<Cidade> lstCidade = new ArrayList();
        String sql = "SELECT id, nome, id_estado FROM cidade WHERE nome LIKE ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, nome + "%");
            ResultSet resultado = pstmt.executeQuery();
            while (resultado.next()) {
                cidade = new Cidade();
                cidade.setId(resultado.getLong("id"));
                cidade.setNome(resultado.getString("nome"));
                cidade.setEstado(pesquisarEstado(resultado.getInt("id_estado")));  
                lstCidade.add(cidade);
            }
            return lstCidade;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao pesquisar Cidade por Nome. " + ex.getMessage());
            return null;
        }      
    }
       

    
}

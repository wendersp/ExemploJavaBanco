/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Estado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public void insert(Estado estado) {
        iniciarConexaoDB();
        String sql = "INSERT INTO estado (nome, sigla)"
                + " VALUES (?,?)";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, estado.getNome());
            pstmt.setString(2, estado.getSigla());
            pstmt.execute();
            System.out.println("Estado inserido com sucesso!...");
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir o estado. " + ex.getMessage());
        }
    }

    public void update(Estado estado) {
         iniciarConexaoDB();
        String sql = "UPDATE estado SET nome = ?, sigla = ? "
                + " WHERE id = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, estado.getNome());
            pstmt.setString(2, estado.getSigla());
            pstmt.setInt(3, estado.getId());
            pstmt.execute();
            System.out.println("Estado atualizado com sucesso!...");
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar o estado. " + ex.getMessage());
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
            System.out.println("Erro ao pesquisar Estado por Id. " + ex.getMessage());
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
            System.out.println("Erro ao pesquisar Estado por Nome. " + ex.getMessage());
            return null;
        }      
    }

}

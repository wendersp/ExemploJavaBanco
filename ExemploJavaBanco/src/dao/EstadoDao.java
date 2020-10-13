/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Banco;
import entidade.Estado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
        String sqlInsert = "INSERT INTO estado (nome, sigla)"
                + " VALUES (?,?)";
        try {
            PreparedStatement pstmt = con.prepareStatement(sqlInsert);
            pstmt.setString(1, estado.getNome());
            pstmt.setString(2, estado.getSigla());
            pstmt.execute();
            System.out.println("Estado inserido com sucesso!...");
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir o estado. " + ex.getMessage());
        }
    }

}

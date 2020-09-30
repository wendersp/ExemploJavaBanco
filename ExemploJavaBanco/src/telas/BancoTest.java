/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import dao.BancoDao;
import entidade.Banco;
import java.util.List;

/**
 *
 * @author wender
 */
public class BancoTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BancoDao bancoDao = new BancoDao();
        
        Banco b1 = new Banco();
        Banco b2 = new Banco();
        Banco b3 = new Banco();
        
        b1.setNumero(1);
        b1.setNome("Banco do Brasil");
        bancoDao.salvar(b1);
        
        b2.setNumero(2);
        b2.setNome("Caixa");
        bancoDao.salvar(b2);
        
        b3.setNumero(3);
        b3.setNome("Itau");
        bancoDao.salvar(b3);
        
        
        System.out.println("-------------------------------------------------");
        List<Banco> listaBanco = bancoDao.getAll();
        for (Banco b :listaBanco) {
            System.out.println("Numero.: " + b.getNumero());
            System.out.println("Nome...: " + b.getNome());
        }
        
        Banco bancoEdit = bancoDao.pesquisar(2);
        System.out.println("-----[Editar]------------------------------------");
        System.out.println("Numero.: " + bancoEdit.getNumero());
        System.out.println("Nome...: " + bancoEdit.getNome());
        
        bancoEdit.setNome("Caixa Economica Federal");
        
        bancoDao.salvar(bancoEdit);

        System.out.println("-------------------------------------------------");
        List<Banco> listaBanco2 = bancoDao.getAll();
        for (Banco b :listaBanco2) {
            System.out.println("Numero.: " + b.getNumero());
            System.out.println("Nome...: " + b.getNome());
        }
        
        
        
        
    }
    
}

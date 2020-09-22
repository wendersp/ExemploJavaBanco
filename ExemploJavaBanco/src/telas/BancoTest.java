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
        BancoDao bDao = new BancoDao();
        Banco b1 = new Banco();
        Banco b2 = new Banco();
        Banco b3 = new Banco();
        
        b1.setNumero(1);
        b1.setNome("Banco do Brasil");
        bDao.adicionar(b1);
        
        b2.setNumero(2);
        b2.setNome("Caixa");
        bDao.adicionar(b2);
        
        b3.setNumero(3);
        b3.setNome("Itau");
        bDao.adicionar(b3);
        System.out.println("-------------------------------------------------");
        List<Banco> listaBanco = bDao.getAll();
        for (Banco b :listaBanco) {
            System.out.println("Numero.: " + b.getNumero());
            System.out.println("Nome...: " + b.getNome());
        }
        
        Banco bEdit = bDao.pesquisar(2);
        System.out.println("-----[Editar]------------------------------------");
        System.out.println("Numero.: " + bEdit.getNumero());
        System.out.println("Nome...: " + bEdit.getNome());
        
        bEdit.setNome("Caixa Economica Federal");
        bDao.editar(bEdit);
        System.out.println("-------------------------------------------------");
        List<Banco> listaBanco2 = bDao.getAll();
        for (Banco b :listaBanco2) {
            System.out.println("Numero.: " + b.getNumero());
            System.out.println("Nome...: " + b.getNome());
        }
        
        
        
        
    }
    
}

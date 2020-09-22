/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Banco;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wender
 */
public class BancoDao {
    
    List<Banco> lstBanco = new ArrayList<>();
    
    public void salvar(Banco banco) {
        if (lstBanco.contains(banco)) {
            editar(banco);
        } else {
            adicionar(banco);
        }
    }
    
    public void adicionar(Banco banco) {        
        lstBanco.add(banco);        
    }
    
    public void remover(Banco banco) {
        lstBanco.remove(banco);
    }
    
    public void editar(Banco banco) {
        int index = lstBanco.indexOf(banco);
        if (index > -1) {
            lstBanco.remove(index);
            lstBanco.add(index, banco);
        }
    }
    
    public Banco pesquisar(int numero) {
        for (Banco b : lstBanco) {
            if (b.getNumero() == numero) {
                return b;
            }
        }
        return null;
    }
    
    public List<Banco> getAll() {
        return lstBanco;
    }
    
}

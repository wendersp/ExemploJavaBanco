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
    
    List<Banco> listaBancos = new ArrayList<>();
    
    public void salvar(Banco banco) {
        if (listaBancos.contains(banco)) {
            editar(banco);
        } else {
            adicionar(banco);
        }
    }
    
    private void adicionar(Banco banco) {        
        listaBancos.add(banco);        
    }
    
    private void editar(Banco banco) {
        int index = listaBancos.indexOf(banco);
        if (index > -1) {
            listaBancos.remove(index);
            listaBancos.add(index, banco);
        }
    }
    
    public void remover(Banco banco) {
        listaBancos.remove(banco);
    }
    
    
    
    public Banco pesquisar(int numeroBanco) {
        for (Banco banco : listaBancos) {
            if (banco.getNumero() == numeroBanco) {
                return banco;                
            }
        }
        return null;
    }
    
    public List<Banco> getAll() {
        return listaBancos;
    }
    
}

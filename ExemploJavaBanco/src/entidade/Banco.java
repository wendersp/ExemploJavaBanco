/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

/**
 *
 * @author wender
 */
public class Banco {
    int numero;
    String nome;
    
    public Banco() {
        this.numero = 0;
        this.nome = "";
    }  
    
    public Banco(int numero) {
        this.numero = numero;       
        this.nome = "";
    }
    
    public Banco(String nome) {
        this.numero = 0;
        this.nome = nome;
    }
    
    public Banco(int numero, String nome) {
        this.numero = numero;       
        this.nome = nome;
    }
    
    
    
}

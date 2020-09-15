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
public class CaixaEletronico {

    public static void main(String[] args) {

        Banco banco = new Banco();
        banco.numero = 1;
        banco.nome = "Banco do Brasil";
        
        Conta conta = new Conta(banco);
        conta.numero = 21009;
        conta.nomePessoa = "JOSE DA SILVA";
        conta.deposito(50);
        
        conta.info();
        
        System.out.println("saque: " + conta.saque(60));
        conta.deposito(150);        
        System.out.println("saque: " + conta.saque(60));
        
        
        
        
        
        
    }
    
}

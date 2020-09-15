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
public class Conta {
    
    int numero;
    String nomePessoa;
    Banco banco;
    double saldo;
    
    public Conta() {
        this.numero = 0;
        this.nomePessoa = "";
        this.banco = new Banco();
        this.saldo = 0;
    }
    
     public Conta(Banco banco) {
        this.numero = 0;
        this.nomePessoa = "";
        this.banco = banco;
        this.saldo = 0;
    }
    
    public Conta(int numero, Banco banco, String nomePessoa) {
        this.numero = numero;
        this.banco = banco;
        this.nomePessoa = nomePessoa;
        this.saldo = 0;
    }
    
    public void saldo() {
        System.out.println("Saldo: " + saldo);
    }
    
    public void info() {
        System.out.println("Numero Banco.: " + banco.numero);
        System.out.println("Nome Banco...: " + banco.nome);
        System.out.println("Numero conta.: " + numero);
        System.out.println("Pessoa.......: " + nomePessoa);                
        saldo();
    }
    
    public void deposito(double valor) {
        saldo += valor;
        saldo();
    }
    
    public double saque(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            return valor;
        } else {
            System.out.println("Saldo insuficiente...");
            return 0;
        }
    }
    
    
    
}

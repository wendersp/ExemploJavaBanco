/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import entidade.Agencia;
import entidade.Banco;
import entidade.Cidade;
import entidade.Cliente;
import entidade.Conta;
import entidade.Estado;



/**
 *
 * @author wender
 */
public class CaixaEletronico {

    public static void main(String[] args) {

        Banco banco = new Banco();
        banco.setNumero(1);
        banco.setNome("Banco do Brasil");
        
        Agencia agencia = new Agencia();
        agencia.setBanco(banco);
        agencia.setNumero(530);
        agencia.setEstado("GO");
        agencia.setCidade("SÃO LUIS DE MONTES BELOS");
        agencia.setTelefone("(64)3333-3355");
        
        
        Cliente cli01 = new Cliente();
        cli01.setNome("JOSE DA SILVA");
        cli01.setCpf("123.654.123-00");
        cli01.setRg("126464");
        cli01.setCelular("(64)9999-9988");
        cli01.setEmail("josesilva@gmail.com");
        Estado estado = new Estado();
        estado.setNome("GOIAS");
        estado.setSigla("GO");
        Cidade cidade = new Cidade();
        cidade.setEstado(estado);
        cidade.setNome("São Luis de Montes Belos");
        
        cli01.setCidade(cidade);
        cli01.setEndereco("AV. HERMOGENES COELHO");
        cli01.setNomeMae("MARIA DA SILVA");
        cli01.setNomePai("JOAO DA SILVA");
        
        
        Conta conta = new Conta();
        conta.setAgencia(agencia);
        conta.setNumero(21009);
        conta.setCliente(cli01);
        
        conta.depositar(50.0);
        System.out.println("-----------------------------------");        
        System.out.println("-----------------------------------");
        System.out.println("saque: " + conta.sacar(60.0));
        System.out.println("-----------------------------------");
        conta.depositar(150.0);     
        System.out.println("-----------------------------------");
        System.out.println("saque: " + conta.sacar(60.0));
        
        
        
        
        
        
        
    }
    
}

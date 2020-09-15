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
        cli01.setEstado("GO");
        cli01.setCidade("SÃO LUIS DE MONTES BELSO");
        cli01.setEndereco("AV. HERMOGENES COELHO");
        cli01.setNomeMae("MARIA DA SILVA");
        cli01.setNomePai("JOAO DA SILVA");
        
        
        Conta conta = new Conta();
        conta.setAgencia(agencia);
        conta.setNumero(21009);
        conta.setCliente(cli01);
        
        conta.deposito(50);
        System.out.println("-----------------------------------");
        conta.info();
        System.out.println("-----------------------------------");
        System.out.println("saque: " + conta.saque(60));
        System.out.println("-----------------------------------");
        conta.deposito(150);     
        System.out.println("-----------------------------------");
        System.out.println("saque: " + conta.saque(60));
        
        
        
        
        
        
        
    }
    
}

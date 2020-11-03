package modelo.entidade;

import java.util.Date;

public class Conta {

    private Long id;
    private Cliente cliente;
    private Agencia agencia;
    private Integer numero;
    private Double saldo;
    private Date dataAbertura;
    private String senha;

    
    public void depositar(Double valor) {
        if (valor > 0) {
           saldo = saldo + valor; 
           System.out.println("Deposito realizado com sucesso!...");
        } else {
            System.out.println("Valor do deposito é invalido!");
        }        
    }
    
    public Double sacar(double valor) {
        if (valor > 0) {
            if (verificarSaldoSuficiente(valor)) {
                saldo = saldo - valor;
                return valor;
            } else {
                System.out.println("Saldo insuficiente!...");
            }
        } else {
            System.out.println("valor do saque é invalido!");
        }
        return 0.0;
    }
    
    private boolean verificarSaldoSuficiente(Double valor) {        
            if (valor > saldo) {
              return true;
            } else {
                return false;
            }        
    }
    
    public void emitirSaldo() {
        System.out.println("Saldo: " + saldo);
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getSaldo() {
        return saldo;
    }

//    public void setSaldo(Double saldo) {
//        this.saldo = saldo;
//    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}

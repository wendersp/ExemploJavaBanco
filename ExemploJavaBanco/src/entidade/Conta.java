package entidade;

/**
 *
 * @author wender
 */
public class Conta {

    private int numero;
    private Cliente cliente;
    private Agencia agencia;
    private double saldo;

    public Conta() {
        this.numero = 0;
        this.cliente = new Cliente();
        this.agencia = new Agencia();
        this.saldo = 0;
    }

    public void saldo() {
        System.out.println("Saldo: " + saldo);
    }

    public void info() {
        System.out.println("Numero Banco....: " + agencia.getBanco().getNumero());
        System.out.println("Nome Banco......: " + agencia.getBanco().getNome());
        System.out.println("Agencia.........: " + agencia.getNumero());
        System.out.println("Numero conta....: " + numero);
        System.out.println("Nome do Cliente.: " + cliente.getNome());
        System.out.println("CPF.............: " + cliente.getCpf());
        saldo();
    }

    public void deposito(double valor) {
        if (valor > 0) {
            saldo += valor;
            saldo();
        } else {
            System.out.println("Valor do deposito é invalido...");
        }
    }

    public double saque(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            saldo();
            return valor;
        } else {
            System.out.println("Saldo insuficiente para realizar o saque...");
            return 0;
        }
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}

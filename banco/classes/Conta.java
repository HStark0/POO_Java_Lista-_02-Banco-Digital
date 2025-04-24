package classes;
import excecao.SaldoInsuficienteException;
import excecao.LimiteExcedidoException;
import excecao.ValorInvalidoException;

public abstract class Conta {
    private String numero;
    private double saldo;
    private Cliente cliente;

    public Conta(String numero, Cliente cliente) {
        this.numero = numero;
        this.saldo = 0;
        this.cliente = cliente;
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double valor) throws ValorInvalidoException {
        if (valor <= 0) {
            throw new ValorInvalidoException("Valor de depósito inválido");
        }
        saldo += valor;
    }

    public abstract void sacar(double valor) throws SaldoInsuficienteException, LimiteExcedidoException;

    public void transferir(Conta destino, double valor) 
            throws SaldoInsuficienteException, LimiteExcedidoException, ValorInvalidoException {
        this.sacar(valor);
        destino.depositar(valor);
    }

    @Override
    public String toString() {
        return "Conta " + numero + " - Saldo: R$ " + String.format("%.2f", saldo);
    }
}
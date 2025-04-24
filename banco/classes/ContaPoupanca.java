package classes;
import excecao.SaldoInsuficienteException;

public class ContaPoupanca extends Conta {
    private double taxaRendimento;

    public ContaPoupanca(String numero, Cliente cliente, double taxaRendimento) {
        super(numero, cliente);
        this.taxaRendimento = taxaRendimento;
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void aplicarRendimento() {
        setSaldo(getSaldo() * (1 + taxaRendimento));
    }

    @Override
    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de saque inválido");
        }
        
        if (valor > getSaldo()) {
            throw new SaldoInsuficienteException("Saldo insuficiente para saque");
        }
        
        setSaldo(getSaldo() - valor);
    }
}
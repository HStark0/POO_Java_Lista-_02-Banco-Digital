package classes;
import excecao.SaldoInsuficienteException;
import excecao.LimiteExcedidoException;

public class ContaCorrente extends Conta {
    private double limiteChequeEspecial;

    public ContaCorrente(String numero, Cliente cliente, double limiteChequeEspecial) {
        super(numero, cliente);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    @Override
    public void sacar(double valor) throws SaldoInsuficienteException, LimiteExcedidoException {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de saque inválido");
        }
        
        double saldoDisponivel = getSaldo() + limiteChequeEspecial;
        if (valor > saldoDisponivel) {
            throw new LimiteExcedidoException("Limite de cheque especial excedido");
        }
        
        setSaldo(getSaldo() - valor);
    }
}
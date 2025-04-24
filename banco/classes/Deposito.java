package classes;

public class Deposito extends Transacao {
    public Deposito(double valor, Conta conta) {
        super(valor, conta);
    }

    @Override
    public String getTipo() {
        return "Depósito";
    }
}
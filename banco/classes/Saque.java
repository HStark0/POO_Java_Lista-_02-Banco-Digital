package classes;

public class Saque extends Transacao {
    public Saque(double valor, Conta conta) {
        super(valor, conta);
    }

    @Override
    public String getTipo() {
        return "Saque";
    }
}
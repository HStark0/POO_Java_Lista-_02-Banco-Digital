package classes;

public class Transferencia extends Transacao {
    private Conta contaDestino;

    public Transferencia(double valor, Conta contaOrigem, Conta contaDestino) {
        super(valor, contaOrigem);
        this.contaDestino = contaDestino;
    }

    public Conta getContaDestino() {
        return contaDestino;
    }

    @Override
    public String getTipo() {
        return "Transferência";
    }
}
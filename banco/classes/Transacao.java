package classes;
import java.util.Date;

public abstract class Transacao {
    private Date data;
    private double valor;
    private Conta conta;

    public Transacao(double valor, Conta conta) {
        this.data = new Date();
        this.valor = valor;
        this.conta = conta;
    }

    public Date getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

    public Conta getConta() {
        return conta;
    }

    public abstract String getTipo();
}
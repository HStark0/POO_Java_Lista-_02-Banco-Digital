package excecao;

public class LimiteExcedidoException extends Exception {
    public LimiteExcedidoException(String mensagem) {
        super(mensagem);
    }
}
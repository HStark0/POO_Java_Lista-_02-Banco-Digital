import classes.*;
import excecao.*;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Conta contaAtual;

    public static void main(String[] args) {
        
        PessoaFisica cliente1 = new PessoaFisica("Tony Stark", "Malibu, Califórnia", "99 9999-9999", "123.456.789-00");
        
		ContaCorrente cc = new ContaCorrente("12345-6", cliente1, 1000);
        contaAtual = cc;

        boolean executando = true;
        
        while (executando) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1:
                    depositar();
                    break;
                case 2:
                    sacar();
                    break;
                case 3:
                    consultarSaldo();
                    break;
                case 4:
                    transferir();
                    break;
                case 5:
                    if (contaAtual instanceof ContaPoupanca) {
                        aplicarRendimento();
                    } else {
                        System.out.println("Esta operação é válida apenas para conta poupança!");
                    }
                    break;
                case 6:
                    trocarConta();
                    break;
                case 0:
                    executando = false;
                    System.out.println("Obrigado por usar nosso banco digital!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n=== MENU BANCÁRIO ===");
        System.out.println("1 - Depositar");
        System.out.println("2 - Sacar");
        System.out.println("3 - Consultar Saldo");
        System.out.println("4 - Transferir");
        if (contaAtual instanceof ContaPoupanca) {
            System.out.println("5 - Aplicar Rendimento");
        }
        System.out.println("6 - Trocar de Conta");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void depositar() {
        System.out.print("Digite o valor para depósito: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();
        
        try {
            contaAtual.depositar(valor);
            System.out.println("Depósito realizado com sucesso!");
            System.out.println(contaAtual);
        } catch (ValorInvalidoException e) {
            System.out.println("Erro no depósito: " + e.getMessage());
        }
    }

    private static void sacar() {
        System.out.print("Digite o valor para saque: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();
        
        try {
            contaAtual.sacar(valor);
            System.out.println("Saque realizado com sucesso!");
            System.out.println(contaAtual);
        } catch (SaldoInsuficienteException | LimiteExcedidoException e) {
            System.out.println("Erro no saque: " + e.getMessage());
        }
    }

    private static void consultarSaldo() {
        System.out.println("\n=== SALDO ATUAL ===");
        System.out.println(contaAtual);
        System.out.println("Titular: " + contaAtual.getCliente().getNome());
    }

    private static void transferir() {
        System.out.print("Digite o número da conta destino: ");
        String numeroDestino = scanner.nextLine();
        
        PessoaJuridica cliente2 = new PessoaJuridica("Industrias Stark", "Manhattan, 456", "11 1111-1111", "12.345.678/0001-99", "Stark Indústria Ltda");
        ContaPoupanca destino = new ContaPoupanca("65432-1", cliente2, 0.005);
        
        System.out.print("Digite o valor para transferência: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();
        
        try {
            contaAtual.transferir(destino, valor);
            System.out.println("Transferência realizada com sucesso!");
            System.out.println(contaAtual);
        } catch (SaldoInsuficienteException | LimiteExcedidoException | ValorInvalidoException e) {
            System.out.println("Erro na transferência: " + e.getMessage());
        }
    }

    private static void aplicarRendimento() {
        ((ContaPoupanca) contaAtual).aplicarRendimento();
        System.out.println("Rendimento aplicado com sucesso!");
        System.out.println(contaAtual);
    }

    private static void trocarConta() {
        System.out.println("\n=== TROCAR DE CONTA ===");
        System.out.println("1 - Conta Corrente");
        System.out.println("2 - Conta Poupança");
        System.out.print("Escolha o tipo de conta: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();
        
        if (tipo == 1) {
            PessoaFisica cliente = new PessoaFisica("Tony Stark", "Malibu, Califórnia", "99 9999-9999", "123.456.789-00");
            contaAtual = new ContaCorrente("12345-6", cliente, 1000);
        } else if (tipo == 2) {
            PessoaJuridica cliente = new PessoaJuridica("Industrias Stark", "Manhattan, 456", "11 1111-1111", "12.345.678/0001-99", "Stark Indústria Ltda");
            contaAtual = new ContaPoupanca("65432-1", cliente, 0.005);
        } else {
            System.out.println("Opção inválida! Mantendo a conta atual.");
        }
        
        System.out.println("Conta alterada para: " + contaAtual.getClass().getSimpleName());
    }
}
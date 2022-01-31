package screen;

import bank.Banco;
import bank.Conta;
import utils.CLI;

import java.util.Locale;
import java.util.Scanner;

public class Screen {

    static Scanner scan = new Scanner(System.in);
    static Banco bank = new Banco("JavaBank");

    static public void exibirMensagemComeco(String nome) {
        CLI.printaDash();
        CLI.printaMensagem("Olá " +nome+ ", Bem-vindo ao Sistema " + bank.getNome());
        CLI.printaMensagem("Escolha uma opção: ");
    }
    static public void exibirMensagemFinal() {
        CLI.printaMensagem("\n\t[0] para Fechar programa");
    }


    static public int exibirTelaPrincipal(Conta conta, String nome) {
        String contaNome = conta.getName();

        exibirMensagemComeco(nome);
        CLI.printaMensagem("[1] Extrato da Conta " +contaNome+ "\t\t[3] Depositar na Conta " +contaNome);
        CLI.printaMensagem("[2] Saque na Conta " +contaNome);
        exibirMensagemFinal();

        CLI.printaMensagemDeEntrada();
        return scan.nextInt();
    }

    static public void exibirExtrato(Conta conta) {
        String contaNome = conta.getName().toUpperCase(Locale.ROOT);

        CLI.printaDash();
        CLI.printaMensagem("\t=@= EXTRATO CONTA " +contaNome+" =@=");
        CLI.printaMensagem("Agência: " +conta.getAgencia()+ "\t Número: " +conta.getNumero());
        CLI.printaMensagem("Saldo: R$" + conta.getSaldo());
        if (conta.getSaldo() < 0) {
            CLI.printaMensagem("Você está Devendo!");
        }
    }

    static public void exibirTelaSacar(Conta conta) {
        String contaNome = conta.getName();

        System.out.print("Insira o valor para sacar na conta " +contaNome+ ": ");
        int valor = scan.nextInt();
        conta.Sacar(valor);
        CLI.printaMensagem("R$" + valor + " sacado na conta");
    }

    static public void exibirTelaDepositar(Conta conta) {
        String contaNome = conta.getName();

        System.out.print("Insira o valor para depositar na conta " +contaNome+ ": ");
        int valor = scan.nextInt();
        conta.Depositar(valor);
        CLI.printaMensagem("R$" +valor+ " depositado na conta!");
    }


    static public void escolhaTela(Conta conta, int escolha) {
        switch (escolha) {
            case 1 -> exibirExtrato(conta);
            case 2 -> exibirTelaSacar(conta);
            case 3 -> exibirTelaDepositar(conta);
        }
    }

}

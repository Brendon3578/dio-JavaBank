import bank.Conta;
import bank.ContaCorrente;
import bank.ContaPoupanca;
import screen.Screen;
import utils.CLI;

import java.util.Scanner;


/** Projeto JavaBank
 * @author Brendon Gomes
 * @version 1.0.0
 * */
public class Main {

    /* ## DESAFIO
    * Considerando o nosso conhecimento no domínio bancário, iremos abstrair uma
    * solução Orientada a Objetos em Java. Para isso, vamos interpretar o seguinte
    * cenário: “Um banco oferece aos seus clientes dois tipos de contas (corrente e poupança),
    * as quais possuem as funcionalidades de depósito, saque e transferência (entre contas
    * da própria instituição).”
    */

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String nomeUsuario;
        int escolhaTipoConta = 0;

        System.out.print("Insira seu nome: ");
        nomeUsuario = scan.next();

        while (escolhaTipoConta != 1 && escolhaTipoConta != 2) {
            System.out.println("Escolha o tipo de conta que você quer fazer:");
            System.out.println("[1] Conta corrente \t\t [2] Conta poupança");
            CLI.printaMensagemDeEntrada();
            escolhaTipoConta = scan.nextInt();
        }

        if (escolhaTipoConta == 1) {
            RodarPrograma(new ContaCorrente("corrente"), nomeUsuario);
        }
        if (escolhaTipoConta == 2) {
            RodarPrograma(new ContaPoupanca("poupança"), nomeUsuario);
        }
    }

    static void RodarPrograma(Conta conta, String nomeUsuario) {
        boolean rodarPrograma = true;
        int escolhaOpcao;

        while(rodarPrograma) {
            CLI.limpaConsole();

            escolhaOpcao = Screen.exibirTelaPrincipal(conta, nomeUsuario);
            Screen.escolhaTela(conta, escolhaOpcao);

            if (escolhaOpcao == 0) {
                rodarPrograma = false;
            }

        }
    }

//    static void RodarPrograma(ContaPoupanca conta, String nome) {
//        boolean rodarPrograma = true;
//        int escolhaOpcao;
//
//        while(rodarPrograma) {
//            CLI.limpaConsole();
//
//            escolhaOpcao = ScreenContaPoupanca.exibirTelaPrincipal(nome);
//            ScreenContaPoupanca.escolhaTela(conta, escolhaOpcao);
//
//            if (escolhaOpcao == 0) {
//                rodarPrograma = false;
//            }
//
//        }
//    }

}

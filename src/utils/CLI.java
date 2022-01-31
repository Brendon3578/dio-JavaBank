package utils;

/**
 * <b>ClI (command-line interface)</b>
 * <br>
 * Essa classe foi feita para exibir linhas, limpar console, etc
 *
 * @author Brendon Gomes
 * */
public class CLI {
    public static void printaDash() {
        System.out.println("-@-------------------------------------------------@-");
    }
    public static void printaMensagem(String msg) {
        System.out.println("\t" + msg);
    }
    public static void printaMensagemDeEntrada() {
        System.out.print("> ");
    }

    /**
     * Limpar a tela -codigo pego de um link
     * @see <a href="https://www.delftstack.com/howto/java/java-clear-console/">Código tirado do site DelftStack</a>
     * */
    public static void limpaConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}

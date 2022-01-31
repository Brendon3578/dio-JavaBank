package bank;

public abstract class Conta implements IConta {

    protected static final int AGENCIA_PADRAO = 1;
    protected static int SEQUENCIAL = 1;

    protected String name;
    protected int agencia;
    protected int numero;
    protected double saldo = 0;

    public Conta(String name) {
        this.name = name;
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
    }

    @Override
    public void Sacar(double valor) {
        saldo -= valor;
    }
    @Override
    public void Depositar(double valor) {
        saldo += valor;
    }
    @Override
    public void Transferir(double valor, Conta contaDestino) {
        this.Sacar(valor);
        contaDestino.Depositar(valor);
    }

    public String getName() { return name; }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}

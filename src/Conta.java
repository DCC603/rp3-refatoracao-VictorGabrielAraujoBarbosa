import java.util.ArrayList;
import java.util.List;

public class Conta {

    // DONE(#1) REFATORAÇÃO 1: criação da classe cliente e da classe agência, e mudança dos dados para lá.
    private Cliente _cliente;
    private Agencia _agencia;


    // DONE(#2) REFATORAÇÃO 2: renomeia "valor" para "saldo"
    private double saldo;

    private List<Operacao> operacoes;

    public Conta(String nomeCliente, String cpfCliente, String telefoneCliente, int numAgencia, int numConta, String gerente, double valor) {
        this._cliente = new Cliente(nomeCliente, cpfCliente, telefoneCliente);
        this._agencia = new Agencia(numAgencia, numConta, gerente);
        this.saldo = valor;

        this.operacoes = new ArrayList<>();
    }

    public Conta() {
        this(null, null, null, 0, 0, null, 0);
    }

    // DONE(#3) REFATORAÇÃO 3: extração do método "modificarSaldo"
    public void realizarOperacao(char tipo, int valor) {
        Operacao op = new Operacao(tipo, valor);
        this.operacoes.add(op);
        modificarSaldo(tipo, valor);
    }

    private void modificarSaldo(char tipo, int valor){
        if (tipo == 'd')
            this.saldo += valor;
        else if(tipo == 's')
            this.saldo -= valor;
    }

    public String toString() {
        // DONE(#4) REFATORAÇÃO 4: relocação de código por conta de feature envy
        String dadosConta = String.format("Saldo: %.2f", saldo);

        // TODO(#5) REFATORAR: Essa operação não deveria estar sendo realizada neste método
        String dadosExtrato = "";
        for(Operacao op : this.operacoes) {
            dadosExtrato += op.toString() + "\n";
        }

        return "-----CLIENTE-----\n" +
                _cliente +
                "\n\n" +
                "-----CONTA-----\n" +
                _agencia + "\n" + 
                dadosConta +
                "\n\n" +
                "-----EXTRATO-----\n" +
                dadosExtrato +
                "\n";
    }
}

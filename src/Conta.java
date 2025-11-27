import java.util.ArrayList;
import java.util.List;

public class Conta {

    // DONE(#1) REFATORAÇÃO 1: criação da classe cliente e da classe agência, e mudança dos dados para lá.
    private Cliente _cliente;
    private Agencia _agencia;


    // TODO(#2) REFATORAR: Esse nome não é o ideal para representar o saldo da conta
    private double valor;

    private List<Operacao> operacoes;

    public Conta(String nomeCliente, String cpfCliente, String telefoneCliente, int numAgencia, int numConta, String gerente, double valor) {
        this._cliente = new Cliente(nomeCliente, cpfCliente, telefoneCliente);
        this._agencia = new Agencia(numAgencia, numConta, gerente);
        this.valor = valor;

        this.operacoes = new ArrayList<>();
    }

    public Conta() {
        this(null, null, null, 0, 0, null, 0);
    }

    // TODO(#3) REFATORAR: Muita responsabilidade para o mesmo método
    public void realizarOperacao(char tipo, int valor) {
        Operacao op = new Operacao(tipo, valor);
        this.operacoes.add(op);

        if (tipo == 'd')
            this.valor += valor;
        else if(tipo == 's')
            this.valor -= valor;
    }

    public String toString() {
        // TODO(#4) REFATORAR: Esses dados não estão relacionados a conta
        String dadosCliente = String.format("CPF: %s\nNome: %s\nTelefone: %s",
                this._cliente.cpf(), this._cliente.nome(), this._cliente.telefone());

        // TODO(#4) REFATORAR: Esses dados não estão relacinados a conta
        String dadosConta = String.format("Ag.: %d\nConta: %d\nGerente: %s\nSaldo: %.2f",
                this._agencia.numagencia(), this._agencia.numconta(), this._agencia.gerente(), this.valor);

        // TODO(#5) REFATORAR: Essa operação não deveria estar sendo realizada neste método
        String dadosExtrato = "";
        for(Operacao op : this.operacoes) {
            dadosExtrato += op.toString() + "\n";
        }

        return "-----CLIENTE-----\n" +
                dadosCliente +
                "\n\n" +
                "-----CONTA-----\n" +
                dadosConta +
                "\n\n" +
                "-----EXTRATO-----\n" +
                dadosExtrato +
                "\n";
    }
}

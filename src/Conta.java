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
    public void realizarOperacao(OperacaoTipo tipo, int valor) {
        Operacao op = new Operacao(tipo, valor);
        this.operacoes.add(op);
        modificarSaldo(tipo, valor);
    }

    private void modificarSaldo(OperacaoTipo tipo, int valor){
        if (tipo.Equals('d'))
            this.saldo += valor;
        else if(tipo.Equals('s'))
            this.saldo -= valor;
    }
    
    private String extrato(){
        String extrato = "";
        for(Operacao op : this.operacoes) {
            extrato += op.toString() + "\n";
        }
        return extrato;
    }


    public String toString() {
        // DONE(#4) REFATORAÇÃO 4: relocação de código por conta de feature envy
        String dadosConta = String.format("Saldo: %.2f", saldo);

        // DONE(#5) REFATORAÇÃO 5: extração de método (extrato())
        String dadosExtrato = extrato();

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

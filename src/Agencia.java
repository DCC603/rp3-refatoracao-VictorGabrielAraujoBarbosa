public class Agencia {
    private int _numAgencia;
    private int _numConta;
    private String _gerente;

    public Agencia(int num, int conta, String gerente){
        this._numAgencia = num;
        this._numConta = conta;
        this._gerente = gerente;
    }

    public int numagencia(){return _numAgencia;}
    public int numconta(){return _numConta;}
    public String gerente(){return _gerente;}

    public String toString(){
        return String.format("Ag.: %d\nConta: %d\nGerente: %s",
                _numAgencia, _numConta, _gerente);
    }
}

public class Operacao {

    private OperacaoTipo tipo;
    private double valor;

    public Operacao(OperacaoTipo tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    // DONE(#6) REFATORAÇÃO: Extração de classe (OperacaoTipo)
    public String toString() {
        return tipo + ":\t" + this.valor;
    }
}

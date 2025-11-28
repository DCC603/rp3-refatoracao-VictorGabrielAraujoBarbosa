public class OperacaoTipo {
    private char _tipo;

    OperacaoTipo(char tipo){
        _tipo = tipo;
    }

    public Boolean Equals(char c){
        return _tipo == c;
    }

    public String toString() {
        switch (this._tipo) {
            case 'd':
                return "Depósito";
            case 's':
                return "Saque";
            default:
                return null;
        }
    }
}

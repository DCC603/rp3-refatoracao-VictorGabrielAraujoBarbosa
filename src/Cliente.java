public class Cliente {
    private String _nomeCliente;
    private String _cpfCliente;
    private String _telefoneCliente;

    public Cliente(String nome, String cpf, String telefone){
        this._nomeCliente = nome;
        this._cpfCliente = cpf;
        this._telefoneCliente = telefone;
    }

    public String nome(){return _nomeCliente;}
    public String cpf(){return _cpfCliente;}
    public String telefone(){return _telefoneCliente;}

    public String toString(){
        return String.format("CPF: %s\nNome: %s\nTelefone: %s",
                _cpfCliente, _nomeCliente, _telefoneCliente);
    }
}

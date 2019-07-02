package unifacef.funcionario;

import unifacef.servico.Servico;

public class Funcionario {
    private int codigo;
    private String nomeCompleto;
    private String sexo;
    private String email;
    private String telefone;
    private String dataNascimento;
    private Servico servico;

    public Funcionario() {
    }

    public Funcionario(int codigo, String nomeCompleto, String sexo, String email, String telefone, String dataNascimento, Servico servico) {
        this.codigo = codigo;
        this.nomeCompleto = nomeCompleto;
        this.sexo = sexo;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.servico = servico;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }
}

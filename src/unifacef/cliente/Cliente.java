package unifacef.cliente;

import java.sql.Date;

public class Cliente {
    private int codigo;
    private String nome;
    private String apelido;
    private Date nascimento;
    private String sexo;
    private String telefone;
    private String email;

    public Cliente() {
    }

    public Cliente(int codigo, String nome, String apelido, Date nascimento, String sexo, String telefone, String email) {
        this.codigo = codigo;
        this.nome = nome;
        this.apelido = apelido;
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.telefone = telefone;
        this.email = email;
        
    }
    public int getCodigo(){
       return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getApelido() {
        return apelido;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
        
    }
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
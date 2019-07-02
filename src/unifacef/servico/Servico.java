package unifacef.servico;

public class Servico {
    private int codigo;
    private String nome;
    private int duracao;
    
    public Servico() {
    }

    public Servico(int codigo, String nome, int duracao) {
        this.codigo = codigo;
        this.nome = nome;
        this.duracao = duracao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
}

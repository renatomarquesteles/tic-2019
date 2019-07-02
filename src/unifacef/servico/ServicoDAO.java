package unifacef.servico;

import java.util.ArrayList;

public interface ServicoDAO {
    public boolean inserir(Servico servico);
    public boolean editar(Servico servico);
    public boolean remover(Servico servico);
    public ArrayList<Servico> consultar();
}
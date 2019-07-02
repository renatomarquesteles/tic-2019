package unifacef.funcionario;

import java.util.ArrayList;

public interface FuncionarioDAO {
    
    public boolean insere(Funcionario funcionario);
    
    public boolean remove(Funcionario funcionario);
    
    public boolean atualiza(Funcionario funcionario);
    
    public ArrayList<Funcionario> consulta();
}

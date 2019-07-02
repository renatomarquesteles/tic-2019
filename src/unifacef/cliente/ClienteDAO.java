package unifacef.cliente;

import java.util.ArrayList;

public interface ClienteDAO {
     public boolean insere(Cliente cliente);
    
    public boolean remove(Cliente cliente);
    
    public boolean atualiza(Cliente cliente);
    
    public ArrayList<Cliente> consulta();
    
}

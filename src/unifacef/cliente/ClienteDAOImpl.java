package unifacef.cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import unifacef.main.BancoDados;

public class ClienteDAOImpl implements ClienteDAO{

    @Override
    public boolean insere(Cliente cliente) {
      Connection conexao = BancoDados.conecta();
        if (conexao == null){
            return false;
        }
        else{
            System.out.println("Conectou com sucesso");
            String sql = "insert into cliente(nome, apelido, nascimento, sexo, telefone, email) values (?, ?, ?, ?, ?, ?)";
            try{
                //cria canal de comunicação para executar SQL
                PreparedStatement canal = conexao.prepareStatement(sql);// prepara a inserção
                //coloca os valores dos ?
                canal.setString(1, cliente.getNome());// o valor que passou como parametro  no ponto de interrogação "?"
                canal.setString(2, cliente.getApelido());
                canal.setDate(3, cliente.getNascimento());
                canal.setString(3, cliente.getSexo());
                canal.setString(3, cliente.getTelefone());
                canal.setString(3, cliente.getEmail());
                //executa o comando no banco
                canal.execute();
                return true;
                
            }
            catch(SQLException e){
                System.out.println(e.getMessage());
                return false;
            }
        }
    }

    @Override
    public boolean remove(Cliente cliente) {
         Connection conexao = BancoDados.conecta();
        if (conexao == null){
            return false;
        }
        else{
            String sql = "delete from cliente where codigo = ?";
            try{
                //cria canal de comunicação para executar SQL
                PreparedStatement canal = conexao.prepareStatement(sql);// prepara a inserção
                //coloca os valores dos ?
                canal.setInt(1, cliente.getCodigo());// o valor que passou como parametro  no ponto de interrogação "?"
                //executa o comando no banco
                canal.execute();
                return true;
                
            }
            catch(SQLException e){
                System.out.println(e.getMessage());
                return false;
            }
        }
        
    }

    @Override
    public boolean atualiza(Cliente cliente) {
         Connection conexao = BancoDados.conecta();
        if (conexao == null){
            return false;
        }
        else{
            String sql = "update cliente set nome = ?, apelido = ?, nascimento = ?, sexo = ?, telefone = ?, email = ? where codigo = ?";
            try{
                //cria canal de comunicação para executar SQL
                PreparedStatement canal = conexao.prepareStatement(sql);// prepara a inserção
                //coloca os valores dos ?
                canal.setString(1, cliente.getNome());// o valor que passou como parametro  no ponto de interrogação "?"
                canal.setString(2, cliente.getApelido());
                canal.setDate(3, cliente.getNascimento());
                canal.setString(3, cliente.getSexo());
                canal.setString(3, cliente.getTelefone());
                canal.setString(3, cliente.getEmail());
                //executa o comando no banco
                canal.execute();
                return true;
                
            }
            catch(SQLException e){
                System.out.println(e.getMessage());
                return false;
            }
        }
    }

    @Override
    public ArrayList<Cliente> consulta() {
         Connection conexao = BancoDados.conecta();
        if (conexao == null){
            return null;
        }
        else{
            String sql = "select * from cliente";
            try{
                //cria canal de comunicação para executar SQL
                Statement canal = conexao.createStatement();// prepara a inserção
                //coloca os valores dos ?
                ResultSet ponteiro = canal.executeQuery(sql);
                ArrayList<Cliente> clientes = new ArrayList();
                while(ponteiro.next()){
                    Cliente cliente = new Cliente();
                        cliente.setCodigo(ponteiro.getInt("codigo"));
                        cliente.setNome(ponteiro.getString("nome"));
                        cliente.setApelido(ponteiro.getString("apelido"));
                        cliente.setNascimento(ponteiro.getDate("nascimento"));
                        cliente.setSexo(ponteiro.getString("sexo"));
                        cliente.setTelefone(ponteiro.getString("telefone"));
                        cliente.setEmail(ponteiro.getString("email"));
                        clientes.add(cliente); //adiciona cada objeto no array     
                }
                //executa o comando no banco
                return clientes;
                
            }
            catch(SQLException e){
                System.out.println(e.getMessage());
                return null;
            }
        }
    }
  }
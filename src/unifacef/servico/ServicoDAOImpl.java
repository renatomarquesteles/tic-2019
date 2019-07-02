package unifacef.servico;

import java.sql.*;
import java.util.ArrayList;
import unifacef.main.BancoDados;

public class ServicoDAOImpl implements ServicoDAO{

    @Override
    public ArrayList<Servico> consultar() {
        Connection conexao = BancoDados.conecta();
        if(conexao == null){
            return null;
        }
        else{
            String sql = "select * from tb_servicos";
            try{
                Statement canal = conexao.createStatement();
                ResultSet ponteiro = canal.executeQuery(sql);
                ArrayList<Servico> servicos = new ArrayList();
                while(ponteiro.next()){
                    Servico servico = new Servico();
                    servico.setCodigo(ponteiro.getInt("cod"));
                    servico.setNome(ponteiro.getString("nm"));
                    servico.setDuracao(ponteiro.getInt("duracao"));
                    servicos.add(servico);
                }
                return servicos;
            }
            catch(SQLException e){
                System.out.println(e.getMessage());
                return null;
            }
        }
    }

    @Override
    public boolean inserir(Servico servico) {
        Connection conexao = BancoDados.conecta();
        if(conexao == null){
            return false;
        }
        else{
            System.out.println("Conectou");
            String sql = "insert into tb_servicos(nm, duracao) values (?,?)";
            try{
                PreparedStatement canal = conexao.prepareStatement(sql);
                canal.setString(1, servico.getNome());
                canal.setInt(2, servico.getDuracao());
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
    public boolean remover(Servico servico) {
        Connection conexao = BancoDados.conecta();
        if(conexao == null){
            return false;
        }
        else{
            String sql = "DELETE FROM tb_servicos WHERE cod = ?";
            try{
                PreparedStatement canal = conexao.prepareStatement(sql);
                canal.setInt(1, servico.getCodigo());
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
    public boolean editar(Servico servico) {
        Connection conexao = BancoDados.conecta();
        if(conexao == null){
            return false;
        }
        else{
            String sql = "UPDATE tb_servicos set nm = ?, duracao = ? where cod = ?";
            try{
                PreparedStatement canal = conexao.prepareStatement(sql);
                
                canal.setString(1, servico.getNome());
                canal.setInt(2, servico.getDuracao());
                canal.setInt(3, servico.getCodigo());
                
                canal.execute();
                return true;
            }
            catch(SQLException e){
                System.out.println(e.getMessage());
                return false;
            }
        }
    }
  
}
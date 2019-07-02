package unifacef.funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import unifacef.main.BancoDados;

public class FuncionarioDAOImpl implements FuncionarioDAO{
    @Override
    public boolean insere(Funcionario funcionario) {
        Connection conexao = BancoDados.conecta();
        if (conexao == null){
            return false;
        }
        else {
            System.out.println("Conectou com sucesso");
            String sql = "insert into funcionario (nomeCompleto, sexo, email, telefone, dataNascimento) values (?, ?, ?, ?, ?)";
            try {
                PreparedStatement canal = conexao.prepareStatement(sql);
                canal.setString(1, funcionario.getNomeCompleto());
                canal.setString(2, funcionario.getSexo());
                canal.setString(3, funcionario.getEmail());
                canal.setString(4, funcionario.getTelefone());
                canal.setString(5, funcionario.getDataNascimento());
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
    public boolean remove(Funcionario funcionario) {
         Connection conexao = BancoDados.conecta();
            if (conexao == null){
                return false;
            }
            else {
                String sql = "delete from funcionario where codigo = ?";
                try {
                    PreparedStatement canal = conexao.prepareStatement(sql);
                    canal.setInt(1, funcionario.getCodigo());
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
    public boolean atualiza(Funcionario funcionario) {
          Connection conexao = BancoDados.conecta();
            if (conexao == null){
                return false;
            }
            else {
                String sql = "update funcionario set nomeCompleto = ?, sexo = ?, email = ?, telefone = ?, dataNascimento = ? where codigo = ?";
                try {
                    PreparedStatement canal = conexao.prepareStatement(sql);
                    canal.setString(1, funcionario.getNomeCompleto());
                    canal.setString(2, funcionario.getSexo());
                    canal.setString(3, funcionario.getEmail());
                    canal.setString(4, funcionario.getTelefone());
                    canal.setString(5, funcionario.getDataNascimento());
                    canal.setInt(6, funcionario.getCodigo());
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
    public ArrayList<Funcionario> consulta() {
         Connection conexao = BancoDados.conecta();
            if (conexao == null){
                return null;
            }
            else {
                String sql = "select * from funcionario";
                try {
                    Statement canal = conexao.createStatement();
                    ResultSet ponteiro = canal.executeQuery(sql);
                    ArrayList<Funcionario> funcionarios = new ArrayList();
                    while (ponteiro.next()){
                        Funcionario funcionario = new Funcionario();
                        funcionario.setCodigo(ponteiro.getInt("codigo"));
                        funcionario.setNomeCompleto(ponteiro.getString("nomeCompleto"));
                        funcionario.setSexo(ponteiro.getString("sexo"));
                        funcionario.setEmail(ponteiro.getString("estado"));
                        funcionario.setTelefone(ponteiro.getString("telefone"));
                        funcionario.setDataNascimento(ponteiro.getString("dataNascimento"));
                        funcionarios.add(funcionario);
                    }
                    canal.execute(sql);
                    return funcionarios;
                }
                catch(SQLException e){
                    System.out.println(e.getMessage());
                    return null;
                }
            }
    }
}

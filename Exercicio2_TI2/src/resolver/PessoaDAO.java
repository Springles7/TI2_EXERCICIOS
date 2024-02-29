package resolver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class PessoaDAO {
    private Connection connection;

    public PessoaDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserir(Pessoa pessoa) {
        try {
            String query = "INSERT INTO pessoa (nome, idade) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, pessoa.getNome());
                preparedStatement.setInt(2, pessoa.getIdade());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Pessoa> listar() {
        List<Pessoa> pessoas = new ArrayList<>();
        try {
            String query = "SELECT * FROM pessoa";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    Pessoa pessoa = new Pessoa();
                    pessoa.setId(resultSet.getInt("id"));
                    pessoa.setNome(resultSet.getString("nome"));
                    pessoa.setIdade(resultSet.getInt("idade"));
                    pessoas.add(pessoa);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pessoas;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mysql.cj.jdbc.ConnectionImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.alunos;
import tela.CadastroAluno;

/**
 *
 * @author PC
 */
public class alunoDao {

    private final Connection connection;
    ResultSet rs;
    PreparedStatement pstm;

    public alunoDao(Connection connection) {
        this.connection = connection;
    }

    public void insert(alunos aluno) throws SQLException {

        // TODO add your handling code here:
        String sql = "insert into alunos (nome,idade,cpf,rg,endereco,bairro,email) values ('" + aluno.getNome() + "','" + aluno.getIdade() + "','" + aluno.getCpf() + "','" + aluno.getRg() + "','" + aluno.getEndereco() + "','" + aluno.getBairro() + "','" + aluno.getEmail() + "');";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();

    }

    public void update(alunos aluno) throws SQLException {
        String sql = "update alunos set alunos nome = ?,idade = ? ,cpf = ?,rg = ?,endereco = ?,bairro = ?,email = ? where id = ?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
    }

    public ArrayList<alunos> selectAll() throws SQLException {

        String sql = "select * from alunos";

        PreparedStatement statement = connection.prepareStatement(sql);
        
        ArrayList<alunos> Alunos = new ArrayList<>();
        
        
        statement.execute();
        ResultSet resulset = statement.getResultSet();

        

        while (resulset.next()) {

            String nome = resulset.getString("nome");
            String idade = resulset.getString("idade");
            String cpf = resulset.getString("cpf");
            String rg = resulset.getString("rg");
            String endereco = resulset.getString("endereco");
            String bairro = resulset.getString("bairro");
            String email = resulset.getString("email");

            alunos alunoComDadosDoBanco = new alunos(nome, idade, cpf, rg, endereco, bairro, email);

            Alunos.add(alunoComDadosDoBanco);
        }

        return Alunos;

    }

}

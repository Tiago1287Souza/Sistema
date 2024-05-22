/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class ConexaoTeste {
    
    public Connection getConnectionLogin () throws SQLException {
        Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "admin");
        return conexao;
    }
    
    public Connection getConnectionAluno () throws SQLException {
        Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/alunos", "root", "admin");
        return conexao;
    }
    
}

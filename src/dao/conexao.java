/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 *
 * @author aluno
 */
public class conexao {
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/academia?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String USER = "tiago";
    private static final String PASS = "12345";
    
    public static Connection getConnetion () throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USER, PASS);
        
    }
    public static void closeConnection(Connection c) throws SQLException {
        if (c != null && !c.isClosed()) {
            c.close();
        }
        
    }
    public static void closeConnectin(Connection c, PreparedStatement statment) throws SQLException {
       closeConnection(c);
       if (statment != null) {
           statment.close();
       }
    }
}

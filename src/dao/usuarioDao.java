/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import modelo.Usuarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class usuarioDao {
    
    private final Connection connection;

    public usuarioDao(Connection connection) {
        this.connection = connection;
    }
    
    public void insert (Usuarios usuario) throws SQLException {
        
        
        try (connection) {
            String sql = "insert into usuario(usuario,senha) values ('"+usuario.getUsuario()+"','"+usuario.getSenha()+"');";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
        }
        }

    public boolean  existeNoBancoPorUsuarioESenha(Usuarios usuario) throws SQLException {
        String sql = "select * from usuario where usuario = '"+usuario.getUsuario()+"' and senha = '"+usuario.getSenha()+"'";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
        
        ResultSet resulSet = statement.getResultSet();
        
        return resulSet.next();
       
          
        
    }    
 
    
}

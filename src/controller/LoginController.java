/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.mysql.cj.jdbc.ConnectionImpl;
import dao.ConexaoTeste;
import dao.usuarioDao;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Usuarios;
import tela.Menu;
import tela.TelaLogin;

/**
 *
 * @author PC
 */
public class LoginController {
    
    public TelaLogin view;

    public LoginController(TelaLogin view) {
        this.view = view;
    }

    public void autenticar() throws SQLException {
        
        //Buscar o usuario no tela
        
        String usuario = view.getjTextFieldUsuario().getText();
        String senha = view.getjPasswordFieldSenha().getText();
        
        Usuarios usuarioAutenticar = new Usuarios(usuario, senha);
        
        // vererificar o usuario no banco
        
        ConnectionImpl conexao =  (ConnectionImpl) new ConexaoTeste().getConnectionLogin();
        usuarioDao UsuarioDao = new usuarioDao((java.sql.Connection) conexao);
        
        
        boolean existe =  UsuarioDao.existeNoBancoPorUsuarioESenha(usuarioAutenticar);
        
        
        if(existe){
        Menu menu = new Menu ();
        menu.setVisible(Boolean.TRUE);
        
        JOptionPane.showMessageDialog(null, "Login com Sucesso !!!");
        

        }else {
            JOptionPane.showMessageDialog(view, " Usuario e Senha Invalido!!!");
            
        }
        
        
        
        
    }
    
    
    
    
    
    
}

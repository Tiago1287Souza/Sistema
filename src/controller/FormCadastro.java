/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.mysql.cj.jdbc.ConnectionImpl;
import dao.ConexaoTeste;
import dao.usuarioDao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Usuarios;
import tela.Registrar;

/**
 *
 * @author PC
 */
public class FormCadastro {
    
    public Registrar view;

    public FormCadastro(Registrar view) {
        this.view = view;
    }
    
    public void salvaUsuario () {
        
        
        view.getjTextFieldUsuario().getText();
        view.getjPasswordFieldSenha().getText();
        
        
        String usuario = view.getjTextFieldUsuario().getText();
        String senha = view.getjPasswordFieldSenha().getText();
        
        Usuarios usuarioXandi = new Usuarios(usuario, senha);
        
        try {
            ConnectionImpl conexao =  (ConnectionImpl) new ConexaoTeste().getConnectionLogin();
            usuarioDao UsuarioDao = new usuarioDao((java.sql.Connection) conexao);
            UsuarioDao.insert(usuarioXandi);
            
            JOptionPane.showMessageDialog(null, "Usuario de droga casdatrado com sucesso!!!");
        } catch (SQLException ex) {
            Logger.getLogger(Registrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    
}

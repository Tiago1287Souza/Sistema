/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.mysql.cj.jdbc.ConnectionImpl;
import dao.ConexaoTeste;
import dao.alunoDao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.alunos;
import tela.CadastroAluno;

/**
 *
 * @author PC
 */
public class FormAluno {
    
    public CadastroAluno view;

    public FormAluno(CadastroAluno view) {
        this.view = view;
    }
    
    public void salvarAlunos() {
        
        
        view.getjTextFieldbairro().getText();
    
        String nome = view.getjTextFieldnome().getText();
        String idade = view.getjTextFieldidade().getText();
        String email = view.getjTextFieldemail().getText();
        String cpf = view.getjTextFieldcpf().getText();
        String rg = view.getjTextFieldcpf().getText();
        String endereco = view.getjTextFieldendereco().getText();
        String bairro = view.getjTextFieldbairro().getText();
        
        
        
        alunos AlunosXandi = new alunos(nome, idade, cpf, rg, endereco, bairro, email);
       
       
       
       
        try {
            ConnectionImpl conexao = (ConnectionImpl) new ConexaoTeste().getConnectionAluno();
            
            alunoDao  AlunoDao = new alunoDao(conexao);
            AlunoDao.insert(AlunosXandi);
            
            
                JOptionPane.showMessageDialog(null, "Aluno salvo com sucesso !!!");
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastroAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
    
}

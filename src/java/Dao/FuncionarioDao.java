/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pacote.Funcionario;

/**
 *
 * @author Ina
 */
public class FuncionarioDao {
    private Connection connection = null;
    PreparedStatement stmt = null;
    
    public FuncionarioDao(){
        this.connection = ConnectionFactory.getConnection();
    }
    
     public Boolean verificaFunc(String login, String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException{
         String sql = "select * from admin where login=? and senha=?";
        
        try{
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setString(2, senha);
            stmt.execute();
            
            ResultSet rs = stmt.getResultSet();
            
            if(rs.next()){
                return true;
            } 
            return false;
        
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
                try{stmt.close();}catch (Exception ex){};
        }   
        }
     
     public Funcionario getFunc(String login) throws NoSuchAlgorithmException, UnsupportedEncodingException{
         String sql = "select * from admin where login=?";
        
        try{
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.execute();
            
            ResultSet rs = stmt.getResultSet();
            
            if(rs.next()){
                Funcionario f = new Funcionario();              
                f.setNome(rs.getString("nome"));
                f.setLogin(rs.getString("login"));
                f.setCpf(rs.getString("cpf"));
                f.setEmail(rs.getString("email"));
                f.setSenha(rs.getString("senha"));
                f.setSexo(rs.getString("sexo"));
                f.setTipo(rs.getInt("tipo"));
                
                
                return f;
            } 
            return null;
        
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
                try{stmt.close();}catch (Exception ex){};
        }   
        }
}

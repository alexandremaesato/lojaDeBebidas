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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pacote.Funcionario;

/**
 *
 * @author Ina
 */
public class FuncionarioDao {
   
    
      private Connection con=null;
    PreparedStatement ptmt = null;
    private Statement comando;  
    ResultSet resultSet = null;
    
    public FuncionarioDao(){
        this.con = ConnectionFactory.getConnection();
    }
    
     public Boolean verificaFunc(String login, String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException{
         String sql = "select * from admin where login=? and senha=?";
        
        try{
            ptmt = con.prepareStatement(sql);
            ptmt.setString(1, login);
            ptmt.setString(2, senha);
            ptmt.execute();
            
            ResultSet rs = ptmt.getResultSet();
            
            if(rs.next()){
                return true;
            } 
            return false;
        
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
                try{ptmt.close();}catch (Exception ex){};
        }   
        }
     
     public Funcionario getFunc(String login) throws NoSuchAlgorithmException, UnsupportedEncodingException{
         String sql = "select * from admin where login=?";
        
        try{
            ptmt = con.prepareStatement(sql);
            ptmt.setString(1, login);
            ptmt.execute();
            
            ResultSet rs = ptmt.getResultSet();
            
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
                try{ptmt.close();}catch (Exception ex){};
        }   
        }
     
     public List<Funcionario> busca(String s,String tipo) throws SQLException {
        String query;
        if(tipo.equals("cpf"))
             query = "SELECT * FROM admin where cpf="+ s;
        else//palavra
             query = "SELECT * FROM admin WHERE nome LIKE '%"+s+"%' OR email LIKE '%"+s+"%' or login LIKE '%"+s+"%'";
        List<Funcionario> lista = new ArrayList<>();
            try {
                con = ConnectionFactory.getConnection();
                ptmt = con.prepareStatement(query);
                resultSet= ptmt.executeQuery();
                
                while(resultSet.next()){  
                    Funcionario f = new Funcionario();                      
                    f.setNome(resultSet.getString("nome"));  
                    f.setCpf(resultSet.getString("cpf"));
                    f.setTipo(resultSet.getInt("tipo"));
                    f.setEmail(resultSet.getString("email"));
                    f.setSexo(resultSet.getString("sexo"));
                     f.setLogin(resultSet.getString("login"));
                      f.setSenha(resultSet.getString("senha"));
                    lista.add(f);  
                }  
            }finally {       
            }
                return lista;  
            
        }  
     public int add(Funcionario p) {///altera ou cadastra
        		try {
			String query = "INSERT INTO admin(nome, tipo, login, senha, cpf, email, sexo) VALUES(?,?,?,?,?,?,?)";
			String query1 = "update admin set nome=?,tipo=?,login=?,senha=?,email=?, sexo=? where cpf=?";

                        con = ConnectionFactory.getConnection();
			
                        // try {
                           // con = ConnectionFactory.getConnection();
                            ptmt = con.prepareStatement("SELECT cpf FROM admin where cpf="+p.getCpf());
                            resultSet= ptmt.executeQuery();
                        // }
                        
                            if (!resultSet.next()) {//cadastra
                                ptmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                                ptmt.setString(1, p.getNome());
                                ptmt.setInt(2, p.getTipo());
                                ptmt.setString(3, p.getLogin());
                                ptmt.setString(4, p.getSenha());
                                ptmt.setString(5, p.getCpf());
                                ptmt.setString(6, p.getEmail());
                                ptmt.setString(7, p.getSexo());

                                int affectedRows = ptmt.executeUpdate();
                                if (affectedRows == 0) {
                                    throw new SQLException("Creating user failed, no rows affected.");
                                }

                                try (ResultSet generatedKeys = ptmt.getGeneratedKeys()) {
                                    if (generatedKeys.next()) {
                                        return generatedKeys.getInt(1);
                                    } else {
                                        throw new SQLException("Creating user failed, no ID obtained.");
                                    }
                                }
                            } else {//atualiza
                                ptmt = con.prepareStatement(query1);
                                ptmt.setString(1, p.getNome());
                                ptmt.setInt(2, p.getTipo());
                                ptmt.setString(3, p.getLogin());
                                ptmt.setString(4, p.getSenha());
                              
                                ptmt.setString(5, p.getEmail());
                                ptmt.setString(6, p.getSexo());
                                ptmt.setString(7, p.getCpf());

                                int affectedRows = ptmt.executeUpdate();
                                if (affectedRows == 0) {
                                    throw new SQLException("Creating user failed, no rows affected.");
                                }else return 1;

                              

                            }
	}  catch (SQLException e) {
                try {
                    con.rollback();
                } catch (SQLException ex) {
                    Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, ex);
                }
                 throw new RuntimeException(e);
            }finally{
                        try{ptmt.close();}catch (Exception ex){};
                }
    }
     public int remove(Funcionario p) {
         try {
			String query = "delete from admin where cpf=?";
			con = ConnectionFactory.getConnection();
			ptmt = con.prepareStatement(query);
                        
                        ptmt.setString(1, p.getCpf());
                                                
                        int affectedRows = ptmt.executeUpdate();
                        if (affectedRows == 0) {
                            throw new SQLException("Deleting user failed, no rows affected.");
                        }else return 1;
                                        
	}  catch (SQLException e) {
                try {
                    con.rollback();
                } catch (SQLException ex) {
                    Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, ex);
                }
                 throw new RuntimeException(e);
            }finally{
                        try{ptmt.close();}catch (Exception ex){};
                }
     
     }
     
     
     
}

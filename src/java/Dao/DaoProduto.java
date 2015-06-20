/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pacote.Categoria;
import pacote.Produto;

/**
 *
 * @author Ina
 */
public class DaoProduto {
    private Connection con=null;
    PreparedStatement ptmt = null;
    private Statement comando;  
    ResultSet resultSet = null;
    
    public int add(Produto p) {
        		try {
			String query = "INSERT INTO Produto(idCategoria, nome, descricao, valor, quantidade, status, imagem) VALUES(?,?,?,?,?,?,?)";
			con = ConnectionFactory.getConnection();
			ptmt = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
                        
			ptmt.setInt(1,p.getCategoria().getIdCategoria());
                        ptmt.setString(2, p.getNome());
                        ptmt.setString(3, p.getDescricao());
                        ptmt.setFloat(4, p.getValor());
			ptmt.setInt(5, p.getQuantidade());
                        ptmt.setInt(6, p.getStatus());
                        ptmt.setString(7, p.getImagem());
                        
                        int affectedRows = ptmt.executeUpdate();
                        if (affectedRows == 0) {
                            throw new SQLException("Creating user failed, no rows affected.");
                        }

                        try (ResultSet generatedKeys = ptmt.getGeneratedKeys()) {
                            if (generatedKeys.next()) {
                                return generatedKeys.getInt(1);
                            }
                            else {
                                throw new SQLException("Creating user failed, no ID obtained.");
                            }
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
    public List<Produto> busca(String cat,String ordem) throws SQLException {
        String query;
        if(cat.equals("todos"))
             query = "SELECT * FROM produto p, imagem a where p.idProduto= a.idProduto ORDER BY "+ordem;
        else
             query = "SELECT * FROM produto p, imagem a where p.idProduto= a.idProduto and idCategoria="+cat+" ORDER BY "+ordem;// nome ASC;  nome DESC; valor ASC; valor DESC;
             
        List<Produto> lista = new ArrayList<>();
            try {
                con = ConnectionFactory.getConnection();
                ptmt = con.prepareStatement(query);
                resultSet= ptmt.executeQuery();
                
                while(resultSet.next()){  //idProduto, idCategoria, nome, descricao, valor, quantidade, status
                    Produto p = new Produto();  
                    Categoria c=new Categoria();
                    c.setIdCategoria(resultSet.getInt("idcategoria"));
                    
                    p.setCategoria(c); 
                   
                    p.setNome(resultSet.getString("nome"));  
                    p.setDescricao(resultSet.getString("descricao"));
                    p.setValor(resultSet.getFloat("valor"));
                    p.setQuantidade(resultSet.getInt("quantidade"));
                    p.setStatus(resultSet.getInt("status"));
                    
                    
                  
                    p.setImagem(resultSet.getString("foto"));

                    
                    lista.add(p);  
                }  
            }finally {       
            }
                return lista;  
            
        }  
    
        
}

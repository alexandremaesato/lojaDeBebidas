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
import pacote.Cliente;

/**
 *
 * @author hednisk
 */
public class DaoCliente {
  
   private Connection con=null;
   private Statement comando;  
  PreparedStatement ptmt = null;
	ResultSet resultSet = null;
  /* public void apagar(String cpf) {         
      try {  
          con = ConnectionFactory.getConnection();
          comando = con.createStatement();
          comando.executeUpdate("DELETE FROM cliente WHERE cpf = '" + cpf + "';");  
      } catch (SQLException e) {  
        //System.out.println(e.getMessage());  
      } finally {  
          
        // fechar();  
      }  
   }  */
   
   public void add(Cliente cli) {
		try {
			String query = "INSERT INTO Cliente(nome, login, senha, cpf, email, telefone, celular, status) VALUES(?,?,?,?,?,?,?,?)";
			con = ConnectionFactoryIna.getConnection();
			ptmt = con.prepareStatement(query);
			//ptmt.setInt(1, cli.getRollNo());
                        ptmt.setString(1, cli.getNome());
			ptmt.setString(2, cli.getLogin());
			ptmt.setString(3, cli.getSenha());
			ptmt.setString(4, cli.getEmail());
                        ptmt.setString(5, cli.getTelefone());
                        ptmt.setString(6, cli.getCelular());
                        ptmt.setBoolean(7, cli.getStatus());
                        
			ptmt.executeUpdate();
			System.out.println("Data Adicionada!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import pacote.Imagem;

/**
 *
 * @author Ina
 */
public class DaoImagem {
    private Connection con=null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;
    
      public int add(Imagem im) throws SQLException {
          String message = null;    
          try { 
                    //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                    //con = DriverManager.getConnection(dbURL, dbUser, dbPass);                    
                    String query = "INSERT INTO imagem (idProduto, foto) values (?, ?)";
                    con = ConnectionFactory.getConnection();
                    ptmt = con.prepareStatement(query);

                    ptmt.setInt(1, im.getIdProduto());
                    
                       ptmt.setString(2, im.getFoto());
                   
                    int row = ptmt.executeUpdate();
                    if (row > 0) {
                        message = "File uploaded and saved into database";
                        return 1;
                    }
                    
                } catch (SQLException ex) {
                    message = "ERROR: " + ex.getMessage();
                    ex.printStackTrace();
                } finally {
                    if (con != null) {
                        // closes the database connection
                        try {
                            con.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }  
            }                        return 0;

      }
}

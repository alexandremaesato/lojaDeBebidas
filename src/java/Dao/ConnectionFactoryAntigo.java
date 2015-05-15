/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.*;

/**
 *
 * @author Alexandre
 */
public class ConnectionFactoryAntigo {
    /*
     private ConnectionFactory() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static Connection getConnection() {
        return instance.createConnection();
    }  
    
    */
     
    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/bancoDados?useUnicode=true&characterEncoding=UTF-8", "root", "senha2");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    
}

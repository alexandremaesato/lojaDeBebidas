package Dao;


import Dao.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import pacote.Cliente;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alexandre
 */
public class DataLogDao {
    private Connection connection = null;
    PreparedStatement stmt = null;
    
    public DataLogDao(){
        this.connection = ConnectionFactory.getConnection();
    }
    
    public void adiciona(Cliente cliente) {
    
        String sql = "insert into datalog " +
            "(idCliente, dataLogin)" +
            " values (?,?)";
        
    try {
        // prepared statement para inserção
        stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        // seta os valores

        stmt.setLong(1,cliente.getIdCliente());
        stmt.setDate(2,new Date(System.currentTimeMillis()));
        // executa
        stmt.execute();
        ResultSet rs = stmt.getGeneratedKeys(); // pega o Id gerado
        rs.next();
        long i = rs.getLong(1);
        
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }finally{
                try{stmt.close();}catch (Exception ex){};
            }
    }
    
    public boolean setLogout(Cliente cliente){
    
        String sql = "UPDATE datalog SET dataLogout=? WHERE idDatalog=?";
        DataLogDao datalogdao = new DataLogDao();
    try {
        // prepared statement para inserção
        stmt = connection.prepareStatement(sql);

        // seta os valores
        
        stmt.setDate(1,new Date(System.currentTimeMillis()));
        stmt.setLong(2,datalogdao.pegarUltimo(cliente));
        
        // executa
        stmt.execute();
        return true;
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }finally{
                try{stmt.close();}catch (Exception ex){};
            }
    }
    
    public long pegarUltimo(Cliente cliente){
       String sql = "SELECT idDatalog FROM datalog WHERE idCliente=? ORDER BY dataLogin DESC LIMIT 1";
        
    try {
        long result;
        // prepared statement para inserção
        stmt = connection.prepareStatement(sql);
        stmt.setLong(1,cliente.getIdCliente());
        // executa
        //stmt.execute();
        ResultSet rs = stmt.executeQuery();
        rs.next();
        result = rs.getLong(1);
        return result;
        
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }finally{
                try{stmt.close();}catch (Exception ex){};
            }
    } 
    
}

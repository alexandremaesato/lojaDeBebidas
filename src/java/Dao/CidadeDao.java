package Dao;



import Dao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pacote.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alexandre
 */
public class CidadeDao {
    private Connection connection = null;
    PreparedStatement stmt = null;
    
    public CidadeDao(){
    this.connection = ConnectionFactory.getConnection();
}
    public List<Cidade> getCidades() throws SQLException{
        String sql = "select * from Cidade";
        stmt = connection.prepareStatement(sql);
        List<Cidade> cidades = new ArrayList<Cidade>();
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            Cidade c = new Cidade();
            c.setIdCidade(rs.getLong("idCidade"));
            c.setCidade(rs.getString("cidade"));
            c.setStatus(rs.getBoolean("status"));
            cidades.add(c);
        }
        
        return cidades;
    }
    
    public List<String> getNomeCidades() throws SQLException{
        List<Cidade> cidades = this.getCidades();
        
        List<String> lista = new ArrayList();
        
        Iterator i = cidades.iterator();
        while(i.hasNext()){
            Cidade cidade = (Cidade)i.next();
            lista.add(cidade.getCidade());
        }
        return lista;
        
    }
    
    public Cidade getCidade(String Nome) throws SQLException{
        String sql = "select * from cidade where cidade=?";
        
        stmt = connection.prepareStatement(sql);
        stmt.setString(1,Nome);
        
        //ResultSet rs = stmt.getResultSet();
        ResultSet rs = stmt.executeQuery();
        
        if(rs.next()){
            Cidade c = new Cidade();
            c.setIdCidade(rs.getLong("idCidade"));
            c.setCidade(rs.getString("cidade"));
            c.setStatus(rs.getBoolean("status"));
            return c;
        }else{
        
        return null;
        }
    }
    
    public Cidade getCidade(long id) throws SQLException{
        String sql = "select * from cidade where idCidade=?";
        
        stmt = connection.prepareStatement(sql);
        stmt.setLong(1,id);
        
        //ResultSet rs = stmt.getResultSet();
        ResultSet rs = stmt.executeQuery();
        
        if(rs.next()){
            Cidade c = new Cidade();
            c.setIdCidade(rs.getLong("idCidade"));
            c.setCidade(rs.getString("cidade"));
            c.setStatus(rs.getBoolean("status"));
            return c;
        }else{
        
        return null;
        }
    }
}

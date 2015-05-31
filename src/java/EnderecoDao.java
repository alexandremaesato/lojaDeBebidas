
import Dao.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import pacote.Cidade;
import pacote.Endereco;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alexandre
 */
public class EnderecoDao {
    private Connection connection = null;
    
    public EnderecoDao(){
        this.connection = ConnectionFactory.getConnection();
    }
    
    public void adiciona(Endereco endereco){
        
        PreparedStatement stmt = null;
        String sql = "insert into endereco " +
            "(rua,numero,complemento,cep,bairro,idCidade)" +
            " values (?,?,?,?,?,?)";
        
        try {
        // prepared statement para inserção
        stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        // seta os valores

        stmt.setString(1,endereco.getRua());
        stmt.setInt(2,endereco.getNumero());
        stmt.setString(3,endereco.getComplemento());
        stmt.setString(4,endereco.getCep());
        stmt.setString(5,endereco.getBairro());
        stmt.setLong(6,endereco.getCidade().getIdCidade());
        
        // executa
        stmt.execute();
        
        ResultSet rs = stmt.getGeneratedKeys(); // pega o Id gerado
        rs.next();
        long i = rs.getLong(1);
        endereco.setIdEndereco(i);
        
        
        
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
                try{stmt.close();}catch (Exception ex){};
        } 
    }
    
    public void alterarEndereco(Endereco velho, Endereco novo){
        
    }

    public Endereco getEndereco(long id) {
        PreparedStatement stmt = null;
        String sql = "select * from endereco where idEndereco=?";
        
        try {
        // prepared statement para inserção
        stmt = connection.prepareStatement(sql);

        // seta os valores

        stmt.setLong(1,id);
        
        
        // executa
        stmt.execute();
        
        ResultSet rs = stmt.executeQuery(); 
        if(rs.next()){
            Endereco endereco = new Endereco();
            CidadeDao cidadeDao = new CidadeDao();
            Cidade cidade = new Cidade();
            
            endereco.setBairro(rs.getString("bairro"));
            endereco.setCep(rs.getString("cep"));
            endereco.setComplemento(rs.getString("complemento"));
            
            //endereco.setIdCidade(rs.getLong("idCidade"));
            cidade = cidadeDao.getCidade(rs.getLong("idCidade"));
            endereco.setCidade(cidade);
            
            endereco.setIdEndereco(rs.getLong("idEndereco"));
            endereco.setNumero(rs.getInt("numero"));
            endereco.setRua(rs.getString("rua"));
            return endereco;
        }
        return null;
        
        
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
                try{stmt.close();}catch (Exception ex){};
        }
    }
}

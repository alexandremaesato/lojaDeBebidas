package Dao;



import Dao.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
public class CarrinhoDao {
    private Connection connection = null;
    PreparedStatement stmt = null;
    
    public CarrinhoDao(){
    this.connection = ConnectionFactory.getConnection();
    }
    
    public void novoCarrinho(Cliente cliente){
        //String sql = "insert into carrinho (idCliente) values(?)";
        String sql = "INSERT INTO  carrinho (idCliente, dataPedido) VALUES (?,?)";
        
        try {
        // prepared statement para inserção
        stmt = connection.prepareStatement(sql);

        // seta os valores

        stmt.setLong(1,cliente.getIdCliente());
        stmt.setDate(2,new Date(System.currentTimeMillis()));
        
        // executa
        stmt.execute();
        
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }finally{
                try{stmt.close();}catch (Exception ex){};
            }
    }
}

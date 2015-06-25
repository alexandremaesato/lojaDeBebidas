/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import pacote.Carrinho;
import pacote.Endereco;
import pacote.Venda;

/**
 *
 * @author Alexandre
 */
public class VendaDao {
    private Connection connection = null;
    private PreparedStatement stmt = null;
    
    public VendaDao() {
        this.connection = ConnectionFactory.getConnection();
    }
    
    public void novaVenda(Venda venda) throws SQLException {
        String sql = "INSERT INTO  venda (idCarrinho, idEndereco, valor, pago, formaDePagamento, dataPagamento, enviado, dataEnvio) "
                + "VALUES (?,?,?,?,?,?,?,?)";
        try {
            // prepared statement para inserção
            stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setLong(1, venda.getIdCarrinho());
            stmt.setLong(2, venda.getIdEndereco());
            stmt.setFloat(3, venda.getValor());
            stmt.setFloat(4, 1);
            stmt.setString(5, venda.getFormaDePagamento());
            stmt.setDate(6, (Date) venda.getDataPagamento());
            stmt.setBoolean(7, false);
            stmt.setDate(8, (Date) venda.getDataEnvio());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
            
        } finally {
            try {
                stmt.close();
            } catch (Exception ex) { 
            };
        }
    }
    
}

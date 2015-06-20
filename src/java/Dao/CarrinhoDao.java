package Dao;

import Dao.ConnectionFactory;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pacote.Carrinho;
import pacote.Cliente;
import pacote.Endereco;
import pacote.Produto;

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
    private PreparedStatement stmt = null;

    public CarrinhoDao() {
        this.connection = ConnectionFactory.getConnection();
    }

    public void novoCarrinho(Cliente cliente) {
        //String sql = "insert into carrinho (idCliente) values(?)";
        String sql = "INSERT INTO  carrinho (idCliente, dataPedido,status) VALUES (?,?,'aberto')";

        try {
            // prepared statement para inserção
            stmt = connection.prepareStatement(sql);

        // seta os valores
            stmt.setLong(1, cliente.getIdCliente());
            stmt.setDate(2, new Date(System.currentTimeMillis()));

            // executa
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

    public Carrinho getCarrinho(Cliente cliente) {

        String sql = "select * from carrinho where idCliente=?";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setLong(1, cliente.getIdCliente());
            stmt.execute();

            ResultSet rs = stmt.getResultSet();

            if (rs.next()) {
                Carrinho carrinho = new Carrinho();
                carrinho.setIdCarrinho(rs.getLong("idCarrinho"));
                return carrinho;
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                stmt.close();
            } catch (Exception ex) {
            };
        }

    }

    public void deletarItemCarrinho(long idCarrinho, long idProduto) {
        String sql = "delete from produtoscarrinho where idCarrinho=? and idProduto=?";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setLong(1, idCarrinho);
            stmt.setLong(2, idProduto);
            stmt.execute();

            ResultSet rs = stmt.getResultSet();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                stmt.close();
            } catch (Exception ex) {
            };
        }
    }

    public void alterarItemCarrinho(long idCarrinho, long idProduto, int quantidade) {
        String sql = "update produtoscarrinho set quantidade=? where idCarrinho=? and idProduto=?";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, quantidade);
            stmt.setLong(2, idCarrinho);
            stmt.setLong(3, idProduto);
            stmt.execute();

            ResultSet rs = stmt.getResultSet();

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

package Dao;

import Dao.ConnectionFactory;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pacote.Carrinho;
import pacote.Categoria;
import pacote.Cliente;
import pacote.Endereco;
import pacote.Produto;
import pacote.ProdutosCarrinho;

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
                carrinho.setProdutosCarrinho(getProdutosCarrinho(carrinho));
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
    
    public List<ProdutosCarrinho> getProdutosCarrinho(Carrinho carrinho) throws SQLException {
        String sql = "select produtoscarrinho.idProdutoscarrinho as idProdutocarrinhoPC,\n" +
"produtoscarrinho.idproduto as idprodutoPC,\n" +
"produtoscarrinho.idCarrinho as idCarrinhoPC,\n" +
"produtoscarrinho.quantidade as quantidadePC,\n" +
"produtoscarrinho.valor as valorPC,\n" +
"Produto.idProduto as idProdutoP,\n" +
"Produto.idCategoria as idCategoriaP,\n" +
"Produto.nome as nomeP,\n" +
"Produto.descricao as descricaoP,\n" +
"Produto.valor as valorP,\n" +
"Produto.quantidade as quantidadeP,\n" +
"Produto.status as statusP,\n" +
"Produto.imagem as imagemP\n" +
"from produto\n" +
"inner join produtoscarrinho on produtoscarrinho.idProduto = produto.idProduto where produtoscarrinho.idcarrinho=?";
        DaoCategoria categoriaDao = new DaoCategoria();
        List<Categoria> categorias = categoriaDao.buscaLista();
        List<Produto> produtos = new ArrayList();
        List<ProdutosCarrinho> listaProdutosCarrinho = new ArrayList();
        //colocar conexao de estoque
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setLong(1, carrinho.getIdCarrinho());
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                Produto produto = new Produto();
                ProdutosCarrinho produtosCarrinho = new ProdutosCarrinho();
                produto.setCategoria(categorias.get((int) rs.getLong("idCategoriaP")));
                produto.setDescricao(rs.getString("descricaoP"));
                //produto.setEstoque();
                produto.setIdProduto(rs.getInt("idProdutoP"));
                produto.setImagem(rs.getString("imagemP"));
                produto.setNome(rs.getString("nomeP"));
                produto.setQuantidade(rs.getInt("quantidadeP"));
                produto.setStatus(rs.getInt("statusP"));
                produto.setValor(rs.getFloat("valorP"));
                produtosCarrinho.setProduto(produto);
                produtosCarrinho.setIdCarrinho(rs.getLong("idCarrinhoPC"));
                produtosCarrinho.setIdProduto(rs.getLong("idProdutoPC"));
                produtosCarrinho.setIdProdutoCarrinho(rs.getLong("idProdutocarrinhoPC"));
                produtosCarrinho.setQuantidade(rs.getInt("quantidadePC"));
                produtosCarrinho.setValor(rs.getFloat("valorPC"));
                listaProdutosCarrinho.add(produtosCarrinho);
            }
            return listaProdutosCarrinho;
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

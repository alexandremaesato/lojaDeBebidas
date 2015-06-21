
import Dao.CarrinhoDao;
import Dao.ClienteDao;
import Dao.DaoProduto;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
public class Testar {
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException, SQLException{
        CarrinhoDao carrinhoDao = new CarrinhoDao();
        DaoProduto produtoDao = new DaoProduto();
        ClienteDao clienteDao = new ClienteDao();
        Cliente cliente = new Cliente();
        Carrinho carrinho = new Carrinho();
        List<Produto> produtos = new ArrayList();
        cliente = clienteDao.getCliente("ale");
        
        //cliente.setIdCliente(191);
        carrinho = carrinhoDao.getCarrinho(cliente);
        //carrinho.setIdCarrinho(cliente.getCarrinho().getIdCarrinho());
        produtos = carrinhoDao.getProdutosCarrinho(carrinho);
        carrinho = carrinhoDao.getCarrinho(cliente);
        //System.out.println(produtos.get(1).getNome());
        System.out.println(carrinho.getTotal());
        /*
        Cliente cliente = new Cliente();
        Endereco endereco = new Endereco();
        
        cliente.setNome("Alexandre");
        cliente.setCpf("03736593937");
        endereco.setCep("81330490");
        //endereco.setEndereco("Afranio Peixoto");
        endereco.setCidade(null);
        cliente.setEndereco(endereco);
        */
        //System.out.println(cliente.getNome()+" "+cliente.getCpf());
                
        
    }
    
}

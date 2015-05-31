package pacote;


import java.io.Serializable;
import java.util.Date;


import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alexandre
 */
public class Carrinho implements Serializable{
    private Date dataPedido;
    private long idCarrinho;
    private List<Produto> produtos;

    public Carrinho() {
    }

    public long getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(long idCarrinho) {
        this.idCarrinho = idCarrinho;
    }
    
    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    
    public void setProduto(Produto produto) {
        if (!this.produtos.contains(produto)){
            this.produtos.add(produto);
        }
        
    }
    
    
    
    
}

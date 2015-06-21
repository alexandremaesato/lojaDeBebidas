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
    private float total = 0;
    private int quantidade = 0;
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
        this.quantidade = produtos.size();
        for(int i=0; i < this.quantidade; i++){
            total = total + produtos.get(i).getValor();
        }
        
    }
    
    public void setProduto(Produto produto) {
        if (!this.produtos.contains(produto)){
            this.produtos.add(produto);
            this.total =total + produto.getValor();
            this.quantidade =quantidade + produto.getQuantidade();
        }
        
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
    
    
}

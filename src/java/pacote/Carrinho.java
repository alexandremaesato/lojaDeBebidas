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
    private List<ProdutosCarrinho> produtosCarrinho;
    //private List<Produto> produtos;

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

    public float getTotal() {
        this.total=0;
        for(int i = 0; i<this.produtosCarrinho.size(); i++){
            this.total = this.total + this.produtosCarrinho.get(i).getValor(); 
        }
        
        return this.total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getQuantidade() {
        return this.quantidade = this.produtosCarrinho.size();
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public List<ProdutosCarrinho> getProdutosCarrinho() {
        return produtosCarrinho;
    }

    public void setProdutosCarrinho(List<ProdutosCarrinho> produtosCarrinho) {
        this.produtosCarrinho = produtosCarrinho;
    }
    
    
    
    
    
    
}

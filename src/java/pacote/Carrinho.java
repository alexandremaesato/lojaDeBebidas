package pacote;


import java.io.Serializable;
import java.sql.Time;

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
    private int idCarrinho;
    private Time dataPedido;
    private List<Produto> produtos;

    public Carrinho() {
    }

    public Time getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Time dataPedido) {
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

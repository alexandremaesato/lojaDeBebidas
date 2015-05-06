/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacote;

import java.io.Serializable;

/**
 *
 * @author Alexandre
 */
public class Produto implements Serializable {
    private int idProduto;
    private String nome;
    private String descricao;
    private Float valor;
    private int quantidade;
    private int status;
    private Categoria categoria;
    private Estoque estoque;

    public Produto() {
    }

    public Produto(int idProduto) {
        //PRODUTO DAO, o produto com a ID
        this.idProduto = idProduto;
    }
    
    
    

    public Categoria getCategoria() {
   
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }
    
   
    
    
}

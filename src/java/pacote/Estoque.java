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
public class Estoque implements Serializable {
    private int idEstoque;
    private int quantidade;
    private int utilizados;
    private float valor;

    public Estoque() {
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getUtilizados() {
        return utilizados;
    }

    public void setUtilizados(int utilizados) {
        this.utilizados = utilizados;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
   
    
    
}

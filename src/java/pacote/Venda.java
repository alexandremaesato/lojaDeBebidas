/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacote;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Alexandre
 */
public class Venda implements Serializable {
    private long idVenda;
    private long idCarrinho;
    private long idEndereco;
    private Endereco endereco;
    private String formaDeEnvio;
    private float valor;
    private boolean pago;
    private String formaDePagamento;
    private Date dataPagamento;
    private boolean enviado;
    private Date dataEnvio;

    public Venda() {
    }

    public long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(long idVenda) {
        this.idVenda = idVenda;
    }

    public long getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(long idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(long idEndereco) {
        this.idEndereco = idEndereco;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getFormaDeEnvio() {
        return formaDeEnvio;
    }

    public void setFormaDeEnvio(String formaDeEnvio) {
        this.formaDeEnvio = formaDeEnvio;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public boolean isEnviado() {
        return enviado;
    }

    public void setEnviado(boolean enviado) {
        this.enviado = enviado;
    }

    public Date getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
    }
    
    
    
}

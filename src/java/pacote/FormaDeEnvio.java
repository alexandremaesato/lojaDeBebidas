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
public class FormaDeEnvio implements Serializable{
    private int idFormaDeEnvio;
    private String forma;

    public FormaDeEnvio() {
    }

    public int getIdFormaDeEnvio() {
        return idFormaDeEnvio;
    }

    public void setIdFormaDeEnvio(int idFormaDeEnvio) {
        this.idFormaDeEnvio = idFormaDeEnvio;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }
   
    
}

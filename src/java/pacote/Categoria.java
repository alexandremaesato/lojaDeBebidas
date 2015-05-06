/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacote;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Alexandre
 */
public class Categoria implements Serializable{
    private List<String> categorias;
    private int status;

    
    public String getCategoria(int i) {
        return categorias.get(i);
    }
    
    public List<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<String> categoria) {
        this.categorias = categoria;
    }
  
    public void setCategoria(String categoria) {
        if( !this.categorias.contains(categoria)) {
            this.categorias.add(categoria);
        }    
    }
    
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}

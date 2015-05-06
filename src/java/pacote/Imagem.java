/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacote;

import java.awt.Image;
import java.io.Serializable;

/**
 *
 * @author Alexandre
 */
public class Imagem implements Serializable {
    private Image foto;
    private Image miniatura;

    public Imagem() {
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public Image getMiniatura() {
        return miniatura;
    }

    public void setMiniatura(Image miniatura) {
        this.miniatura = miniatura;
    }
    
    
    
}

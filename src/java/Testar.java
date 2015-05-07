
import pacote.Cliente;
import pacote.Endereco;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alexandre
 */
public class Testar {
    public static void main(String[] args){
        
        Cliente cliente = new Cliente();
        Endereco endereco = new Endereco();
        
        cliente.setNome("Alexandre");
        cliente.setCpf("03736593937");
        endereco.setCep("81330490");
        endereco.setEndereco("Afranio Peixoto");
        endereco.setCidade(null);
        cliente.setEndereco(endereco);
        
        System.out.println(cliente.getNome()+" "+cliente.getCpf());
                
        
    }
    
}

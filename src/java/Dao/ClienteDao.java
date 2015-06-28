package Dao;


import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pacote.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alexandre
 */
public class ClienteDao {
    private Connection connection = null;
    PreparedStatement stmt = null;
    	ResultSet resultSet = null;

    public ClienteDao(){
        this.connection = ConnectionFactory.getConnection();
    }
    
    public void adiciona(Cliente cliente) {
    
        String sql = "insert into cliente " +
            "(nome,login,senha,cpf,sexo,status,telefone,celular,email,idEndereco,dataNascimento)" +
            " values (?,?,?,?,?,?,?,?,?,?,?)";
        
    try {
        // prepared statement para inserção
        stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        // seta os valores

        stmt.setString(1,cliente.getNome());
        stmt.setString(2,cliente.getLogin());
        stmt.setString(3,cliente.getSenha());
        stmt.setString(4,cliente.getCpf());
        stmt.setString(5,cliente.getSexo());
        stmt.setBoolean(6,cliente.getStatus());
        stmt.setString(7,cliente.getTelefone());
        stmt.setString(8,cliente.getCelular());
        stmt.setString(9,cliente.getEmail());
        stmt.setLong(10,cliente.getEndereco().getIdEndereco());
        stmt.setDate(11, new Date(cliente.getDataNascimento().getTime()));
        
        
        // executa
        stmt.execute();
        
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }finally{
                try{stmt.close();}catch (Exception ex){};
            }
    }
    
    public boolean verificaCpf(Cliente cliente){
        
        String sql = "select * from cliente where cpf=?";
        
        try{
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, cliente.getCpf());
            stmt.execute();
            
            ResultSet rs = stmt.getResultSet();
            
            if(rs.next()){
                return true;
            } 
            return false;
        
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
                try{stmt.close();}catch (Exception ex){};
        }
    }
    
    
    public Cliente getCliente(String login) throws NoSuchAlgorithmException, UnsupportedEncodingException{
         String sql = "select * from cliente where login=?";
        
        try{
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.execute();
            
            ResultSet rs = stmt.getResultSet();
            
            if(rs.next()){
                Cliente cliente = new Cliente();
                EnderecoDao enderecoDao = new EnderecoDao();
                Endereco endereco = new Endereco();
                cliente.setIdCliente(rs.getLong("idCliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setLogin(rs.getString("login"));
                cliente.setCelular(rs.getString("Celular"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setDataNascimento(rs.getDate("dataNascimento"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSenha(rs.getString("senha"));
                cliente.setSexo(rs.getString("sexo"));
                cliente.setStatus(rs.getBoolean("status"));
                cliente.setTelefone(rs.getString("telefone"));
                endereco = enderecoDao.getEndereco(rs.getLong("idEndereco"));
                cliente.setEndereco(endereco);
                
                
                return cliente;
            } 
            return null;
        
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
                try{stmt.close();}catch (Exception ex){};
        }   
        }
    
    public Boolean verificaCliente(String login, String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException{
         String sql = "select * from cliente where login=? and senha=?";
        
        try{
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setString(2, senha);
            stmt.execute();
            
            ResultSet rs = stmt.getResultSet();
            
            if(rs.next()){
                return true;
            } 
            return false;
        
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
                try{stmt.close();}catch (Exception ex){};
        }   
        }
    
    public boolean verificaLogin(Cliente cliente){
        
        String sql = "select * from cliente where login=?";
        
        try{
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, cliente.getCpf());
            stmt.execute();
            
            ResultSet rs = stmt.getResultSet();
            
            if(rs.next()){
                return true;
            } 
            return false;
        
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
                try{stmt.close();}catch (Exception ex){};
        }
    }
    public List<Cliente> busca(String s,String tipo) throws SQLException {
        String query;
        if(tipo.equals("cpf"))
             query = "SELECT * FROM cliente where cpf="+ s;
        else//palavra
             query = "SELECT * FROM cliente WHERE nome LIKE '%"+s+"%' OR email LIKE '%"+s+"%' or login LIKE '%"+s+"%'";
        List<Cliente> lista = new ArrayList<>();
            try {
                connection = ConnectionFactory.getConnection();
                stmt = connection.prepareStatement(query);
                resultSet= stmt.executeQuery();
                
                while(resultSet.next()){  //idCliente,idEndereco,login, senha, nome, cpf,dataNascimento, Sexo,email, telefone, celular,status
                    Cliente f = new Cliente();
                    f.setLogin(resultSet.getString("login"));
                   // f.setSenha(resultSet.getString("senha"));
                    f.setNome(resultSet.getString("nome"));
                    f.setCpf(resultSet.getString("cpf"));
                     f.setIdCliente(resultSet.getInt("idCliente"));
                   // f.setCpf(resultSet.getString("dataNascimento"));
                   // f.setSexo(resultSet.getString("sexo"));
                    f.setEmail(resultSet.getString("email"));
                   // f.setEmail(resultSet.getString("telefone"));
                   // f.setEmail(resultSet.getString("celular"));
                   // f.setEmail(resultSet.getString("status"));

                    lista.add(f);  
                }  
            }finally {       
            }
                return lista;  
            
        } 
    public List<Datalog> buscadatalog(Cliente s) throws SQLException {
        String query = "SELECT * FROM Datalog where idCliente=?";

        List<Datalog> lista = new ArrayList<>();
        try {
            connection = ConnectionFactory.getConnection();
            stmt = connection.prepareStatement(query);
            stmt.setLong(1, s.getIdCliente());
            resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                Datalog f = new Datalog();
                f.setDatalogin(resultSet.getTimestamp("dataLogin"));
                f.setDatalogout(resultSet.getTimestamp("dataLogout"));
                lista.add(f);
            }
        } finally {
        }
        return lista;

    }
     public List<ProdutosCarrinho> buscaCompras(Cliente s) throws SQLException {
        String query = "select p.nome, p.valor, pc.quantidade, v.idvenda from carrinho c, produto p, venda v, produtoscarrinho "
                + "pc where c.idcarrinho=pc.idcarrinho and p.idproduto=pc.idproduto and v.idcarrinho=c.idcarrinho and "
                + "v.pago=1 and c.idCliente=?";

        List<ProdutosCarrinho> lista = new ArrayList<>();
        try {
            connection = ConnectionFactory.getConnection();
            stmt = connection.prepareStatement(query);
            stmt.setLong(1, s.getIdCliente());
            resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                ProdutosCarrinho f = new ProdutosCarrinho();
                f.setIdvenda(resultSet.getInt("idvenda"));
                f.setNome(resultSet.getString("nome"));
                f.setQuantidade(resultSet.getInt("quantidade"));
                f.setValor(resultSet.getFloat("valor"));
                lista.add(f);
            }
        } finally {
        }
        return lista;

    }
 
}

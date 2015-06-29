/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pacote.Categoria;
import pacote.Produto;

/**
 *
 * @author hednisk
 */
public class DaoCategoria {

    private Connection con = null;
    private Statement comando;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;

    public void add(Categoria c) {
        try {
            String query = "INSERT INTO categoria(nome, status) VALUES(?,?)";
            con = ConnectionFactory.getConnection();
            ptmt = con.prepareStatement(query);
            ptmt.setString(1, c.getNome());
            ptmt.setInt(2, c.getStatus());

            ptmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ptmt != null) {
                    ptmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //pega lista categorias

    public List<Categoria> buscaLista() throws SQLException {
        String query = "select * from categoria";
        List<Categoria> lista = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            ptmt = con.prepareStatement(query);
            resultSet = ptmt.executeQuery();

            while (resultSet.next()) {
                Categoria c = new Categoria();
                c.setIdCategoria(resultSet.getInt("idcategoria"));
                c.setNome(resultSet.getString("nome"));
                lista.add(c);
            }
        } finally {
            ptmt.close();

        }
        return lista;

    }

    public Categoria getCategoria(int id) throws SQLException {
        String query = "SELECT * FROM Categoria WHERE idCategoria=?";

        try {
            con = ConnectionFactory.getConnection();
            ptmt = con.prepareStatement(query);
            ptmt.setInt(1, id);
            resultSet = ptmt.executeQuery();

            if (resultSet.next()) {
                Categoria c = new Categoria();
                c.setIdCategoria(resultSet.getInt("idcategoria"));
                c.setNome(resultSet.getString("nome"));
                c.setStatus(resultSet.getInt("status"));
                return c;
            } else {
                return null;
            }
        } finally {
            ptmt.close();
        }

    }

}

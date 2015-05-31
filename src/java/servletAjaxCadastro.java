/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.*;
import pacote.*;

/**
 *
 * @author Alexandre
 */
@WebServlet(urlPatterns = {"/servletAjaxCadastro"})
public class servletAjaxCadastro extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("acao");
        
       
        if("cpf".equals(action)){
        try (PrintWriter out = response.getWriter()) {
            //out.println(action);
            ClienteDao clienteDao = new ClienteDao();
            /* TODO output your page here. You may use following sample code. */
            
            String cpf = request.getParameter("cpf");
            Cliente cliente = new Cliente();
            cliente.setCpf(cpf);
            String json;
            if(clienteDao.verificaCpf(cliente)){
                json = new Gson().toJson("CPF ja cadastrado!");
            }else{
                json = new Gson().toJson("Ok");
            }
            
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
            }
        }    
        if("login".equals(action)){
            try (PrintWriter out = response.getWriter()) {
            ClienteDao clienteDao = new ClienteDao();
            
            String login = request.getParameter("login");
            Cliente cliente = new Cliente();
            cliente.setCpf(login);
            String json;
            if(clienteDao.verificaLogin(cliente)){
                json = new Gson().toJson("Login ja cadastrado!");
            }else{
                json = new Gson().toJson("Ok");
            }
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
            }
            
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

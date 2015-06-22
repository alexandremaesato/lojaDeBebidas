/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Dao.CarrinhoDao;
import Dao.ClienteDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static javax.xml.bind.DatatypeConverter.parseInt;
import static javax.xml.bind.DatatypeConverter.parseLong;
import pacote.Carrinho;
import pacote.Cliente;

/**
 *
 * @author Alexandre
 */
@WebServlet(urlPatterns = {"/servletCarrinho"})
public class servletCarrinho extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            CarrinhoDao carrinhoDao = new CarrinhoDao();
            ClienteDao clienteDao = new ClienteDao();
            Carrinho carrinho = new Carrinho();
            HttpSession sessao = request.getSession();
            carrinho = (Carrinho) sessao.getAttribute("carrinho");
            
            if("alterar".equals(action)){
                out.println("id: "+request.getParameter("id"));
                out.println("quantidade: "+request.getParameter("quantidade"));
                out.println("alert('teste')");
                out.println("idCarrinho: "+carrinho.getIdCarrinho());
                int idQuantidade = parseInt(request.getParameter("id"));
                int quantidade = parseInt(request.getParameter("quantidade"));
                //carrinho = (Carrinho) request.getAttribute("carrinho");
                
                try{   
                carrinhoDao.alterarItemCarrinho(carrinho.getIdCarrinho(), carrinho.getProdutosCarrinho().get(idQuantidade).getIdProduto(), quantidade);    
                //carrinhoDao.alterarItemCarrinho(carrinho.getIdCarrinho(), carrinho.getProdutos().get(idQuantidade).getIdProduto(), quantidade);
                
                sessao.setAttribute("carrinho", carrinhoDao.getCarrinho((Cliente) sessao.getAttribute("cliente")));
                RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                rd.forward(request, response);
                
                }catch (Exception e) {
                    out.println(e);
                }    
            }
            if ("delete".equals(action)) {
                out.println("1");
                long idProduto = parseLong(request.getParameter("idProduto"));
                long idCarrinho = parseLong(request.getParameter("idCarrinho"));
                //CarrinhoDao carrinhoDao = new CarrinhoDao();
                carrinhoDao.deletarItemCarrinho(idCarrinho, idProduto);
                sessao.setAttribute("carrinho", carrinhoDao.getCarrinho((Cliente) sessao.getAttribute("cliente")));
                out.println("2");
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

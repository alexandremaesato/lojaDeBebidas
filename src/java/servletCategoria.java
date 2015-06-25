/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Dao.DaoCategoria;
import Dao.DaoProduto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pacote.Categoria;
import pacote.Produto;

/**
 *
 * @author Ina
 */
@WebServlet(urlPatterns = {"/servletCategoria"})
public class servletCategoria extends HttpServlet {

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
        
        String action = request.getParameter("action");

        if ("listacat".equals(action)){
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
               DaoCategoria catd = new DaoCategoria();
               Categoria c=new Categoria();
                try {
                    request.setAttribute("lista", catd.buscaLista());
                       // c=catd.buscaLista().get(0);
                } catch (SQLException ex) {
                    Logger.getLogger(servletLogar.class.getName()).log(Level.SEVERE, null, ex);

                }           
                 HttpSession session = request.getSession();
                session.setAttribute("redir", "cadastroprod");
                //out.println(c.getNome());
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
              //  <c:set var="redir" value="cadastroprod" scope="session" />  
                rd.forward(request, response);  

            }
        }
        if ("cadastracat".equals(action)){
            try (PrintWriter out = response.getWriter()) {
                Categoria c = new Categoria();
                c.setNome(request.getParameter("categoria"));
                c.setStatus(1);
                out.println("passou");
            //tratar acentuacao
                // FAZER Conexao DAO passando cat
                DaoCategoria daoc = new DaoCategoria();
                daoc.add(c);

                //if(inseriu de boa){
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
                rd.forward(request, response);
            }
        }
        if ("buscamenuleft".equals(action)){
            try (PrintWriter out = response.getWriter()) {
            List<Produto> produtos = new ArrayList();
            DaoProduto dp = new DaoProduto();
           // DaoCategoria catd = new DaoCategoria();
            Categoria c = new Categoria();
            String id = request.getParameter("id");
            String ordem = request.getParameter("ordem");
            produtos = dp.busca(id, ordem);
            request.setAttribute("produtos", produtos );
           // request.setAttribute("lista", catd.buscaLista());

            out.println(request.getParameter("id"));
          //  out.print(request.getParameter("ordem"));
            
            HttpSession session = request.getSession();
            session.setAttribute("redir", "produtos");
            session.setAttribute("produtos", produtos );
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
 
            } catch (SQLException ex) {
                Logger.getLogger(servletCategoria.class.getName()).log(Level.SEVERE, null, ex);
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

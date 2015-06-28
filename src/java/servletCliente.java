/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Dao.ClienteDao;
import Dao.DaoCliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import javax.ws.rs.client.Client;
import pacote.Cliente;
import pacote.Datalog;
import pacote.ProdutosCarrinho;

/**
 *
 * @author Ina
 */
@WebServlet(urlPatterns = {"/servletCliente"})
public class servletCliente extends HttpServlet {

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

          PrintWriter out = response.getWriter();

            if ("pesquisa".equals(action)){
                List<Cliente> lista = new ArrayList<>();
                ClienteDao dc=new ClienteDao();
                String key=request.getParameter("cpf");
                if(key!=null && !key.isEmpty()){// key!=null && !key.isEmpty()
                    try {
                    //VAI PROCURAR SE TIVER NO CAMPO CPF, SENAO, SE TIVER NO PALAVRA
                    lista=dc.busca(request.getParameter("cpf"),"cpf");
                    } catch (SQLException ex) {
                        Logger.getLogger(servletFuncionario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else{
                    try {
                        lista=dc.busca(request.getParameter("palavra"),"palavra");
                    } catch (SQLException ex) {
                        Logger.getLogger(servletFuncionario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                 HttpSession session = request.getSession();
                session.setAttribute("listacli",lista );
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
                rd.forward(request, response);  
                //out.println(lista.get(0).getIdCliente());

            }
            if ("acoes".equals(action)){
               // List<Datalog> lista = new ArrayList<>();
                List<Datalog> lista = new ArrayList<>();
                ClienteDao dc=new ClienteDao();
                Cliente c=new Cliente();
                c.setIdCliente(Integer.valueOf(request.getParameter("t")));
                //out.print(request.getParameter("t"));
                
                    try {
                        lista=dc.buscadatalog(c);
                    } catch (SQLException ex) {
                        Logger.getLogger(servletCliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                 HttpSession session = request.getSession();
                session.setAttribute("listadatalog",lista );
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
                rd.forward(request, response);  
                //if(lista!=null)
               // dc.adiciona(c);                
               // out.println(df.format(lista.get(0).getDatalogin()));
            }
            if ("compras".equals(action)){
                List<ProdutosCarrinho> lista = new ArrayList<>();
                ClienteDao dc=new ClienteDao();
                Cliente c=new Cliente();
               //out.println(request.getParameter("t"));
                
            try {
                c = dc.getCliente((String)request.getParameter("login"));
                 
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(servletCliente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(servletCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            out.println(c);
            
                //c.setIdCliente(Integer.valueOf(request.getParameter("t")));
                //out.print(request.getParameter("t"));
                    try {
                        lista=dc.buscaCompras(c);
                        out.print(lista);
                    } catch (SQLException ex) {
                        Logger.getLogger(servletCliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if(!lista.isEmpty())
                    out.print(lista.get(0).getNome());
                    
                 HttpSession session = request.getSession();
                session.setAttribute("listacompras",lista );
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
                rd.forward(request, response);  
                
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

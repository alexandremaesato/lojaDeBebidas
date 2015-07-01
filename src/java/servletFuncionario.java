/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Dao.FuncionarioDao;
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
import pacote.Funcionario;

/**
 *
 * @author Ina
 */
@WebServlet(urlPatterns = {"/servletFuncionario"})
public class servletFuncionario extends HttpServlet {

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
                List<Funcionario> lista = new ArrayList<>();
                FuncionarioDao df=new FuncionarioDao();
                String key=request.getParameter("cpf");
                if(key!=null && !key.isEmpty()){// key!=null && !key.isEmpty()
                    try {
                    //VAI PROCURAR SE TIVER NO CAMPO CPF, SENAO, SE TIVER NO PALAVRA
                    lista=df.busca(request.getParameter("cpf"),"cpf");
                    } catch (SQLException ex) {
                        Logger.getLogger(servletFuncionario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else{
                    try {
                        lista=df.busca(request.getParameter("palavra"),"palavra");
                    } catch (SQLException ex) {
                        Logger.getLogger(servletFuncionario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                 HttpSession session = request.getSession();
                session.setAttribute("listafunc",lista );
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
                rd.forward(request, response);  
                //out.println(lista.get(1).getNome());

            }
        
            if ("cadastra".equals(action)){
                FuncionarioDao df=new FuncionarioDao();
                Funcionario f= new Funcionario();
                f.setNome(request.getParameter("nome1")); //nome, tipo, login, senha, cpf, email, sexo
                f.setTipo(Integer.valueOf(String.valueOf(request.getParameter("tipo1"))));
                f.setLogin(request.getParameter("login1"));
                f.setSenha(request.getParameter("senha1"));
                f.setCpf(request.getParameter("cpf1"));
                f.setEmail(request.getParameter("email1"));
                f.setSexo(request.getParameter("sexo1"));
                df.add(f);    
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
                rd.forward(request, response);  
            }
            
            if ("remove".equals(action)){
                FuncionarioDao df=new FuncionarioDao();
                Funcionario f= new Funcionario();
                f.setCpf(request.getParameter("cpf"));
                df.remove(f);
                HttpSession session = request.getSession();
                session.setAttribute("listafunc",null );
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

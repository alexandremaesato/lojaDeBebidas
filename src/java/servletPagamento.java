/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Dao.ClienteDao;
import Dao.VendaDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static javax.xml.bind.DatatypeConverter.parseFloat;
import static javax.xml.bind.DatatypeConverter.parseInt;
import static javax.xml.bind.DatatypeConverter.parseLong;
import pacote.Cidade;
import pacote.Cliente;
import pacote.Endereco;
import pacote.Venda;

/**
 *
 * @author Alexandre
 */
@WebServlet(urlPatterns = {"/servletPagamento"})
public class servletPagamento extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        Cliente cliente;
        ClienteDao clienteDao = new ClienteDao();
        
        String action = request.getParameter("action");
        String idEndereco = request.getParameter("idEndereco");
        String check = request.getParameter("checar");
        HttpSession session = request.getSession();
        cliente = (Cliente) session.getAttribute("cliente");

        try (PrintWriter out = response.getWriter()) {
            try {
                if ("pagar".equals(action)) {
                    VendaDao vendaDao = new VendaDao();
                    EnderecoDao enderecoDao = new EnderecoDao();
                    Venda venda = new Venda();
                    Endereco endereco = new Endereco();

                    if ("teste".equals(check)) {
                        CidadeDao cidadeDao = new CidadeDao();
                        endereco.setBairro(request.getParameter("bairro"));
                        endereco.setCep(request.getParameter("cep"));
                        endereco.setCidade(cidadeDao.getCidade(request.getParameter("Cidade")));
                        endereco.setComplemento(request.getParameter("idEndereco"));
                        endereco.setNumero(parseInt(request.getParameter("numero")));
                        endereco.setRua(request.getParameter("rua"));
                    } else {
                        endereco = cliente.getEndereco();
                    }
                    venda.setEndereco(endereco);
                    venda.setDataEnvio(new java.sql.Date(System.currentTimeMillis()));
                    venda.setEnviado(false);
                    venda.setFormaDeEnvio(request.getParameter("formaDeEnvio"));
                    venda.setFormaDePagamento(request.getParameter("forma"));
                    venda.setDataPagamento(new java.sql.Date(System.currentTimeMillis()));
                    venda.setIdCarrinho(cliente.getCarrinho().getIdCarrinho());
                    venda.setIdEndereco(endereco.getIdEndereco());
                    venda.setPago(true);
                    venda.setValor(cliente.getCarrinho().getTotal());
                    
                    vendaDao.novaVenda(venda);
                    processaMensagem(request, response, "Pagamento efetuado com sucesso!</br>Logo estaremos enviando.");

                }
            } catch (Exception e) {
                processaMensagem(request, response, "Deu erro: " + e);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(servletPagamento.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(servletPagamento.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public void processaMensagem(HttpServletRequest request, HttpServletResponse response, String mensagem) {
        try {
            request.setAttribute("mensagem", mensagem);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensagem.jsp");

            rd.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(servletLogar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(servletLogar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

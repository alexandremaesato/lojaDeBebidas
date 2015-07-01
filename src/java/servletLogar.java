/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Dao.DataLogDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
import static javax.xml.bind.DatatypeConverter.parseInt;

import pacote.*;
import Dao.*;
import static javax.xml.bind.DatatypeConverter.parseInt;

/**
 *
 * @author Alexandre
 */
@WebServlet(urlPatterns = {"/servletLogar"})
public class servletLogar extends HttpServlet {

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
            throws ServletException, IOException, NoSuchAlgorithmException, SQLException {
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        Cliente cliente = new Cliente();

        if ("logar".equals(action)) {
            try (PrintWriter out = response.getWriter()) {
                out.println("1");
                //Antes fazer conexao DAO e verificar login e senha
                CidadeDao cidadeDao = new CidadeDao();
                ClienteDao clienteDao = new ClienteDao();
                Dao.CarrinhoDao carrinhoDao = new Dao.CarrinhoDao();
                
                Cliente clienteLogin = new Cliente();

                String login = request.getParameter("login");
                clienteLogin.setSenha(request.getParameter("senha"));
                cliente = clienteDao.getCliente(login);
                
                if(cliente!=null){
                    cliente.setCarrinho(carrinhoDao.getCarrinho(cliente));
                }

                FuncionarioDao fd=new FuncionarioDao();
                Funcionario funcLogin=new Funcionario();
                funcLogin.setSenha(request.getParameter("senha"));
                 Funcionario func=new Funcionario();
                func = fd.getFunc(login);
                
                if (clienteDao.verificaCliente(login, clienteLogin.getSenha())) {
                    //Adiciona no LOG 
                    try {
                        DataLogDao datalogDao = new DataLogDao();
                        datalogDao.adiciona(cliente);

                        //Coloca o Cliente na Sessao
                        session.setAttribute("cliente", cliente);
                        session.setMaxInactiveInterval(-1);

                        //Coloca o Carrinho na Sessao
                        session.setAttribute("carrinho", carrinhoDao.getCarrinho(cliente));

                        //session.setAttribute("nome", login);
                        session.setAttribute("tipo", 1);// linha de teste

                        session.setAttribute("cidades", cidadeDao.getCidades());
                        RequestDispatcher rd = request.getRequestDispatcher("servletProduto?action=carregarProdutos");
                        rd.forward(request,response);
                        out.flush();
                    } catch (Exception e) {
                        out.println(e);
                    }
                }
                    else if (fd.verificaFunc(login, funcLogin.getSenha())) {
                    //Adiciona no LOG 
                    try {
                        session.setAttribute("funcio", func);
                        cliente = null;
                        //Coloca o Carrinho na Sessao
                       // session.setAttribute("carrinho", carrinhoDao.getCarrinho(cliente));

                        //session.setAttribute("nome", login);
                        session.setAttribute("tipo", func.getTipo());// linha de teste
                        session.setAttribute("cliente", cliente);
                       // session.setAttribute("cidades", cidadeDao.getCidades());
                        RequestDispatcher rd = request.getRequestDispatcher("servletProduto?action=pagina");
            rd.forward(request,response);
                        out.flush();
                    } catch (Exception e) {
                        out.println(e);
                    }
                            
                            

                } else {

                    processaErro(request, response, "Não foi possivel logar!</br>Erro de Login ou Senha.");
                }
                /*
                 out.println("passou 74");
                 request.setAttribute("mensagem", "Não foi possivel logar!</br>Erro de Login ou Senha.");
                 RequestDispatcher rd = request.getRequestDispatcher("/erro.jsp");
                 rd.forward(request,response);
                 */

            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(servletLogar.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(servletLogar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if ("cadastrar".equals(action)) {
            PrintWriter out = response.getWriter();
            out.println("foi");
            CidadeDao cidadeDao = new CidadeDao();
            try {
                request.setAttribute("cidades", cidadeDao.getNomeCidades());
            } catch (SQLException ex) {
                Logger.getLogger(servletLogar.class.getName()).log(Level.SEVERE, null, ex);

            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/cadastrar.jsp");
            rd.forward(request, response);
        }

        if ("deslogar".equals(action)) {

            ClienteDao clienteDao = new ClienteDao();
            
            cliente = clienteDao.getCliente(request.getParameter("login"));
            session = request.getSession();
            DataLogDao datalogDao = new DataLogDao();
            
            datalogDao.setLogout(cliente);
            session.invalidate();
            session = null;
            cliente = null;
            request.setAttribute("redir", "produtos");
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }
         if ("deslogarF".equals(action)) {

           FuncionarioDao fDao = new FuncionarioDao();
            Funcionario f = new Funcionario();
            f = fDao.getFunc(request.getParameter("login"));
            session = request.getSession();
            //cliente = null;
            session.invalidate();
            request.setAttribute("redir", "produtos");
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }

        if ("gravar".equals(action)) {
            try (PrintWriter out = response.getWriter()) {

                
                CidadeDao cidadeDao = new CidadeDao();
                Cidade cidade = new Cidade();
                Dao.CarrinhoDao carrinhoDao = new Dao.CarrinhoDao();

                Endereco endereco = new Endereco();
                EnderecoDao enderecoDao = new EnderecoDao();

                cliente.setNome(request.getParameter("nome"));
                cliente.setLogin(request.getParameter("login"));
                cliente.setSenha(request.getParameter("senha"));
                cliente.setCpf(request.getParameter("cpf"));
                cliente.setEmail(request.getParameter("email"));
                cliente.setTelefone(request.getParameter("telefone"));
                cliente.setCelular(request.getParameter("celular"));
                cliente.setSexo(request.getParameter("sexo"));

                String dataTexto = request.getParameter("data");
                out.println(dataTexto);
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy"); //arrumar data
                Date data = format.parse(dataTexto);

                cliente.setDataNascimento(data);
                cliente.setStatus(true);
                endereco.setCep(request.getParameter("cep"));
                cidade = cidadeDao.getCidade(request.getParameter("cidade"));

                endereco.setCidade(cidade);
                endereco.setComplemento(request.getParameter("complemento"));
                endereco.setNumero(parseInt(request.getParameter("numero")));
                endereco.setRua(request.getParameter("rua"));
                endereco.setBairro(request.getParameter("bairro"));

                enderecoDao.adiciona(endereco);
                cliente.setEndereco(endereco);

                // FAZER Conexao DAO passando cliente
                ClienteDao clienteDao = new ClienteDao();

                if (!clienteDao.verificaCpf(cliente)) {
                    clienteDao.adiciona(cliente);
                    // Criando carrinho para o cliente
                    carrinhoDao.novoCarrinho(clienteDao.getCliente(cliente.getLogin()));
                    request.setAttribute("action", "logar");
                    RequestDispatcher rd = request.getRequestDispatcher("/servletLogar?action=logar");
                    rd.forward(request, response);
                }

            } catch (Exception e) {
                System.out.println(e);
            }

        }
        
            
        }

    public void processaErro(HttpServletRequest request, HttpServletResponse response, String erro) {
        try {
            request.setAttribute("mensagem", erro);
            //RequestDispatcher rd = request.getRequestDispatcher("erro.jsp");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");

            rd.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(servletLogar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(servletLogar.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(servletLogar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(servletLogar.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(servletLogar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(servletLogar.class.getName()).log(Level.SEVERE, null, ex);
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

}

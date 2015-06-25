/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Dao.DaoCategoria;
import Dao.DaoImagem;
import Dao.DaoProduto;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import static java.lang.Float.parseFloat;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import pacote.Categoria;
import pacote.Imagem;
import pacote.Produto;

/**
 *
 * @author Ina
 */
@MultipartConfig
@WebServlet(urlPatterns = {"/servletProduto"})
public class servletProduto extends HttpServlet {

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

        if ("pagina".equals(action)) {
            /* TODO output your page here. You may use following sample code. */
            DaoCategoria catd = new DaoCategoria();
            Categoria c = new Categoria();
            try {
                request.setAttribute("lista", catd.buscaLista());//lista categorias
                // c=catd.buscaLista().get(0);
            } catch (SQLException ex) {
                Logger.getLogger(servletLogar.class.getName()).log(Level.SEVERE, null, ex);

            }
            HttpSession session = request.getSession();
            session.setAttribute("redir", "produtos");
            //out.println(c.getNome());
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            //  <c:set var="redir" value="cadastroprod" scope="session" />  
            rd.forward(request, response);
        }

        if ("listaprod".equals(action)) {
            try (PrintWriter out = response.getWriter()) {

                DaoProduto dp = new DaoProduto();
           // dp.busca(request.getParameter("cat"), request.getParameter("ordem"));
                // DaoCategoria catd = new DaoCategoria();
                Categoria c = new Categoria();
                
                request.setAttribute("produtos", dp.busca(request.getParameter("cat"), request.getParameter("ordem")));
                
            //  request.setAttribute("lista", catd.buscaLista());
                out.println(request.getParameter("cat"));
                out.print(request.getParameter("ordem"));
                HttpSession session = request.getSession();
                session.setAttribute("redir", "produtos");
                session.setAttribute("produtos", dp.busca(request.getParameter("cat"), request.getParameter("ordem")));
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
                //  <c:set var="redir" value="cadastroprod" scope="session" />  
                rd.forward(request, response);

            } catch (SQLException ex) {
                Logger.getLogger(servletProduto.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if ("cadastrap".equals(action)) {
            try (PrintWriter out = response.getWriter()) {

                Produto p = new Produto();
                Categoria c = new Categoria();
                int id = Integer.valueOf(request.getParameter("cat"));

                float valor;
                c.setIdCategoria(id);
                c.setStatus(1);
                //c.setNome(request.getParameter("cat"));VERRRRRRRRRRRRRRRRRRRRRRRRRR
                p.setNome((String) request.getParameter("produto"));
                p.setCategoria(c);
                p.setDescricao((String) request.getParameter("descr"));

                valor = parseFloat(request.getParameter("valor"));

                p.setValor(valor);

                p.setQuantidade(Integer.valueOf(request.getParameter("qtd")));
                p.setStatus(1);

                //--------------------UPLOAD IMAGEM----------------------
                final String path = request.getParameter("destino");
                final Part filePart = request.getPart("arq");
                final String fileName = getFileName(filePart);

                OutputStream outp = null;
                InputStream filecontent = null;
                final PrintWriter writer = response.getWriter();

                try {
                    outp = new FileOutputStream(new File(path + File.separator
                            + fileName));
                    filecontent = filePart.getInputStream();

                    int read = 0;
                    final byte[] bytes = new byte[1024];

                    while ((read = filecontent.read(bytes)) != -1) {
                        outp.write(bytes, 0, read);
                    }
                    // String s=path+"\\"+fileName;
                    String s = "images/" + fileName;

                    p.setImagem(s);
                    out.println("idCategoria:" + p.getCategoria().getIdCategoria() + "</br>");
                    out.println("Nome:" + p.getNome() + "</br>");
                    out.println("Descricao:" + p.getDescricao());
                    out.println("Valor:" + p.getValor() + "</br>");
                    out.println("Quantidade:" + p.getQuantidade() + "</br>");
                    out.println("Status:" + p.getStatus() + "</br>");
                    out.println("Imagem:" + p.getImagem() + "</br>");

                    DaoProduto daoprod = new DaoProduto();
                    out.println("DAO:" + daoprod.add(p));
                    int idp = daoprod.add(p);

               // out.println(request.getParameter("id"));
                    Imagem im = new Imagem();
                    im.setFoto(s);
                    im.setIdProduto(idp);

                    DaoImagem daoi = new DaoImagem();
                    daoi.add(im);

                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/servletIndex");
                    rd.forward(request, response);
                  //  LOGGER.log(Level.INFO, "File{0}being uploaded to {1}", 
                    //      new Object[]{fileName, path});
                } catch (FileNotFoundException fne) {
                    writer.println("You either did not specify a file to upload or are "
                            + "trying to upload a file to a protected or nonexistent "
                            + "location.");
                    writer.println("<br/> ERROR: " + fne.getMessage());

                    //LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}", 
                    //        new Object[]{fne.getMessage()});
                } catch (SQLException ex) {
                    Logger.getLogger(servletProduto.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    if (outp != null) {
                        outp.close();
                    }
                    if (filecontent != null) {
                        filecontent.close();
                    }
                    if (writer != null) {
                        writer.close();
                    }
                }
            }
        }
    }

    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        // LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
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

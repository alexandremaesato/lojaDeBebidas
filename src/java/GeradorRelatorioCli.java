/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.*;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Ina
 */
@WebServlet(urlPatterns = {"/GeradorRelatorioCli"})
public class GeradorRelatorioCli extends HttpServlet {

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
        Connection con = null;
try {
// Conexão com o banco
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lojadebebidas2","root", "@36");
// Caminho físico do relatório compilado
String jasper = request.getContextPath() + "/report2.jasper";
// Host onde o servlet esta executando
String host = "http://" + request.getServerName() + ":" + request.getServerPort();

// URL para acesso ao relatório
URL jasperURL = new URL(host + jasper);
HashMap params = new HashMap();
byte[] bytes = JasperRunManager.runReportToPdf(
jasperURL.openStream(), params, con);
if (bytes != null) {
// A página será mostrada em PDF
response.setContentType("application/pdf");
// Envia o PDF para o Cliente
OutputStream ops = null;
ops = response.getOutputStream();
ops.write(bytes);
}
}
catch(ClassNotFoundException e) {
// erro de driver
response.setContentType("text/html;charset=UTF-8");
PrintWriter out = response.getWriter();
out.println("<html><head>");
out.println("<title>Servlet GeradorRelatorio</title>");
out.println("</head><body>");
out.println("<h1>Erro de Driver (" + e.getMessage() +
") no Servlet GeradorRelatorio at " +
request.getContextPath () + "</h1>");
out.println("</body></html>");
out.flush();
}
catch(SQLException e) {
// erro de SQL
response.setContentType("text/html;charset=UTF-8");
PrintWriter out = response.getWriter();
out.println("<html><head>");
out.println("<title>Servlet GeradorRelatorio</title>");
out.println("</head><body>");
out.println("<h1>Erro de SQL (" + e.getMessage() +
") no Servlet GeradorRelatorio at " +
request.getContextPath () + "</h1>");
out.println("</body></html>");
out.flush();
}

catch(JRException e) {
// erro de Jasper
response.setContentType("text/html;charset=UTF-8");
PrintWriter out = response.getWriter();
out.println("<html><head>");
out.println("<title>Servlet GeradorRelatorio</title>");
out.println("</head><body>");
out.println("<h1>Erro de Jasper (" + e.getMessage() +
") no Servlet GeradorRelatorio at " +
request.getContextPath () + "</h1>");
out.println("</body></html>");
out.flush();
}
finally {
if (con!=null)
try { con.close(); } catch(Exception e) {}
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.cs313.forumindproject;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aubrey
 */
@WebServlet(name = "SignInServlet", urlPatterns = {"/SignInServlet"})
public class SignInServlet extends HttpServlet {

    String uname; // "fallen";
    String pword; // "fallenrocks";
    String fileName = "userCreds.txt";

    public void loadFromFileString(String str) {
        String[] checkPassword = str.split(",");
        uname = checkPassword[0];
        pword = checkPassword[1];

    }

    public boolean checkLoginDetails(String username, String password) {
        try {
            //java.util.Properties prop = new java.util.Properties();
            //String path = "localization/stat_codes.properties";
            //InputStream foo = prop.getClass().getResourceAsStream(path);

            String root = getServletContext().getRealPath("/");
            Scanner fileIn = null;
            // BufferedReader bufferedReader = new BufferedReader(new FileReader("password.txt"));
            // String line = bufferedReader.readLine();
            // loadFromFileString(line); 
            fileIn = new Scanner(new File(root + "/WEB-INF/password.txt"));            
            while (fileIn.hasNextLine()) {
            String aline = fileIn.nextLine();           

            String[] fields = aline.split(",");
            if (fields.length == 2) {
                uname = fields[0];
                pword = fields[1];
            } else {
            }
            if (username.equals(uname) && password.equals(pword))                 
               return true;
            }
            fileIn.close();
        } //catch (IOException e) {
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
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
            // Get username and password from form                
            String name = request.getParameter("username");
            String password = request.getParameter("password");
            
                        // Check that username and password from form match username and password
            // if it authenticates, display welcome screen
            if (name != null && password != null && checkLoginDetails(name,password)) {
                request.getSession().setAttribute("username", name);
                response.sendRedirect("newPost.jsp");

                // If it does not authenticate, display error message                  
            } else {
                response.sendRedirect("failedLogin.jsp");
            }
            
            out.println("Welcom :    " +name);
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

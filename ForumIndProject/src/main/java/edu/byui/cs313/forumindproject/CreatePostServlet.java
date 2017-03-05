/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.cs313.forumindproject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Aubrey
 */
@WebServlet(name = "CreatePostServlet", urlPatterns = {"/CreatePostServlet"})
public class CreatePostServlet extends HttpServlet {
 
    
    
    
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
        //Obtain the session object, create a new session if doesn't exist
        HttpSession session = request.getSession(true);
        String uname = (String) session.getAttribute("username");
        
        if (uname != null) {
            String root = getServletContext().getRealPath("/");
            
            //Get current contents of file
            String current = "";
            Scanner fileIn = null;
            fileIn = new Scanner(new File(root + "/WEB-INF/forumPosts.txt"));            
            while (fileIn.hasNextLine()) {
                String aline = fileIn.nextLine();
                current = current + aline + System.getProperty("line.separator") ;
            }
            fileIn.close();
            
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd_HH:mm:ss").format(Calendar.getInstance().getTime());
            String postEntry = request.getParameter("postEntry");
            String postWrite = uname + " " + timeStamp + " " + postEntry + System.getProperty("line.separator") + current;
            
            try{
                
                FileWriter writer = new FileWriter(root + "WEB-INF/forumPosts.txt");
                
//                BufferedWriter out = new BufferedWriter(writer);
// 
//		out.write(postWrite);
//
//		//close buffer writer
//		out.close();
                
                writer.write(postWrite);
                writer.flush();
                writer.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
            
            response.sendRedirect("viewPosts.jsp");
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

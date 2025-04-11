/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.Servlet;

import com.DAO.UserDAO;
import com.Db.DBConnection;
import com.User.UserDetails;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
//import java.io.PrintWriter;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author azhar
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {

   
   
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String email=request.getParameter("uemail");
        String password=request.getParameter("upassword");
        
        
        UserDetails us=new UserDetails();
        us.setEmail(email);
        us.setPassword(password);
        
        UserDAO dao=new UserDAO(DBConnection.getConn());
        UserDetails user=dao.loginUser(us);
        
        if(user!=null)
        {
          HttpSession session=request.getSession();
          session.setAttribute("userD",user);
          response.sendRedirect("Home.jsp");
        }
        else
        {
            HttpSession session=request.getSession();
            session.setAttribute("login-failed","Invalid UserName and Password");
            response.sendRedirect("login.jsp");
            
        }
        
    }

    

}

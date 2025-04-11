/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import java.io.PrintWriter;

/**
 *
 * @author azhar
 */
@WebServlet("/UserServlet")

public class UserServlet extends HttpServlet {
    
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
    {
        String name=request.getParameter("uname");
        System.out.println(name);
        String email=request.getParameter("uemail");
        String password=request.getParameter("upassword");
        
       UserDetails us=new UserDetails();
       
       us.setName(name);
       us.setEmail(email);
       us.setPassword(password);
       
        UserDAO dao=new UserDAO(DBConnection.getConn());
        boolean f=dao.addUser(us);
        
        HttpSession session;
        
        if(f)
        {
            session=request.getSession();
          
            session.setAttribute("reg-sucess","Registration Successfully..");
            response.sendRedirect("register.jsp");
        }
       
        else
        {
            session=request.getSession();
          
            session.setAttribute("failed-msg","Something went wrong on server");
            response.sendRedirect("register.jsp");
        }
    }
   
}

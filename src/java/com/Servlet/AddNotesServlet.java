/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.Servlet;

import com.DAO.PostDAO;
import com.Db.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
//import java.io.PrintWriter;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author azhar
 */
@WebServlet(name = "AddNotesServlet", urlPatterns = {"/AddNotesServlet"})
public class AddNotesServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int uid = Integer.parseInt(request.getParameter("uid"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        PostDAO dao = new PostDAO(DBConnection.getConn());
        boolean f = dao.AddNotes(title, content, uid);

        if (f) {
            System.out.println("Data inserted successfully");
            response.sendRedirect("showNotes.jsp");
        } else {
            System.out.println("Data not inserted ");
        }
    }

}

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
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author azhar
 */
@WebServlet(name = "deleteServlet", urlPatterns = {"/deleteServlet"})
public class deleteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer noteid = Integer.parseInt(request.getParameter("note_id"));
        System.out.println(noteid);
        PostDAO dao = new PostDAO(DBConnection.getConn());
        boolean f = dao.deleteNotes(noteid);
        HttpSession session = null;

        if (f) {
            session = request.getSession();
            session.setAttribute("updateMsg", "Notess Delete Successfully..");
            response.sendRedirect("showNotes.jsp");

        } else {
            session = request.getSession();
            session.setAttribute("wrongMsg", "Something went wrong on server");
            response.sendRedirect("showNotes.jsp");
        }

    }

}

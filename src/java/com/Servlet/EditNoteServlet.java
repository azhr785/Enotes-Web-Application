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
@WebServlet(name = "EditNoteServlet", urlPatterns = {"/EditNoteServlet"})
public class EditNoteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Integer noteid = Integer.parseInt(request.getParameter("noteid"));
            System.out.println(noteid);
            String Title = request.getParameter("title");
            String Content = request.getParameter("content");
            System.out.println(Content);
            System.out.println(Title);
            PostDAO dao = new PostDAO(DBConnection.getConn());
            boolean f = dao.postUpdate(noteid, Title, Content);

            if (f) {
                System.out.println("data update successfully");
                HttpSession session = request.getSession();
                session.setAttribute("updateMsg", "Notes Update Successfully");
                response.sendRedirect("showNotes.jsp");
            } else {
                System.out.println("data not updated");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

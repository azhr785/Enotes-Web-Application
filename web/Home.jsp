<%--
    Document   : Home
    Created on : 22-Jun-2024, 8:57:53 am
    Author     : azhar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    UserDetails user1=(UserDetails)session.getAttribute("userD");
    if(user1==null)
    {
    response.sendRedirect("login.jsp");
    session.setAttribute("Login-error","Please Login..");
    }
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="all_component/allcss.jsp"%>
    </head>
    <body>


        <div class="container-fluid p-0">
            <%@ include file="all_component/navbar.jsp"%>
            <div class="card py-5">
                <div class="card-body text-center">
                    <img alt="" src="image/edit.png" class="img-fluid mx-auto" style="max-width: 300px;">
                    <h1>START TAKING YOUR NOTES</h1>
                    <a href="addNotes.jsp" class="btn btn-outline-primary">Start Here</a>
                </div>

            </div>
        </div>
        <%@include file="all_component/footer.jsp"%>
    </body>
</html>

<%--
    Document   : addNotes
    Created on : 30-Jun-2024, 4:41:27 pm
    Author     : azhar
--%>
<%@page import="com.User.UserDetails"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    UserDetails user2=(UserDetails)session.getAttribute("userD");
    if(user2==null)
    {
    response.sendRedirect("login.jsp");
    session.setAttribute("Login-error","Please Login..");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Notes</title>
        <%@include file="all_component/allcss.jsp"%>
    </head>
    <body>
        <!--        <div class="container-fluid">-->
        <%@include file="all_component/navbar.jsp"%>
        <h1 class="text-center">Add Your Notes</h1>
        <div class="container">
            <div class="row">
                <div class="col-md-12">

                    <form action="AddNotesServlet" method="post">
                        <div class="form-group">
                            <%
                                UserDetails us=(UserDetails)session.getAttribute("userD");
                                if(us!=null)
                                {%>
                            <input type="hidden" value="<%=us.getId()%>" name="uid">
                            <%}
                            %>


                            <label for="exampleInputEmail1">Enter Title</label>
                            <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="title" required="required">

                        </div>

                        <div class="form-group">
                            <label for="exampleInputEmail1">Enter content</label>
                            <textarea rows="8" cols="" class="form-control" name="content" required="required"></textarea>
                        </div>

                        <div class="container text-center">
                            <button type="submit" class="btn btn-primary">Add Notes</button>
                        </div>
                    </form>



                </div>
            </div>
        </div>
        <!--        </div>-->
        <%@include file="all_component/footer.jsp"%>
    </body>
</html>

<%--
    Document   : edit.jsp
    Created on : 05-Jul-2024, 11:02:57 pm
    Author     : azhar
--%>
<%@page import="com.User.Post"%>
<%--<%@page import="java.util.List"%>--%>
<%@page import="com.DAO.PostDAO"%>
<%@page import="com.Db.DBConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Notes</title>
        <%@include file="all_component/allcss.jsp"%>
    </head>
    <body>

        <%
        Integer noteid=Integer.parseInt(request.getParameter("note_id"));
        PostDAO post=new PostDAO(DBConnection.getConn());
        Post p=post.getDataById(noteid);
        %>

        <%@include file="all_component/navbar.jsp"%>
        <h1 class="text-center">Edit Your Notes</h1>
        <div class="container">
            <div class="row">
                <div class="col-md-12">

                    <form action="EditNoteServlet" method="post">
                        <input type="hidden" value="<%=noteid%>" name="noteid">
                        <div class="form-group">



                            <label for="exampleInputEmail1">Enter Title</label>
                            <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="title" required="required" value="<%=p.getTitle()%>">

                        </div>

                        <div class="form-group">
                            <label for="exampleInputEmail1">Enter content</label>
                            <textarea rows="8" cols="" class="form-control" name="content" required="required"><%=p.getContent()%></textarea>
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

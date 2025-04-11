<%-- 
    Document   : index.jsp
    Created on : 08-Jun-2024, 3:17:53 pm
    Author     : azhar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <%@include file="all_component/allcss.jsp" %>
        <style type="text/css">
            .back-img{
                background: url("image/Enotes8.jpg");
                width:100%;
                  height:80vh; 
                  background-repeat:no-repeat; 
                  background-size:cover;
                  
            }
        </style>
        
    </head>
    <body>
        
        <%@include file="all_component/navbar.jsp" %>
        <div class="container-fluid back-img">
            <div class="text-center">
                <h1 class="text-white"><i class="fa fa-book" aria-hidden="true"></i> E Notes-Save Your Notes </h1>
            <a href="login.jsp"class="btn btn-light"><i class="fa fa-user-circle-o" aria-hidden="true"></i> Login</a>
            <a href="register.jsp"class="btn btn-light"><i class="fa fa-user-plus" aria-hidden="true"></i> Register</a>
            </div>
        </div>
        <%@include file="all_component/footer.jsp"%>
    </body>
</html>

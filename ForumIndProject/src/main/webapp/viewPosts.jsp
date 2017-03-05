<%-- 
    Document   : viewPosts
    Created on : Feb 25, 2017, 8:07:06 PM
    Author     : Aubrey
--%>
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.PrintWriter" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"></></link>
            <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
            <link rel="stylesheet" href="personal.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>View Posts</title>
    </head>
    <body>
        <div class="container">
            <h1  class="page-header">View Posts</h1>
            <p>You may create a new post <a href="newPost.jsp">here</a>.</p>
            <ul class="list-group">
                <jsp:include page="/LoadPostsServlet" flush="true"></jsp:include>
            </ul>
        </div>
    </body>
</html>

<%-- 
    Document   : newPost
    Created on : Mar 2, 2017, 8:23:09 PM
    Author     : Aubrey
--%>

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
        <title>New Post</title>
    </head>
    <body>
        <div class="container">
            <h1  class="page-header">Enter New Post</h1>
            <p>Please fill out the form below to create a new forum post.</p>
            <form method="post" action="CreatePostServlet">
                <fieldset>
                    POST :   <textarea class="form-control" name="postEntry" rows="4" cols="50"></textarea> 

                    <button class="btn btn-primary" type="submit" >SUBMIT</button>
                </fieldset>
            </form>
            <p>If you prefer not to make a post, you may read the existing posts in the discussion forum <a href="viewPosts.jsp">here</a>.</p>
        </div>
    </body>
</html>

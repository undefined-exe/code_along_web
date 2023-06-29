<%-- 
    Document   : index
    Created on : 11-Mar-2023, 8:47:23 pm
    Author     : ASHISH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/index1.js"></script>
        <link rel="stylesheet" href="css/style.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        </br>
        </br>
        <div class="wrapper">
            <div class="logo">
                <img src="images\code_cluster.png" alt="">
            </div>
            <div class="text-center mt-4 name">
                Code Cluster
            </div>
            <form class="p-3 mt-3">
                <div class="form-field d-flex align-items-center">
                    <span class="far fa-user"></span>
                    <input type="text" name="userName" id="username" placeholder="Username">
                </div>
                <div class="form-field d-flex align-items-center">
                    <span class="fas fa-key"></span>
                    <input type="password" name="password" id="password" placeholder="Password">
                </div>
                <button class="btn mt-3 btn-dark" onclick="return validForm()">Login</button>
            </form>
            <div class="text-center link">
                <a href="#">Forget password?</a> or <a href="signup">Sign up</a>
            </div>
        </div>
        <input type="hidden" id="ajax">
    </body>
</html>

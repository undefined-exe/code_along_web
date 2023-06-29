<%-- 
    Document   : signup
    Created on : 23-Apr-2023, 12:37:02 pm
    Author     : ASHISH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="js/index1.js"></script>
        <link rel="stylesheet" href="css/style.css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" >
        <script src="https://use.fontawesome.com/releases/v5.7.2/css/all.css"></script>
    </head>
    <body>
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
                    <span class="far fa-email"></span>
                    <input type="text" name="email" id="email" placeholder="Email">
                </div>
                <div class="form-field d-flex align-items-center">
                    <span class="fas fa-key"></span>
                    <input type="password" name="password" id="password" placeholder="Password">
                </div>
                <div class="form-field d-flex align-items-center">
                    <span class="fas fa-key"></span>
                    <input type="password" name="cnfPassword" id="cnfPassword" placeholder="Confirm Password">
                </div>
                <button class="btn mt-3 btn-dark" onclick="return validateSignup()">Register</button>
            </form>
            <div class="text-center link">
                Already have An Account? <a href="login">Login</a>
            </div>
        </div>
        <input type="hidden" id="ajax2">
    </body>
</html>

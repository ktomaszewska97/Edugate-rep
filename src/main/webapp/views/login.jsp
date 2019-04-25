<link rel="stylesheet" type="text/css" href="Login.css">
<%@ page language="java" contentType="text/html"%>
<%@ page import="java.text.*,java.util.*" %>
<html>
<head>
<title>Date JSP</title>
</head>
<body>
         <div class="login-container">
                <div class="login-content">
                    <h1 class="login-title">Login to Edugate</h1>

                    <div class="social-login">
                        <a className="btn btn-block social-btn google" href="">
                        <img src=google-logo.png alt="Google" /> Log in with Google</a>
                    </div>

                    <div class="or-separator">
                        <span class="or-text">OR</span>
                    </div>

                    <form action="login">
                        <div class="form-item">
                            <input type="email" name="email" 
                            class="form-control" placeholder="Email"
                            value="" onChange="" required/>
                        </div>
                        <div class="form-item">
                            <input type="password" name="password" 
                            class="form-control" placeholder="Password"
                            value="" onChange="" required/>
                        </div>
                        <div class="form-item">
                        <button type="submit" class="btn btn-block btn-primary">Login</button>
                        </div>
                    </form>
                    <span class="signup-link">New user? <Link to="">Sign up!</Link></span>
                </div>
            </div>
</body>
</html>

           
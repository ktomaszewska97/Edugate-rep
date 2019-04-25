<link rel="stylesheet" type="text/css" href="Signup.css">
<%@ page language="java" contentType="text/html"%>
<%@ page import="java.text.*,java.util.*" %>
<html>
<head>
<title>Date JSP</title>
</head>
<body>
            <div class="signup-container">
                <div class="signup-content">
                    <h1 class="signup-title">Start using Edugate!</h1>
                        <div class="social-signup">
                        <a class="btn btn-block social-btn google" href="">
                        <img src="google-logo.png" alt="Google" /> Sign up with Google</a>
                        </div>
                            <div class="or-separator">
                                <span class="or-text">OR</span>
                            </div>
                                <form action="signup">
                                    <div class="form-item">
                                        <input type="text" name="name" 
                                        class="form-control" placeholder="Username"
                                        value="" onChange="" required/>
                                    </div>
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
                                        <button type="submit" class="btn btn-block btn-primary" >Sign Up</button>
                                    </div>
                                </form>                    
                    <span class="login-link">Already have an account? <Link to="">Login!</Link></span>
                </div>
            </div>
</body>
</html>

           
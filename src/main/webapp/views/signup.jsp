<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.text.*,java.util.*" %>
<html>
<head>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<link href="/css/Signup.css" rel="stylesheet">
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

           
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="style.css" rel="stylesheet" />
<meta charset="ISO-8859-1">
<title>Insert title here</title>
      <style>
        .error{
         width:100%;
         padding:0;
         font-size:80%;
         colour:white;
         background-colour:#900;
         border-radius:0 0 5px 5px;
         box-sizing:border-box;
        }
        .error.active
        {
        padding:0.3em;}
        </style>
</head>
<body>
 <div class="container">
            <div class="header">
                <h2>Sign Up</h2>
            </div>
            <form class="form" action="Register" method="POST">
                <div class="form-control">
                    <label>User Name</label>
                    <input id="name" placeholder="user name" name="name" type="text" required minlengh=3 />
                    <span class="error" aria-live="polite"></span>
                </div>
                <div class="form-control">
                    <label>Email</label>
                    <input id="email" placeholder="example@gmail.com" type="email" name="email" required minlength="12"/>
                    <span class="error" aria-live="polite"></span>
                </div>
                <div class="form-control">
                    <label >Password</label>
                    <input id="password" type="password" placeholder="********" name="password" required minlength="8"  />
                    
                    <span class="error" aria-live="polite"></span>
                </div>
                <div class="form-control">
                    <label>Confirm Password</label>
                    <input id="password2" type="password" placeholder="********" name="password2" required minlength="8" />
                    
                    <span class="error" aria-live="polite"></span>
                </div>
              
                <input type="submit" value="Register" id="button">
                <h5 style:"text-align:center;">Already have an account?<a style="text-decoration:none;" href="login.jsp">Login in</a>
                </h5>
            </form>
        </div>
       
        <script src="page.js"></script>
</body>
</html>
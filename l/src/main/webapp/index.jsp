<%@page import="online.connection.*" %>
<%@page import="online.model.*" %>
<%@page import="online.logic.*" %>
<%@page import="online.servelt.*" %>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    User author = (User) request.getSession().getAttribute("author");
                if(author!=null)
                {
                	request.setAttribute("author",author);
                }
                ProductLogic productlogic=new ProductLogic(DatabaseConnection.getConnetion());
                List<Product> products=productlogic.getAllProducts();
                ArrayList<Cart> cart_list=(ArrayList<Cart>) session.getAttribute("cart-list");
                if(cart_list!=null)
                {
                	request.setAttribute("cart_list",cart_list);
                }
    %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<%@include file="inludes/head.jsp" %>
</head>
<body>
<%@include file="inludes/nav.jsp" %>
<style>
body{
background:url(img/bg.jpg) no-repeat;
background-size:cover;
}
</style>      

<%@include file="inludes/foot.jsp" %>
</body>
</html>
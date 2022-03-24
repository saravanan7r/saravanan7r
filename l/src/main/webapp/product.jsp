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
<div class="container">
<div class="card-header my-3 text align:center">Baby Care</div>
<div class="row">
<% if(!products.isEmpty())
{
	for(Product count:products)
	{%>
		<div class=col-md-3>
		<div class="card w-100" style="width: 18rem;">
		  <img class="card-img-top" src="img/<%=count.getImage() %>" alt="Card image cap">
		  <div class="card-body">
		    <h5 class="card-title"><%= count.getName() %></h5>
		     <h6 class="price">Price:<%= count.getPrice() %></h6>
		      <h6 class="category">Category:<%=count.getCategory() %></h6>
		      <div class="mt-3 d-flex justify-content-between">  <a href="AddCart?id=<%= count.getId() %>" class="btn btn-dark">Add to cart</a>
		        <a href="OrderPage" class="btn btn-primary">Buy Now</a></div>
		  
		  </div>
		</div>
		</div>
	<%}
}
%>

</div>
</div>

<%@include file="inludes/foot.jsp" %>
<style>
body{
background:url(img/bg.jpg) no-repeat;
background-size:cover;
}
</style>
</body>
</html>
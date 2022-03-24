<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="online.connection.DatabaseConnection" %>
<%@page import="online.model.*" %>
<%@page import="online.logic.*" %>
    <%
                User author=(User)request.getSession().getAttribute("author");
                if(author!=null)
                {
                	request.setAttribute("author",author);
                }
                ArrayList<Cart> cart_list=(ArrayList<Cart>) session.getAttribute("cart-list");
                List<Cart> cartProduct=null;
                if(cart_list!=null)
                {
                	ProductLogic productlogic=new ProductLogic(DatabaseConnection.getConnetion());
                	cartProduct=productlogic.getCartProducts(cart_list);
                	double total=productlogic.getTotalCartPrice(cart_list);
                	request.setAttribute("cart_list",cart_list);
                	request.setAttribute("total",total);
                }
    %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<%@include file="inludes/head.jsp" %>
<style type="text/css">
.table tbody td{
 vertical-align:middle;
}
.btn-incre,.btn-decre{
       box-shadow:none;
       font-size:25px;
}
body{
background:url(img/bg.jpg) no-repeat;
background-size:cover;
}
</style>
</head>
<body>
   <% if(author!=null){%>
    	  <li class="nav-item">
          <a class="nav-link disabled" href="orders.jsp">orders</a>
        </li>
         <li class="nav-item">
          <a class="nav-link disabled" href="logout">Log Out</a>
        </li>
     <% }
       else{ %>
      
    	  <li class="nav-item">
          <a class="nav-link disabled" href="login.jsp">Login</a>
        </li>
     <% } %>
<%@include file="inludes/nav.jsp" %>
<div class="container">
<div class="d-flex py-3">
<h3> Total Price:$ ${  (total>0)?total:0 }</h3><a class="mx-3 btn btn-primary" href="ChoiceList">Check Out</a>
</div>
<table class="table table-light">
<thead>
<tr>
<th scope="col">Name</th>
<th scope="col">Category</th>
<th scope="col">Price</th>
<th scope="col">Buy Now</th>
<th scope="col">Cancel</th>
</tr>
</thead>
<tbody>
<%
if(cart_list!=null)
{
	for(Cart cart:cartProduct)
	{%>
		<tr>
		<td><%=cart.getName() %></td>
		<td><%=cart.getCategory() %></td>
		<td><%=cart.getPrice() %></td>
		<td><form action="OrderPage" method="post" class="form-inline">
		<input type="hidden" name="id" value="<%=cart.getId() %>" class="form-input">
		<div class="form-group d-flex justify-content-between w-50">
		<a class="btn btn-sm btn-incre" href="IncDec?action=inc&id=<%=cart.getId()%>"><i class="fas fa-plus-square"></i></a>
		<input type="text" name="quantity" class="form-control w-50" value="<%=cart.getQuantity()%>" readonly>
		<a class="btn btn-sm btn-decre" href="IncDec?action=dec&id=<%=cart.getId()%>"><i class="fas fa-minus-square"></i></a>
		<button typr="submit" class="btn btn-primary btn-sm">Buy</button>
		</div>
		</form></td>
		<td>
		<a class="btn btn-sm btn-danger" href="Remove?id=<%=cart.getId()%>">Remove</a>
		</td>
		</tr>
	<% }
}
%>

</tbody>
</table>
</div>
<%@include file="inludes/foot.jsp" %>
</body>
</html>
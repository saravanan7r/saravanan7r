<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="online.connection.DatabaseConnection" %>
<%@page import="online.model.*" %>
    <%
    User author=(User)request.getSession().getAttribute("author");
    List<Order> orders=null;
        if(author!=null)
        {
        	request.setAttribute("author",author);
        	orders=new OrderLogic(DatabaseConnection.getconnetion()).userOrders(author,getId());
        }
        else
        {
        	response.sendRedirect("login.jsp");
        }
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
    <div class="card-header my-3"> All Orders</div>
    <table class="table table-light">
        <thead>
            <tr>
                <th scope="col">Date</th>
                <th scope="col">Name</th>
                <th scope="col">Category</th>
                <th scope="col">Quantity</th>
                <th scope="col">Price</th>
                <th scope="col">Cancel</th>
            </tr>
        </thead>

        <tbody>
           
            <%
            if(orders !=null){
            for(Order order:orders){ %>
            <tr>
            <td><%= order.getDate() %> </td>
            <td><%= order.getName() %> </td>
            <td><%= order.getCategory() %> </td>
            <td><%= order.getQuantity() %> </td>
            <td><%= order.getPrice() %> </td>
            <td><a class="btn btn-sm btn-danger" href="Cancel-Order?id=<%= order.getOrderId()%>">Cancel</a></td>
            </tr>
            <%}
            }
            %>
        </tbody>

    </table>
</div>
<%@include file="inludes/foot.jsp" %>
</body>
</html>
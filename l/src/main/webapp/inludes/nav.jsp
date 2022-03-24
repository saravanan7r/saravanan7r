
<nav class="navbar navbar-expand-lg navbar-light bg-light">

<div class="container">
  <a class="navbar-brand" href="index.jsp">Medikart</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav ml-auto">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
       <li class="nav-item active">
        <a class="nav-link" href="product.jsp">Products <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="cart.jsp">Cart<span class="badge badge-danger px-1">${cart_list.size()}</span></a>
      </li>
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
   
  
    </ul>

  </div>
  </div>
</nav>

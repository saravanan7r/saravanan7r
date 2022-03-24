package online.servelt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import online.model.*;

@WebServlet("/AddCart")
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html;charset=UTF-8");

  	       Cart cart=new Cart();
	       try(PrintWriter out = response.getWriter())
	       {
	    	   ArrayList<Cart> cartList=new ArrayList<>();
	    	   int id=Integer.parseInt(request.getParameter("id"));
	    	   cart.setId(id);
               cart.setQuantity(1);
             
              HttpSession session=request.getSession();
               ArrayList<Cart> cart_list=(ArrayList<Cart>) session.getAttribute("cart-list");
               if(cart_list==null)
               {
              	 cartList.add(cart);
              	 session.setAttribute("cart-list", cartList);
              	 response.sendRedirect("product.jsp");
               }
               else
               {
              	cartList=cart_list;
              	boolean exist=false;
              	cartList.contains(cart);
              	for(Cart count:cartList)
              	{
              		if(count.getId()==id) {
              			exist=true;
              			out.print("<h3 style='colour:crimson; text-align:center'>Item already exist in cart.<a href='cart.jsp'>Go to Cart Page</a></h3>");
              		}
              		
              	}
              	if(!exist) {
          			cartList.add(cart);
          			response.sendRedirect("product.jsp");
          		}
              	
               }
	       }
	}
	}



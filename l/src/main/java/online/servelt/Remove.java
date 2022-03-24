package online.servelt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import online.model.Cart;

@WebServlet("/Remove")
public class Remove extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter())
	       {
			 String id=request.getParameter("id");
			 if(id!=null)
			 {
				 HttpSession session=request.getSession();
				 ArrayList<Cart> cart_list=(ArrayList<Cart>)session.getAttribute("cart-list");
				 if(cart_list!=null) {
					 for(Cart cart:cart_list) {
						 if(cart.getId()==Integer.parseInt(id)) {
							 cart_list.remove(cart_list.indexOf(cart));
							 break;
						 }
					 }
					 response.sendRedirect("cart.jsp");
				 }
			 }else {
				 response.sendRedirect("cart.jsp");
			 }
	       }
	}


}

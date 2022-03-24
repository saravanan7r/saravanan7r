package online.servelt;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import online.connection.DatabaseConnection;
import online.logic.OrderLogic;
import online.model.Cart;
import online.model.Order;
import online.model.User;

/**
 * Servlet implementation class OrderPage
 */
@WebServlet("/OrderPage")
public class OrderPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		try(PrintWriter out = response.getWriter()){
			SimpleDateFormat formatter=new SimpleDateFormat("yyyy-mm-dd");
			Date date=new Date();
			User author=(User) request.getSession().getAttribute("author");
			if(author!=null)
			{
				String productId=request.getParameter("id");
				int productQuantity=Integer.parseInt(request.getParameter("quantity"));
				if(productQuantity<=0)
				{
					productQuantity=1;
				}
				Order order =new Order();
				order.setId(Integer.parseInt(productId));
				order.setUserId(author.getId());
				order.setQuantity(productQuantity);
				order.setDate(formatter.format(date));
				
			    OrderLogic orderlogic = new OrderLogic(DatabaseConnection.getConnetion());
				boolean result = orderlogic.inserOrder(order);

				if(result) {
				@SuppressWarnings("unchecked")
				ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
				if(cart_list != null) {
				for(Cart cart:cart_list) {
				if(cart.getId()==Integer.parseInt(productId)) {
				cart_list.remove(cart_list.indexOf(cart));
				break;
				}
				}
				}

				response.sendRedirect("orders.jsp");
				}else {
				out.print("order failed");
				}

				}else {
				response.sendRedirect("login.jsp");
				}
		} catch (Exception exception) {
			exception.printStackTrace();
		} 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

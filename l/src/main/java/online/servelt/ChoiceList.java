package online.servelt;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

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
 * Servlet implementation class ChoiceList
 */
@WebServlet("/ChoiceList")
public class ChoiceList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try(PrintWriter out = response.getWriter()){

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date();

	//retrive cart products
	@SuppressWarnings("unchecked")
	ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
	//user authentication
	User author = (User)request.getSession().getAttribute("author");

	if(cart_list != null && author != null) {

	for(Cart cart:cart_list) {
	Order order = new Order();
	order.setId(cart.getId());
	order.setUserId(author.getId());
	order.setQuantity(cart.getQuantity());
	order.setDate(formatter.format(date));

	OrderLogic  orderlogic = new OrderLogic(DatabaseConnection.getConnetion());
	boolean result = orderlogic.inserOrder(order);

	if(!result) break;
	}
	cart_list.clear();
	if(author == null) {
	response.sendRedirect("login.jsp");
	}else {
	response.sendRedirect("payment.jsp");
	}


	}else {
	if(author == null) response.sendRedirect("login.jsp");
	response.sendRedirect("cart.jsp");
	}

	}catch(Exception e){
	e.printStackTrace();
	}
	}

	/**
	* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(request, response);
	}
}

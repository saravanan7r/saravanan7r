package online.servelt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import online.connection.DatabaseConnection;
import online.logic.OrderLogic;

/**
 * Servlet implementation class CancelOrder
 */
@WebServlet("/Cancel-Order")
public class CancelOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out = response.getWriter()){
		String id= request.getParameter("id");
		if(id!=null) {
		OrderLogic orderlogic =new OrderLogic(DatabaseConnection.getConnetion());
		orderlogic.cancelOrder(Integer.parseInt(id));
		}

		//request.getRequestDispatcher("/WEB-INF/User_interface/orders.jsp").forward(request, response);

		response.sendRedirect("orders.jsp");
		} catch (Exception exception) {

		exception.printStackTrace();
		}
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

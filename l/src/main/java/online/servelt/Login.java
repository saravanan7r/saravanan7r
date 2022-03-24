package online.servelt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import online.connection.DatabaseConnection;
import online.logic.UserLogic;
import online.model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");
	try(PrintWriter out = response.getWriter())
			{
		       String email=request.getParameter("login-email");
		       String password=request.getParameter("login-password");
				try {
					UserLogic userlogic = new UserLogic(DatabaseConnection.getConnetion());
					User user=userlogic.userlogin(email, password);
					if(user!=null &&(email.equals("admin@gmail.com")&&password.equals("admin@123")))
					{
						request.getSession().setAttribute("author", user);
						response.sendRedirect("admin.jsp");
					}
					else if(user!=null&& email!=("admin@gmail.com"))
					{
						request.getSession().setAttribute("author", user);
						response.sendRedirect("index.jsp");
					}
					else
					{
						out.print("userLogin failed");
					}
				} catch (ClassNotFoundException | SQLException exception) {
					exception.printStackTrace();
				}
		    	
		    	
		     
			}
	}

}

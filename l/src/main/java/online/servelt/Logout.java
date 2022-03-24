package online.servelt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out = response.getWriter())
		{
			if(request.getSession().getAttribute("author")!=null)
			{
				request.getSession().removeAttribute("author");
				response.sendRedirect("login.jsp");
			}
			else
			{
				response.sendRedirect("index.jsp");
			}
		}
	}

	
}

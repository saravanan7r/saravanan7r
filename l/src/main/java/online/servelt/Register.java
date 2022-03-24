package online.servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import online.connection.DatabaseConnection;
import online.logic.RegisterLogic;
import online.model.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")

public class Register extends HttpServlet {
private static final long serialVersionUID = 1L;
       
   
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String name = request.getParameter("name");
String email = request.getParameter("email");
String password = request.getParameter("password");

User user = new User (name, email, password);
try {
RegisterLogic registerlogic = new RegisterLogic(DatabaseConnection.getConnetion());
if (registerlogic.saveUser(user)) {
  response.sendRedirect("login.jsp");
} else {
   String errorMessage = "User Available";
   HttpSession regSession = request.getSession();
   regSession.setAttribute("RegError", errorMessage);
   response.sendRedirect("Signup.jsp");
   }

} catch (Exception e) {
e.printStackTrace();
}

}

}

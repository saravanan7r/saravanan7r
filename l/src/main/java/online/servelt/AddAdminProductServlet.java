package online.servelt;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import online.connection.DatabaseConnection;
import online.logic.AdminProductDao;
import online.model.AdminProduct;

/**
 * Servlet implementation class AddAdminProductServlet
 */
@WebServlet("/AddAdminProduct")
public class AddAdminProductServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
       
   
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String pname = request.getParameter("productname");
String cat = request.getParameter("productcategory");
String pprice = request.getParameter("productprice");
String pimage = request.getParameter("productimage");

AdminProduct prod = new AdminProduct(pname,cat,pprice,pimage);
try(PrintWriter out=response.getWriter()){
AdminProductDao apdao = new AdminProductDao(DatabaseConnection.getConnetion());
if(apdao.addProduct(prod)) {
response.sendRedirect("admin_product.jsp");
}
else {
out.print("worng credential");
}
}catch(Exception e) {
e.printStackTrace();
}
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
doGet(request, response);
}

}
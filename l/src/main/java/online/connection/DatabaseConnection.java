package online.connection;
import java .sql.*;
public class DatabaseConnection {
private static Connection connection=null;
public static Connection getConnetion() throws ClassNotFoundException,SQLException
{
	if(connection==null)
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping","root","saro@2001");
	}
	return connection;
}
}

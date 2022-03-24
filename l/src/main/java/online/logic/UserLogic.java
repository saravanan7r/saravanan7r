package online.logic;

import java.sql.*;

import online.model.User;

public class UserLogic {
 private Connection  connection;
 private String query;
 private PreparedStatement preparedstatement;
 private ResultSet resultset;
  public UserLogic(Connection connection)
  {
	  this.connection=connection;
  }
  public User userlogin(String email,String password)
  {
	  User  user=null;
	 try
	 {
		 query="select * from shopping.users where email=? and password=?";
		 preparedstatement=this.connection.prepareStatement(query);
		 preparedstatement.setString(1, email);
		 preparedstatement.setString(2,password);
		 resultset=preparedstatement.executeQuery();
		 if(resultset.next())
		 {
			 user=new User();
			 user.setId(resultset.getInt("id"));
			 user.setName(resultset.getString("name"));
			 user.setEmail(resultset.getString("email"));
			 
		 }
	 }
	 catch(Exception exception)
	 {
		 exception.printStackTrace();
		 System.out.print(exception.getMessage());
	 }
	  return user;
  }
}

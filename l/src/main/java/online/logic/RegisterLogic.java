package online.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;

import online.model.User;

public class RegisterLogic {
		Connection connection ;

		    public RegisterLogic(Connection connection) {
		        this.connection = connection;
		    }
		    public boolean saveUser(User user){
		        boolean set = false;
		        try{
		           String query = "insert into shopping.users(name,email,password) values(?,?,?)";
		           PreparedStatement preparedStatement = this.connection.prepareStatement(query);
		           preparedStatement.setString(1, user.getName());
		           preparedStatement.setString(2, user.getEmail());
		           preparedStatement.setString(3, user.getPassword());
		           preparedStatement.executeUpdate();
		           set = true;
		        }catch(Exception e){
		            e.printStackTrace();
		        }
		        return set;
		    }

		   
		   
		}


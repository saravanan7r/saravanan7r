package online.logic;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;



import online.model.User;

public class AdminUserDao {
Connection connection ;

public AdminUserDao(Connection connection) {
this.connection = connection;
}

//display
public List<User> getAllUser(){
List<User> user = new ArrayList<>();

try {
String query = "select * from shopping.users";
PreparedStatement pt = this.connection.prepareStatement(query);
ResultSet rs = pt.executeQuery();

while(rs.next()) {
int id = rs.getInt("id");
String uname = rs.getString("name");
String uemail = rs.getString("email");
String upassword = rs.getString("password");

User row = new User(id,uname,uemail,upassword);
user.add(row);
}
}catch (Exception e) {
e.printStackTrace();
}

return user;

}

//delete

public void deleteUser(int id) {
try {
String query = "delete from shopping.users where id=?";
PreparedStatement pt1 = this.connection.prepareStatement(query);
pt1.setInt(1, id);
pt1.execute();
} catch (Exception e) {
e.printStackTrace();
}
}
}
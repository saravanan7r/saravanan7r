package online.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import online.model.AdminProduct;

public class AdminProductDao {
Connection connection ;

public AdminProductDao(Connection connection) {
this.connection = connection;
}
//INSERT
public boolean addProduct(AdminProduct adminProduct) {
boolean test = false;

try {
String query = "insert into shopping.products(name,category,price,image) values(?,?,?,?)";
PreparedStatement pst = this.connection.prepareStatement(query);
pst.setString(1, adminProduct.getName());
pst.setString(2, adminProduct.getCategory());
pst.setString(3, adminProduct.getPrice());
pst.setString(4, adminProduct.getImage());
pst.executeUpdate();
test = true;
}catch(Exception e) {
e.printStackTrace();
}
return test;
}

//RETRIVE
public List<AdminProduct> getAllProducts(){
List<AdminProduct> product = new ArrayList<>();

try {
String query = "Select * from shopping.products";
PreparedStatement pt = this.connection.prepareStatement(query);
ResultSet rs = pt.executeQuery();

while(rs.next()) {
int id = rs.getInt("id");
String proname = rs.getString("name");
String procat = rs.getString("category");
String proprice = rs.getString("price");
String proimage = rs.getString("image");

AdminProduct row = new AdminProduct(id,proname,procat,proprice,proimage);
product.add(row);
}
} catch (Exception e) {
e.printStackTrace();
}
return product;
}

//DELETE
public void deleteProduct(int id) {
try {
String query = "delete from shopping.products where id=?";
PreparedStatement pt1 = this.connection.prepareStatement(query);
pt1.setInt(1, id);
pt1.execute();
} catch (Exception e) {
e.printStackTrace();
}
}



}
package online.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.*;

import online.model.Order;
import online.model.Product;

public class OrderLogic {
	 private Connection  connection;
	 private String query;
	 private PreparedStatement preparedstatement;
	 private ResultSet resultset;
	 
	 public OrderLogic(Connection connection)
	 {
		 this.connection=connection;
	 }
	 public boolean inserOrder(Order order)
	 {
		 boolean result=false;
		 try {
			query="INSERT INTO shopping.orders (productid,userid,orderquantity,orderdate) VALUES(?,?,?,?)";
			 preparedstatement=this.connection.prepareStatement(query);
			 preparedstatement.setInt(1, order.getId());
			 preparedstatement.setInt(2,order.getUserId());
			 preparedstatement.setInt(3,order.getQuantity());
			 preparedstatement.setString(4,order.getDate());
			 preparedstatement.executeUpdate();
			 result=true;
		} catch (Exception exception) {
			exception.printStackTrace();
			
		}
		 return result;
		 
	 }
	 public void cancelOrder(int id) {
		 try {
		 query = "delete from shopping.orders where orderid=?";
		 preparedstatement = this.connection.prepareStatement(query);
		 preparedstatement.setInt(1, id);
		 preparedstatement.execute();
		 } catch (Exception exception) {
		 exception.printStackTrace();
		 }
	 }
	 public List<Order> userOrders(int id){
		 List<Order> list = new ArrayList<>();

		 try {
		 query = "select * from shopping.orders where userid=? order by orders.orderid desc";
		 preparedstatement = this.connection.prepareStatement(query);
		 preparedstatement.setInt(1, id);
		 resultset= preparedstatement.executeQuery();

		 while(resultset.next()) {
		 Order order = new Order();
		 ProductLogic productlogic = new ProductLogic(this.connection);
		 int productId=resultset.getInt("produtid");

		 Product product = productlogic.getSingleProduct(productId);
		 order.setOrderId(resultset.getInt("orderid"));
		 order.setId(productId);
		 order.setName(product.getName());
		 order.setCategory(product.getCategory());
		 order.setPrice(product.getPrice()*resultset.getInt("o_quantity"));
		 order.setQuantity(resultset.getInt("o_quantity"));
		 order.setDate(resultset.getString("o_date"));
		 list.add(order);

		 }

		 }catch(Exception exception) {
		 exception.printStackTrace();
		 }

		 return list;
		 }

}

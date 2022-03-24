package online.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import online.model.*;
public class ProductLogic {
	private Connection  connection;
	 private String query;
	 private PreparedStatement preparedstatement;
	 private ResultSet resultset;
	public ProductLogic(Connection connetion) {
		this.connection = connetion;
	}
	 public List <Product> getAllProducts()
	 {
		 List <Product> products=new ArrayList<Product>();
		 try {
			 query="select * from shopping.products";
			 preparedstatement=this.connection.prepareStatement(query);
			 resultset=preparedstatement.executeQuery();
			 while(resultset.next())
			 {
				 Product product =new Product();
				 product.setId(resultset.getInt("id"));
				 product.setName(resultset.getString("name"));
				 product.setCategory(resultset.getString("category"));
				 product.setPrice(resultset.getDouble("price"));
				 product.setImage(resultset.getString("image"));
				 products.add(product);
			 }
		 }
		 catch(Exception exception) 
		 {
			 exception.printStackTrace();
		 }
		 return products;
	 }
	 public   List<Cart> getCartProducts(ArrayList<Cart> cartList){
		 List<Cart> products=new ArrayList<Cart>();
		 try {
			 if(cartList.size()>0)
			 {
				 for(Cart item:cartList) {
					 query="select * from shopping.products where id=?";
					 preparedstatement=this.connection.prepareStatement(query);
					 preparedstatement.setInt(1, item.getId());
					 resultset=preparedstatement.executeQuery();
					 while(resultset.next())
					 {
						 Cart cart=new Cart();
						 cart.setId(resultset.getInt("id"));
						 cart.setName(resultset.getString("name"));
						 cart.setCategory(resultset.getString("category"));
						 cart.setPrice(resultset.getDouble("price")*item.getQuantity());
						 cart.setQuantity(item.getQuantity());
						 products.add(cart);
					 }
				 }
			 }
		 }
		 catch(Exception exception) {
			 System.out.println(exception.getMessage());
			 //e.printStackTrace();
		 }
		 return products;
	 }
	 public double getTotalCartPrice(ArrayList<Cart> cartList) {
		 double sum=0;
		 try
		 {
			 if(cartList.size()>0)
			 {
				 for(Cart item:cartList)
				 {
					 query="select price from shopping.products where id=?";
					 preparedstatement=this.connection.prepareStatement(query);
					 preparedstatement.setInt(1, item.getId());
					 resultset=preparedstatement.executeQuery();
					 while(resultset.next())
					 {
						 sum+=resultset.getDouble("price")*item.getQuantity();
					 }
				 }
			 }
			 
		 }
		 catch(Exception exception)
		 {
			 exception.printStackTrace();
			 
		 }
		 return sum;
	 }
	public Product getSingleProduct(int productId) {
		// TODO Auto-generated method stub
		return null;
	}
}

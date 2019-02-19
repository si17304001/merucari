package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import bean.*;
import exp.ResourceAccessException;

public class OraProductsDao extends AbstractDao{
	public void addProduct(ItemBean ib){
		Connection cn = null;
		PreparedStatement st = null;
		System.out.println("OraProductsDao内：1");
		try{
			
			cn = OracleConnectionManager.getInstance().getConnection();
			
			
			String sql = "insert into items(item_id,categorya,name,image1,description,state,postage,price,saler_id)"+"values(?,?,?,?,?,?,?,?,?)";
			st = cn.prepareStatement(sql);
			System.out.println("OraProductsDao内：2");
			
			st.setInt(1,ib.getItem_id());
			st.setInt(2,ib.getCategory());
			st.setString(3,ib.getName());
			st.setString(4,ib.getImage1());
			st.setString(5,ib.getDescription());
			st.setInt(6,ib.getState());
			//st.setString(5,ib.getSize());
			st.setInt(7,ib.getPostage());
			st.setInt(8,ib.getPrice());
			st.setString(9,ib.getSalerId());
			
			System.out.println("OraProductsDao内：3");
			st.executeUpdate();
			
			System.out.println("22222");
			//cn.commit();
			
		/*}catch(ClassNotFoundException e){
			throw new ResourceAccessException(e.getMessage(), e);*/
		}catch(SQLException e){
			System.out.println("OracleProductsDao(SQLException).java:1");
			e.printStackTrace();
			OracleConnectionManager.getInstance().rollback();
			
			
			
		}catch(Exception e){
			System.out.println("OracleProductsDao.java:不明");
		}finally{
			try{
				if(st != null){
					st.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
				System.out.println("OracleProductsDao.java:2");
			}
			System.out.println("OracleProductsDao.java:3");
		}
	}
	
	public ItemBean getProduct(String pid){
		return null;
	}
	
	public List getAllProducts(){
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		ArrayList products = new ArrayList();
		try{
			/*
			System.out.println("getAll1111111");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("getAll2222222");
			cn = DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521:orcl", "info","pro");
			*/
			cn = OracleConnectionManager.getInstance().getConnection();
			System.out.println("つながったよ");
			//cn.setAutoCommit(false);
			
			String sql = "select name,price from t_products";
			
			st = cn.prepareStatement(sql);
			System.out.println("getAll33333");
			rs = st.executeQuery();
			System.out.println("getAll44444");
			while(rs.next()){
				ItemBean ib = new ItemBean();
				
				ib.setName(rs.getString(1));
				ib.setPrice(rs.getInt(2));
				
				products.add(ib);
			}
			System.out.println("getAll55555");
			cn.commit();
		
		/*}catch(ClassNotFoundException e){
			throw new ResourceAccessException(e.getMessage(), e);*/
		}catch(SQLException e){
			OracleConnectionManager.getInstance().rollback();
			System.out.println("OracleProductsDao.java:4");
			
			
		}finally{
			try{
				if(st != null){
					st.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
				System.out.println("OracleProductsDao.java:5");
			}
			System.out.println("OracleProductsDao.java:6");
		}
	return products;
	}
}
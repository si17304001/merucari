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


public class GetItemDao extends AbstractDao{
	
	public List getAllProducts(){
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		ArrayList products = new ArrayList();
		try{

			cn = OracleConnectionManager.getInstance().getConnection();
			//cn.setAutoCommit(false);
			String sql = "select item_id,item_image1,item_name,item_price, item_available from items order by item_id asc";
			
			st = cn.prepareStatement(sql);
			System.out.println("getAll33333");
			rs = st.executeQuery();
			System.out.println("getAll44444");
			while(rs.next()){
				ItemBean ib = new ItemBean();
				
				ib.setItem_id(rs.getInt(1));
				ib.setImage1(rs.getString(2));
				ib.setName(rs.getString(3));
				ib.setPrice(rs.getInt(4));
				ib.setAvailable(rs.getInt(5));
				
				products.add(ib);
				System.out.println("dadada");
			}
			System.out.println("getAll55555");
			cn.commit();
		
		/*}catch(ClassNotFoundException e){
			throw new ResourceAccessException(e.getMessage(), e);*/
		}catch(SQLException e){
			OracleConnectionManager.getInstance().rollback();
			System.out.println("OracleProductsDao.java:4");
			e.printStackTrace();
			
			
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
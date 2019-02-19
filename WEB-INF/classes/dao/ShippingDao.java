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

public class ShippingDao extends AbstractDao{
	public void Shipping(int item_id){
		Connection cn = null;
		PreparedStatement st = null;
		System.out.println("AddItemDaoì‡ÅF1");
		ResultSet rs = null;

		try{
			
			
			
			cn = OracleConnectionManager.getInstance().getConnection();
			/*
			*/
			
			String sql = "update item_status set istatus_flag = 2  where istatus_id ="+item_id;
			st = cn.prepareStatement(sql);
				st.executeUpdate();
			
			
			
			
			
		}catch(SQLException e){
			System.out.println("OracleProductsDao(SQLException).java:1");
			e.printStackTrace();
			OracleConnectionManager.getInstance().rollback();
			
			
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("OracleProductsDao.java:ïsñæ");
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
}

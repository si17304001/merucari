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

public class MyPageEditDao extends AbstractDao{
	public void MyPageEdit(UserBean ub){
		Connection cn = null;
		PreparedStatement st = null;
		System.out.println("AddItemDaoì‡ÅF1");
		ResultSet rs = null;

		try{
			
			
			
			cn = OracleConnectionManager.getInstance().getConnection();
			
			
			/*
				ïœçXèÓïÒÇèëÇ´çûÇ›
			*/
			
				String	sql = "update users set user_nickname=?, user_name=?, user_zipcode=?, user_prefcode=?, user_address=? ,user_introduction = ? where user_id = ?";
					st = cn.prepareStatement(sql);
					st.setString(1,ub.getNickname());
					st.setString(2,ub.getName());
					st.setString(3,ub.getZip_code());
					st.setInt(4,ub.getPref_code());
					st.setString(5,ub.getAddress2());
					st.setString(6,ub.getUser_id());
					st.setString(7,ub.getIntroduction());
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

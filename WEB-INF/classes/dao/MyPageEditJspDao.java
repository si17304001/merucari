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


public class MyPageEditJspDao extends AbstractDao{
	
	public UserBean getMyPageEditJsp(String user_id){
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		UserBean ub = new UserBean();
		
		try{
			/*
			UserBeanÇ÷
			1.é©ï™ÇÃèÓïÒÇéÊìæ
			*/

			cn = OracleConnectionManager.getInstance().getConnection();
			//cn.setAutoCommit(false);
			
			
			//1
			String sql="select user_nickname ,user_name,user_zipcode,user_prefcode, user_address,user_introduction from users where user_id ="+user_id;
			st = cn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()){
				ub.setNickname(rs.getString(1));
				ub.setName(rs.getString(2));
				ub.setZip_code(rs.getString(3));
				ub.setPref_code(rs.getInt(4));
				ub.setAddress2(rs.getString(5));
				ub.setIntroduction(rs.getString(6));
				System.out.println("Mypage:1");
			}
			//SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME LIKE ('users');
//
			
			
			
			
			
			
			cn.commit();
	
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
	return ub;
	}
}
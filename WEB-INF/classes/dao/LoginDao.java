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

public class LoginDao extends AbstractDao{

public UserBean Login(UserBean u){
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		UserBean ub = new UserBean();
		try{
	
			cn = OracleConnectionManager.getInstance().getConnection();
			//cn.setAutoCommit(false);
			if(u.getEmail() == null){
				System.out.println("Ç»Ç¢");
			}
			//String sql = "select user_email,user_password,user_id,user_nickname  from users where user_email = ? and user_password = ?";
			String sql = "select user_email,user_password,user_id,user_nickname   from users where user_email = ? and user_password = ?";

			st = cn.prepareStatement(sql);
			
			if(st == null){
				System.out.println("stÇ»Ç¢");
			}
			
			st.setString(1,u.getEmail());
			st.setString(2,u.getPassword());
			
			/*
			System.out.println("getAll33333");
			st.executeUpdate();*/
				if(u.getPassword() == null){
				System.out.println("passÇ»Ç¢");
			}
			rs = st.executeQuery();
			if(rs == null){
				System.out.println("rsÇ»Ç¢");
			}
			System.out.println("getAll44444");
			while(rs.next()){
				
				ub.setEmail(rs.getString(1));
				ub.setPassword(rs.getString(2));
				ub.setUser_id(rs.getString(3));
				ub.setNickname(rs.getString(4));
				System.out.println("whileèIóπ");
				
				
			}
			System.out.println("em"+ub.getEmail());
			System.out.println("ni"+ub.getNickname());
			if(ub.getUser_id() == null){
				System.out.println("useridÇ»Ç¢");
			}
			System.out.println("getAll55555");
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



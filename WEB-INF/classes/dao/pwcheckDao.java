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

public class pwcheckDao extends AbstractDao{

public UserBean pwcheckDao(UserBean u){
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

			String sql = "select user_email from users where user_email = ? ";

			st = cn.prepareStatement(sql);
			
			if(st == null){
				System.out.println("stÇ»Ç¢");
			}
			
			st.setString(1,u.getEmail());

			

		
			rs = st.executeQuery();
			if(rs == null){
				System.out.println("rsÇ»Ç¢");
			}
			System.out.println("getAll44444");
			while(rs.next()){
				
				ub.setEmail(rs.getString(1));
		
				System.out.println("whileèIóπ");
				
				
			}
			System.out.println("em"+ub.getEmail());
	
		
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



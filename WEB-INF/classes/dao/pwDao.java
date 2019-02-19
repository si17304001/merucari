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

public class pwDao extends AbstractDao{
	public void pw(UserBean ub){
		Connection cn = null;
		PreparedStatement st = null;
		System.out.println("pwDao内：1");
		try{
			
			cn = OracleConnectionManager.getInstance().getConnection();
			
			
			String sql = "update users set user_password = ?  where user_email = ?";
			st = cn.prepareStatement(sql);
			System.out.println("pwDao内：2");
			
			
			st.setString(1,ub.getPassword());
			st.setString(2,ub.getEmail());
			if(ub.getEmail()== null){
				System.out.println("null");
			}
			System.out.println("pwDao内：3");
			st.executeUpdate();
			
			System.out.println("22222");
			cn.commit();
			
		/*}catch(ClassNotFoundException e){
			throw new ResourceAccessException(e.getMessage(), e);*/
		}catch(SQLException e){
			System.out.println("pwDao(SQLException).java:1");
			e.printStackTrace();
			OracleConnectionManager.getInstance().rollback();
			
			
			
		}catch(Exception e){
			System.out.println("pwDao.java:不明");
		}finally{
			try{
				if(st != null){
					st.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
				System.out.println("pwDao.java:2");
			}
			System.out.println("pwDao.java:3");
		}
	}
}
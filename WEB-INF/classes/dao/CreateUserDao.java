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

public class CreateUserDao extends AbstractDao{
	public void createUser(UserBean ub){
		Connection cn = null;
		PreparedStatement st = null;
		System.out.println("CreateUsersDao内：1");
		try{
			
			cn = OracleConnectionManager.getInstance().getConnection();
			
			
			String sql = "insert into users(user_id,user_nickname,user_name,user_zipcode,user_prefcode,user_address,user_email,user_password)"+"values(?,?,?,?,?,?,?,?)";
			st = cn.prepareStatement(sql);
			System.out.println("CreateUserDao内：2");
			
			st.setString(1,ub.getUser_id());
			st.setString(2,ub.getNickname());
			st.setString(3,ub.getName());
			st.setString(4,ub.getZip_code());
			st.setInt(5,ub.getPref_code());
			st.setString(6,ub.getAddress2());
			st.setString(7,ub.getEmail());
			st.setString(8,ub.getPassword());
			
			System.out.println("CreateUserDao内：3");
			st.executeUpdate();
			
			System.out.println("22222");
			//cn.commit();
			
		/*}catch(ClassNotFoundException e){
			throw new ResourceAccessException(e.getMessage(), e);*/
		}catch(SQLException e){
			System.out.println("CreateUserDao(SQLException).java:1");
			e.printStackTrace();
			OracleConnectionManager.getInstance().rollback();
			
			
			
		}catch(Exception e){
			System.out.println("CreateUserDao.java:不明");
		}finally{
			try{
				if(st != null){
					st.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
				System.out.println("CreateUserDao.java:2");
			}
			System.out.println("CreateUserDao.java:3");
		}
	}
}
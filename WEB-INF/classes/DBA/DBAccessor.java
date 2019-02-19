package DBA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import java.util.ArrayList;

public class DBAccessor{
	private static Connection cn;
	
	public void createConnection(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn = DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:orcl","info","pro");
			System.out.println("DBConected");
			cn.setAutoCommit(false);
		
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
		
		
	//ÉRÉlÉNÉVÉáÉìÇ?èÔ
	public Connection getConnection(){
			createConnection();
		return cn;
	}
	//ÉÜÅ[ÉUÅ[ìoò^
	public void userRegist(String ui, String nn, String n, String zc, int pc, String add, String em, String ps){
		try{
			
			String sql = "insert into users(user_id, nickname, name, zip_code, pref_code, address, email, password)values('"+ui+"','"+nn+"','"+n+"','"+zc+"','"+pc+"','"+add+"','"+em+"','"+ps+"')";
			
			getConnection();
		
			Statement st = cn.createStatement();
			st.executeUpdate(sql);
			cn.commit();
			st.close();
			cn.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	//ÉçÉOÉCÉìéû
	public UserBean login(String e, String p){
		String sql = "select user_id, nickname from users where email='"+e+"' and password='"+p+"'";
		UserBean ub = new UserBean();
		try{
			getConnection();
		
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			try{
				rs.next();
				ub.setUser_id(rs.getString(1));
				ub.setNickname(rs.getString(2));
			}catch(SQLException){
				e.printStackTrace();
				return "";
			}catch(Exception e){
				e.printStackTrace();
			}
			
			cn.commit();
			st.close();
			cn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return ub;
	}
	
}       
        
        
        
        

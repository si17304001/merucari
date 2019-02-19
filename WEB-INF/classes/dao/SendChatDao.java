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

public class SendChatDao extends AbstractDao{
	public void SendChat(ResBean rb){
		Connection cn = null;
		PreparedStatement st = null;
		System.out.println("AddItemDao内：1");
		ResultSet rs = null;

		
		/*
			DBのテーブル定義が違う(作り直し必要)
		*/
		try{
			
			
			
			cn = OracleConnectionManager.getInstance().getConnection();
			
			String sql = "insert into chat(chat_itemid,chat_userid,chat_content)"+"values(?,?,?)";
			st = cn.prepareStatement(sql);
			System.out.println("AddItemDao内：2-1");
			st.setInt(1,rb.getItemid());
			st.setString(2,rb.getUserid());
			st.setString(3,rb.getContent());
			st.executeUpdate();
			System.out.println("終了");
			
			
			
			
		}catch(SQLException e){
			System.out.println("OracleProductsDao(SQLException).java:1");
			e.printStackTrace();
			OracleConnectionManager.getInstance().rollback();
			
			
			
		}catch(Exception e){
			e.printStackTrace();
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
}

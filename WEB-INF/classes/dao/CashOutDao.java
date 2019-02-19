package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import exp.*;
import bean.*;
import exp.ResourceAccessException;


public class CashOutDao extends AbstractDao{
	
	public void cashOut(String user_id, int amount)throws CashOutException{
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{

			
			/*
			所持ポイントと比較
			出金しても0より大きければ可・小さいと不可
			*/
			System.out.println("LikeDao内スタート");
			cn = OracleConnectionManager.getInstance().getConnection();
			//cn.setAutoCommit(false);
			String sql = "select user_point from users where user_id="+user_id;
			st = cn.prepareStatement(sql);
			System.out.println("getAll33333");
			rs = st.executeQuery();
			System.out.println("getAll44444");
			int up = 0;
			while(rs.next()){
				up = rs.getInt(1);
				if((up -= amount)< 0){
					throw new Exception("<h1>所持ポイントを超えて出金することはできません</h1>");
				}
			}
				
			sql ="update users set user_point ="+up+"  where user_id = "+user_id;
			st = cn.prepareStatement(sql);
			st.executeUpdate();
			
			System.out.println("getAll55555");
			cn.commit();
			
			
		}catch(SQLException e){
			OracleConnectionManager.getInstance().rollback();
			throw new CashOutException("<h1>出金できませんでした</h1>",e);
		}catch(CashOutException e){
			OracleConnectionManager.getInstance().rollback();
			throw e;
		}catch(Exception e){
			OracleConnectionManager.getInstance().rollback();
			throw new CashOutException("<h1>出金できませんでした</h1>",e);
		}finally{
			try{
				if(st != null){
					st.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
				System.out.println("LikeDao.java:5");
			}
			System.out.println("LikeDao.java:6");
		}
		
		
		System.out.println("LikeDao終了");
	}
}
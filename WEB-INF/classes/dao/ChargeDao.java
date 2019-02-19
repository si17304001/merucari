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

public class ChargeDao extends AbstractDao{
	public void ChargePoint(ItemBean ib){
		Connection cn = null;
		PreparedStatement st = null;
		System.out.println("AddItemDao内：1");
		ResultSet rs = null;

		try{
			
			
			
			cn = OracleConnectionManager.getInstance().getConnection();
			
			
			
			/*
			①Dealにチャージの詳細を書き込み※チャージはdeal_flagがUserID
			②ユーザーポイントを取得
			③チャージした額を加算
			*/
			
			//①
			String sql = "insert into deal(deal_id,deal_amount,deal_flag,deal_commission,deal_received)"+"values(99999,?,?,?,?)";
			st = cn.prepareStatement(sql);
			System.out.println("AddItemDao内：2-1");
			st.setInt(1,ib.getPrice());
			st.setString(2,ib.getBuyerId());
			st.setInt(3,0);
			st.setInt(4,ib.getPrice());
			st.executeUpdate();
			System.out.println("deal終了");
			
			st=null;
			
			//②
			sql = "select user_point from users where user_id = ?";
			st = cn.prepareStatement(sql);
			st.setString(1,ib.getBuyerId());
			rs = st.executeQuery();
			int up = 0;
			while(rs.next()){
				 up = rs.getInt(1);
				up+=ib.getPrice();
			}
			
			System.out.println("ユーザーポイント取得");
			
			st=null;
			
			
			//③
			sql = "update users set user_point ="+up+"  where user_id = ?";
			st = cn.prepareStatement(sql);
				st.setString(1,ib.getBuyerId());
				st.executeUpdate();
			
			
			
			
			
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

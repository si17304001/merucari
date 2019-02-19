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


public class UserPageDao extends AbstractDao{
	
	public MyPageBean getUserPage(String user_id){
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		MyPageBean mp = new MyPageBean();
		
		try{
			/*
			MyPageBeanへ
			1.対象ユーザーの情報を取得
			①名前、評価をセット
			
			2.List
			①対象ユーザーが出品している商品を表示
			*/

			cn = OracleConnectionManager.getInstance().getConnection();
			//cn.setAutoCommit(false);
			
			
			//1
			String sql="select user_nickname ,user_good, user_normal, user_bad, user_introduction from users where user_id ="+user_id;
			st = cn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()){
				UserBean ub = new UserBean();
				ub.setNickname(rs.getString(1));
				ub.setGood(rs.getInt(2));
				ub.setGeneral(rs.getInt(3));
				ub.setBad(rs.getInt(4));
				ub.setIntroduction(rs.getString(5));
				mp.setUb(ub);
				System.out.println("UserPage:1");
			}
			//SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME LIKE ('users');
//
			
			
			
			//2-1
			sql="select i.item_id, i.item_name, i.item_image1, i.item_price, i.item_available from items i join trade_info t on i.item_id = t.tinfo_itemid where tinfo_salerid =" +user_id;
			
			st = cn.prepareStatement(sql);
			rs = st.executeQuery();
			ArrayList arr = new ArrayList();
			while(rs.next()){
				ItemBean ib = new ItemBean();
				ib.setItem_id(rs.getInt(1));
				ib.setName(rs.getString(2));
				ib.setImage1(rs.getString(3));
				ib.setPrice(rs.getInt(4));
				ib.setAvailable(rs.getInt(5));
				arr.add(ib);
				System.out.println("Mypage:2");
			}
			mp.setSList(arr);
			
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
	return mp;
	}
}
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


public class MyPageDao extends AbstractDao{
	
	public MyPageBean getMyPage(String user_id){
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		MyPageBean mp = new MyPageBean();
		
		try{
			/*
			MyPageBeanへ
			1.自分の情報を取得
			①名前、評価、所持ポイント数をセット
			
			2.List
			①自分が出品者&ItemStatusが0の物をsListリストへ(出品中)
			②自分が出品者&ItemStatusが1~5の物をstListへ（取引中）
			③自分が出品者&ItemStatusが6の物をscListへ（取引完了）
			④自分が購入者&Itemstatusが1~5の物をbtListへ（取引中）
			⑤自分が購入者&ItemStatusが６の物をbcListへ（取引完了）
			⑥Dealから自分のやり取りのみを取得dListへ
			*/

			cn = OracleConnectionManager.getInstance().getConnection();
			//cn.setAutoCommit(false);
			
			
			//1
			String sql="select user_nickname ,user_good, user_normal, user_bad, user_point,user_introduction from users where user_id ="+user_id;
			st = cn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()){
				UserBean ub = new UserBean();
				ub.setNickname(rs.getString(1));
				ub.setGood(rs.getInt(2));
				ub.setGeneral(rs.getInt(3));
				ub.setBad(rs.getInt(4));
				ub.setUser_point(rs.getInt(5));
				ub.setIntroduction(rs.getString(6));
				mp.setUb(ub);
				System.out.println("Mypage:1");
			}
			//SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME LIKE ('users');
//
			
			
			
			//2-1
			sql="select i.item_id,i.item_name,i.item_image1,i.item_price from items i join trade_info t on i.item_id = t.tinfo_itemid where item_available = 0 and tinfo_salerid =" +user_id;
			
			st = cn.prepareStatement(sql);
			rs = st.executeQuery();
			ArrayList arr = new ArrayList();
			while(rs.next()){
				ItemBean ib = new ItemBean();
				ib.setItem_id(rs.getInt(1));
				ib.setName(rs.getString(2));
				ib.setImage1(rs.getString(3));
				ib.setPrice(rs.getInt(4));
				arr.add(ib);
				System.out.println("Mypage:2");
			}
			mp.setSList(arr);
			arr = null;
			arr = new ArrayList();
			
			
			//2-2
			sql = "select i.item_id,i.item_name,i.item_image1,i.item_price from (items i join trade_info t on i.item_id = t.tinfo_itemid) join item_status it on i.item_id = it.istatus_id where item_available = 1 and istatus_flag  between 1and 5 and t.tinfo_salerid = "+user_id;
			
			st = cn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()){
				ItemBean ib = new ItemBean();
				ib.setItem_id(rs.getInt(1));
				ib.setName(rs.getString(2));
				ib.setImage1(rs.getString(3));
				ib.setPrice(rs.getInt(4));
				arr.add(ib);
				System.out.println("Mypage:3");
			}
			mp.setStList(arr);
			arr = null;
			arr = new ArrayList();
			
			
			
			//2-3
			sql="select i.item_id,i.item_name,i.item_image1,i.item_price from (items i join trade_info t on i.item_id = t.tinfo_itemid) join item_status it on i.item_id = it.istatus_id where item_available = 1 and istatus_flag = 6 and t.tinfo_salerid = "+user_id;
			
			st = cn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()){
				ItemBean ib = new ItemBean();
				ib.setItem_id(rs.getInt(1));
				ib.setName(rs.getString(2));
				ib.setImage1(rs.getString(3));
				ib.setPrice(rs.getInt(4));
				arr.add(ib);
				System.out.println("Mypage:4");
			}
			mp.setScList(arr);
			arr = null;
			arr = new ArrayList();
			
			
			//2-4
			sql="select i.item_id,i.item_name,i.item_image1,i.item_price from (items i join trade_info t on i.item_id = t.tinfo_itemid) join item_status it on i.item_id = it.istatus_id where item_available = 1 and istatus_flag  between 1and 5 and t.tinfo_buyerid = "+user_id;
			
			st = cn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()){
				ItemBean ib = new ItemBean();
				ib.setItem_id(rs.getInt(1));
				ib.setName(rs.getString(2));
				ib.setImage1(rs.getString(3));
				ib.setPrice(rs.getInt(4));
				arr.add(ib);
				System.out.println("Mypage:5");
			}
			mp.setBtList(arr);
			arr = null;
			arr = new ArrayList();
			
			
			//2-5
			sql="select i.item_id,i.item_name,i.item_image1,i.item_price from (items i join trade_info t on i.item_id = t.tinfo_itemid) join item_status it on i.item_id = it.istatus_id where item_available = 1 and istatus_flag = 6 and t.tinfo_buyerid ="+user_id;
			
			st = cn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()){
				ItemBean ib = new ItemBean();
				ib.setItem_id(rs.getInt(1));
				ib.setName(rs.getString(2));
				ib.setImage1(rs.getString(3));
				ib.setPrice(rs.getInt(4));
				arr.add(ib);
				System.out.println("Mypage:6");
				
			}
			mp.setBcList(arr);
			arr = null;
			arr = new ArrayList();
			
			//2-6
			sql="select d.deal_amount,d.deal_completiondate,t.tinfo_buyerid,t.tinfo_salerid,d.deal_flag from(deal d join items i on d.deal_id = i.item_id) join trade_info t on d.deal_id = t.tinfo_itemid where tinfo_buyerid = "+user_id+" or tinfo_salerid ="+user_id;
			
			st = cn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()){
				DealBean db = new DealBean();
				db.setAmount(rs.getInt(1));
				db.setDate(rs.getString(2));
				String bi = rs.getString(3);
				String si = rs.getString(4);
				String f = rs.getString(5);
				if(f == null){
					if(bi.equals(user_id)){
						db.setFlag(1);
					}else if(si.equals(user_id)){
						db.setFlag(2);
					}
				}else{
					db.setFlag(3);
				}
				arr.add(db);
				System.out.println("Mypage:7");
			}
			mp.setDList(arr);
			arr = null;
			arr = new ArrayList();
			
			
			
			
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
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

public class BuyItemDao extends AbstractDao{
	public void BuyItem(ItemBean ib)throws BuyException{
		Connection cn = null;
		PreparedStatement st = null;
		System.out.println("AddItemDao内：1");
		ResultSet rs = null;
		UserBean ub = new UserBean();

		try{
			
			
			
			cn = OracleConnectionManager.getInstance().getConnection();
			
			
			/*
				所持ポイントが不足していないかどうかの確認
			*/
			String sql ="select item_price from items where item_id= ?";
			st = cn.prepareStatement(sql);
			st.setInt(1,ib.getItem_id());
			rs = st.executeQuery();
			int ip = 0;
			while(rs.next()){
				 ip = rs.getInt(1);
			}
			
			ib.setPrice(ip);
			
			
			sql = "select user_point from users where user_id = ?";
			st = cn.prepareStatement(sql);
			st.setString(1,ib.getBuyerId());
			rs = st.executeQuery();
			System.out.println("getAll44444");
			int up = 0;
			while(rs.next()){
				 up = rs.getInt(1);
			}
			System.out.println("アイテム価格"+ip);
			System.out.println("所持ポイント"+up);
			System.out.println("差引額"+(up - ip));
			if((up - ip) < 0){
				throw new Exception("残高不足のため購入できません");
			}else{
				sql = "update users set user_point = "+(up - ip)+" where user_id = ?";
				st = cn.prepareStatement(sql);
				st.setString(1,ib.getBuyerId());
				st.executeUpdate();
			}
			
			
			
			
			/*
			TradeInfoから出品者でないことを確認する(おなじだったらExceptionをThrow)
				TradeInfoに購入者情報を書き込み
			*/
			
			sql="select tinfo_salerid from trade_info where tinfo_itemid= ?";
			st = cn.prepareStatement(sql);
			st.setInt(1,ib.getItem_id());
			rs = st.executeQuery();
			String saler=null;
			while(rs.next()){
				saler = rs.getString(1);
			}
			System.out.println(saler);
			String user = ib.getBuyerId();
			System.out.println(ib.getBuyerId());
			if(saler.equals(user)){
				throw new Exception("<h1>出品者のため購入できません</h1>");
			}else{}
			
			
			sql = "update trade_info set tinfo_buyerid = ? where tinfo_itemid = ?";
			st = cn.prepareStatement(sql);
			System.out.println("AddItemDao内：211111");
			st.setString(1,ib.getBuyerId());
			st.setInt(2,ib.getItem_id());
			st.executeUpdate();
			
			/*
				item_statusに取引の状態を書き込み
				st.setInt(3,1) 1発送待ち、2受け取り待ち、３評価待ち（2の時点でポイントは移動する）
			*/
			sql = "insert into item_status(istatus_id, istatus_amount, istatus_flag)"+"values(?,?,?)";
			st = cn.prepareStatement(sql);
			System.out.println("AddItemDao内：2-1");
			st.setInt(1,ib.getItem_id());
			st.setInt(2,ib.getPrice());
			st.setInt(3,1);
			st.executeUpdate();
			
			/*
				itemを購入不可に変更
			*/
			
			sql = "update items set item_available = 1 where item_id = ?";
			st = cn.prepareStatement(sql);
			System.out.println("AddItemDao内：2-1");
			st.setInt(1,ib.getItem_id());
			st.executeUpdate();
			
			
			
			System.out.println("AddItemDao内：2-1-2");
			
			
			System.out.println("AddItemDao内：Itemsにインサート完了");
			


		}catch(SQLException e){
			OracleConnectionManager.getInstance().rollback();
			e.printStackTrace();
			throw new BuyException("購入に失敗しました、残高、販売状況を再度確認してください。",e);
		}catch(BuyException e){
			OracleConnectionManager.getInstance().rollback();
			e.printStackTrace();
			throw e;
		}catch(Exception e){
			OracleConnectionManager.getInstance().rollback();
			e.printStackTrace();
			throw new BuyException("購入に失敗しました、残高、販売状況を再度確認してください。",e);
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

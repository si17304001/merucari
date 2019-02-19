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

public class AddItemDao extends AbstractDao{
	public void addProduct(ItemBean ib){
		Connection cn = null;
		PreparedStatement st = null;
		System.out.println("AddItemDao内：1");
		try{
			
			cn = OracleConnectionManager.getInstance().getConnection();
			
			
			/*
				Itemsに書き込み
				TradeInfoに書き込み
				ItemStatusに書きこみ
			*/
			
			String sql = "insert into items(item_id,item_category,item_name,item_image1,item_description,item_state,item_postage,item_price)"+"values(?,?,?,?,?,?,?,?)";
			st = cn.prepareStatement(sql);
			System.out.println("AddItemDao内：211111");
			
			st.setInt(1,ib.getItem_id());
			st.setInt(2,ib.getCategory());
			st.setString(3,ib.getName());
			st.setString(4,ib.getImage1());
			st.setString(5,ib.getDescription());
			st.setInt(6,ib.getState());
			//st.setString(5,ib.getSize());
			st.setInt(7,ib.getPostage());
			st.setInt(8,ib.getPrice());
			
			
			System.out.println("AddItemDao内：2-1");
			st.executeUpdate();
			
			System.out.println("AddItemDao内：2-1-2");
			
			
			System.out.println("AddItemDao内：Itemsにインサート完了");
			st = null;
			
			
			String sql2="insert into trade_info(tinfo_salerid,tinfo_itemid)"+"values(?,?)";
			
			st = cn.prepareStatement(sql2);
			st.setString(1,ib.getSalerId());
			st.setInt(2,ib.getItem_id());
			st.executeUpdate();
			System.out.println("trade_info完了");
			st = null;
			
			sql2 = "insert into item_status(istatus_id,istatus_amount,istatus_flag)"+"values(?,?,'1')";
			st.setInt(1,ib.getItem_id());
			st.setInt(2,ib.getPrice());
			st.executeUpdate();
			
			System.out.println("item_status完了");
			
			
			
			
			
			System.out.println("AddItemDao内：2-2");
			
			System.out.println("AddItemDao内出品完了");
			
			
			System.out.println("22222");
			//cn.commit();
			
		/*}catch(ClassNotFoundException e){
			throw new ResourceAccessException(e.getMessage(), e);*/
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
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


public class ItemEditJspDao extends AbstractDao{
	
	public ItemBean ItemEditJsp(String item_id,String user_id){
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ItemBean ib = new ItemBean();
		try{

			System.out.println("ItemEditJspDao内スタート");
			cn = OracleConnectionManager.getInstance().getConnection();
			
			String sql = "select item_available from items where item_id="+item_id;
			st = cn.prepareStatement(sql);
			rs = st.executeQuery();
			
			while(rs.next()){
				int i = rs.getInt(1);
				if(i == 1){
					System.out.println("購入されていて編集できないアイテムです");
					throw new Exception();
				}
			}
			
			sql = "select tinfo_salerid from trade_info where tinfo_itemid = "+item_id;
			st = cn.prepareStatement(sql);
			rs = st.executeQuery();
			
			while(rs.next()){
				String user = rs.getString(1);
				if(!(user.equals(user_id))){
					System.out.println("商品情報を編集できるのは出品したユーザーのみです");
					throw new Exception();
				}
			}
			
			
			//cn.setAutoCommit(false);
			sql = "select item_id,item_image1,item_name,item_price, item_shipping,item_state,item_description from items where item_id = ?";
			
			st = cn.prepareStatement(sql);
			System.out.println("getAll33333");
			st.setInt(1,Integer.parseInt(item_id));
			rs = st.executeQuery();
			System.out.println("getAll44444");

				
			while(rs.next()){
				ib.setItem_id(rs.getInt(1));
				ib.setImage1(rs.getString(2));
				ib.setName(rs.getString(3));
				ib.setPrice(rs.getInt(4));
				ib.setShipping(rs.getInt(5));
				ib.setState(rs.getInt(6));
				ib.setDescription(rs.getString(7));
			}
			
			System.out.println("getAll55555");
			cn.commit();
		
		/*}catch(ClassNotFoundException e){
			throw new ResourceAccessException(e.getMessage(), e);*/
		}catch(SQLException e){
			OracleConnectionManager.getInstance().rollback();
			System.out.println("OracleProductsDao.java:4");
			e.printStackTrace();
			
			
		}catch(Exception e){
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
		
		if(ib == null){
			System.out.println("nullだよ");
		}
		System.out.println("ItemEditJspDao終了");
	return ib;
	}
}
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


public class GetDetailDao extends AbstractDao{
	
	public ItemBean getDetail(String item_id,String user_id){
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ItemBean ib = new ItemBean();
		try{

			System.out.println("GetDetailDao内スタート");
			cn = OracleConnectionManager.getInstance().getConnection();
			//cn.setAutoCommit(false);
			String sql = "select item_id,item_image1,item_name,item_price, item_available,item_shipping,item_state,item_description from items where item_id = ?";
			
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
				ib.setAvailable(rs.getInt(5));
				ib.setShipping(rs.getInt(6));
				ib.setState(rs.getInt(7));
				ib.setDescription(rs.getString(8));
			}
				
				System.out.println("dadada");
			
			
			sql = "select tinfo_buyerid, tinfo_salerid from trade_info where tinfo_itemid="+item_id;
			st = cn.prepareStatement(sql);
				rs = st.executeQuery();
			System.out.println("getAll44444");

			String saler= null;
			while(rs.next()){
					if(rs.getString(1)==null){
						ib.setBuyerId("0");	
					}else{
						ib.setBuyerId(rs.getString(1));
					}
				saler=rs.getString(2);
				ib.setSalerId(saler);
			}
			
			sql="select user_nickname,user_good,user_normal,user_bad,user_prefcode from users where user_id= ?";
			st = cn.prepareStatement(sql);
			st.setString(1,saler);
			rs = st.executeQuery();
			System.out.println("セラー情報取得");
			while(rs.next()){
				ib.setSalerNickname(rs.getString(1));
				ib.setSalerGood(rs.getInt(2));
				ib.setSalerNormal(rs.getInt(3));
				ib.setSalerBad(rs.getInt(4));
				ib.setPrefcode(rs.getInt(5));
			}
			
			sql="select likes_endisable from likes where likes_userid= "+user_id+" and likes_itemid ="+item_id;
			st = cn.prepareStatement(sql);
			rs = st.executeQuery();
			int li = 0;
			while(rs.next()){
				li = rs.getInt(1);
			}
			ib.setLike(li);
			
			
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
		System.out.println("GetDetailDao終了");
	return ib;
	}
}
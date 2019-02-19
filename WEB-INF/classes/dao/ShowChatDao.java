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


public class ShowChatDao extends AbstractDao{
	
	public ChatBean getAllChat(int id, String userid){
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ChatBean cb = new ChatBean();
		
		ArrayList chats = new ArrayList();
		try{
			
			cn = OracleConnectionManager.getInstance().getConnection();
			
			String sql = "select tinfo_buyerid, tinfo_salerid from trade_info where tinfo_itemid="+ id;
			st = cn.prepareStatement(sql);
			rs = st.executeQuery();
			String buyerid=null;
			String salerid=null;
			while(rs.next()){
				buyerid = rs.getString(1);
				salerid = rs.getString(2);
				System.out.println("dadada");
			}
			
			if((buyerid==null||salerid==null)||!(buyerid.equals(userid)|| salerid.equals(userid))){
				throw new SQLException();
			}
			
			
			
			sql = "select istatus_flag from item_status where istatus_id ="+id;
			st = cn.prepareStatement(sql);
			System.out.println("getAll33333");
			rs = st.executeQuery();
			System.out.println("getAll44444");
			int status;
			
			while(rs.next()){
				status = rs.getInt(1);
				cb.setBtnava(1);
				//ƒ{ƒ^ƒ“‚ÌON/OFF‚ð”»’è‚·‚é
				if(status == 1){
					if(buyerid.equals(userid)){
						cb.setBtnava(0);
					}
				}else if(status == 2){
					if(salerid.equals(userid)){
						cb.setBtnava(0);
					}
				}else if(status == 4){
					if(salerid.equals(userid)){
						cb.setBtnava(0);
					}
				}else if(status == 5){
					if(buyerid.equals(userid)){
						cb.setBtnava(0);
					}
				}
				
				
				System.out.println("dadada");
				cb.setFlag(status);
			}
			
			System.out.println("getAll55555");

			//cn.setAutoCommit(false);
			sql = "select chat_userid,chat_content,chat_date from chat where chat_itemid ="+id;
			st = cn.prepareStatement(sql);
			System.out.println("getAll33333");
			rs = st.executeQuery();
			System.out.println("getAll44444");
			while(rs.next()){
				ResBean rb = new ResBean();
				rb.setUserid(rs.getString(1));
				rb.setContent(rs.getString(2));
				System.out.println(rs.getString(2));
				rb.setTimestamp(rs.getString(3));
				
				chats.add(rb);
				System.out.println("dadada");
			}
			
			cb.setResList(chats);
			cb.setItemid(id);
		
			System.out.println("getAll55555");
			cn.commit();
		
		/*}catch(ClassNotFoundException e){
			throw new ResourceAccessException(e.getMessage(), e);*/
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
	return cb;
	}
}
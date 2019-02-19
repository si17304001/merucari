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


public class LikeDao extends AbstractDao{
	
	public void Like(String item_id,String user_id){
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ItemBean ib = new ItemBean();
		try{

			
			/*
			Like(いいねに書きこみ)
			①テーブルにレコードがあるか確認
			②あったらLikeの値を確認/なかったらInsert
			③0なら1に1なら0にUpdate
			*/
			System.out.println("LikeDao内スタート");
			cn = OracleConnectionManager.getInstance().getConnection();
			//cn.setAutoCommit(false);
			String sql = "select likes_endisable from likes where likes_userid="+user_id+"and likes_itemid="+item_id;
			st = cn.prepareStatement(sql);
			System.out.println("getAll33333");
			rs = st.executeQuery();
			System.out.println("getAll44444");
			
			int count = 0;
			int li = 0;
			while(rs.next()){
				ib.setLike(rs.getInt(1));
				count += 1;
			}
			
			if(count == 0){
				sql="insert into likes(likes_userid,likes_itemid,likes_endisable)"+"values(?,"+item_id+","+1+")";
				st =cn.prepareStatement(sql);
				st.setString(1,user_id);
				st.executeUpdate();
			}else{
				if(ib.getLike() == 1){
					li = 0;
				}else if(ib.getLike() == 0){
					li = 1;
				}else{
					System.out.println("存在しない値が入力されています");
					throw new Exception();
				}
				
				sql ="update likes set likes_endisable ="+li+"  where likes_userid = "+user_id+"and likes_itemid = "+item_id;
				st = cn.prepareStatement(sql);
				st.executeUpdate();
			}
				
			
			
			
			System.out.println("getAll55555");
			cn.commit();
		
		/*}catch(ClassNotFoundException e){
			throw new ResourceAccessException(e.getMessage(), e);*/
		}catch(SQLException e){
			OracleConnectionManager.getInstance().rollback();
			System.out.println("LikeDao.java:4");
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
				System.out.println("LikeDao.java:5");
			}
			System.out.println("LikeDao.java:6");
		}
		
		if(ib == null){
			System.out.println("nullだよ");
		}
		System.out.println("LikeDao終了");
	}
}
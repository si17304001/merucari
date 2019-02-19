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
		System.out.println("AddItemDao���F1");
		ResultSet rs = null;
		UserBean ub = new UserBean();

		try{
			
			
			
			cn = OracleConnectionManager.getInstance().getConnection();
			
			
			/*
				�����|�C���g���s�����Ă��Ȃ����ǂ����̊m�F
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
			System.out.println("�A�C�e�����i"+ip);
			System.out.println("�����|�C���g"+up);
			System.out.println("�����z"+(up - ip));
			if((up - ip) < 0){
				throw new Exception("�c���s���̂��ߍw���ł��܂���");
			}else{
				sql = "update users set user_point = "+(up - ip)+" where user_id = ?";
				st = cn.prepareStatement(sql);
				st.setString(1,ib.getBuyerId());
				st.executeUpdate();
			}
			
			
			
			
			/*
			TradeInfo����o�i�҂łȂ����Ƃ��m�F����(���Ȃ���������Exception��Throw)
				TradeInfo�ɍw���ҏ�����������
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
				throw new Exception("<h1>�o�i�҂̂��ߍw���ł��܂���</h1>");
			}else{}
			
			
			sql = "update trade_info set tinfo_buyerid = ? where tinfo_itemid = ?";
			st = cn.prepareStatement(sql);
			System.out.println("AddItemDao���F211111");
			st.setString(1,ib.getBuyerId());
			st.setInt(2,ib.getItem_id());
			st.executeUpdate();
			
			/*
				item_status�Ɏ���̏�Ԃ���������
				st.setInt(3,1) 1�����҂��A2�󂯎��҂��A�R�]���҂��i2�̎��_�Ń|�C���g�͈ړ�����j
			*/
			sql = "insert into item_status(istatus_id, istatus_amount, istatus_flag)"+"values(?,?,?)";
			st = cn.prepareStatement(sql);
			System.out.println("AddItemDao���F2-1");
			st.setInt(1,ib.getItem_id());
			st.setInt(2,ib.getPrice());
			st.setInt(3,1);
			st.executeUpdate();
			
			/*
				item���w���s�ɕύX
			*/
			
			sql = "update items set item_available = 1 where item_id = ?";
			st = cn.prepareStatement(sql);
			System.out.println("AddItemDao���F2-1");
			st.setInt(1,ib.getItem_id());
			st.executeUpdate();
			
			
			
			System.out.println("AddItemDao���F2-1-2");
			
			
			System.out.println("AddItemDao���FItems�ɃC���T�[�g����");
			


		}catch(SQLException e){
			OracleConnectionManager.getInstance().rollback();
			e.printStackTrace();
			throw new BuyException("�w���Ɏ��s���܂����A�c���A�̔��󋵂��ēx�m�F���Ă��������B",e);
		}catch(BuyException e){
			OracleConnectionManager.getInstance().rollback();
			e.printStackTrace();
			throw e;
		}catch(Exception e){
			OracleConnectionManager.getInstance().rollback();
			e.printStackTrace();
			throw new BuyException("�w���Ɏ��s���܂����A�c���A�̔��󋵂��ēx�m�F���Ă��������B",e);
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

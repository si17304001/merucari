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

public class EvaluationDao extends AbstractDao{
	public void Evaluation(int id,String ud,String eval){
		Connection cn = null;
		PreparedStatement st = null;
		System.out.println("AddItemDao���F1");
		ResultSet rs = null;

		try{
			
			
			
			cn = OracleConnectionManager.getInstance().getConnection();
			
			
			
			/*
			�@istatus��Flag��3�ł��邱�Ƃ��m�F
			�ATradeInfo���玩�����w���ҁA�܂��͏o�i�҂ł��邱�Ƃ��m�F
			�BSaler/Buyer�ǂ��炩���m�F������ɕ]������������
			*/
			
			
			//�@
			String sql ="select istatus_flag from item_status where istatus_id="+id;
			st = cn.prepareStatement(sql);
			rs = st.executeQuery();
			int istatus = 0;
			while(rs.next()){
				istatus = rs.getInt(1);
			}
			if(istatus == 3 ||istatus == 4 || istatus == 5){
				//�A
				sql = "select tinfo_buyerid, tinfo_salerid from trade_info where tinfo_itemid="+id;
				st = cn.prepareStatement(sql);
				rs = st.executeQuery();
				String buyer="";
				String saler="";
				String tp="";
				
				while(rs.next()){
					buyer = rs.getString(1);
					saler = rs.getString(2);
				}
				//�B
				//4�Ȃ�Saler�̂ݕ]���ς݁A5�Ȃ�Buyer�̂ݕ]���ς�,6�Ȃ�Ƃ��ɕ]���ς�
				if(buyer.equals(ud)){
					if(istatus == 5){
						System.out.println("���łɕ]�����Ă��܂�");
						throw new Exception();
					}else if(istatus == 4){
						tp = saler;
						istatus = 6;
					}else if(istatus == 3){
						tp = saler;
						istatus = 5;
					}
					
				}else if(saler.equals(ud)){
					if(istatus == 4){
						System.out.println("�o�i�҂Ƃ��Ă��łɕ]�����Ă��܂��B");
						throw new Exception();
					}else if(istatus == 5){
						tp = buyer;
						istatus = 6;
					}else if(istatus == 3){
						tp = buyer;
						istatus = 4;
					}
				}else{
					System.out.println("�o�i�ҁA�w���҂ǂ���ł��Ȃ����ߕ]���ł��܂���B");
					throw new Exception();
				}
				
				sql = "select user_bad,user_normal,user_good from users where user_id = "+tp;
					st = cn.prepareStatement(sql);
					rs = st.executeQuery();
					int bad=0;	
					int normal=0;
					int good=0;
					while(rs.next()){
						bad = rs.getInt(1);
						normal = rs.getInt(2);
						good = rs.getInt(3);
					}
				System.out.println(ud+"�̂�邢"+bad);
				System.out.println(ud+"�̂ӂ�"+normal);
				System.out.println(ud+"�̂悢"+good);
				
				System.out.println("update users set user_bad = "+bad+"where user_id="+tp);
				if(eval.equals("1")){
					bad += 1;
					sql = "update users set user_bad = "+bad+"where user_id="+tp;
				}else if(eval.equals("2")){
					normal += 1;
					sql = "update users set user_normal = "+normal+"where user_id="+tp;;
				}else if(eval.equals("3")){
					good += 1;
					sql = "update users set user_good = "+good+"where user_id="+tp;;
				}else{
					System.out.println("�����ȕ]���ł�");
					throw new Exception();
				}
				st = cn.prepareStatement(sql);
				st.executeUpdate();

				sql="update item_status set istatus_flag = "+istatus+" where istatus_id ="+id;
				st = cn.prepareStatement(sql);
				st.executeUpdate();
					
			}else{
				System.out.println("������������Ă��Ȃ����]���ς݂̂��ߕ]���ł��܂���");
				throw new Exception();
			}
			
			
			
			
		}catch(SQLException e){
			System.out.println("OracleProductsDao(SQLException).java:1");
			e.printStackTrace();
			OracleConnectionManager.getInstance().rollback();
			
			
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("OracleProductsDao.java:�s��");
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

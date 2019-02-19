package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import calculation.*;


import bean.*;
import exp.ResourceAccessException;

public class ReceiptDao extends AbstractDao{
	public void Receipt(int item_id){
		Connection cn = null;
		PreparedStatement st = null;
		System.out.println("AddItemDao���F1");
		ResultSet rs = null;

		try{
			
			
			cn = OracleConnectionManager.getInstance().getConnection();
			/*
			�@�A�C�e���̏�Ԃ�3(�󂯎�芮���ɕύX)
			�A������������Ƃ���Deal�֏�������(�萔�ʓ������ׂČv�Z����������)
			�B�|�C���g��̔��҂̃A�J�E���g�։��Z(�萔�����������z+���Ƃ��珊�����Ă����|�C���g��) 
			*/
			
			String sql ="select istatus_flag from item_status where istatus_id="+item_id;
			st = cn.prepareStatement(sql);
			rs = st.executeQuery();
			int flag = 0;
			while(rs.next()){
				flag = rs.getInt(1);
			}
			
			if(flag == 2){
				sql = "update item_status set istatus_flag = 3 where istatus_id = "+item_id;
				st = cn.prepareStatement(sql);
				st.executeUpdate();
			
				System.out.println("AddItemDao���F2");
				
				
				
				//�A(�̔��ҁA�w���҂��擾�����i�̋��z���擾���萔�����v�Z��Deal�֏�������)
				sql = "select tinfo_salerid, tinfo_buyerid from trade_info where tinfo_itemid ="+item_id;
				st = cn.prepareStatement(sql);
				rs = st.executeQuery();
				String salerid = null;
				String buyerid = null;
				while(rs.next()){
					salerid  = rs.getString(1);
					buyerid  = rs.getString(2);
				}
				
					System.out.println("AddItemDao���F3");
					sql = "select istatus_amount from item_status where istatus_id = "+item_id;
					st = cn.prepareStatement(sql);
					rs = st.executeQuery();
					int price = 0;
					while(rs.next()){
						price = rs.getInt(1);
					}
						
				//double c = 0.0;
				//int commission = 0;
				//int received = 0;
				/*
					�萔�����v�Z�A�萔�������A�萔�����������z�̕ϐ��ɓ����
					(�P�萔���́��͊O���t�@�C���ɏ���
					�@�Q���̌v�Z�̃��\�b�h��Import���ĊO���ɍ쐬
					�@�R�����_���܂ޕ��ɕϊ����Čv�Z�B
					�@�S�����_�؂�グfloor�Ŏ�������)
					��������킹��Deal�ɏ�������
				*/
						System.out.println("AddItemDao���F4");
						
						
						int c = Calculation.calculation(price);
							System.out.println(c);
						int commission  = Math.round(c);
							System.out.println(commission);
						int received =  price - commission ;
							System.out.println(received);
						
						sql = "insert into deal(deal_id,deal_amount,deal_commission,deal_received)values(?,?,?,?)";
						st = cn.prepareStatement(sql);
						
						 
						st.setInt(1,item_id);
						st.setInt(2,price);
						st.setInt(3,commission);
						st.setInt(4,received);
				
					
						st.executeQuery();
						//�B�萔�����������z��Deal����Select�łƂ��Ă���
						//Saler�ɉ��Z�|�C���g��̔��҂̃A�J�E���g�։��Z(�萔�����������z+���Ƃ��珊�����Ă����|�C���g��)
						
						System.out.println("AddItemDao���F5");
						
						
						sql = "select deal_received from deal where deal_id ="+item_id;
						st = cn.prepareStatement(sql);
						rs = st.executeQuery();
						
						int rd = 0;
							while(rs.next()){
							rd = rs.getInt(1);
						
						}
							System.out.println(rd);
							System.out.println("AddItemDao���F6");
							sql = "select user_point from users where user_id ="+salerid;
							st = cn.prepareStatement(sql);
							rs = st.executeQuery();
							
							
							int up = 0;
							int userpoint = 0;
								while(rs.next()){
									up = rs.getInt(1);
									userpoint = up + rd;
								}
						
									sql = "update users  set user_point ="+userpoint +"where user_id = "+ salerid;
									st = cn.prepareStatement(sql);
									rs = st.executeQuery();
				
			}else{
				System.out.println("�Ⴄ");
				sql = "select istatus_flag from item_status where istatus_id = "+item_id;
				st = cn.prepareStatement(sql);
				rs = st.executeQuery();
			}
			

				
			System.out.println("AddItemDao���F7");
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

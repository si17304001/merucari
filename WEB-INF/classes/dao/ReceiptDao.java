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
		System.out.println("AddItemDao内：1");
		ResultSet rs = null;

		try{
			
			
			cn = OracleConnectionManager.getInstance().getConnection();
			/*
			①アイテムの状態を3(受け取り完了に変更)
			②完了した取引としてDealへ書き込み(手数量等をすべて計算したうえで)
			③ポイントを販売者のアカウントへ加算(手数料を引いた額+もとから所持していたポイント数) 
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
			
				System.out.println("AddItemDao内：2");
				
				
				
				//②(販売者、購入者を取得→商品の金額を取得→手数料を計算→Dealへ書き込み)
				sql = "select tinfo_salerid, tinfo_buyerid from trade_info where tinfo_itemid ="+item_id;
				st = cn.prepareStatement(sql);
				rs = st.executeQuery();
				String salerid = null;
				String buyerid = null;
				while(rs.next()){
					salerid  = rs.getString(1);
					buyerid  = rs.getString(2);
				}
				
					System.out.println("AddItemDao内：3");
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
					手数料を計算、手数料だけ、手数料を引いた額の変数に入れる
					(１手数料の％は外部ファイルに書く
					　２この計算のメソッドをImportして外部に作成
					　３小数点を含む方に変換して計算。
					　４小数点切り上げfloorで実装する)
					それを合わせてDealに書き込む
				*/
						System.out.println("AddItemDao内：4");
						
						
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
						//③手数料を引いた額はDealからSelectでとってくる
						//Salerに加算ポイントを販売者のアカウントへ加算(手数料を引いた額+もとから所持していたポイント数)
						
						System.out.println("AddItemDao内：5");
						
						
						sql = "select deal_received from deal where deal_id ="+item_id;
						st = cn.prepareStatement(sql);
						rs = st.executeQuery();
						
						int rd = 0;
							while(rs.next()){
							rd = rs.getInt(1);
						
						}
							System.out.println(rd);
							System.out.println("AddItemDao内：6");
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
				System.out.println("違う");
				sql = "select istatus_flag from item_status where istatus_id = "+item_id;
				st = cn.prepareStatement(sql);
				rs = st.executeQuery();
			}
			

				
			System.out.println("AddItemDao内：7");
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

package tera;
import java.util.ArrayList;
import java.util.Map;
import dao.AbstractDaoFactory;
import dao.IDao;
import dao.OracleConnectionManager;

import bean.*;


class ReceiptCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		
		
		
		RequestContext reqc= getRequestContext();
		String[] item_idarr = reqc.getParameter("item_id");
		String[] user_idarr = reqc.getParameter("user_id");
		int item_id = Integer.parseInt(item_idarr[0]);
		String user_id = user_idarr[0];
		
		
		/*
			ItemBean以外にチャージ専用のBeanを作成する必要有？
			購入の際の書きこむテーブルが正しいか見直す必要有
			チャージも同じように書き込む必要有
		*/
		
		
		System.out.println("AddProduct内:1");
		
		OracleConnectionManager.getInstance().beginTransaction();
		System.out.println("AddProduct内：2");
		
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory("dao");
		System.out.println("AddProduct内：3");
		IDao dao = factory.getConcreteDao("receipt");
		System.out.println("AddProduct内：4");
		
		dao.Receipt(item_id);
		System.out.println("AddProduct内：5");
		
		
		
		OracleConnectionManager.getInstance().commit();
		OracleConnectionManager.getInstance().closeConnection();
		
		
		dao = factory.getConcreteDao("showchat");
		
		
		resc.setResult(dao.getAllChat(item_id,user_id));
		
		
		resc.setTarget("showchat");
		
		return resc;
	}
}
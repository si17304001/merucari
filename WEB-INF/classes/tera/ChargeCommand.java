package tera;
import java.util.ArrayList;
import java.util.Map;
import dao.AbstractDaoFactory;
import dao.IDao;
import dao.OracleConnectionManager;

import bean.*;


class ChargeCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		
		
		
		RequestContext reqc= getRequestContext();
		String[] user_idarr = reqc.getParameter("user_id");
		String[] charge_idarr = reqc.getParameter("charge_id");
		String[] charge_amountarr = reqc.getParameter("charge_amount");
		
		String user_id = user_idarr[0];
		int charge_amount = Integer.parseInt(charge_amountarr[0]);
		
		
		/*
			ItemBean以外にチャージ専用のBeanを作成する必要有？
			購入の際の書きこむテーブルが正しいか見直す必要有
			チャージも同じように書き込む必要有
		*/
		
		
		ItemBean ib = new ItemBean();
		
		
		ib.setItem_id(99999);
		ib.setBuyerId(user_id);
		ib.setPrice(charge_amount);
		System.out.println("AddProduct内:1");
		
		OracleConnectionManager.getInstance().beginTransaction();
		System.out.println("AddProduct内：2");
		
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory("dao");
		System.out.println("AddProduct内：3");
		IDao dao = factory.getConcreteDao("charge");
		System.out.println("AddProduct内：4");
		
		dao.ChargePoint(ib);
		System.out.println("AddProduct内：5");
		
		
		
		OracleConnectionManager.getInstance().commit();
		OracleConnectionManager.getInstance().closeConnection();
		
		
		resc.setTarget("start");
		
		return resc;
	}
}
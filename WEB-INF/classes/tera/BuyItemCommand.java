package tera;
import java.util.ArrayList;
import java.util.Map;
import dao.AbstractDaoFactory;
import dao.IDao;
import dao.OracleConnectionManager;
import exp.*;
import bean.*;


class BuyItemCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		
		
		
		
		RequestContext reqc= getRequestContext();
		
		String p = "showchat";
		String[] user_idarr = reqc.getParameter("user_id");
		String[] item_idarr = reqc.getParameter("item_id");

		String user_id = user_idarr[0];
		int item_id = Integer.parseInt(item_idarr[0]);
		
		ItemBean ib = new ItemBean();
		
		
		ib.setItem_id(item_id);
		ib.setBuyerId(user_id);

		OracleConnectionManager.getInstance().beginTransaction();
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory("dao");
		IDao dao = factory.getConcreteDao("buy");

		try{
			dao.BuyItem(ib);
			OracleConnectionManager.getInstance().commit();
			OracleConnectionManager.getInstance().closeConnection();
			
			
			dao = factory.getConcreteDao("showchat");
			resc.setResult(dao.getAllChat(item_id,user_id));
		}catch(Exception e){
			p = "exp";
			String mes = e.getMessage();
			resc.setResult(mes);
		}
	
		resc.setTarget(p);
		
		return resc;
	}
}
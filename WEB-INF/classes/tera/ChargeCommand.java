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
			ItemBean�ȊO�Ƀ`���[�W��p��Bean���쐬����K�v�L�H
			�w���̍ۂ̏������ރe�[�u�������������������K�v�L
			�`���[�W�������悤�ɏ������ޕK�v�L
		*/
		
		
		ItemBean ib = new ItemBean();
		
		
		ib.setItem_id(99999);
		ib.setBuyerId(user_id);
		ib.setPrice(charge_amount);
		System.out.println("AddProduct��:1");
		
		OracleConnectionManager.getInstance().beginTransaction();
		System.out.println("AddProduct���F2");
		
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory("dao");
		System.out.println("AddProduct���F3");
		IDao dao = factory.getConcreteDao("charge");
		System.out.println("AddProduct���F4");
		
		dao.ChargePoint(ib);
		System.out.println("AddProduct���F5");
		
		
		
		OracleConnectionManager.getInstance().commit();
		OracleConnectionManager.getInstance().closeConnection();
		
		
		resc.setTarget("start");
		
		return resc;
	}
}
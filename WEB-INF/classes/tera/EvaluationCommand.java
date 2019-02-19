package tera;
import java.util.ArrayList;
import java.util.Map;
import dao.AbstractDaoFactory;
import dao.IDao;
import dao.OracleConnectionManager;

import bean.*;


class EvaluationCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		
		
		
		RequestContext reqc= getRequestContext();
		String[] user_idarr = reqc.getParameter("user_id");
		String[] item_idarr = reqc.getParameter("item_id");
		String[] evalarr = reqc.getParameter("eval");
		int item_id = Integer.parseInt(item_idarr[0]);
		String user_id = user_idarr[0];
		String eval = evalarr[0];
		
		
		/*
			ItemBean�ȊO�Ƀ`���[�W��p��Bean���쐬����K�v�L�H
			�w���̍ۂ̏������ރe�[�u�������������������K�v�L
			�`���[�W�������悤�ɏ������ޕK�v�L
		*/
		
		
		System.out.println("Eval��:1");
		
		OracleConnectionManager.getInstance().beginTransaction();
		System.out.println("Eval���F2");
		
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory("dao");
		System.out.println("Eval���F3");
		IDao dao = factory.getConcreteDao("eval");
		System.out.println("Eval���F4");
		
		dao.Evaluation(item_id,user_id,eval);
		System.out.println("Eval���F5");
		
		
		
		OracleConnectionManager.getInstance().commit();
		OracleConnectionManager.getInstance().closeConnection();
		
		dao = factory.getConcreteDao("showchat");
		System.out.println("showchat�֓]��");
		
		
		resc.setResult(dao.getAllChat(item_id,user_id));
		resc.setTarget("showchat");
		
		return resc;
	}
}
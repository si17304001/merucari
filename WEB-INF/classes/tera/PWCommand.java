package tera;
import java.util.ArrayList;
import java.util.Map;
import dao.AbstractDaoFactory;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import dao.IDao;

import dao.OracleConnectionManager;
import bean.*;
import email.*;


class PWCommand extends AbstractCommand{
	
		public ResponseContext execute(ResponseContext resc){
		
		
		
		/*
			emarr:Email
			psarr:PassWord
		*/
		RequestContext reqc= getRequestContext();
		HttpServletRequest req =(HttpServletRequest)reqc.getRequest();
	
		String[] emarr = reqc.getParameter("em");
		
		
	
			
		String em = emarr[0];
	
		
		UserBean ub = new UserBean();
		

		ub.setEmail(em);
	
		
		System.out.println("PWCommand内:1");
		
		OracleConnectionManager.getInstance().beginTransaction();
		System.out.println("PWCommand内：2");
		
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory("dao");
		System.out.println("PWCommand内：3");
		IDao dao = factory.getConcreteDao("pwcheck");
		System.out.println("PWCommand内：4");
			
			if(ub == null){
				req.setAttribute("errorMsg", em + "，ないです。");
					System.out.println("emailが違います");		
			}else{
			
				 HttpSession session = req.getSession();
      	
  				session.setAttribute("pwmail",ub.getEmail());
				
				EmailUtils.sendResetPasswordEmail(ub);//?送重?密??接
			}
			
			
		
		req.setAttribute("sendMailMsg", "fasongyouxiang"+ub.getEmail()+"email。");
		dao.pw(ub);
		System.out.println("PWCommand内：5");
		
		
		
		OracleConnectionManager.getInstance().commit();
		OracleConnectionManager.getInstance().closeConnection();
		
		
		resc.setTarget("start");
		
		return resc;
	}
}




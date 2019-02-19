package tera;
import java.util.ArrayList;
import java.util.Map;
import dao.AbstractDaoFactory;
import dao.IDao;
import dao.OracleConnectionManager;
import bean.UserBean;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;


class LoginCommand extends AbstractCommand{
	
		public ResponseContext execute(ResponseContext resc){
		
		/*
		
			emarr:Email
			psarr:PassWord
		*/
			
		boolean loginflag= false;
		RequestContext reqc= getRequestContext();
		HttpServletRequest req =(HttpServletRequest)reqc.getRequest();
	
		String[] emarr = reqc.getParameter("em");
		String[] psarr = reqc.getParameter("ps");
		

	
		String em = emarr[0];
		String ps = psarr[0];
		
		UserBean ub = new UserBean();

		ub.setEmail(em);
		ub.setPassword(ps);
	
			
		System.out.println("LoginCommand内:1");
		
		OracleConnectionManager.getInstance().beginTransaction();
		System.out.println("LoginCommand内：2");
		
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory("dao");
		System.out.println("LoginCommand内：3");
		IDao dao = factory.getConcreteDao("login");
		System.out.println("LoginCommand内：4");
			if(ub == null){
				System.out.println("ない");
			}
			UserBean u = dao.Login(ub);
			
			
			if(u == null){
					System.out.println("passもしくはIDが違います");		
			}else{
				//System.out.println(u.getNickname());
				//resc.setLoginUserId(u.getUser_id());
				//resc.setLoginName(u.getNickname());
				 HttpSession session = req.getSession();
      			session.setAttribute("loginid",u.getUser_id());
  				session.setAttribute("loginname",u.getNickname());
				
			}
		/*if(u.getPassword().equals(ps)){

    }else{

      System.out.println("passもしくはIDが違います");

    }*/

		System.out.println("LoginCommand内：5");
		
		
		
		OracleConnectionManager.getInstance().commit();
		OracleConnectionManager.getInstance().closeConnection();
		
			

		resc.setTarget("start");
		
		return resc;
	}
}




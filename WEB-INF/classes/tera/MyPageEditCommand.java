package tera;
import java.util.List;
import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import dao.*;
import bean.*;



class MyPageEditCommand extends AbstractCommand{
	
	public ResponseContext execute(ResponseContext resc){
		
		
		
		RequestContext reqc= getRequestContext();
		String P ="view";
		String[] unnarr = reqc.getParameter("user_nickname");
		String[] intarr = reqc.getParameter("user_introduction");
		String[] unarr = reqc.getParameter("user_name");
		String[] zcarr = reqc.getParameter("user_zipcode");
		String[] pcarr = reqc.getParameter("user_prefcode");
		String[] adarr = reqc.getParameter("user_address2");
		UserBean ub = new UserBean();
		ub.setNickname(unnarr[0]);
		ub.setIntroduction(intarr[0]);
		System.out.println(intarr[0]);
		ub.setName(unarr[0]);
		ub.setZip_code(zcarr[0]);
		ub.setPref_code(Integer.parseInt(pcarr[0]));
		ub.setAddress2(adarr[0]);
		
		HttpServletRequest req = (HttpServletRequest)reqc.getRequest();
		HttpSession session = req.getSession();
		String user_id = (String)session.getAttribute("loginid");	
		ub.setUser_id(user_id);
	
	
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory("dao");
		IDao dao = factory.getConcreteDao("mypageedit");
		
		try{
			System.out.println(user_id);
			dao.MyPageEdit(ub);
			OracleConnectionManager.getInstance().commit();
			OracleConnectionManager.getInstance().closeConnection();
		}catch(Exception e){
			String mes = e.getMessage();
			p = "exp";
		}
		resc.setTarget(p);
		return resc;
	}
}
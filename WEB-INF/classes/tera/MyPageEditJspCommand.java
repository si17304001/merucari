package tera;
import java.util.List;
import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import dao.*;



class MyPageEditJspCommand extends AbstractCommand{
	
	public ResponseContext execute(ResponseContext resc){
		
		
		
		RequestContext reqc= getRequestContext();
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory("dao");
		IDao dao = factory.getConcreteDao("mypageeditjsp");
		
		HttpServletRequest req = (HttpServletRequest)reqc.getRequest();
		
		
		HttpSession session = req.getSession();
		
		String user_id = (String)session.getAttribute("loginid");	
		System.out.println(user_id);
		System.out.println("Daoスタート");
		resc.setResult(dao.getMyPageEditJsp	(user_id));
		resc.setTarget("mypageedit");
		return resc;
	}
}
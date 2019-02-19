package tera;
import java.util.List;
import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import dao.*;



class UserPageCommand extends AbstractCommand{
	
	public ResponseContext execute(ResponseContext resc){
		
		
		
		RequestContext reqc= getRequestContext();
		String[] user_idarr = reqc.getParameter("user_id");
		String user_id = user_idarr[0];
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory("dao");
		IDao dao = factory.getConcreteDao("userpage");
		
		System.out.println(user_id);
		System.out.println("Daoスタート");
		resc.setResult(dao.getUserPage(user_id));
		resc.setTarget("userpage");
		return resc;
	}
}
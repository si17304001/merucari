package tera;
import java.util.List;
import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import dao.*;



class LikeCommand extends AbstractCommand{
	
	public ResponseContext execute(ResponseContext resc){
		
		
		
		RequestContext reqc= getRequestContext();
		String[] item_idarr = reqc.getParameter("item_id");
		String item_id = item_idarr[0];
		
		System.out.println(item_id);
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory("dao");
		IDao dao = factory.getConcreteDao("like");
		
		HttpServletRequest req = (HttpServletRequest)reqc.getRequest();
		
		
		HttpSession session = req.getSession();
		
		String user_id = (String)session.getAttribute("loginid");
		dao.Like(item_id,user_id);
		
		System.out.println("Daoスタート");
		
		dao = factory.getConcreteDao("detail");
		resc.setResult(dao.getDetail(item_id,user_id));
		resc.setTarget("detail");
		return resc;
	}
}
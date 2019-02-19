package tera;
import java.util.List;
import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import dao.*;



class CashOutCommand extends AbstractCommand{
	
	public ResponseContext execute(ResponseContext resc){
		
		
		
		RequestContext reqc= getRequestContext();
		String[] amountarr = reqc.getParameter("amount");
		String p ="cashout";
		int amount  = Integer.parseInt(amountarr[0]);
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory("dao");
		IDao dao = factory.getConcreteDao("cashout");
		HttpServletRequest req = (HttpServletRequest)reqc.getRequest();
		HttpSession session = req.getSession();
		String user_id = (String)session.getAttribute("loginid");	
		System.out.println(user_id);
		
		try{
			System.out.println("Daoスタート");
			dao.cashOut(user_id, amount);
		}catch(Exception e){
			String mes = e.getMessage();
			p = "exp";
		}
		resc.setTarget(p);
		return resc;
	}
}
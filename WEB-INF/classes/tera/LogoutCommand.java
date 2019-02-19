package tera;
import java.util.ArrayList;
import java.util.Map;
import dao.AbstractDaoFactory;
import dao.IDao;
import dao.OracleConnectionManager;
import bean.*;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

class LogoutCommand extends AbstractCommand{
	
		public ResponseContext execute(ResponseContext resc){
		
		    RequestContext reqc=getRequestContext();
  			HttpServletRequest req =(HttpServletRequest)reqc.getRequest();


		  	HttpSession session = req.getSession();
		  	session.invalidate();
				resc.setTarget("start");
				
				return resc;
	}
}




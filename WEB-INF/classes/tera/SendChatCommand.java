package tera;
import java.util.List;
import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import dao.*;
import bean.*;



class SendChatCommand extends AbstractCommand{
	
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc= getRequestContext();
			String[] item_idarr = reqc.getParameter("item_id");
			String[] user_idarr = reqc.getParameter("user_id");
			String[] contentarr = reqc.getParameter("content");
		    int item_id = Integer.parseInt(item_idarr[0]);
		String user_id = user_idarr[0];
		String content = contentarr[0];
				if(item_idarr[0] == null || item_idarr[0] == "" || item_idarr[0] == " " ){ System.out.println("‚ ‚ ‚ ‚ ‚ ");}
			System.out.println(item_id);
		ResBean rb = new ResBean();
		rb.setUserid(user_id);
		rb.setItemid(item_id);
		rb.setContent(content);
		
		
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory("dao");
		IDao dao = factory.getConcreteDao("sendchat");
		dao.SendChat(rb);
		
		dao = factory.getConcreteDao("showchat");
		
		
		resc.setResult(dao.getAllChat(item_id,user_id));
		resc.setTarget("showchat");
		return resc;
	}
}
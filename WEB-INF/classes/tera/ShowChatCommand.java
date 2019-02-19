package tera;
import java.util.List;
import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import dao.*;



class ShowChatCommand extends AbstractCommand{
	
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc= getRequestContext();
		String[] item_idarr = reqc.getParameter("item_id");
		String[] user_idarr = reqc.getParameter("user_id");
		int item_id  = Integer.parseInt(item_idarr[0]);
		String user_id = user_idarr[0];
		if(item_idarr[0] == null || item_idarr[0] == "" || item_idarr[0] == " " ){ System.out.println("Ç†Ç†Ç†Ç†Ç†");}
		System.out.println(item_id);
		
		
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory("dao");
		IDao dao = factory.getConcreteDao("showchat");
		
		
		
		
		System.out.println("showchaté¿çs");
		resc.setResult(dao.getAllChat(item_id,user_id));
		resc.setTarget("showchat");
		return resc;
	}
}
package tera;
import java.util.List;
import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import dao.*;



class KeywordSearchCommand extends AbstractCommand{
	
	public ResponseContext execute(ResponseContext resc){
		
		
		RequestContext reqc= getRequestContext();
			String[] keyarr = reqc.getParameter("key");
			String key = keyarr[0];
		
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory("dao");
		IDao dao = factory.getConcreteDao("keywordsearch");
		
		
		
		
		resc.setResult(dao.getKeywordItems(key));
		resc.setTarget("view");
		return resc;
	}
}
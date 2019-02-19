package tera;
import java.util.List;
import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import dao.*;

class GetProductsCommand extends AbstractCommand{
	
	public ResponseContext execute(ResponseContext resc){
		
		
		
		String p = "view";
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory("dao");
		IDao dao = factory.getConcreteDao("get");
		
		try{
			resc.setResult(dao.getAllProducts());
		}catch(Exception e){
			String mes = e.getMessage();
			p = "exp";
		}
		resc.setTarget(p);
		return resc;
	}
}
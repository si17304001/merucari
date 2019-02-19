package tera;
import java.util.List;
import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import dao.*;



class GetItemsCommand extends AbstractCommand{
	
	public ResponseContext execute(ResponseContext resc){
		
		
		
		
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory("dao");
		IDao dao = factory.getConcreteDao("get");
		
		
		
		
		
		resc.setResult(dao.getAllProducts());
		List al = dao.getAllProducts();
		if(al == null){
			System.out.println("�擾�ł��Ă��Ȃ�");
		}
		resc.setTarget("view");
		return resc;
	}
}
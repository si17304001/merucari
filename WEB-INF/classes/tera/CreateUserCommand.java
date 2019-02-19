package tera;
import java.util.ArrayList;
import java.util.Map;
import dao.AbstractDaoFactory;
import dao.IDao;
import dao.OracleConnectionManager;
import bean.UserBean;


class CreateUserCommand extends AbstractCommand{
	
		public ResponseContext execute(ResponseContext resc){
		
		
		
		/*
			uiarr:ユーザーId
			nnarr:ユーザーネーム
			narr :氏名
			zcarr:郵便番号
			pcarr:都道府県番号
		   addarr:市番地
			emarr:Email
			psarr:PassWord
		*/
		RequestContext reqc= getRequestContext();
		String[] uiarr = reqc.getParameter("ui");
		String[] nnarr = reqc.getParameter("nn");
		String[] narr = reqc.getParameter("n");
		String[] zcarr = reqc.getParameter("zc");
		String[] pcarr = reqc.getParameter("pc");
		String[] add2arr = reqc.getParameter("add2");
		String[] emarr = reqc.getParameter("em");
		String[] psarr = reqc.getParameter("ps");
		
	
			
			
			
		String ui = uiarr[0];
		String nn = nnarr[0];
		String n =narr[0];
		String zc = zcarr[0];
		int pc = Integer.parseInt(pcarr[0]);
		String add2 = add2arr[0];
		String em = emarr[0];
		String ps = psarr[0];
		
		UserBean ub = new UserBean();
		
		
		ub.setUser_id(ui);
		ub.setNickname(nn);
		ub.setName(n);
		ub.setZip_code(zc);
		ub.setPref_code(pc);
		ub.setAddress2(add2);
		ub.setEmail(em);
		ub.setPassword(ps);
		
		System.out.println("CreateUserCommand内:1");
		
		OracleConnectionManager.getInstance().beginTransaction();
		System.out.println("CreateUserCommand内：2");
		
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory("dao");
		System.out.println("CreateUserCommand内：3");
		IDao dao = factory.getConcreteDao("createuser");
		System.out.println("CreateUserCommand内：4");
		
		dao.createUser(ub);
		System.out.println("CreateUserCommand内：5");
		
		
		
		OracleConnectionManager.getInstance().commit();
		OracleConnectionManager.getInstance().closeConnection();
		
		
		resc.setTarget("start");
		
		return resc;
	}
}




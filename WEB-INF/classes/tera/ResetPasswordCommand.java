package tera;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import dao.AbstractDaoFactory;
import dao.IDao;
import dao.OracleConnectionManager;
import bean.*;
import email.*;

class ResetPasswordCommand extends AbstractCommand{
	
		public ResponseContext execute(ResponseContext resc){
		
		
		
		/*
			emarr:Email
			psarr:PassWord
		*/
		RequestContext reqc= getRequestContext();

		String[] emarr = reqc.getParameter("em");
		String[] psarr = reqc.getParameter("ps");
		String[] psarr2 = reqc.getParameter("ps2");
		
	
			
		String em = emarr[0];
		String ps = psarr[0];
		String ps2 = psarr2[0];
			
		Map<String,String> errors = new HashMap<String, String>();
		if (ps == null || "".equals(ps)) {
			errors.put("ps", "�V�����p�X���[�h����ɂ��邱�Ƃ͂ł��܂���B");
		}
		
		if (ps2 == null || "".equals(ps2)) {
			errors.put("ps2", "�m�F�p�X���[�h����ɂ��邱�Ƃ͂ł��܂���B");
		}
		
		if (!ps.equals(ps2)) {
			errors.put("passwordError", "2����͂����p�X���[�h���������Ă��܂��B");
		}
		
		UserBean ub = new UserBean();
		
		
	
		ub.setEmail(em);
		ub.setPassword(ps);
		String a = ub.getEmail();
			System.out.println(a);
		String b = ub.getPassword();
			System.out.println(b);
		System.out.println("ResetPasswordDao��:1");
		
		OracleConnectionManager.getInstance().beginTransaction();
		System.out.println("ResetPasswordDao���F2");
		
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory("dao");
		System.out.println("ResetPasswordDao���F3");
		IDao dao = factory.getConcreteDao("pw");
		System.out.println("ResetPasswordDao���F4");
		
		dao.pw(ub);
		System.out.println("ResetPasswordDao���F5");
		
		
		
		OracleConnectionManager.getInstance().commit();
		OracleConnectionManager.getInstance().closeConnection();
		
		
		resc.setTarget("rpws");
		
		return resc;
	}
}




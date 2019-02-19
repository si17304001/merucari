package tera;
import java.util.ArrayList;
import java.util.Map;
import dao.AbstractDaoFactory;
import dao.IDao;
import dao.OracleConnectionManager;

import bean.*;


class AddProductCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		
		
		
		
		RequestContext reqc= getRequestContext();
		String[] item_idarr = reqc.getParameter("item_id");
		String[] namearr = reqc.getParameter("name");
		String[] categoryarr = reqc.getParameter("category");
		String[] image1arr = reqc.getParameter("image1");
		String[] sizearr = reqc.getParameter("size");
		String[] descriptionarr = reqc.getParameter("description");
		String[] statearr = reqc.getParameter("state");
		String[] postagearr = reqc.getParameter("postage");
		String[] pricearr = reqc.getParameter("price");
		String[] salerarr = reqc.getParameter("saler");
		
		int item_id = Integer.parseInt(item_idarr[0]);
		String name = namearr[0];
		int category = Integer.parseInt(categoryarr[0]);
		String image1 =image1arr[0];
		int size = Integer.parseInt(sizearr[0]);
		String description = descriptionarr[0];
		int state = Integer.parseInt(statearr[0]);
		int postage = Integer.parseInt(postagearr[0]);
		int price = Integer.parseInt(pricearr[0]);
		String saler =salerarr[0];
		
		ItemBean ib = new ItemBean();
		
		
		ib.setItem_id(item_id);
		ib.setName(name);
		ib.setCategory(category);
		ib.setImage1(image1);
		ib.setSize(size);
		ib.setDescription(description);
		ib.setState(state);
		ib.setPostage(postage);
		ib.setPrice(price);
		ib.setSalerId(saler);
		System.out.println("AddProduct内:1");
		
		OracleConnectionManager.getInstance().beginTransaction();
		System.out.println("AddProduct内：2");
		
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory("dao");
		System.out.println("AddProduct内：3");
		IDao dao = factory.getConcreteDao("add");
		System.out.println("AddProduct内：4");
		
		dao.addProduct(ib);
		System.out.println("AddProduct内：5");
		
		
		
		OracleConnectionManager.getInstance().commit();
		OracleConnectionManager.getInstance().closeConnection();
		
		
		resc.setTarget("start");
		
		return resc;
	}
}
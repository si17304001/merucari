package bean;

import java.util.List;
import java.util.ArrayList;

public class MyPageBean extends AbstractBean{
	/*
		UserBean
		販売中リスト
		取引中リスト
		取引済みリスト
	
		購入(取引中)リスト
		購入(取引済み)リスト
		Dealリスト
	*/
	private UserBean ub;
	private ArrayList sList;
	private ArrayList stList;
	private ArrayList scList;
	private ArrayList btList;
	private ArrayList bcList;
	private ArrayList dList;
	
		
	public MyPageBean(){
	}
	
	public void setUb(UserBean u){
		ub = u;
	}
	
	public UserBean getUb(){
		return ub;
	}
	
	public void setSList(ArrayList li){
		sList = li;
	}
	
	public ArrayList getSList(){
		return sList;
	}
	
	public void setStList(ArrayList li){
		stList = li;
	}
	
	public ArrayList getStList(){
		return stList;
	}
	
	public void setScList(ArrayList li){
		scList = li;
	}
	
	public ArrayList getScList(){
		return scList;
	}
	
	public void setBtList(ArrayList li){
		btList = li;
	}
	
	public ArrayList getBtList(){
		return btList;
	}
	
	public void setBcList(ArrayList li){
		bcList = li;
	}
	
	public ArrayList getBcList(){
		return bcList;
	}
	
	public void setDList(ArrayList li){
		dList = li;
	}
	
	public ArrayList getDList(){
		return dList;
	}
	
	
}
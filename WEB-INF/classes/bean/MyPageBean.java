package bean;

import java.util.List;
import java.util.ArrayList;

public class MyPageBean extends AbstractBean{
	/*
		UserBean
		�̔������X�g
		��������X�g
		����ς݃��X�g
	
		�w��(�����)���X�g
		�w��(����ς�)���X�g
		Deal���X�g
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
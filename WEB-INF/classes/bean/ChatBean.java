package bean;
import java.util.List;

public class ChatBean extends AbstractBean{
	/*
		レスのリスト
		状態
		アイテムID
		ボタン表示/非表示
	*/
	
	
	public ChatBean(){
	}
	private List resList;
	private int flag;
	private int itemid;
	private int btnava;
	
	
	//商品ID
	public void setBtnava(int a){
		btnava = a;
	}
	
	public int getBtnava(){
		return btnava;
	}
	
	public void setResList(List li){
		resList = li;
	}
	
	public List getResList(){
		return resList;
	}
	
	
	public void setFlag(int flg){
		flag = flg;
	}
	
	public int getFlag(){
	return flag;
	}
	
	public void setItemid(int iid){
		itemid = iid;
	}
	
	public int getItemid(){
		return itemid;
	}
	
	
}
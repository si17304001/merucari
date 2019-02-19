package dao;
import java.util.List;
import bean.*;
import exp.*;


public class AbstractDao implements IDao{
	public void addProduct(ItemBean ib){}
	public List getAllProducts(){
		return null;
	}
	
	public void createUser(UserBean ub){}
	
	public ItemBean getDetail(String item_id,String user_id){
		return null;
	}
	
	public List getKeywordItems(String key){
		return null;
	}
	
	public void BuyItem(ItemBean ib)throws BuyException{}
	
	public void ChargePoint(ItemBean ib){}
	
	public void Shipping(int item_id){}
	
	public void Receipt(int item_id){}
	
	public ChatBean getAllChat(int id,String userid){
	 return null;
	}
	public UserBean Login(UserBean ub){
		return null;
	}
	
	public void SendChat(ResBean rb){}
	
	public void Evaluation(int id, String ud, String eval){}
	
	public void pw(UserBean ub){}
	
	public UserBean pwcheckDao(UserBean ub){
	return null;
	}
	
	public void Like(String item_id, String user_id){}
	
	public ItemBean ItemEditJsp(String item_id,String user_id){
	 return null;
	}
	
	public MyPageBean getMyPage(String user_id){
		return null;
	}
	
	public void cashOut(String user_id, int amount)throws CashOutException{}
	
	public MyPageBean getUserPage(String user_id){
		return null;
	}
	public UserBean getMyPageEditJsp(String user_id){
		return null;
	}
	
	public void MyPageEdit(UserBean ub){
	}
	
	
}
package dao;

import java.util.List;
import bean.*;
import exp.*;

public interface IDao{
	public void addProduct(ItemBean ib);
	public List getAllProducts();
	public void createUser(UserBean ub);
	public ItemBean getDetail(String item_id,String user_id);
	public List getKeywordItems(String key);
	public void BuyItem(ItemBean ib)throws BuyException;
	public void ChargePoint(ItemBean ib);
	public void Shipping(int item_id);
	public void Receipt(int item_id);
	public ChatBean getAllChat(int id,String userid);
	public UserBean Login(UserBean ub);
	public void SendChat(ResBean rb);
	public void Evaluation(int id, String ud,String eval);
	public void pw(UserBean ub);
	public UserBean pwcheckDao(UserBean ub);
	public void Like(String item_id, String user_id);
	public ItemBean ItemEditJsp(String item_id,String user_id);
	public MyPageBean getMyPage(String user_id);
	public void cashOut(String user_id, int amount)throws CashOutException;
	public MyPageBean getUserPage(String user_id);
	public UserBean getMyPageEditJsp(String user_id);
	public void MyPageEdit(UserBean ub);
}
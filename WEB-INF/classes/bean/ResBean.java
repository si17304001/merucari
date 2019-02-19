package bean;

public class ResBean extends AbstractBean{
	/*
		商品ID
		チャット送信者(名前)
		チャット送信者(ID)
		内容
		送信日時
		
	*/
	
	
	public ResBean(){
	}
	private int item_id;
	private String name;
	private String user_id;
	private String content;
	private String timestamp;
	
	
	//商品ID
	public void setItemid(int iid){
		item_id = iid;
	}
	
	public int getItemid(){
		return item_id;
	}
	
	//ユーザー名
	public void setName(String un){
		name = un;
	}
	
	public String getName(){
		return name;
	}
	
	//ID
	public void setUserid(String ui){
		user_id = ui;
	}
	
	public String getUserid(){
		return user_id;
	}
	
	//内容
	public void setContent(String cc){
		content = cc;
	}
	public String getContent(){
		return content;
	}
	
	
	//送信日時
	
	public void setTimestamp(String ts){
		timestamp = ts;
	}
	
	public String getTimestamp(){
		return timestamp;
	}
	
	
	
}
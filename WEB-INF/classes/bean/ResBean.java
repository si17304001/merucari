package bean;

public class ResBean extends AbstractBean{
	/*
		���iID
		�`���b�g���M��(���O)
		�`���b�g���M��(ID)
		���e
		���M����
		
	*/
	
	
	public ResBean(){
	}
	private int item_id;
	private String name;
	private String user_id;
	private String content;
	private String timestamp;
	
	
	//���iID
	public void setItemid(int iid){
		item_id = iid;
	}
	
	public int getItemid(){
		return item_id;
	}
	
	//���[�U�[��
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
	
	//���e
	public void setContent(String cc){
		content = cc;
	}
	public String getContent(){
		return content;
	}
	
	
	//���M����
	
	public void setTimestamp(String ts){
		timestamp = ts;
	}
	
	public String getTimestamp(){
		return timestamp;
	}
	
	
	
}
package bean;

public class DealBean extends AbstractBean{
	
	private int amount;
	private String date;
	private int flag;
	
	public DealBean(){
	}
	
	public void setAmount(int i){
		amount = i;
	}
	
	public int getAmount(){
		return amount;
	}
	
	public void setDate(String d){
		date = d;
	}
	
	public String getDate(){
		return date;
	}
	
	public void setFlag(int f){
		flag = f;
	}
	
	public int getFlag(){
		return flag;
	}

}
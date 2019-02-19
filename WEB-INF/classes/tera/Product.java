package bean;
import java.io.Serializable;

public class Product implements Serializable{
	private String name;
	private String price;
	private String uname;
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	public String getPrice(){
		return price;
	}
	public void setPrice(String price){
		this.price=price;
	}
	
	public String getUname(){
		return uname;
	}
	
	public void setUname(String uname){
		this.uname=uname;
	}
}
package Bean;
import java.io.Serializable;

public class ItemsBean implements Serializable{
	private int item_id;
	private int category;
	private String name;
	private String image1;
	private String image2;
	private String image3;
	private String image4;
	private String size;
	private String description;
	private int state;
	private int shipping;
	private int postege;
	private String date;
	private int price;
	private int available;
	private String saler_id;
	private String buyer_id;
	private int pay;
	private String pay_time;
	private int send;
	private int receipt;
	
	
	public ItemsBean(){
	}
	
	//item_id
	public void setItem_id(int id){
		item_id = id;
	}
	public int getItem_id(){
		return item_id;
	}
	
	//category
	public void setCategory(int cg){
		category = cg;
	}
	public int getCategory(){
		return category;
	}
	
	//name
	public void setName(String n){
		name = n;
	}
	public String getName(){
		return name;
	}
	
	//image1
	public void setImage1(String im1){
		image1 = im1;
	}
	public String getImage1(){
		return image1;
	}
	
	//image2
	public void setImage2(String im2){
		image2 = im2;
	}
	public String getImage2(){
		return image2;
	}
	
	//image3
	public void setImage3(String im3){
		image3 = im3;
	}
	public String getImage3(){
		return image3;
	}
	
	//image4
	public void setImage4(String im4){
		image4 = im4;
	}
	public String getImage4(){
		return image4;
	}
	
	//size
	public void setSize(String s){
		size = s;
	}
	public String getSize(){
		return size;
	}
	
	//description
	public void setDescription(String di){
		description = di;
	}
	public String getDescription(){
		return description;
	}
	
	//state
	public void setState(int st){
		state = st;
	}
	public int getState(){
		return state;
	}
	
	//shipping
	public void setShipping(int sp){
		shipping = sp;
	}
	public int getShipping(){
		return shipping;
	}
	
	//postage
	public void setPostege(int pt){
		postege = pt;
	}
	public int getPostege(){
		return postege;
	}
	
	//data
	public void setDate(String da){
		date = da;
	}
	public String getDate(){
		return date;
	}
	
	//price
	public void setPrice(int pi){
		price = pi;
	}
	public int getPrice(){
		return price;
	}
	
	//available
	public void setAvailable(int al){
		available = al;
	}
	public int getAvailable(){
		return available;
	}
	
	//saler_id
	public void setSaler_id(String si){
		saler_id = si;
	}
	public String getSaler_id(){
		return saler_id;
	}
	
	//buyer_id
	public void setBuyer_id(String bi){
		buyer_id = bi;
	}
	public String getBuyer_id(){
		return buyer_id;
	}
	
	//pay
	public void setPay(int p){
		pay = p;
	}
	public int getPay(){
		return pay;
	}
	
	//pay_time
	public void setPay_time(String pt){
		pay_time = pt;
	}
	public String getPay_time(){
		return pay_time;
	}
	//send
	public void setSend(int s){
		send = s;
	}
	public int getSend(){
		return send;
	}
	//receipt
	public void setReceipt(int ri){
		receipt = ri;
	}
	public int setReceipt(){
		return receipt;
	}
}
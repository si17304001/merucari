package bean;

public class ItemBean extends AbstractBean{
	/*
		商品ID<input type='text' name='item_id'><br>
		商品名<input type='text' name = 'name'><br>
		カテゴリー番号<input type='text' name='category'><br>
		画像1<input type='text' name='image1'><br>
		商品サイズ<select name = size>
		<option value="1">S</option>
		<option value="2">M</option>
		<option value="3">L</option>
		</select><br>
		商品説明<input type='text' name='description'><br>
		状態<input type='text' name='state'><br>
		発送までの日時<input type='text' name='postage'><br>
		価格<input type='text' name='price'><br>
		出品者ID<input type='text' name='saler'><br>
		出品者名
	*/
	private int item_id;
	private int category;
	private String name;
	private String image1;
	private String image2;
	private String image3;
	private String image4;
	private int size;
	private String description;
	private int state;
	private int shipping;
	private int postage;
	private String date;
	private int price;
	private int available;
	private String salerId;
	private String salerNickname;
	private String buyerId;
	private String buyerNickname;
	private int salerNormal;
	private int salerGood;
	private int salerBad;
	private int like;
	private int prefcode;
	
	
	
	
	
	
	
	public ItemBean(){
	}
	
	public void setPrefcode(int pc){
		prefcode = pc;
	}
	
	public int getPrefcode(){
		return prefcode;
	}
	
	//Like
	public void setLike(int lk){
		like = lk;
	}
	
	public int getLike(){
		return like;
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
	public void setSize(int s){
		size = s;
	}
	public int getSize(){
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
	public void setPostage(int pt){
		postage = pt;
	}
	public int getPostage(){
		return postage;
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
	
	
	public void setSalerNickname(String sn){
		salerNickname = sn;
	}
	
	public String getSalerNickname(){
		return salerNickname;
	}
	
	public void setSalerId(String si){
		salerId = si;
	}
	
	public String getSalerId(){
		return salerId;
	}
	
	public void setBuyerId(String bi){
		buyerId = bi;
	}
	
	public String getBuyerId(){
		return buyerId;
	}
	
	public void setBuyerNickname(String bn){
		buyerNickname = bn;
	}
	
	public String getBuyerNickname(){
		return buyerNickname;
	}
	
	public void setSalerGood(int sg){
		salerGood = sg;
	}
	
	public int getSalerGood(){
		return salerGood;
	}
	
	public void setSalerNormal(int sn){
		salerNormal = sn;
	}
	
	public int getSalerNormal(){
		return salerNormal;
	}
	
	public void setSalerBad(int sb){
		salerBad = sb;
	}
	
	public int getSalerBad(){
		return salerBad;
	}
}
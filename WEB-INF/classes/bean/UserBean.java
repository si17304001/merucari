package bean;

public class UserBean extends AbstractBean{
	
	private String user_id;
	private String nickname;
	private String name;
	private String zip_code;
	private int pref_code;
	private String address2;
	private String email;
	private String password;
	private String introduction;
	private int good;
	private int general;
	private int bad;
	private int alert;
	private int user_point;
	private String randomCode;
	
	public UserBean(){
	}
	
	//user_id
	public void setUser_id(String ui){
		user_id = ui;
	}
	public String getUser_id(){
		return user_id;
	}
	
	//nickname
	public void setNickname(String nn){
		nickname = nn;
	}
	public String getNickname(){
		return nickname;
	}
	
	//name
	public void setName(String n){
		name = n;
	}
	public String getName(){
		return name;
	}
	
	//zip_code
	public void setZip_code(String zc){
		zip_code = zc;
	}
	public String getZip_code(){
		return zip_code;
	}
	//pref_code
	public void setPref_code(int pc){
		pref_code = pc;
	}
	public int getPref_code(){
		return pref_code;
	}
	//address2
	public void setAddress2(String add){
		address2 = add;
	}
	public String getAddress2(){
		return address2;
	}
	
	//email
	public void setEmail(String e){
		email = e;
	}
	public String getEmail(){
		return email;
	}
	
	//password
	public void setPassword(String pass){
		password = pass;
	}
	public String getPassword(){
		return password;
	}
	
	//introduction
	public void setIntroduction(String id){
		introduction = id;
	}
	public String getIntroduction(){
		return introduction;
	}
	
	//good
	public void setGood(int g){
		good = g;
	}
	public int getGood(){
		return good; 
	}
	
	//general
	public void setGeneral(int gn){
		general = gn;
	}
	public int getGeneral(){
		return general;
	}
	
	//bad
	public void setBad(int b){
		bad = b;
	}
	public int getBad(){
		return bad;
	}
	
	//alert
	public void setAlert(int a){
		alert = a;
	}
	public int getAlert(){
		return alert;
	}
	
	//user_point
	public void setUser_point(int up){
		user_point = up;
	}
	public int getUser_point(){
		return user_point;
	}
	
	//MD5(ÉLÅ[)
	public String getRandomCode() {
		return randomCode;
	}
	public void setRandomCode(String randomCode) {
		this.randomCode = randomCode;
	}
}
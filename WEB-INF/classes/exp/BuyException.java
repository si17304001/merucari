package exp;

public class BuyException extends Exception{
	public BuyException(String mess,Throwable cause){
		super(mess,cause);
	}
}
package exp;

public class CashOutException extends Exception{
	public CashOutException(String mess,Throwable cause){
		super(mess,cause);
	}
}
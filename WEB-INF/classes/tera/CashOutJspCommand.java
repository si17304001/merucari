package tera;
import java.util.ArrayList;

class CashOutJspCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		resc.setTarget("cashout");
		return resc;
	}
}
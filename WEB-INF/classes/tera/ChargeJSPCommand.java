package tera;
import java.util.ArrayList;

class ChargeJSPCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		resc.setTarget("charge");
		return resc;
	}
}
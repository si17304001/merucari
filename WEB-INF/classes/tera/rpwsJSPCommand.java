package tera;
import java.util.ArrayList;

class rpwsJSPCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		resc.setTarget("resetPassword");
		return resc;
	}
}
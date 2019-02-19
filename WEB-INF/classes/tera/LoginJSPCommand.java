package tera;
import java.util.ArrayList;

class LoginJSPCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		resc.setTarget("login");
		return resc;
	}
}
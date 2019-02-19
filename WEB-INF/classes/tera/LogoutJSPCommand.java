package tera;
import java.util.ArrayList;

class LogoutJSPCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		resc.setTarget("logout");
		return resc;
	}
}
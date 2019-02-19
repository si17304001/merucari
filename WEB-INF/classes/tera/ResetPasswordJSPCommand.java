package tera;
import java.util.ArrayList;

class ResetPasswordJSPCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		resc.setTarget("rpws");
		return resc;
	}
}
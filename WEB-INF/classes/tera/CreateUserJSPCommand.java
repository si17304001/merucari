package tera;
import java.util.ArrayList;

class CreateUserJSPCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		resc.setTarget("createuser");
		return resc;
	}
}
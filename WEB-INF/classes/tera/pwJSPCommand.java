package tera;
import java.util.ArrayList;

class pwJSPCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		resc.setTarget("PW");
		return resc;
	}
}
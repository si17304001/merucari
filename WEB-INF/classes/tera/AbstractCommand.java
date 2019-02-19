package tera;
import java.util.Map;

public abstract class AbstractCommand{
	private RequestContext reqContext;
	//private Object result;

	public void init(RequestContext reqc){
		reqContext = reqc;
	}

	public RequestContext getRequestContext(){
		return reqContext;
	}
	public abstract  ResponseContext execute(ResponseContext resc);
}

package tera;

import java.io.IOException;
import java.util.Properties;
import java.util.Map;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public abstract class CommandFactory{
	public static AbstractCommand getCommand(RequestContext rc){
		AbstractCommand command=null;
		
		Properties prop= new Properties();
		try{
			prop.load(new FileInputStream("c:/webapps/merucari/commands.properties"));
			
			String name =prop.getProperty(rc.getCommandPath());
			
			Class c=Class.forName(name);
			
			command=(AbstractCommand)c.newInstance();
		}catch(FileNotFoundException e){
			throw new RuntimeException(e.getMessage(), e);
		}catch(IOException e){
			throw new RuntimeException(e.getMessage(), e);
		}catch(ClassNotFoundException e){
			throw new RuntimeException(e.getMessage(), e);
		}catch(InstantiationException e){
			throw new RuntimeException(e.getMessage(), e);
		}catch(IllegalAccessException e){
			throw new RuntimeException(e.getMessage(), e);
		}
		return command;
	}
}

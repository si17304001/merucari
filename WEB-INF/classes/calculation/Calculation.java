package calculation;

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


public class Calculation{
		public static int calculation(int price){
			int commission = 0;
			Properties prop= new Properties();
		try{
			prop.load(new FileInputStream("c:/webapps/merucari/commission.properties"));
			
			String  comstr= prop.getProperty("com");
			
			int com = Integer.parseInt(comstr);
			System.out.println(com);
			  commission = price/100 * com;
			
			System.out.println(commission);
	}catch(FileNotFoundException e){
			throw new RuntimeException(e.getMessage(), e);
		}catch(IOException e){
			throw new RuntimeException(e.getMessage(), e);
		}
			return commission;
}
}
package dao;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class OraDaoFactory extends AbstractDaoFactory{
	public IDao getConcreteDao(String key){
		IDao id = null;
		Properties prop = new Properties();
		System.out.println("OraDaoFactory(getFactory)：開始");
		
		try{
			prop.load(new FileInputStream("c:/webapps/merucari/dao.properties"));
			
			String name = prop.getProperty(key);

			Class c = Class.forName(name);
			
			id = (IDao) c.newInstance();
			
		
		}catch(FileNotFoundException e){
			throw new RuntimeException(e.getMessage(), e);
		}catch(ClassNotFoundException e){
			throw new RuntimeException(e.getMessage(), e);
		}catch(InstantiationException e){
			throw new RuntimeException(e.getMessage(), e);
		}catch(IllegalAccessException e){
			throw new RuntimeException(e.getMessage(), e);
		}catch(IOException e){
			throw new RuntimeException(e.getMessage(), e);
		}
		System.out.println("AbstractDao(getFactory)：終了");
		return id;
	}
}
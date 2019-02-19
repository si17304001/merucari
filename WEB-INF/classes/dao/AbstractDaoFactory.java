package dao;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public abstract class AbstractDaoFactory{
	public static AbstractDaoFactory getFactory(String com){
		AbstractDaoFactory factory = null;
		Properties prop = new Properties();
		System.out.println("AbstractDao(getFactory)：開始");
		
		try{
			prop.load(new FileInputStream("c:/webapps/merucari/dao.properties"));
			
			String name = prop.getProperty(com);

			Class c = Class.forName(name);
			
			factory = (AbstractDaoFactory) c.newInstance();
			
		
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
		return factory;
	}
	
	public abstract IDao getConcreteDao(String key);
}
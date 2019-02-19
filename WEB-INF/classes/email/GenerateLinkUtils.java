package email;  
  
import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;  
  
import javax.servlet.ServletRequest;  
  
import bean.*;
import tera.*;

/** 
 * ����??�����A�d�V?�u��?�I?�� 
 */  
public class GenerateLinkUtils {  
      
    private static final String CHECK_CODE = "checkCode";  
      
      
    /** 
     * �����d?��?�I?�� 
     */  
    public static String generateResetPwdLink(UserBean user) {  
        return "http://localhost:8080/merucari/resetPassword?Email="   
                + user.getEmail() + "&" + CHECK_CODE + "=" + generateCheckcode(user);  
    }  
      
    /** 
     * ����????�IMD5�Z?? 
     * @param user  �v�����I?? 
     * @return ���p?���a��??���@�C��?md5�����@�I16?���i���I������ 
     */  
    public static String generateCheckcode(UserBean user) {  
        String userName = user.getEmail();  
        String randomCode = user.getRandomCode();  
        return md5(userName + ":" + randomCode);  
    }  
      
    /** 
     * ??�Z??���ۘa���e??���I???��v 
     * @param user �v�����I?? 
     * @param checkcode ���e??���I�Z?? 
     * @return �@�ʈ�v�ԉ�true�C��?�ԉ�false 
     */  
    public static boolean verifyCheckcode(UserBean user,ServletRequest request) {  
        String checkCode = request.getParameter(CHECK_CODE);  
        return generateCheckcode(user).equals(checkCode);  
    }  
  
    private static String md5(String string) {  
        MessageDigest md = null;  
        try {  
            md = MessageDigest.getInstance("md5");  
            md.update(string.getBytes());  
            byte[] md5Bytes = md.digest();  
            return bytes2Hex(md5Bytes);  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        }  
          
        return null;  
    }  
      
    private static String bytes2Hex(byte[] byteArray)  
    {  
        StringBuffer strBuf = new StringBuffer();  
        for (int i = 0; i < byteArray.length; i++)  
        {  
            if(byteArray[i] >= 0 && byteArray[i] < 16)  
            {  
                strBuf.append("0");  
            }  
            strBuf.append(Integer.toHexString(byteArray[i] & 0xFF));  
        }  
        return strBuf.toString();  
    }  
}
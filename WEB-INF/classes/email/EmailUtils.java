package email;
import java.io.IOException;  
import java.io.InputStream;  
import java.util.Date;  
import java.util.Properties;  
  
import javax.mail.Authenticator;  
import javax.mail.Message.RecipientType;  
import javax.mail.PasswordAuthentication;  
import javax.mail.Session;  
import javax.mail.Transport;  
import javax.mail.internet.InternetAddress;  
import javax.mail.internet.MimeMessage;  
import bean.*;
import tera.*;
  
  
public class EmailUtils {  
      
    private static final String FROM = "test@92kan.xyz";  
    

    /** 
     * ?���d?��??�ړI?�� 
     */  
    public static void sendResetPasswordEmail(UserBean user) {  
        Session session = getSession();  
        MimeMessage message = new MimeMessage(session);  
        try {  
            message.setSubject("�p�X���[�h�ύX�葱���̂��ē�");  
            message.setSentDate(new Date());  
            message.setFrom(new InternetAddress(FROM));  
            message.setRecipient(RecipientType.TO, new InternetAddress(user.getEmail()));  
            message.setContent("�p�X���[�h�̍Đݒ�����肢�������܂��B<br/>------------------------------<br/>���p�X���[�h�Đݒ�葱����<br/><a href='" + GenerateLinkUtils.generateResetPwdLink(user) +"'>�N���b�N����</a><br/>------------------------------<br/>�y�����Ӂz<br/>����LURL�ł̃p�X���[�h�ύX�́A���̂݉\�ł��B�߂�{�^����������URL�͖����ɂȂ�܂��B<br/>���p�X���[�h�Đݒ�̗L�����Ԃ͂����p��t��12���Ԃł��B<br/>���p�X���[�h�Đݒ�̃��[���𕡐��񑗐M�����ꍇ�A�Ō�Ɏ�M�������[���ȊO�͖����ƂȂ�܂��̂ł����ӂ��������B<br/>���{���[���͔z�M��p�ł��B���ԐM�����邱�Ƃ��ł��܂���̂ŗ\�߂��������������B<br/>*****************************","text/html;charset=utf-8");  
              
            Transport.send(message);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
      
    public static Session getSession() {  
        Properties props = new Properties();  
        props.setProperty("mail.transport.protocol", "smtp");  
        props.setProperty("mail.smtp.host", "smtp.92kan.xyz");  
        props.setProperty("mail.smtp.port", "587");  
        props.setProperty("mail.smtp.auth", "true");
    	props.put("mail.smtp.starttls.enable", "true");
    	props.put("mail.smtp.ssl.trust", "*");
        Session session = Session.getInstance(props, new Authenticator() {  
            @Override  
            protected PasswordAuthentication getPasswordAuthentication() {  
                String password = null;  
                InputStream is = EmailUtils.class.getResourceAsStream("password.dat");  
                byte[] b = new byte[1024];  
                try {  
                    int len = is.read(b);  
                    password = new String(b,0,len);  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
                return new PasswordAuthentication(FROM, password);  
            }  
              
        });  
        return session;  
    }  
}  
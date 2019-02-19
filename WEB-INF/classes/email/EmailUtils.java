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
     * ?送重?密??接的?件 
     */  
    public static void sendResetPasswordEmail(UserBean user) {  
        Session session = getSession();  
        MimeMessage message = new MimeMessage(session);  
        try {  
            message.setSubject("パスワード変更手続きのご案内");  
            message.setSentDate(new Date());  
            message.setFrom(new InternetAddress(FROM));  
            message.setRecipient(RecipientType.TO, new InternetAddress(user.getEmail()));  
            message.setContent("パスワードの再設定をお願いいたします。<br/>------------------------------<br/>＜パスワード再設定手続き＞<br/><a href='" + GenerateLinkUtils.generateResetPwdLink(user) +"'>クリックして</a><br/>------------------------------<br/>【ご注意】<br/>※上記URLでのパスワード変更は、一回のみ可能です。戻るボタンを押すとURLは無効になります。<br/>※パスワード再設定の有効時間はご利用受付後12時間です。<br/>※パスワード再設定のメールを複数回送信した場合、最後に受信したメール以外は無効となりますのでご注意ください。<br/>※本メールは配信専用です。ご返信を承ることができませんので予めご了承ください。<br/>*****************************","text/html;charset=utf-8");  
              
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
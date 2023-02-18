import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class ConfirmationEmailSender {
    public ConfirmationEmailSender() {}
    private final String from = "okarintiba@gmail.com";
    private Session emailsettings(){
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("okarintiba@gmail.com", "clhjszfzlsubozod");
            }

        });
        session.setDebug(false);
        return session;
    }
    public String send(String to){
        var code = String.valueOf((int)(100000 + Math.random() * 899999));
        try {
            MimeMessage message = new MimeMessage(emailsettings());
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("2Factor Auth!");
            message.setText(code);
            System.out.println("sending...");
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
        return code;
    }

}

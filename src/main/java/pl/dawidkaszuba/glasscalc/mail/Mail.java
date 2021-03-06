package pl.dawidkaszuba.glasscalc.mail;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

@Component
public class Mail {

    @NotEmpty(message = "no recipients")
    private List<String> mailTo;
    private String subject;
    @NotBlank(message = "lack of content")
    private String message;

    public List<String> getMailTo() {
        return mailTo;
    }

    public void setMailTo(List<String> mailTo) {
        this.mailTo = mailTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void send(String from, String password, List<String> to, String sub, String msg){


        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from,password);
                    }
                });

        try {
            MimeMessage message = new MimeMessage(session);

            for (String recipient : to) {

                message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

            }
            message.setSubject(sub);
            message.setText(msg);

            Transport.send(message);
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }

    }
}





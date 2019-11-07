package company_candidates.email;

import com.sun.security.sasl.Provider;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.security.Security;
import java.time.Instant;
import java.util.Date;
import java.util.Properties;

//model to send mail, see updated props bellow in sendMail()
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Properties;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//public class Report {
//    public void sendMail() {
//        //Setting up configurations for the email connection to the Google SMTP server using TLS
//        Properties props = new Properties();
//        props.put("mail.smtp.host", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "587");
//        props.put("mail.smtp.auth", "true");
//        //Establishing a session with required user details
//        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication("youremail@gmail.com", "yourpassword");
//            }
//        });
//        try {
//            //Creating a Message object to set the email content
//            MimeMessage msg = new MimeMessage(session);
//            //Storing the comma seperated values to email addresses
//            String to = "recepient1@email.com,recepient2@gmail.com";
//            /*Parsing the String with defualt delimiter as a comma by marking the boolean as true and storing the email
//            addresses in an array of InternetAddress objects*/
//            InternetAddress[] address = InternetAddress.parse(to, true);
//            //Setting the recepients from the address variable
//            msg.setRecipients(Message.RecipientType.TO, address);
//            String timeStamp = new SimpleDateFormat("yyyymmdd_hh-mm-ss").format(new Date());
//            msg.setSubject("Sample Mail : " + timeStamp);
//            msg.setSentDate(new Date());
//            msg.setText("Sampel System Generated mail");
//            msg.setHeader("XPriority", "1");
//            Transport.send(msg);
//            System.out.println("Mail has been sent successfully");
//        } catch (MessagingException mex) {
//            System.out.println("Unable to send an email" + mex);
//        }
//    }
//}
public class EmailService {

    private static void sendEmail() {
        //Setting up configurations for the email connection to the Google SMTP server using TLS
//        Properties props = new Properties();
//        props.put("mail.smtp.host", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "587");
//        props.put("mail.smtp.auth", "true");

        Security.addProvider(new Provider());
        Properties prop = new Properties();
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.host", "smtp.gmail.com");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        prop.put("mail.smtp.socketFactory.fallback", "false");
        prop.setProperty("mail.smtp.quitwait", "false");


        //Establishing a session with required user details
        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("testertesting557@gmail.com", "testers1@");
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            String receivers = "testertesting557@gmail.com,paulandrei173@yahoo.com";
            InternetAddress[] receiverAddresses = InternetAddress.parse(receivers);

            message.setRecipients(Message.RecipientType.TO, receiverAddresses);
            message.setSubject("Test email");
            message.setSentDate(Date.from(Instant.now()));
            message.setText("");
//            message.addFrom(); //pt a adauga custom sent from mail


//            Multipart multipart = new MimeMultipart();
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent("this is a test mail", "text/html");
//            multipart.addBodyPart(mimeBodyPart);

            MimeBodyPart attachmentBodyPart = new MimeBodyPart();
            attachmentBodyPart.attachFile(new File("candidati-acceptati.json"));

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
            multipart.addBodyPart(attachmentBodyPart);
            message.setContent(multipart);


            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Mail could not be sent.");

        }
    }

    public static void main(String[] args) {
        sendEmail();
    }
}

package Utils;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSendingUtils {

  
    public static boolean sendEmail(String recipientEmail, String subject, String messageBody) {
        // Sender's email and password (use environment variables or secure vault for production)
        final String senderEmail = "your-email@example.com"; // Replace with your email
        final String senderPassword = "your-email-password"; // Replace with your password

        // Configuring email properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com"); // Change if using a different email provider
        props.put("mail.smtp.port", "587");

        // Creating a session with an authenticator
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            // Creating the email
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject(subject);
            message.setText(messageBody);

            // Sending the email
            Transport.send(message);
            System.out.println("Email sent successfully to " + recipientEmail);
            return true;
        } catch (MessagingException e) {
            System.out.println("Failed to send email: " + e.getMessage());
            return false;
        }
    }

    
    public static void main(String[] args) {
        // Test email sending
        String testRecipient = "test-recipient@example.com"; // Replace with test email
        String subject = "Welcome to Lost & Found";
        String body = "Thank you for registering with Lost & Found!";

        boolean isSent = sendEmail(testRecipient, subject, body);
        System.out.println("Was the email sent? " + isSent);
    }
}

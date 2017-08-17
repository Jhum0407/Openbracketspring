package h.j.results;
import java.util.List;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class  Mail {
    static final String FROM = "jeriah.humphrey@outlook.com";   // Replace with your "From" address. This address must be verified.
    // Supply your SMTP credentials below. Note that your SMTP credentials are different from your AWS credentials.
    static final String SMTP_USERNAME = "AKIAI3QGYBJGOFED27ZA";  // Replace with your SMTP username.
    static final String SMTP_PASSWORD = "Aje1gNbBB6PgVHt7pztnds7hmHGiVY99rlasc1AAxzjs";  // Replace with your SMTP password.

    // Amazon SES SMTP host name. This example uses the US West (Oregon) Region.
    static final String HOST = "email-smtp.us-east-1.amazonaws.com";

    // The port you will connect to on the Amazon SES SMTP endpoint. We are choosing port 25 because we will use
    // STARTTLS to encrypt the connection.
    static final int PORT = 25;

    public void sendMail(User user) throws Exception {

        // Create a Properties object to contain connection configuration information.
        Properties props = System.getProperties();
        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtp.port", PORT);

        // Set properties indicating that we want to use STARTTLS to encrypt the connection.
        // The SMTP session will begin on an unencrypted connection, and then the client
        // will issue a STARTTLS command to upgrade to an encrypted connection.
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.starttls.required", "true");

        // Create a Session object to represent a mail session with the specified properties.
        Session session = Session.getDefaultInstance(props);

        // Create a message with the specified information.
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(FROM));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
        msg.setSubject("OpenBracket Invite Test");
        msg.setContent("Hello " + user.getName() + ", you have been invited to participate in the Open Bracket Competit  ion. You" +
                "can log in at https://openbracket.org/login. Your username is your email address and your password is ???","text/plain");

        // Create a transport.
        Transport transport = session.getTransport();

        // Send the message.
        try
        {
            System.out.println("Attempting to send an email through the Amazon SES SMTP interface...");

            // Connect to Amazon SES using the SMTP username and password you specified above.
            transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);

            // Send the email.
            transport.sendMessage(msg, msg.getAllRecipients());
            System.out.println("Email sent!");
        }
        catch (Exception ex) {
            System.out.println("The email was not sent.");
            System.out.println("Error message: " + ex.getMessage());
        }
        finally
        {
            // Close and terminate the connection.
            transport.close();
        }
    }
    public void sendBulk(List <User> users )throws Exception{
        for (User user:users  ) {
            sendMail(user);
        }
    }
}

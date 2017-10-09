
package h.j.results;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.imageio.*;


public class  Mail {
/*
    private String results="";

    static final String FROM = "win@openbracket.org";   // Replace with your "From" address. This address must be verified.
    // Supply your SMTP credentials below. Note that your SMTP credentials are different from your AWS credentials.
    static final String SMTP_USERNAME = "AKIAJCPTLKY4KDWDRI7A";  // Replace with your SMTP username.
    static final String SMTP_PASSWORD = "Ar2gLTxPSVG1fwobx+oBVzyyZXT7Ut1MbaPaYLe/qRs1";  // Replace with your SMTP password.

    // Amazon SES SMTP host name. This example uses the US West (Oregon) Region.
    static final String HOST = "email-smtp.us-east-1.amazonaws.com";

    // The port you will connect to on the Amazon SES SMTP endpoint. We are choosing port 25 because we will use
    // STARTTLS to encrypt the connection.
    static final int PORT = 25;
    BufferedImage img;

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
        String message = "<!DOCTYPE html><html><head><title>OpenBracket Hotel Information</title> <link rel='stylesheet' type='text/css' ></head>" +
                "<body>"+ "<p>Hello " + user.getName() +",</p>" +
                "<p>Congratulations again in earning your spot as a Qualifying Participant in OpenBracket, the country's biggest, head-to-head in-person, algorithmic coding championship.\n" +
                "The championship will take place in Wilmington, Delaware from Friday, Oct. 20 to Sunday, Oct. 22, 2017. </p>  " +
                "<p>This email is about the final steps for your travel and directed only at those of you who ranked high enough in our online qualifying round to earn financial support, " +
                "in hotel coverage and/or a travel stipend. </p><p>Your hotel reservation is already confirmed for Friday, Oct. 20 to Sunday, Oct 22. No further action is needed on your part,  unless you need accommodations outside of those dates. If you do need additional accommodations, \n" +
                "please respond to this email address before the end of day Thursday Oct 5th.</p>" +
                "<p>Travel stipends will be distributed onsite on Sunday Oct 22 to those eligible to receive them.</p>" +
                "<p>Looking forward to seeing you!</p> " +
                "<p>Let us know if you have any questions. Find out more at <a href='https://openbracket.org/'>OpenBracket.org.</a></p>"+
                " </body></html>";
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
        msg.setSubject("OpenBracket Hotel Information ");
        msg.setContent(message,"text/html; charset=utf-8");

        // Create a transport.1
        Transport transport = session.getTransport();

        // Send the message.
        try
        {
            System.out.println("Attempting to send an email to " + user.getEmail() + " through the Amazon SES SMTP interface...");

            // Connect to Amazon SES using the SMTP username and password you specified above.
            transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);

            // Send the email.
            transport.sendMessage(msg, msg.getAllRecipients());
            System.out.println("Email sent!");
            results += "The email to " + user.getEmail() +" was sent." + "\n";
        }
        catch (Exception ex) {
            results += "The email to " + user.getEmail() +" was not sent." + " Error message: " + ex.getMessage()+ "\n";
            System.out.println("The email was not sent.");
            System.out.println("Error message: " + ex.getMessage());
        }
        finally
        {
            // Close and terminate the connection.
            transport.close();
        }
    }
    public void sendBulk(User[] users )throws Exception{
        for (User user:users  ) {
            sendMail(user);
        }
    }
    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

*/
}

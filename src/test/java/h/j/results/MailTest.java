package h.j.results;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MailTest {
   // Mail mail;
    User jeriah;
    User j2;
    User j3;
    User[]users;
    User tariq;

    @Before
    public void setUp(){
        users= new User[3];
        jeriah = new User();
        tariq= new User();
        j2= new User();
       // mail= new Mail();
        jeriah.setEmail("jhum0407@yahoo.com");
        jeriah.setName("Jeriah Humphrey");
        jeriah.setUsername("Jelehu");
        jeriah.setZipCode("6905");
        j2.setEmail("jeriah.humphrey@outloook.com");
        j2.setName("Jeriah Humphrey");
        j2.setUsername("Jelehu");
        j2.setZipCode("19124");
        tariq.setEmail("tariq@zipcodewilmington.com");
        tariq.setName("Tariq Hook");
        tariq.setUsername("coderhino");
        tariq.setZipCode("19000");
        users[0]=jeriah;
        users[1]=j2;
        users[2]=tariq;


    }
    /*
    @Test
    public void sendMailTest() throws Exception {
        mail.sendMail(jeriah);

    }

    @Test
    public void sendBulkTest()throws Exception{
        mail.sendBulk(users);
    }
*/
}

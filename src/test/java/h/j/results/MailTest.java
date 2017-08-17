package h.j.results;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MailTest {
    Mail mail;
    User andy;
    User jeriah;
    User jeriahAgain;
    List <User> users;

    @Before
    public void setUp(){
        users= new ArrayList<>();
        mail= new Mail();
        andy= new User();
        andy.setName("Andy Kim");
        andy.setEmail("andyvkim@gmail.com");
        jeriah=new User();
        jeriah.setEmail("jhum0407@yahoo.com");
        jeriah.setName("Jeriah Humphrey");
        jeriahAgain=new User();
        jeriahAgain.setEmail("jeriah.humphrey@outlook.com");
        jeriahAgain.setName("Jeriah Humphrey");
    }
    @Test
    public void sendMailTest() throws Exception {
        mail.sendMail(jeriah);
    }

        @Test
    public void sendBulkTest()throws Exception{
        users.add(andy);
        users.add(jeriah);
        users.add(jeriahAgain);
        mail.sendBulk(users);
    }

}
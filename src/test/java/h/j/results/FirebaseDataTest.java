package h.j.results;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class FirebaseDataTest {
    Clock clock;
    FirebaseData data;
    User andy;
    User jeriah;
    User jeriahAgain;
    Map<String, Clock> map;

    @Before
    public void setUp(){
        clock = new Clock();
        clock.setTime("3:00");
        data = new FirebaseData();
        map=new HashMap<>();
       map.put("time",clock);
    }

    @Test
    public void initializeTest() throws Exception{
        data.initialize();
    }

    @Test
    public void getUserDataTest()throws Exception{
        data.initialize();
        data.getUserData();
        assertEquals("Error fetching user data", data.getMessage());
    }
    @Test
    public void addToDatabase() throws Exception {
        data.initialize();
        data.addToDatabase(map);
    }
    @Test
    public void SendMessageTest(){
        data.sendMessage(55);
    }

}
package h.j.results;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class FirebaseDataTest {
    FirebaseData data;
    User andy;
    User jeriah;
    User jeriahAgain;
    Map<String, User> map;

    @Before
    public void setUp(){
        data = new FirebaseData();
        map=new HashMap<>();
        andy= new User();
        andy.setName("Andy Kim");
        andy.setEmail("andyvkim@gmail.com");
        jeriah=new User();
        jeriah.setEmail("jhum0407@yahoo.com");
        jeriah.setName("Jeriah Humphrey");
        jeriahAgain=new User();
        jeriahAgain.setEmail("jeriah.humphrey@outlook.com");
        jeriahAgain.setName("Jeriah Humphrey");
        map.put(jeriah.getName(),jeriah);
        map.put(andy.getName(),andy);
        map.put(jeriahAgain.getName(),jeriahAgain);
    }
    @Test
    public void addToDatabase() throws Exception {
        data.initialize();
        data.addToDatabase(map);
    }

}
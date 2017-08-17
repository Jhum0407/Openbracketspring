package h.j.results;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserListTest {
    UserList userList;
    User user;

    @Before
    public void setUp(){
        userList=new UserList();
        user = new User();
    }
    @Test
    public void addTest(){
        userList.add(user);
        userList.add(user);
        assertEquals(2, userList.getList().size());
    }
    @Test
    public void setDistance() throws Exception {
        userList.add(user);
        userList.setDistance(userList.getList().get(0),"50");
        assertEquals("50", userList.getList().get(0).getDistance());
    }

    @Test
    public void convertDistance() throws Exception {
        assertEquals(250, userList.convertDistance("250 mi"),0);
    }

    @Test
    public void getList() throws Exception {
    }

    @Test
    public void getNewList() throws Exception {
    }


}
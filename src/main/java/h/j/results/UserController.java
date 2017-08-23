package h.j.results;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {
    User[] users;
    UserList userList;
    FirebaseData firebaseData= new FirebaseData();
    Mail mail= new Mail();

    @RequestMapping("/json")
    public User[] makePeople() throws java.io.IOException, Exception {

        ObjectMapper mapper = new ObjectMapper();
        users = mapper.readValue(new File("C:\\Users\\Jelehu\\Documents\\openbracket17.json"), User[].class);
            return users;
    }


    @RequestMapping("/sendfile")
    public List sendPeople() throws java.io.IOException, Exception {
        makePeople();
        userList=new UserList(users);
        userList.sortList();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("C:\\Users\\Jelehu\\Documents\\userlist.json"), userList.getNewList());
       // mail.sendBulk(userList.getNewList());
        return userList.getNewList();

    }







}


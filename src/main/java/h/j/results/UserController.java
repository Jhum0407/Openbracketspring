package h.j.results;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
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
    UserList userList = new UserList();

    @RequestMapping("/consumefile")
    public void makePeople() throws java.io.IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
        users = mapper.readValue(new File("C:\\Users\\Jelehu\\Documents\\userlist.json"), User[].class);

    }


    @RequestMapping("/sendfile")
    public String sendPeople() throws java.io.IOException {
        makePeople();
        userList=new UserList(users);
        userList.sortList();
        return userList.toString();
    }



}


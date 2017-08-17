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
    UserList userList;

    @RequestMapping("/json")
    public String makePeople() throws java.io.IOException {
        ObjectMapper mapper = new ObjectMapper();
        users = mapper.readValue(new File("C:\\Users\\Jelehu\\Documents\\openbracket17.json"), User[].class);
        String result ="";
        for (User user:users ) {
            result += user.toString() + "\n";
        }
            return result;
    }


    @RequestMapping("/sendfile")
    public User[] sendPeople() throws java.io.IOException {
        makePeople();
        userList=new UserList(users);
        userList.sortList();
        ObjectMapper mapper = new ObjectMapper();
        User[] finalList= userList.getList().toArray(new User[userList.getList().size()]);
        mapper.writeValue(new File("C:\\Users\\Jelehu\\Documents\\total.json"), finalList);
        return finalList;
    }







}


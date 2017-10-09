package h.j.results;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.*;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.springframework.web.bind.annotation.*;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {
    User[] users;
    UserList userList;
    FirebaseData firebaseData= new FirebaseData();
    HackerrankInvite invite= new HackerrankInvite();
    //Mail mail= new Mail();
    Map <String, Clock> mapClock;
    Clock clock;
/*
    @RequestMapping("/json")
    public String makeMailPeople() throws java.io.IOException, Exception {
        String result= "";
        ObjectMapper mapper= new ObjectMapper();
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        users = mapper.readValue(new File("C:\\Users\\Jelehu\\Documents\\finalUserlist.json"), User[].class);
        for (User user:users
             ) {
            result += user.toString() + "\n";
        }
        return result;
    }
    */

    @PostMapping("/people")
    public List<User> makePeople() throws java.io.IOException, Exception {

        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        userList= new UserList( mapper.readValue(new File("C:\\Users\\Jelehu\\Documents\\data4.json"),User[].class));
        return userList.getList();
    }

/*
    @RequestMapping("/mail")
    public String sendMail() throws java.io.IOException, Exception {
        makePeople();
        mail.sendBulk(users);
        return mail.getResults();

    }
*/

    @RequestMapping(value = "/redirect", method = RequestMethod.PUT)
    public Map<String, Clock> sendClock(){
        mapClock = new HashMap<>();
        clock.setTime("3:30");
        mapClock.put("time",clock);
        return mapClock;

    }

    @RequestMapping("/list")
    public User[] sendList() throws java.io.IOException, Exception {
        makePeople();
        userList=new UserList(users);
        ObjectMapper mapper = new ObjectMapper();
        User[] finalList = userList.generateSecondRound().toArray(new User[userList.getRoundTwoList().size()]);
        mapper.writeValue(new File("C:\\Users\\Jelehu\\Documents\\USUninvited"), finalList);
        return finalList;


    }

    @PostMapping("/invite")
    public HackerrankInvite sendInvite(){
        invite.setUsername("jhum0407@yahoo.com");
        invite.setForce(false);
        invite.setSend_email(true);
        invite.setHide_login_credentials(true);
        try {
            invite.inviteCandidate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return invite;
    }







}


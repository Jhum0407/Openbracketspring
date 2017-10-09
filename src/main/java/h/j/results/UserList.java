package h.j.results;
import org.springframework.web.client.RestTemplate;
import java.util.*;
public class UserList {
    private int id = 1;
    private DistanceCalculator distanceCalculator;
    private List<User> list= new ArrayList<>();
    private List <NewUser> shortlist= new ArrayList<>();
    private List<User> newList = new ArrayList<>();
    private List <User> americanList= new ArrayList<>();



    private List<User> roundTwoList= new ArrayList<>();
    private String apiKey;
    private String url;
    private int newIndex;
    private int splitIndex;
    private int count;
    public UserList(){

    }
    public UserList(NewUser[] mailUsers){
          for (NewUser user:mailUsers) {
            this.addShortList(user);
        }
    }
    public UserList(User[]users){
        for (User user:users ) {
            this.add(user);
        }
    }
    public List<User> getRoundTwoList() {
        return roundTwoList;
    }

    public List<User> generateTop50() {
        int counter=0;
        for (int i=0; i < list.size(); i++) {
            if(list.get(i).getCountry().equals("United States")) {
                list.get(i).setStatus("Invited");
                this.setDistances(i);
                newList.add(list.get(i));
                counter++;
            }
            if(counter==50){
                newIndex=i+1;
                return newList;
            }
        }
        return newList;
    }

    public User createUser(String name){
        User user = new User();
        return user;
    }

    public List<NewUser> getShortlist() {
        return shortlist;
    }

    public void setShortlist(List<NewUser> shortlist) {
        this.shortlist = shortlist;
    }

    public List<User> generateNext25(){
        System.out.println(newIndex);
            int counter = 0;
            for(int i=newIndex;i<list.size();i++){
                if (list.get(i).getGender().equalsIgnoreCase("Woman")&&list.get(i).getCountry().equals("United States")){
                    list.get(i).setStatus("Invited");
                    newList.add(list.get(i));
                    this.setDistances(i);
                    counter ++;
                }
                if (counter==25){
                    splitIndex=i+1;
                    return newList;
                }
                splitIndex=i+1;
            }

        return newList;
    }


    public List<User> generateRestOne() {

        for (int i = newIndex; i < splitIndex; i++) {
            if ((list.get(i).getCountry().equals("United States")&&(!(list.get(i).getGender().equalsIgnoreCase("Woman")))
            &&list.get(i).getZipCode().length()==5)) {
                System.out.println("index : " + i);
                this.setDistances(i);

                if (convertDistance(list.get(i).getDistance()) <= 100) {
                    list.get(i).setStatus("Invited");
                    newList.add(list.get(i));
                    count++;
                    System.out.println("count: " + count);
                }
            }

            if (count == 50) {
                return newList;
            }
        }
            return newList;

    }
    public List<User> generateRestTwo() {

        for (int i = splitIndex; i < list.size(); i++) {

            if (list.get(i).getCountry().equals("United States")&&list.get(i).getZipCode().length()==5) {
                System.out.println("index : " + i);
                this.setDistances(i);
                if (convertDistance(list.get(i).getDistance()) < 100) {
                    list.get(i).setStatus("Invited");
                    newList.add(list.get(i));
                    count++;
                    System.out.println("count: " + count);
                }
            }

            if (count == 50) {
                return newList;
            }
        }
        return newList;
    }

    public List<User> generateSecondRound() {

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).getStatus().equalsIgnoreCase("no")){
                System.out.println("index : " + i);
                this.setDistances(i);
                    roundTwoList.add(list.get(i));

            }

        }
        Collections.sort(roundTwoList);

        return roundTwoList;

    }


    public List<User> sortList() {
        generateTop50();
        generateNext25();
        generateRestOne();
        if(count<50){
            generateRestTwo();
        }
        return newList;
    }

    public void generateDistance(int index){
        apiKey ="AIzaSyAwEjKxNaz6zxYzN3hOqcAC4dBZ3O0IcCQ";
        url = "https://maps.googleapis.com/maps/api/distancematrix/json?units=imperial&origins="+list.get(index).getZipCode()+"&destinations=+19801&key="+ apiKey;
        System.out.println(url);
        RestTemplate restTemplate = new RestTemplate();
        distanceCalculator=restTemplate.getForObject(url ,DistanceCalculator.class);
    }

    public List<User> getAmericanList() {
        for(int i=0;i<list.size();i++){
            if(list.get(i).getCountry().equalsIgnoreCase("United States")){
                americanList.add(list.get(i));
            }
        }
        return americanList;
    }

    public String setDistance(User user, String distance){
         user.setDistance(distance);
         return user.getDistance();
    }

    public void setDistances(int index){
        generateDistance(index);
        this.setDistance(list.get(index),distanceCalculator.getRows()[0].getElements()[0].getDistance().getText());
    }

    public double convertDistance(String distance){
        distance=distance.replace(",","");
        return Double.parseDouble(distance.substring(0,distance.length()-3));
    }

  //  }

    public List <User> getList() {
        return list;
    }

    public List<User> getNewList() {
        return newList;
    }

    public void add(User user){
        list.add(user);
    }

    public void addShortList(NewUser newUser){
        shortlist.add(newUser);
    }

    public void setList(List <User> list) {
        this.list = list;
    }



    @Override
    public String toString(){
        String result = "";
        for (User user:list
             ) {
            result += user.toString() + " \n";

        }
        return result;
    }
}

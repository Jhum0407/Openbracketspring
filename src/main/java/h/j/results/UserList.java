package h.j.results;
import java.util.*;
public class UserList {

    private List<User> list= new ArrayList<User>();
    private List <User> newList = new ArrayList<User>();
    public UserList(){

    }
    public UserList(User[] users){
        for (User user:users) {
            this.add(user);
        }
    }

    public List <User> generateTop50() {
        for (int i = 0; i < 50; i++) {
            newList.add(list.get(i));
        }
        return newList;
    }

    public List <User> generateNext25(){
            int counter = 0;
            for(int i=50;i<list.size();i++){
                if (list.get(i).getGender().equals("f")){
                    newList.add(list.get(i));
                    counter ++;
                }
                if (counter==25){
                    return newList;
                }
            }



        return newList;
    }

    public List <User> generateRest() {
        for (int i = 50; i < list.size(); i++) {
            if (list.get(i).getGender().equals("m")) {
                newList.add(list.get(i));

            }

        }
        return newList;
    }


    public List<User> sortList() {
        generateTop50();
        generateNext25();
        generateRest();
        return newList;
    }

    public List <User> getList() {
        return list;
    }

    public List<User> getNewList() {
        return newList;
    }

    public void add(User user){
        list.add(user);
    }

    public void setList(List <User> list) {
        this.list = list;
    }



    @Override
    public String toString(){
        String result = "";
        for (User user:newList
                ) {
            result+= user.toString() + "\n";
        }
        return result;
    }
}

package h.j.results;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.UUID;

import com.google.firebase.*;
import com.google.firebase.auth.FirebaseCredentials;
import com.google.firebase.database.*;


public class FirebaseData {



    public void initialize() throws FileNotFoundException, Exception {

        FileInputStream serviceAccount = new FileInputStream("C:\\Users\\Jelehu\\Documents\\FirebaseSDK.json");

        FirebaseOptions options = new FirebaseOptions.Builder().setCredential(FirebaseCredentials.fromCertificate(serviceAccount))
                .setDatabaseUrl("https://openbracket-699df.firebaseio.com/").build();

        FirebaseApp.initializeApp(options);

    }

    public void addToDatabase(Map<String, User> map){
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("users");
        DatabaseReference usersRef= ref.child("users");
        usersRef.setValue(map);
    }


}

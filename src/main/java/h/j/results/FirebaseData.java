package h.j.results;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

import com.firebase.client.Firebase;
import com.google.firebase.*;
import com.google.firebase.auth.FirebaseCredentials;
import com.google.firebase.database.*;
import com.google.firebase.database.connection.PersistentConnection;
import com.google.firebase.database.connection.util.RetryHelper;
import com.google.firebase.auth.*;
import javafx.concurrent.Task;


public class FirebaseData {
    Firebase firebase;
    String message="";

public FirebaseData(){
    firebase = new Firebase("https://openbracket-699df.firebaseio.com/");
}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void sendMessage(int message){
    firebase.child("date").setValue(message);
}



    public void initialize() throws FileNotFoundException, Exception {

        FileInputStream serviceAccount = new FileInputStream("C:\\Users\\Jelehu\\Documents\\openbracket-699df-firebase-adminsdk-ncyko-26b460b627.json");

        FirebaseOptions options = new FirebaseOptions.Builder().setCredential(FirebaseCredentials.fromCertificate(serviceAccount))
                .setDatabaseUrl("https://openbracket-699df.firebaseio.com/").build();

        FirebaseApp.initializeApp(options);

    }

    public void getUserData(){
        com.google.firebase.tasks.Task<UserRecord> task = FirebaseAuth.getInstance().getUser("Luqh2p6lrXOC11fgDqTDKQR72H3")
                .addOnSuccessListener(userRecord -> {
                    // See the UserRecord reference doc for the contents of userRecord.
                    System.out.println("Successfully fetched user data: " + userRecord.getUid());
                    message="Successfully fetched user data";
                })
                .addOnFailureListener(e -> {
                    System.err.println("Error fetching user data: " + e.getMessage());
                    message="Error fetching user data";
                });
    }

    public void addToDatabase(Map<String, Clock> map){
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("date");
        ref.setValue(map);
    }


}

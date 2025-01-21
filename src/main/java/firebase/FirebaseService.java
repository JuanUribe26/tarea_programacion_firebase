package firebase;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileInputStream;
import java.io.IOException;

public class FirebaseService {

    public FirebaseService() {
        try {
            // Ruta al archivo de credenciales JSON
            FileInputStream serviceAccount = new FileInputStream("C:\\Users\\gerqu\\Downloads\\fir-d3262-firebase-adminsdk-fbsvc-a9c2bea234.json");

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://fir-d3262-default-rtdb.firebaseio.com/") 
                    .build();

            if (FirebaseApp.getApps().isEmpty()) { 
                FirebaseApp.initializeApp(options);
            }
        } catch (IOException e) {
            System.err.println("Error al inicializar Firebase: " + e.getMessage());
        }
    }

    void listItems() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
public void addItem(Item item) {
    try {
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        String itemId = database.push().getKey();  // Genera un nuevo ID para el ítem
        if (itemId != null) {
            // Agrega el ítem a Firebase bajo el nuevo ID
        }
    } catch (Exception e) {
        e.printStackTrace();
        throw new UnsupportedOperationException("Error al agregar el ítem.");
    }
}

    void deleteItem(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
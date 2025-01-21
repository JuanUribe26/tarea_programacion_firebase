package firebase;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.auth.oauth2.GoogleCredentials;

import java.io.FileInputStream;
import java.io.IOException;

public class FirebaseConfig {

    public void initializeFirebase() {
        try {
            // Ruta al archivo de credenciales JSON
            FileInputStream serviceAccount = new FileInputStream("C:\\Users\\gerqu\\Downloads\\fir-d3262-firebase-adminsdk-fbsvc-a9c2bea234.json");

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://fir-d3262-default-rtdb.firebaseio.com/") 
                    .build();

            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
                System.out.println("Firebase inicializado correctamente.");
            } else {
                System.out.println("Firebase ya estaba inicializado.");
            }
        } catch (IOException e) {
            System.err.println("Error al inicializar Firebase: " + e.getMessage());
        }
    }
}
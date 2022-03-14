package com.example.classroomiot.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.*;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class FirebaseConfig {

    private final ResourceLoader resourceLoader;

    @Autowired
    public FirebaseConfig(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Bean
    public FirebaseDatabase firebaseDatabase() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:classroom-iot-firebase-adminsdk-aayi7-58c5c571e0.json");
        InputStream inputStream = resource.getInputStream();
        FirebaseOptions firebaseOptions = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(inputStream))
                .setDatabaseUrl("https://classroom-iot-default-rtdb.asia-southeast1.firebasedatabase.app/")
                .build();
        FirebaseApp.initializeApp(firebaseOptions);
        return FirebaseDatabase.getInstance();
    }

    @Bean
    public DatabaseReference databaseReference(FirebaseDatabase firebaseDatabase) {
        DatabaseReference ref = firebaseDatabase.getReference();
        ref.addValueEventListener(new ValueEventListener() {

            @SneakyThrows
            public void onDataChange(DataSnapshot dataSnapshot) {
            }
            public void onCancelled(DatabaseError error) {
                System.out.print("Error: " + error.getMessage());
            }
        });
        return ref;
    }
}

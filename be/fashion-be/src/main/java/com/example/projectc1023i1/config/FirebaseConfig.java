package com.example.projectc1023i1.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;

@Component
public class FirebaseConfig {
    @Bean
    public void initializeFirebase() throws IOException {
        FileInputStream serviceAccount =
                new FileInputStream("D:\\ptran-fashion\\ptran-fashion-backend\\ptran-fashion-be\\project-C1023I1\\firebase_conf\\c1023l1-firebase-adminsdk-ydqwc-71110193d2.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setStorageBucket("c1023l1.appspot.com")
                .build();
        FirebaseApp.initializeApp(options);

    }

}

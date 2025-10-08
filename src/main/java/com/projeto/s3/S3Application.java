package com.projeto.s3;

import com.projeto.s3.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class S3Application implements CommandLineRunner {

    @Autowired
    private S3Service s3Service;

    public static void main(String[] args) {
        SpringApplication.run(S3Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        s3Service.uploadFile("c:\\Users\\nawsz\\Downloads\\images.jpg");
    }
}

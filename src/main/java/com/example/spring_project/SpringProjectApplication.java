package com.example.spring_project;

import com.example.spring_project.entities.Patient;
import com.example.spring_project.service.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringProjectApplication implements CommandLineRunner {
    @Autowired
    private PatientServiceImpl patService;

    public static void main(String[] args) {
        SpringApplication.run(SpringProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String[] names = {"walid", "malak", "anass", "houssam", "marwa", "walid", "malak", "anass", "houssam", "marwa", "walid", "malak", "anass", "houssam", "marwa", "walid", "malak", "anass", "houssam", "marwa"};

        Random random = new Random();

        for (String name : names) {
            Patient pat = new Patient();
            pat.setNom(name);
            pat.setMalade(name.equals("marwa"));
            pat.setDateNaissance(randomDate());
            pat.setScore(random.nextInt(20));
            patService.addPatient(pat);
        }
    }

    private Date randomDate() {
        long offset = Timestamp.valueOf("1970-01-01 00:00:00").getTime();
        long end = Timestamp.valueOf("2024-3-11 00:00:00").getTime();
        long diff = end - offset + 1;
        return new Date(offset + (long)(Math.random() * diff));
    }

    @Bean
    PasswordEncoder passwordEncoder (){
        return new BCryptPasswordEncoder();

    }
}
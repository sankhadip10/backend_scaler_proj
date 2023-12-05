package com.productservice.productservice;

//import com.productservice.productservice.inheritancerelations.mappedsuperclass.Mentor;
import com.productservice.productservice.inheritancerelations.tableperclass.*;
//import com.productservice.productservice.inheritancerelations.mappedsuperclass.MentorRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {
    private MentorRepository mentorRepository;
    private StudentRepository studentRepository;
    private UserRepository userRepository;
    ProductServiceApplication(@Qualifier("tpc_mentorrepository")
                              MentorRepository mentorRepository,
                              StudentRepository studentRepository,
                              UserRepository userRepository){
        this.mentorRepository = mentorRepository;
        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
    }
    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Mentor mentor = new Mentor();
//        mentor.setName("Sankhadip");
//        mentor.setEmail("sankhadip10.das@gmaiol.com");
//        mentor.setAvgRating(4.8);
//
//        mentorRepository.save(mentor);

        Mentor mentor = new Mentor();
        mentor.setName("Ricky");
        mentor.setEmail("ricky.das25@gmail.com");
        mentor.setAvgRating(4.5);
        mentorRepository.save(mentor);

        Student student = new Student();
        student.setName("Ram");
        student.setEmail("ram.das25@gmail.com");
        student.setPsp(80.0);
        studentRepository.save(student);

        User user = new User();
        user.setEmail("archi@gmail.com");
        user.setName("Archii");
        userRepository.save(user);


        List<User> users = userRepository.findAll();
        for(User user1 :users){
            System.out.println(user1.toString());
        }


    }
}

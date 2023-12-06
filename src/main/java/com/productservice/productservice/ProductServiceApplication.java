package com.productservice.productservice;

//import com.productservice.productservice.inheritancerelations.mappedsuperclass.Mentor;

import com.productservice.productservice.inheritancerelations.singletable.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {
    private MentorRepository mentorRepository;
    private UserRepository userRepository;
    private StudentRepository studentRepository;

    ProductServiceApplication(@Qualifier("st_mentorrepo") MentorRepository mentorRepository,
                              @Qualifier("st_userrepo") UserRepository userRepository,
                              @Qualifier("st_studentrepo") StudentRepository studentRepository){
        this.mentorRepository = mentorRepository;
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
    }

//    private MentorRepository mentorRepository;
//    private StudentRepository studentRepository;
//    private UserRepository userRepository;
//    ProductServiceApplication(@Qualifier("tpc_mentorrepository")
//                              MentorRepository mentorRepository,
//                              StudentRepository studentRepository,
//                              UserRepository userRepository){
//        this.mentorRepository = mentorRepository;
//        this.studentRepository = studentRepository;
//        this.userRepository = userRepository;
//    }
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
//
//        Mentor mentor = new Mentor();
//        mentor.setName("Ricky");
//        mentor.setEmail("ricky.das25@gmail.com");
//        mentor.setAvgRating(4.5);
//        mentorRepository.save(mentor);
//
//        Student student = new Student();
//        student.setName("Ram");
//        student.setEmail("ram.das25@gmail.com");
//        student.setPsp(80.0);
//        studentRepository.save(student);
//
//        User user = new User();
//        user.setEmail("archi@gmail.com");
//        user.setName("Archii");
//        userRepository.save(user);
//
//
//        //Get all the Users
//        List<User> users = userRepository.findAll();
//        for(User user1 :users){
//            System.out.println(user1.toString());
//        }
        User user =new User();
        user.setName("Arshi");
        user.setEmail("arshi@gmail.com");
        userRepository.save(user);

        Mentor mentor = new Mentor();
        mentor.setName("Deepak");
        mentor.setEmail("sankhad@gmail.com");
        mentor.setAvgRating(4.8);
        mentorRepository.save(mentor);

        Student student = new Student();
        student.setName("Sankha");
        student.setEmail("ricky.das25@gmail.com");
        student.setPsp(99.0);
        studentRepository.save(student);


    }
}

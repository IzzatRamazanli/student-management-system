package com.izzat.sms;

import com.izzat.sms.entity.Student;
import com.izzat.sms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementSystemApplication.class, args);
    }

    @Autowired
    private StudentRepository repository;

    @Override
    public void run(String... args) throws Exception {
        Student student1 = new Student("Izzat", "Ramazanli", "izzat@gmail.com");
        Student student2 = new Student("Jim", "Maxwell", "jim@gmail.com");
        repository.save(student1);
        repository.save(student2);
    }
}

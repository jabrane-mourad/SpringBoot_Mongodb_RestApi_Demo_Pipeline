package xj.students;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import xj.students.model.Student;
import xj.students.repositrory.StudentRepository;

import java.util.Date;
//test 1 by XJabrane
@SpringBootApplication
public class StudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class, args);
    }

    @Bean
    CommandLineRunner start(StudentRepository studentRepository) {
        return args -> {
            Student e1 = new Student("F14", "mourad", "jabrane", new Date(), "xjabrane@gmail.com");
            Student e2 = new Student("F147", "abdo", "lahlou", new Date(), "lahlou@gmail.com");
            Student e3 = new Student("F14s7", "rachid", "dahbi", new Date(), "dahbi@gmail.com");
            Student e4 = new Student("F14d7", "rabab", "belmebkhout", new Date(), "belmebkhout@gmail.com");
            studentRepository.save(e1);
            studentRepository.save(e2);
            studentRepository.save(e3);
            studentRepository.save(e4);
        };
    }
}

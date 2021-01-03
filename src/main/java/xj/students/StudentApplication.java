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
            Student e = new Student("F147", "mourad", "jabrane", new Date(), "xjabrane@gmail.com");
            studentRepository.save(e);
        };
    }
}

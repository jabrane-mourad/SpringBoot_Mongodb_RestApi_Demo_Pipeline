package xj.students.api;

import org.springframework.web.bind.annotation.*;
import xj.students.model.Student;
import xj.students.repositrory.StudentRepository;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    @PostMapping
    public Student saveStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @PutMapping
    public Student updateStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }


    @DeleteMapping("/{codeMasar}")
    public void deleteStudent(@PathVariable String codeMasar) {
        studentRepository.deleteById(codeMasar);
    }
}

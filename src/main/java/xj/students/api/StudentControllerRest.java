package xj.students.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xj.students.model.Student;
import xj.students.repositrory.StudentRepository;
//xj
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentControllerRest {
    private final StudentRepository studentRepository;

    //@Autowired
    public StudentControllerRest(StudentRepository studentRepository) {
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

package xj.students.repositrory;
//xj
import org.springframework.data.mongodb.repository.MongoRepository;
import xj.students.model.Student;

public interface StudentRepository extends MongoRepository<Student, String> {
}

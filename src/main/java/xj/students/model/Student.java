package xj.students.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "student")
public class Student {
    @Id
    private String codeMassar;
    private String firstname;
    private String lastname;
    private Date dateOfBirth;
    private String email;
}

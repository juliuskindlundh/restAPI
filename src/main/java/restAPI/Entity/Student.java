package restAPI.Entity;

import lombok.Data;
import lombok.Generated;
import lombok.NonNull;
import org.hibernate.id.UUIDGenerator;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
public class Student implements Serializable {
    @Id
    @Generated
    private String studentId = UUID.randomUUID().toString();

    private String firstName;
    private String lastName;
    private int age;
    private boolean present;

    public Student() {
    }
}

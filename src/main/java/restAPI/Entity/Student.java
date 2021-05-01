package restAPI.Entity;

import lombok.Data;
import lombok.Generated;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
public class Student implements Serializable {
    @Id
    @Generated
    private String studentId;

    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private int age;
    @NonNull
    private boolean present;

    public Student() {}
}

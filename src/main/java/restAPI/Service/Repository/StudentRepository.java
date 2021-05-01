package restAPI.Service.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import restAPI.Entity.Student;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudentRepository extends CrudRepository<Student, UUID> {
    Optional<Student> findByStudentId(String id);
}

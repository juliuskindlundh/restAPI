package restAPI.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restAPI.Entity.Student;
import restAPI.Service.Repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Optional<Student> createStudent(Student student) {
        studentRepository.save(student);
        Optional<Student> studentOptional = studentRepository.findByStudentId(student.getStudentId());
        return studentOptional;
    }

    public List<Student> findAll() {
        List<Student> list = new ArrayList<Student>();
        studentRepository.findAll().iterator().forEachRemaining(student -> list.add(student));
        return list;
    }

    public Optional<Student> findById() {
        return  null;
    }
}

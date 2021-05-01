package restAPI.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restAPI.Entity.Student;
import restAPI.Repository.StudentRepository;

import javax.transaction.Transactional;
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

    public Optional<Student> findById(String studentId) {
        return studentRepository.findByStudentId(studentId);
    }

    @Transactional
    public void updateStudent(String studentId,Student student) {
        Optional<Student> toUpdate = studentRepository.findByStudentId(studentId);
        if(toUpdate.isPresent()){
            if(student.getAge() != 0){
                toUpdate.get().setAge(student.getAge());
            }
            if(student.getFirstName() != null || !student.getFirstName().equals("")){
                toUpdate.get().setFirstName(student.getFirstName());
            }
            if(student.getFirstName() != null || !student.getFirstName().equals("")){
                toUpdate.get().setFirstName(student.getFirstName());
            }
            if(student.getLastName() != null || !student.getLastName().equals("")){
                toUpdate.get().setLastName(student.getLastName());
            }
            toUpdate.get().setPresent(student.isPresent());
        }
    }
}

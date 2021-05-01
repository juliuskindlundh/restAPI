package restAPI.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import restAPI.Entity.Student;
import restAPI.Service.Repository.StudentRepository;
import restAPI.Service.StudentService;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;


    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping("/students")
    ResponseEntity<Student> createStudent(@RequestParam Student student) {
        Optional<Student> response = studentService.createStudent(student);
        if (response.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response.get());
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/students")
    ResponseEntity<List<Student>> findAll(){
        List<Student> list = new ArrayList<Student>();
        studentService.findAll().iterator().forEachRemaining(student -> list.add(student));
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/students/{id}")
    ResponseEntity<Student> findById(@RequestParam String studentId){
        Optional<Student> response = studentService.findById();
        if(response.isPresent()){

        }
        return null;
    }

}

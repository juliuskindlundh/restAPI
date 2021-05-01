package restAPI.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restAPI.Entity.Student;
import restAPI.Repository.StudentRepository;
import restAPI.Service.StudentService;

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
    ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Optional<Student> response = studentService.createStudent(student);
        if (response.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response.get());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/students")
    ResponseEntity<List<Student>> findAll(){
        List<Student> list = new ArrayList<Student>();
        studentService.findAll().iterator().forEachRemaining(student -> list.add(student));
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/students/{id}")
    ResponseEntity<Student> findById(@PathVariable(name ="id") String studentId){
        Optional<Student> response = studentService.findById(studentId);
        if(response.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(response.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/students/{id}")
    ResponseEntity<Student> updateStudent(@PathVariable(name = "id") String studentId,@RequestBody Student student){
        studentService.updateStudent(studentId,student);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}

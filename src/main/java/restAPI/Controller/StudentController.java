package restAPI.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import restAPI.Entity.Student;
import restAPI.Repository.StudentRepository;
import restAPI.Service.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;

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

    @Transactional
    @RequestMapping(value="/students/{id}",produces ="application/json",method= {RequestMethod.PUT})
    ResponseEntity<Student> updateStudent(@PathVariable(name = "id") String studentId,@RequestBody Student student){
    	Optional<Student> response;
		try {
			response = studentService.updateStudent(studentId,student);
			return ResponseEntity.status(HttpStatus.OK).body(response.get());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();  
		}	
    }
    
    @RequestMapping(value="/students/{id}",method= {RequestMethod.DELETE})
    ResponseEntity<Object> deleteStudent(@PathVariable(name="id") String studentId) {
    	studentService.deleteById(studentId);
		return ResponseEntity.ok(null);
    }


}

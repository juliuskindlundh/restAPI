package restAPI.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import restAPI.Entity.Student;
import restAPI.Repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Optional<Student> createStudent(Student student) {
		// TODO make sum logics 5this
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
	public Optional<Student> updateStudent(String studentId, Student student) throws Exception {
		Optional<Student> toUpdate = studentRepository.findByStudentId(studentId);
		if (toUpdate.isPresent()) {
			toUpdate.get().setAge(student.getAge());
			toUpdate.get().setFirstName(student.getFirstName());
			toUpdate.get().setFirstName(student.getFirstName());
			toUpdate.get().setLastName(student.getLastName());
			toUpdate.get().setPresent(student.isPresent());
			studentRepository.save(toUpdate.get());
			return toUpdate;
		} else {
			throw new Exception("Entity not found");
		}
	}

	public void deleteById(String studentId) {
		studentRepository.deleteById(studentId);
		
	}
}

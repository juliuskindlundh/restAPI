package restAPI.Entity;

import lombok.Generated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Student{
    @Id @Generated
    private String studentId = UUID.randomUUID().toString();
    @GeneratedValue(strategy =GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private boolean present;
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isPresent() {
		return present;
	}
	public void setPresent(boolean present) {
		this.present = present;
	}
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", age=" + age + ", present=" + present + "]";
	}
    
    
}

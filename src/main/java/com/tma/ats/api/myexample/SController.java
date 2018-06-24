package com.tma.ats.api.myexample;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("user")
public class SController {
	@Autowired
	private IStudentService studentService;

	@GetMapping("student/{id}")
	// ResponseEntity is meant to represent the entire HTTP
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Integer id) {
		Student student = studentService.getStudentById(id);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

	@GetMapping("students")
	public ResponseEntity<List<Student>> getAllStudent() {
		List<Student> list = studentService.getAllStudent();
		return new ResponseEntity<List<Student>>(list, HttpStatus.OK);

	}

	@PostMapping("student")
	public ResponseEntity<Void> addStudent(@RequestBody Student student, UriComponentsBuilder builder) {
		boolean flag = studentService.addStudent(student);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("student")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		studentService.updateStudent(student);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

	@DeleteMapping("student/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable("id") Integer id) {
		studentService.deleteStudent(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

	}
}

package com.tma.ats.api.myexample;

import java.util.List;

public interface IStudentDAO {
	List<Student> getAllStudent();

	Student getStudentById(int studentId);

	void addStudent(Student student);

	void updateStudent(Student student);

	void deleteStudent(int studentId);

	boolean studentExists(String student);
}

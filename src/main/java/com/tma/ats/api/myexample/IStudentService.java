package com.tma.ats.api.myexample;

import java.util.List;

public interface IStudentService {

	List<Student> getAllStudent();

	Student getStudentById(int studentId);

	boolean addStudent(Student student);

	void updateStudent(Student student);

	void deleteStudent(int studentId);
}

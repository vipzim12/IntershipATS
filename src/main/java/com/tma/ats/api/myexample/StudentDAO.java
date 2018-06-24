package com.tma.ats.api.myexample;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Repository
public class StudentDAO implements IStudentDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getAllStudent() {
		String sql = " FROM Student as stu ORDER BY stu.studentId";
		return (List<Student>) entityManager.createQuery(sql).getResultList();
	}

	@Override
	public Student getStudentById(int studentId) {

		return entityManager.find(Student.class, studentId);
	}

	@Override
	public void addStudent(Student student) {
		// saving an object to the database
		entityManager.persist(student);
	}

	@Override
	public void updateStudent(Student student) {
		Student stud = getStudentById(student.getStudentId());
		stud.setStudentName(student.getStudentName());
		stud.setMath(student.getMath());
		stud.setPhysical(student.getPhysical());
		stud.setChemistry(student.getChemistry());
		// update an object to the database
		entityManager.flush();
	}

	@Override
	public void deleteStudent(int studentId) {
		entityManager.remove(getStudentById(studentId));
	}

	@Override
	public boolean studentExists(String student) {
		String sql = "FROM Student as stu WHERE stu.studentName =?";
		int count = entityManager.createQuery(sql).setParameter(1, student).getResultList().size();
		return count > 0 ? true : false;
	}

}

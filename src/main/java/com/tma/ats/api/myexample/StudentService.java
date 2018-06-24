package com.tma.ats.api.myexample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tma.ats.api.dto.FleetObject;
import com.tma.ats.api.service.FleetService;

@Service
public class StudentService implements IStudentService {
	@Autowired
	private IStudentDAO iStudentDAO;
	@Autowired
	private FleetService fleetService;

	@Override
	public List<Student> getAllStudent() {
		List<FleetObject> fleets = fleetService.getAllFleets();
		if (fleets != null) {
			for (FleetObject fleet : fleets) {
				System.out.println(fleet.getName());
			}
		}
		return iStudentDAO.getAllStudent();
	}

	@Override
	public Student getStudentById(int studentId) {
		Student obj = iStudentDAO.getStudentById(studentId);
		return obj;
	}

	@Override
	public synchronized boolean addStudent(Student student) {
		if (iStudentDAO.studentExists(student.getStudentName())) {
			return false;
		} else {
			iStudentDAO.addStudent(student);
			return true;
		}

	}

	@Override
	public void updateStudent(Student student) {
		iStudentDAO.updateStudent(student);
	}

	@Override
	public void deleteStudent(int studentId) {
		iStudentDAO.deleteStudent(studentId);
	}

}

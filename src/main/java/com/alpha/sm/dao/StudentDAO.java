package com.alpha.sm.dao;

import java.util.List;

import com.alpha.sm.dto.Student;
import com.alpha.sm.dto.StudentDTO;

public interface StudentDAO {

	List<StudentDTO> loadStudents();
	void insertStudent(StudentDTO studentDTO);
	StudentDTO getStudent(int id);
	void updateStudent(StudentDTO studentDTO);
	void deleteStudent(int id);
	
}

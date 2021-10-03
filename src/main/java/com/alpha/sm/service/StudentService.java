package com.alpha.sm.service;

import java.util.List;

import com.alpha.sm.dto.StudentDTO;

public interface StudentService {
 
	List<StudentDTO> loadStudents();
	void saveStudent(StudentDTO studentDTO);
	StudentDTO getStudent(int id);
	void deleteStudent(int id);
}

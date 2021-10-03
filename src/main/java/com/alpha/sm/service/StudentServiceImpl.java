package com.alpha.sm.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.sm.dao.StudentDAO;
import com.alpha.sm.dto.StudentDTO;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;
	Logger logger = Logger.getLogger(StudentServiceImpl.class.getName());

	@Override
	public List<StudentDTO> loadStudents() {

		// Call the DAO layer to get the data
		List<StudentDTO> listStudentDTO = studentDAO.loadStudents();
		listStudentDTO.forEach(studentDTO -> logger.info(">>>>>>>>>>>>" + studentDTO));

		return listStudentDTO;
	}

	@Override
	public void saveStudent(StudentDTO studentDTO) {
		// TODO Auto-generated method stub
		// Call the DAO layer to save the data
		logger.info(">>>>>>>>>>>>" + studentDTO);
		if (studentDTO.getId() == null) {
			logger.info(">>>>>>>>>>>>Insert process");
			studentDAO.insertStudent(studentDTO);
		} else {
			logger.info(">>>>>>>>>>>>Update process");
			studentDAO.updateStudent(studentDTO);
		}

	}

	@Override
	public StudentDTO getStudent(int id) {

		return studentDAO.getStudent(id);
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		logger.info(">>>>>>>>>>>>Delete process");
		logger.info(">>>>>>>>>>>>" + studentDAO.getStudent(id));
		studentDAO.deleteStudent(id);

	}

}

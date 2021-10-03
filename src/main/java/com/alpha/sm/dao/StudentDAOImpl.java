package com.alpha.sm.dao;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.alpha.sm.dto.Student;
import com.alpha.sm.dto.StudentDTO;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	Logger logger = Logger.getLogger(StudentDAOImpl.class.getName());

	@Override
	public List<StudentDTO> loadStudents() {

		String querystr = "Select * from students";
		List<StudentDTO> listStudents = jdbcTemplate.query(querystr, new BeanPropertyRowMapper(StudentDTO.class));

		return listStudents;
	}

	@Override
	public void insertStudent(StudentDTO studentDTO) {
		// TODO Auto-generated method stub
		String queryStr = "Insert into students(name,mobile,country) Values(?,?,?)";

		Object[] args = { studentDTO.getName(), studentDTO.getMobile(), studentDTO.getCountry() };
//		Student student=new Student();
//		student.setName(studentDTO.getName());
//		student.setMobile(studentDTO.getMobile());
//		student.setCountry(studentDTO.getCountry());
		jdbcTemplate.update(queryStr, args);
		logger.info(">>>>>>>>>>>>A record has been inserted");

	}

	@Override
	public StudentDTO getStudent(int id) {
		// TODO Auto-generated method stub
		String queryStr = "Select * FROM students where id=?";

		return (StudentDTO) jdbcTemplate.queryForObject(queryStr, new BeanPropertyRowMapper(StudentDTO.class), id);
	}

	@Override
	public void updateStudent(StudentDTO studentDTO) {
		String queryStr = "update students set name=?,mobile=?,country=? where id=?";
		Object[] args = { studentDTO.getName(), studentDTO.getMobile(), studentDTO.getCountry(), studentDTO.getId() };
		jdbcTemplate.update(queryStr, args);
		logger.info(">>>>>>>>>>>>Updated successfully");

	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		String queryStr = "delete from students where id=?";

		jdbcTemplate.update(queryStr, id);
		logger.info(">>>>>>>>>>>>deleted successfully");
	}

}

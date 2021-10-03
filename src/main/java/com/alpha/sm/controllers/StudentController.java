package com.alpha.sm.controllers;

import java.util.List;
import java.util.logging.Logger;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alpha.sm.dao.StudentDAO;
import com.alpha.sm.dto.Student;
import com.alpha.sm.dto.StudentDTO;
import com.alpha.sm.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	Logger logger = Logger.getLogger(StudentController.class.getName());

	// @RequestMapping(value="/showStudentList", method = RequestMethod.GET)
	@GetMapping("/showStudents")
	public String showStudentList(Model model) {

		// Call the service layer to get the data
		logger.info(">>>>>>>>>>>>Show Students");
		List<StudentDTO> listStudents = studentService.loadStudents();

		model.addAttribute("students", listStudents);
		return "student-list";
	}

	@GetMapping("/showAddStudentPage")
	public String showAddStudentPage(Model model) {
		StudentDTO studentDTO = new StudentDTO();

		model.addAttribute("student", studentDTO);
		return "add-student";
	}

	@PostMapping("/save-student")
	public String saveStutdent(@ModelAttribute("student") StudentDTO studentDTO) {
		// Call the service layer to save the data
		logger.info(">>>>>>>>>>>>Save Student");

		studentService.saveStudent(studentDTO);

		return "redirect:/showStudents";
	}

	@ResponseBody
	@GetMapping("/thankyou")
	public String thankYou() {

		return "Thank You.. Your record has been added to the database";
	}

	@GetMapping("/updateStudent")
	public String updateStudentPage(@RequestParam("id") int id, Model model) {
		logger.info(">>>>>>>>>>>>Update Student");
		StudentDTO studentDTO = studentService.getStudent(id);
		model.addAttribute("student", studentDTO);
		logger.info(">>>>>>>>>>>>"+studentDTO);
		return "add-student";
	}

	@GetMapping("/deleteStudent")
	public String deleteStudentPage(@RequestParam("id") int id) {
		logger.info(">>>>>>>>>>>>Delete Student");
		studentService.deleteStudent(id);

		return "redirect:/showStudents";
	}

}

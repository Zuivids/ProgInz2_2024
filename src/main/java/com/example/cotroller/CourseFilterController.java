package com.example.cotroller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.Course;
import com.example.service.ICourseFilterService;

@Controller
@RequestMapping("/course/filter")

public class CourseFilterController {

	@Autowired
	private ICourseFilterService courseService;

	@GetMapping("/creditpoints/{param}")
	public String getCourseFilterByCreditPoints(@PathVariable("param") int param, Model model) {

		try {
			ArrayList<Course> selectedCourses = courseService.selectCoursesByCreditPoints(param);
			model.addAttribute("mydata", selectedCourses);
			model.addAttribute("msg", "Courses filtered by creditpoints");
			return "course-show-all-page";
		} catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}
	}

	@GetMapping("/student/{id}")
	public String getCourseFilterByStudentId(@PathVariable("id") int id, Model model) {

		try {
			ArrayList<Course> selectedCourses = courseService.selectCoursesByStudentId(id);
			model.addAttribute("mydata", selectedCourses);
			model.addAttribute("msg", "Courses filtered by student id");
			return "course-show-all-page";
		} catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}
	}

	@GetMapping("/professor/{id}")
	public String getCourseFilterByProfessorId(@PathVariable("id") int id, Model model) {

		try {
			Course selectedCourse = courseService.selectCourseByProfessorId(id);
			model.addAttribute("mydata", selectedCourse);
			model.addAttribute("msg", "Courses filtered by professor id");
			return "course-show-page";
		} catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}
	}
}

package com.example.cotroller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.Course;
import com.example.model.Grade;
import com.example.service.IGradeFilterService;

@Controller
@RequestMapping("/grade/filter")
public class GradeFilterController {

	@Autowired
	private IGradeFilterService gradeFilterService;

	@GetMapping("/failedgrades")
	public String getFailedGrades(Model model) {

		try {
			ArrayList<Grade> failedGrades = gradeFilterService.selectFailedGrades();
			model.addAttribute("mydata", failedGrades);
			model.addAttribute("msg", "Grades filtered by failed ones");
			return "grades-show-all-page";
		} catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}
	}
	
	//TODO  FIX
	@GetMapping("/student/{id}")//localhost:8080/grade/filter/student/1
	public String getGradeFilterByStudentId(@PathVariable("id") int id, Model model) {
		try
		{
			ArrayList<Grade> selectGrades = gradeFilterService.selectGradesByStudnetId(id);
			model.addAttribute("mydata", selectGrades);//padodam datus uz grade-show-all-page.html lapu
			model.addAttribute("msg", "Filtered grades by student");
			return "grade-show-all-page";//tiks parādīt grade-show-all-page.html lapa interneta pārlūka
		}
		catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());//padod kļudas ziņu uz error-page.html lapu
			return "error-page";//parādām pašu error-page.html lapu interneta pārlūkā

		}
	}
	
	@GetMapping("/avg/course/{id}")
	//TODO Fix
	public String getGradeFilterAVGByCourseId(@PathVariable("id") int id, Model model) {

		try {
			float avgGrade = gradeFilterService.calculateAVGGradeCourseId(id);
			model.addAttribute("msg", "Avg grade: " + avgGrade);
			return "grades-show-all-page";
		} catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}
	}

}

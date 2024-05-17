package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.model.Course;
import com.example.model.Degree;
import com.example.model.Grade;
import com.example.model.Product;
import com.example.model.Professor;
import com.example.model.Student;
import com.example.repo.ICourseRepo;
import com.example.repo.IGradeRepo;
import com.example.repo.IProfessorRepo;
import com.example.repo.IStudentRepo;

@SpringBootApplication
public class ProgInzSeminar2Application {

	public static void main(String[] args) {
		SpringApplication.run(ProgInzSeminar2Application.class, args);
	}

	@Bean
	public CommandLineRunner testDB(ICourseRepo courseRepo, IProfessorRepo profRepo, IGradeRepo gradeRepo, IStudentRepo studRepo ) {
		
		return new CommandLineRunner() {
		
			@Override
			public void run (String...args) throws Exception{
				Professor p1 = new Professor("Karina", "Skirmante", Degree.mg);
				Professor p2 = new Professor("Vija", "Vagale", Degree.mg);
				Professor p3 = new Professor("Raita", "Rollande", Degree.mg);
				profRepo.save(p1);
				profRepo.save(p2);
				profRepo.save(p3);
				
				Student s1 = new Student("Valdis", "Maldis");
				Student s2 = new Student("Anna", "Panna");
				Student s3 = new Student("Raisa", "Maisa");
				studRepo.save(s1);
				studRepo.save(s2);
				studRepo.save(s3);
				
				Course c1 = new Course("Datu strukturas un algoritmi", 2 ,p1);
				Course c2 = new Course("Datu bāzes 2", 2 ,p2);
				Course c3 = new Course("Prog inz 1",4,p3, p1);  //TODO nepieiceshams pieviejot ari p1 prof
				courseRepo.save(c1);
				courseRepo.save(c2);
				courseRepo.save(c3);
				
				p1.addCourse(c1);
				p1.addCourse(c3);
				profRepo.save(p1);
				p2.addCourse(c2);
				profRepo.save(p2);
				p3.addCourse(c3);
				profRepo.save(p3);
				

				gradeRepo.save(new Grade(5,c1,s1));
				gradeRepo.save(new Grade(5,c2,s1));
				gradeRepo.save(new Grade(5,c3,s1));

				gradeRepo.save(new Grade(1,c1,s2));
				gradeRepo.save(new Grade(2,c2,s2));
				gradeRepo.save(new Grade(1,c3,s2));
				
				gradeRepo.save(new Grade(4,c1,s3));
				gradeRepo.save(new Grade(8,c2,s3));
				gradeRepo.save(new Grade(10,c3,s3));
			}
		};
		
		//TODO 
		//izveidot servisu-interfeisu prieksh kursu filtracijas
		
		// selectCoursesByProfessor() return all courses of specific professor;
		// selectCoursesByStudent() return all courses where specific student is involved
		// izveidot servisu-interfeicu prieksh atzimju filtracijas
		
		//selectGradesByStudent() return all grades of specific student;
		// calculateAVGGradeInCourse() return avarage grade in specific course;
		
		//abiem interfeisiem uztaisit atbilstoshas servisa klases
		
	}
}

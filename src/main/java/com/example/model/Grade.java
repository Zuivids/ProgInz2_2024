package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "GradeTable")
@Entity
public class Grade {

	@Id
	@Column(name = "Idg")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int idg;

	@Column(name = "Grvalue")
	@Max(10)
	@Min(1)
	private int grvalue;

	@ManyToOne
	@JoinColumn(name = "Idc")
	private Course course;
	
	@ManyToOne
	@JoinColumn(name = "Ids")
	private Student student;
	
	public Grade(int grvalue, Course course, Student student) {
		setGrvalue(grvalue);
		setCourse(course);
		setStudent(student);
	}

	
}

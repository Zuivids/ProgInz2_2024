package com.example.model;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "ProfessorTable")
@Entity
public class Professor {
	@Id
	@Column(name = "Idp")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int idp;

	@Column(name = "Name")
	@NotNull
	@Size(min = 3, max = 50)
	// TODO regex
	private String name;

	@Column(name = "Surname")
	@NotNull
	@Size(min = 3, max = 50)
	// TODO regex
	private String surname;

	@Column(name = "Degree")
	@NotNull
	private Degree degree;

	@ManyToMany
	@JoinTable(name = "ProfessorCourseTable",
	joinColumns = @JoinColumn(name = "Idp"),
	inverseJoinColumns = @JoinColumn(name = "Idc"))
	@ToString.Exclude
	private Collection<Course> courses = new ArrayList<>();

	public Professor(String name, String surname, Degree degree) {
		setName(name);
		setSurname(surname);
		setDegree(degree);
	}

	public void addCourse(Course course) {
		if (!courses.contains(course))
			courses.add(course);

	}
	//TODO uztaisit ari iznemsanas funkciju
}

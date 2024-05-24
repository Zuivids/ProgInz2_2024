package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
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

public class Professor extends Person {

	@Column(name = "Degree")
	@NotNull
	private Degree degree;

	public Professor(String name, String surname, Degree degree) {
		super(name, surname);
		setDegree(degree);
	}

	@OneToOne(mappedBy = "professor")
	@ToString.Exclude
	private Course course;

}

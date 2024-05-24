package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Professor extends Person {
	@Id
	@Column(name = "Idp")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int idp;

	@Column(name = "Degree")
	@NotNull
	private Degree degree;

	public Professor(String name, String surname, Degree degree) {
		super(name,surname);
		setDegree(degree);
	}

	@OneToOne(mappedBy = "professor")
	@ToString.Exclude
	private Course course;

}

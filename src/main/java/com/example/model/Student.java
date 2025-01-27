package com.example.model;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name="StudentTable")
@Entity
public class Student {
	@Id
	@Column(name="Ids")
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int ids;
	
	@Column(name="Name")
	@NotNull
	@Size(min = 3, max = 50)
	//	TODO regex
	private String name;
	
	@Column(name="Surname")
	@NotNull
	@Size(min = 3, max = 50)
	//	TODO regex
	private String surname;
	
	@OneToMany(mappedBy = "student")
	@ToString.Exclude
	private Collection<Grade> grades;
	
	public Student(String name, String surname) {
		setName(name);
		setSurname(surname);
	}
	
	
}

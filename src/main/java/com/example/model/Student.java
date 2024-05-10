package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	@Column(name="Id_s")
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int id_s;
	
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
	
	public Student(String name, String surname) {
		setName(name);
		setSurname(surname);
	}
	
}

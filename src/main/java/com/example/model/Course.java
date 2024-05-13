package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
@Table(name = "CourseTable")
@Entity
public class Course {
	@Id
	@Column(name = "Id_c")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int id_c;

	@Column(name = "Title")
	@NotNull
	@Size(min = 4, max = 50)
	private String title;

	@Column(name = "CreditPoints")
	@Min(1)
	@Max(20)
	private int creditPoints;

	// TODO uztaisit konstruktoru pec saites pievienoshanas ar profesoru

	@OneToOne
	@JoinColumn(name = "Id_p")
	private Professor professor;

	public Course(String title, int creditpoints, Professor profressor) {
		setTitle(title);
		setCreditPoints(creditpoints);
		setProfessor(professor);
	}
}

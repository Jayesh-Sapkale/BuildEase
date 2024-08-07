package com.buildEase.entities;

import java.time.LocalDate;

import com.buildEase.enums.ProjectStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Project")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer projectId;

	@ManyToOne
	@JoinColumn(name = "builder_id")
	private Builder builder;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToOne
	@JoinColumn(name = "projectDetailId")
	private ConstructionDetail constructionDetail;

	@NotNull
	@Pattern(regexp = "^[a-zA-Z]+$")
	private String projectName;

	@NotNull
	private Address address;

	@NotNull
	private LocalDate startDate;

	@NotNull
	private LocalDate endDate;

	@NotNull
	@Enumerated(EnumType.STRING)
	private ProjectStatus projectStatus; // Enum values: [COMPLETE, PENDING, IN_PROGRESS]

	@NotNull
	private String projectDescription;

	@NotNull
	private double totalPrice; // Auto-generate as per (rate * area per square feet)

	

}

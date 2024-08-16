package com.construction.entities;

import java.time.LocalDate;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.construction.entities.utils.Address;
import com.construction.entities.utils.ProjectDetails;
import com.construction.enums.ProjectStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer projectId;

	@ManyToOne()
	@OnDelete(action = OnDeleteAction.SET_NULL)
	@JoinColumn(name = "builderId")
	private Builder builder;

	@OneToOne()
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "customerId")
	private Customer customer;

	@OneToOne()
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "constructionDetailsId")
	private ProjectDetails constructionDetails;

	@OneToOne()
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "addressId")
	private Address address;

	@NotNull
	private String projectName;

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

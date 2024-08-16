package com.construction.entities;

import java.time.LocalDate;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.construction.entities.utils.Address;
import com.construction.entities.utils.ContactDetails;
import com.construction.enums.ConstructionType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer companyId;

	@ManyToOne(cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "builderId")
	private Builder builder;

	private String companyName;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "addressId")
	private Address address;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "contactDetailsId")
	private ContactDetails contactDetails;

	@NotNull
	private LocalDate foundingDate;

	@NotNull
	@Min(100000)
	@Max(999999)
	private Integer licenseNumber;

	@NotNull
	@Enumerated(EnumType.STRING)
	private ConstructionType constructionType;

	private double annualRevenue;

	private int numberOfEmployees;

}

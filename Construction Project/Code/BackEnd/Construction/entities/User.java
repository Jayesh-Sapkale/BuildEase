package com.construction.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.construction.entities.utils.Address;
import com.construction.entities.utils.BasicDetails;
import com.construction.entities.utils.ContactDetails;
import com.construction.enums.Role;
import com.construction.enums.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty(access = Access.READ_ONLY)
	private Integer id;
	@JsonProperty(access = Access.READ_ONLY)
	@Enumerated(EnumType.STRING)
	private Role role;
	@NotNull
	private String userName;
	@NotNull
	private String password;
	@NotNull
	@Enumerated(EnumType.STRING)
	private Status status;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "addressId")
	private Address address;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "basicDetailsId")
	private BasicDetails basicDetails;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "contactDetailsId")
	private ContactDetails contactDetails;

}

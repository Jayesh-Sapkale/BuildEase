package com.construction.payment;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SubscriptionOrderDto {
	private String name;
	private String phoneNo;
	private String email;

	private Role role;

	private Subscription subscription;

	private Plan plan;

	private Integer amount;
}

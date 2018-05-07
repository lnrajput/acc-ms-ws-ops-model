package com.acc.cloud.ms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PolicyDetails {
	
	private String policyNumber;
	private String policyType;
	private Account account;

}

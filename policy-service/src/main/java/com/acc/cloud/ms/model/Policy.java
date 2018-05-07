package com.acc.cloud.ms.model;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Policy {
	
	@NotNull
	private Long policyId;
	@NotNull
	private String policyType;
	@NotNull
	private Long accountId;
	@NotNull
	private Long submissionId;
	private String accountName;
	private String businessType;

}
